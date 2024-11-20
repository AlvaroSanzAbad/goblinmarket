package com.example.goblinmarket.game;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.goblinmarket.game.dto.GameDTO;
import com.example.goblinmarket.game.projections.GameWithGenre;
import com.example.goblinmarket.genre.Genre;
import com.example.goblinmarket.genre.GenreRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GameService {
    private final GameRepository gameRepository;
    private final GenreRepository genreRepository;

    public List<GameWithGenre> getGames(){
        return gameRepository.findAllBy();
    }

    public GameWithGenre getGame(int id){
        return gameRepository.findGameById(id);
    }

    public GameWithGenre insertGame(GameDTO gameDTO){
        //Comprobar que existe el genero de videojuego que nos han pasado
        Genre genre = genreRepository.findById(gameDTO.getGenre())
        .orElseThrow(() -> new IllegalArgumentException("Game's genre not found"));

        Game game = gameRepository.save(Game.fromDTO(gameDTO));
        return gameRepository.findGameById(game.getId());
    }

    public GameWithGenre updateGame(int id, GameDTO gameDTO){
        if (!gameRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found");
        }
        Game game = Game.fromDTO(gameDTO);
        game.setId(id);
        gameRepository.save(game);
        return gameRepository.findGameById(game.getId());
    }

    public void deleteGame(int id){
        gameRepository.deleteById(id);
    }
}
