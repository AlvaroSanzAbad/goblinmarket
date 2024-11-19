package com.example.goblinmarket.game;

import java.util.List;

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
import com.example.goblinmarket.game.projections.GameWithGenre;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/game")
@RestController
public class GameController {
    private final GameService gameService;

    @GetMapping
    public List<GameWithGenre> getGames() {
        return gameService.getGames();
    }

    @GetMapping("/{id}")
    public GameWithGenre getGame(@PathVariable int id) {
        return gameService.getGame(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GameWithGenre insertGame(@RequestBody @Valid GameDTO g) {
        return gameService.insertGame(g);
    }
    
    @PutMapping("/{id}")
    public GameWithGenre updateGame(@PathVariable int id, @RequestBody @Valid GameDTO g) {
        return gameService.updateGame(id, g);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable int id){
        gameService.deleteGame(id);;
    }
}
