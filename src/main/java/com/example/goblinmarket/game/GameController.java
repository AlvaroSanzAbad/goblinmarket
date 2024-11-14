package com.example.goblinmarket.game;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/game")
@RestController
public class GameController {
    private final GameService gameService;

    @GetMapping
    public List<Game> getGames() {
        return gameService.getGames();
    }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable int id) {
        return gameService.getGame(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Game insertGame(@RequestBody Game g) {
        return gameService.insertGame(g);
    }
    


}
