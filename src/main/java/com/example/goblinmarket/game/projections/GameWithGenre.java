package com.example.goblinmarket.game.projections;

import com.example.goblinmarket.genre.projections.GenreWithoutGames;

public interface GameWithGenre {
    int getId();
    String getName();
    String getDescription();
    double getPrice();
    String getImg();
    String getStudio();
    GenreWithoutGames getGenre();
}
