package com.example.goblinmarket.genre;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.goblinmarket.genre.projections.GenreWithGames;
import com.example.goblinmarket.genre.projections.GenreWithoutGames;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public List<GenreWithoutGames> getGenres(){
        return genreRepository.findAllBy();
    }

    public GenreWithGames getGenre(int id){
        return genreRepository.findGenreById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Genre not found"));
    }

    public Genre insertGenre(Genre g){
        g.setId(0); //Id a 0 para asegurar que se haga insert
        return genreRepository.save(g);
    }

    public Genre updateGenre(int id, Genre g){
        if (!genreRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Genre not found");
        }
        g.setId(id);
        return genreRepository.save(g);
    }

    public void deleteGenre(int id){
        genreRepository.deleteById(id);
    }
}
