package com.example.goblinmarket.game.dto;

import java.util.List;

import com.example.goblinmarket.game.projections.GameWithGenre;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseGamesDTO {
    private List<GameWithGenre> games;
}
