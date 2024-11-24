package com.example.goblinmarket.tournament;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.goblinmarket.game.GameRepository;
import com.example.goblinmarket.tournament.dto.TournamentDTO;
import com.example.goblinmarket.tournament.projections.TournamentWithGame;
import com.example.goblinmarket.user.projections.UserWithNothing;

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
        return tournamentRepository.findTournamentById(id);
    }

    public TournamentWithGame insertTournament(TournamentDTO tournamentDTO){
        gameRepository.findById(tournamentDTO.getGame())
        .orElseThrow(() -> new IllegalArgumentException("Game's not found"));
        
        Tournament tournament = tournamentRepository.save(Tournament.fromDTO(tournamentDTO));
        return tournamentRepository.findTournamentById(tournament.getId());
    }

    public TournamentWithGame updateTournament(int id, TournamentDTO tournamentDTO){
        if (!tournamentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tournament's not found");
        }

        gameRepository.findById(tournamentDTO.getGame())
        .orElseThrow(() -> new IllegalArgumentException("Game's not found"));

        Tournament tournament = Tournament.fromDTO(tournamentDTO);
        tournament.setId(id);
        tournamentRepository.save(tournament);

        return tournamentRepository.findTournamentById(tournament.getId());
    }

    public void deleteTournament(int id){
        tournamentRepository.deleteById(id);
    }

    public List<UserWithNothing> getTournamentUsers(int id){
        return tournamentRepository.findUserByTournamentId(id);
    }

}
