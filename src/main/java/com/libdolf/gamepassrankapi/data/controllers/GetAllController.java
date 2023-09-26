package com.libdolf.gamepassrankapi.data.controllers;

import com.libdolf.gamepassrankapi.domain.entities.Game;
import com.libdolf.gamepassrankapi.domain.usecases.GetGamesListUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class GetAllController {
    private GetGamesListUseCase useCase;
    @GetMapping("/best")
    public ResponseEntity<List<Game>> getBest(){
        List<Game> games = useCase.getBestGames();
        return ResponseEntity.ok(games);
    }

    @GetMapping("/worst")
    public ResponseEntity<List<Game>> getWorst(){
        List<Game> games = useCase.getWorstGames();
        return ResponseEntity.ok(games);
    }

    @GetMapping("/{gameName}")
    public ResponseEntity<List<Game>> getGameByName(@PathVariable String gameName){
        List<Game> game = useCase.getGamesByName(gameName);
        return ResponseEntity.ok(game);
    }

}
