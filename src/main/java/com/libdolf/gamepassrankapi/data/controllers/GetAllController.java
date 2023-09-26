package com.libdolf.gamepassrankapi.data.controllers;

import com.libdolf.gamepassrankapi.domain.entities.Game;
import com.libdolf.gamepassrankapi.domain.usecases.GetGamesListUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/")
@AllArgsConstructor
public class GetAllController {
    private GetGamesListUseCase useCase;
    @GetMapping
    public ResponseEntity<List<Game>> getAll(){
        List<Game> games = useCase.getBestGames();
        return ResponseEntity.ok(games);
    }
}
