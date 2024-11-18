package com.example.goblinmarket.genre;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.goblinmarket.genre.dto.GenreDTO;
import com.example.goblinmarket.genre.projections.GenreWithoutGames;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public List<GenreWithoutGames> getGenres(){
        return genreRepository.findAllBy();
    }

    public GenreWithoutGames getGenre(int id){
        return genreRepository.findGenreById(id);
    }

    public GenreWithoutGames insertGenre(GenreDTO genreDTO){
        Genre genre = genreRepository.save(Genre.fromDTO(genreDTO)); //Hacemos save llamando a fromDTO
        return genreRepository.findGenreById(genre.getId());
    }

    public GenreWithoutGames updateGenre(int id, GenreDTO genreDTO){
        if (!genreRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Genre not found");
        }
        Genre genre = Genre.fromDTO(genreDTO);
        genre.setId(id);
        genreRepository.save(genre);
        return genreRepository.findGenreById(genre.getId());
    }

    public void deleteGenre(int id){
        genreRepository.deleteById(id);
    }
}
