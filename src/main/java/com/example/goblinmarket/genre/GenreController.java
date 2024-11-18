package com.example.goblinmarket.genre;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.goblinmarket.genre.dto.GenreDTO;
import com.example.goblinmarket.genre.dto.ResponseGenreDTO;
import com.example.goblinmarket.genre.dto.ResponseGenresDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/genre")
@RestController
public class GenreController {
    private final GenreService genreService;

    @GetMapping
    public ResponseGenresDTO getGenres() {
        return new ResponseGenresDTO(genreService.getGenres());
    }

    @GetMapping("/{id}")
    public ResponseGenreDTO getGenre(@PathVariable int id) {
        return new ResponseGenreDTO(genreService.getGenre(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseGenreDTO insertGenre(@RequestBody @Valid GenreDTO g) {
        return new ResponseGenreDTO(genreService.insertGenre(g));
    }
    
    @PutMapping("/{id}")
    public ResponseGenreDTO updateGenre(@PathVariable int id, @RequestBody @Valid GenreDTO g) {
        return new ResponseGenreDTO(genreService.updateGenre(id, g));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteGenre(@PathVariable int id){
        genreService.deleteGenre(id);
    }
}
