package com.example.goblinmarket.tournament.dto;

import com.example.goblinmarket.tournament.projections.TournamentWithGame;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseTournamentDTO {
    private TournamentWithGame tournament;
}
