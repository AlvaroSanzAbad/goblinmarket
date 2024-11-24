package com.example.goblinmarket.game.projections;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "name", "description", "price", "img", "studio", "genre"})
public interface GameWithGenre {
    int getId();
    String getName();
    String getDescription();
    double getPrice();
    String getImg();
    String getStudio();
    int getGenre();
}
