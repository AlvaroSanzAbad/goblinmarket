package com.example.goblinmarket.game;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GameService {
    private final GameRepository gameRepository;

    public List<Game> getGames(){
        return gameRepository.findAll();
    }

    public Game getGame(int id){
        return gameRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found"));
    }

    public Game insertGame(Game g){
        g.setId(0); //Nos aseguramos que sea insert poniendolo a 0
        return gameRepository.save(g);
    }


}
