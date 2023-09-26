package com.libdolf.gamepassrankapi.domain.usecases;

import com.libdolf.gamepassrankapi.core.infra.GamePassApi;
import com.libdolf.gamepassrankapi.data.adapters.GamePassApiGateway;
import com.libdolf.gamepassrankapi.domain.entities.Game;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@Service
@AllArgsConstructor
public class GetGamesListUseCase {
    private final GamePassApi gateway;
    public List<Game> getBestGames() {
       List<Game> games = gateway.getAll();
        Collections.sort(games, Comparator.comparingDouble(Game::getReviewScore).reversed());
        return games;
    }

    public List<Game> getWorstGames() {
        List<Game> games = gateway.getAll();
        Collections.sort(games, Comparator.comparingDouble(Game::getReviewScore));
        return games;
    }

    public List<Game> getGamesByName(String gameName) {
        List<Game> games = gateway.getAll();
        List<Game> gamesNew = new ArrayList<>();
        for (Game game : games){
            if(game.getTitle().toLowerCase().contains(gameName.toLowerCase())){
                gamesNew.add(game);
            }
        }
        return gamesNew;
    }
}
