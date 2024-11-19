package com.example.goblinmarket.game.dto;

import com.example.goblinmarket.game.projections.GameWithoutGenre;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseGameDTO {
    private GameWithoutGenre game;
}
