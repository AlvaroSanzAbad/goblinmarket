package com.example.goblinmarket.genre.dto;

import com.example.goblinmarket.genre.projections.GenreWithoutGames;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseGenreDTO {
    private GenreWithoutGames genre;
}
