package com.boardcamp.api.controllers;

import com.boardcamp.api.dtos.GameDTO;
import com.boardcamp.api.models.GameModel;
import com.boardcamp.api.services.GameService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<GameModel> createGame(@RequestBody @Valid GameDTO body) {
        GameModel game = gameService.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(game);
    }

    @GetMapping
    public ResponseEntity<List<GameModel>> getGames() {
        List<GameModel> games = gameService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(games);
    }

}
