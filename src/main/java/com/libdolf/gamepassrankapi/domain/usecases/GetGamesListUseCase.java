package com.libdolf.gamepassrankapi.domain.usecases;

import com.libdolf.gamepassrankapi.core.infra.GamePassApi;
import com.libdolf.gamepassrankapi.data.adapters.GamePassApiGateway;
import com.libdolf.gamepassrankapi.domain.entities.Game;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
