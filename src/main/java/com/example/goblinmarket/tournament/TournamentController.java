package com.example.goblinmarket.tournament;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.goblinmarket.tournament.dto.ResponseTournamentDTO;
import com.example.goblinmarket.tournament.dto.ResponseTournamentsDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/tournament")
@RestController
public class TournamentController {
    private final TournamentService tournamentService;

    @GetMapping
    public ResponseTournamentsDTO getTournaments() {
        return new ResponseTournamentsDTO(tournamentService.getTournaments());
    }

    @GetMapping("/{id}")
    public ResponseTournamentDTO getTournament(@PathVariable int id) {
        return new ResponseTournamentDTO(tournamentService.getTournament(id));
    }
    
    
}
