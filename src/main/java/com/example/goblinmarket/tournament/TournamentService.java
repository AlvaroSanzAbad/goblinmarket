package com.example.goblinmarket.tournament;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.goblinmarket.game.GameRepository;
import com.example.goblinmarket.tournament.projections.TournamentWithGame;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TournamentService {
    private final TournamentRepository tournamentRepository;
    private final GameRepository gameRepository;

    public List<TournamentWithGame> getTournaments(){
        return tournamentRepository.findAllBy();
    }

    public TournamentWithGame getTournament(int id){
        return tournamentRepository.findGameById(id);
    }
}
