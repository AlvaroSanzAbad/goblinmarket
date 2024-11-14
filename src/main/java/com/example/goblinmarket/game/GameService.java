package com.example.goblinmarket.game;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.goblinmarket.game.projections.GameWithGenre;
import com.example.goblinmarket.game.projections.GameWithoutGenre;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GameService {
    private final GameRepository gameRepository;

    public List<GameWithoutGenre> getGames(){
        return gameRepository.findAllBy();
    }

    public GameWithGenre getGame(int id){
        return gameRepository.findGameById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found"));
    }

    public Game insertGame(Game g){
        g.setId(0); //Nos aseguramos que sea insert poniendolo a 0
        return gameRepository.save(g);
    }

    public Game updateGame(int id, Game g){
        if (!gameRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found");
        }
        g.setId(id); //En este caso le pasamos la id para que haga el update
        return gameRepository.save(g);
    }

    public void deleteGame(int id){
        gameRepository.deleteById(id);
    }
}
