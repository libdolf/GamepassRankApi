package com.libdolf.gamepassrankapi.core.infra;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.libdolf.gamepassrankapi.data.adapters.GamePassApiGateway;
import com.libdolf.gamepassrankapi.domain.entities.Game;
import com.sun.jdi.PrimitiveValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Component
public class GamePassApi implements GamePassApiGateway {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Gson gson;

    @Value("${GAMEPASS_IDS_URL}")
    private String urlIds;
    @Value("${GAMEPASS_GAMES_URL}")
    private String urlGames;

    @Override
    public List<Game> getAll() {
        String body = "{\"Products\": "+ getAllIds() +"}";
        ResponseEntity<String> response = restTemplate.postForEntity(urlGames, body, String.class);
        JsonObject products = gson.fromJson(response.getBody(), JsonObject.class)
                .getAsJsonObject("Products");

        List<JsonObject> gamesJson = new ArrayList<>();
        for (String id : getAllIdsAsText()){
            gamesJson.add(products.getAsJsonObject(id));
        }

        List<Game> games = new ArrayList<>();
        for (JsonObject g : gamesJson){
            Game game = Game.builder()
                    .id(g.get("StoreId").getAsString())
                    .title(g.get("ProductTitle").getAsString())
                    .developerName(g.get("DeveloperName").getAsString())
                    .publisherName(g.get("PublisherName").getAsString())
                    .reviewScore(g.get("ReviewScore").getAsDouble())
                    .reviewCount(g.get("ReviewCount").getAsInt())
                    .categories(g.get("Categories").getAsJsonArray().toString())
                    .build();
            games.add(game);
        }
        return games;
    }

    private List<String> getAllIds(){
        ResponseEntity<JsonNode[]> response = restTemplate.getForEntity(urlIds, JsonNode[].class);
        JsonNode[] responseBody = response.getBody();
        List<String> ids = new ArrayList<>();

        for(int i = 1; i < responseBody.length; i++){
            JsonNode idObject = responseBody[i];
            ids.add(idObject.get("id").toString());
        }
        return ids;
    }

    private List<String> getAllIdsAsText(){
        List<String> ids = new ArrayList<>();
        for (String id : getAllIds()){
            ids.add(id.substring(1, id.length()-1));
        }
        return ids;
    }

}
