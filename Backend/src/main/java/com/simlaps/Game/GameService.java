package com.simlaps.Game;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.simlaps.Exception.ResourceNotFoundException;

@Service
public class GameService {
    
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    // GET methods

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public ResponseEntity<Game> getGameById(String gameId) throws ResourceNotFoundException {
        Game game = gameRepository.findById(gameId)
            .orElseThrow(() -> new ResourceNotFoundException("Game with id " + gameId + " not found"));

        return ResponseEntity.ok().body(game);
    }

    // CREATE or UPDATE methods

    public ResponseEntity<Game> createGame(Game game) {
        return ResponseEntity.ok(gameRepository.save(game));
    }

}
