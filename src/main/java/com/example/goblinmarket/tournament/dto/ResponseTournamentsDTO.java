package com.example.goblinmarket.tournament.dto;

import java.util.List;

import com.example.goblinmarket.tournament.projections.TournamentWithGame;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseTournamentsDTO {
    private List<TournamentWithGame> tournaments;
}
