package com.example.goblinmarket.game.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonPropertyOrder({"id", "name", "description", "price", "img", "studio", "genre"})
@NoArgsConstructor
@Data
public class GameDTO {

    @NotBlank(message = "Game's name can not be blank")
    @Size(min = 2, message = "Game's name must have at least two charactes")
    private String name;
    @NotBlank(message = "Game's description can not be blank")
    private String description;
    @Positive(message = "Game's price must be a positive value")
    private double price;
    @NotBlank(message = "Game's img can not be blank")
    private String img;
    @NotBlank(message = "Game's studio can not be blank")
    @Size(min = 2, message = "Game's studio must have at least two charactes")
    private String studio;
    @Positive(message = "Game's genre must be a positive value")
    private int genre;

}
