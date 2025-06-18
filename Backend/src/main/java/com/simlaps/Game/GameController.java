package com.simlaps.Game;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simlaps.Exception.ResourceNotFoundException;

import jakarta.validation.Valid;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class GameController {
    
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // GET endpoints

    @GetMapping("/games/all")
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/game/id/{gameId}")
    public ResponseEntity<Game> getGameById(@PathVariable String gameId) throws ResourceNotFoundException {
        return gameService.getGameById(gameId);
    }

    // CREATE or UPDATE endpoints

    @PostMapping("/game/create")
    public ResponseEntity<Game> createGame(@Valid @RequestBody Game game) {
        return gameService.createGame(game);
    }

}
