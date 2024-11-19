package com.example.goblinmarket.game;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.goblinmarket.game.dto.GameDTO;
import com.example.goblinmarket.game.dto.ResponseGameDTO;
import com.example.goblinmarket.game.dto.ResponseGamesDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/game")
@RestController
public class GameController {
    private final GameService gameService;

    @GetMapping
    public ResponseGamesDTO getGames() {
        return new ResponseGamesDTO(gameService.getGames());
    }

    @GetMapping("/{id}")
    public ResponseGameDTO getGame(@PathVariable int id) {
        return new ResponseGameDTO(gameService.getGame(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseGameDTO insertGame(@RequestBody @Valid GameDTO g) {
        return new ResponseGameDTO(gameService.insertGame(g));
    }
    
    @PutMapping("/{id}")
    public ResponseGameDTO updateGame(@PathVariable int id, @RequestBody @Valid GameDTO g) {
        return new ResponseGameDTO(gameService.updateGame(id, g));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable int id){
        gameService.deleteGame(id);;
    }
}
