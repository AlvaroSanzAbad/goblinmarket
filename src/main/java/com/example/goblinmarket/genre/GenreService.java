package com.example.goblinmarket.genre;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public List<Genre> getGenres(){
        return genreRepository.findAll();
    }

    public Genre getGenre(int id){
        return genreRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Genre not found"));
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
}
