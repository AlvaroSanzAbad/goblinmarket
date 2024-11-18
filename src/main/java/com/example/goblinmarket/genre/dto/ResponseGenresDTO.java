package com.example.goblinmarket.genre.dto;

import java.util.List;

import com.example.goblinmarket.genre.projections.GenreWithoutGames;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseGenresDTO {

    private List<GenreWithoutGames> genres;
}
