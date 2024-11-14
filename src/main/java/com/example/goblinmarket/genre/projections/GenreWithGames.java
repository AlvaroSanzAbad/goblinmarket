package com.example.goblinmarket.genre.projections;

import java.util.List;

import com.example.goblinmarket.game.projections.GameWithoutGenre;

public interface GenreWithGames {
    int getId();
    String getName();
    List<GameWithoutGenre> getGames();
}
