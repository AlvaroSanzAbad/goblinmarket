package com.example.goblinmarket.genre;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Genre> getGenres() {
        return genreService.getGenres();
    }

    @GetMapping("/{id}")
    public Genre getGenre(@PathVariable int id) {
        return genreService.getGenre(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Genre insertGenre(@RequestBody Genre g) {
        return genreService.insertGenre(g);
    }
    
    @PutMapping("/{id}")
    public Genre updateGenre(@PathVariable int id, @RequestBody Genre g) {
        return genreService.updateGenre(id, g);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteGenre(@PathVariable int id){
        genreService.deleteGenre(id);
    }
}
