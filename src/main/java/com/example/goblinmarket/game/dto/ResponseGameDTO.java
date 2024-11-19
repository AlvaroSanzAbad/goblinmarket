package com.example.goblinmarket.game.dto;

import com.example.goblinmarket.game.projections.GameWithGenre;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseGameDTO {
    private GameWithGenre game;
}
