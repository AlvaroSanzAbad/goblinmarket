package com.example.goblinmarket.game.projections;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "name", "description", "price", "img", "studio"})
public interface GameWithoutGenre {
    int getId();
    String getName();
    String getDescription();
    double getPrice();
    String getImg();
    String getStudio();
}
