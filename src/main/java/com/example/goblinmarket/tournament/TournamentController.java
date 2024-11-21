package com.example.goblinmarket.tournament;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.goblinmarket.tournament.dto.ResponseTournamentDTO;
import com.example.goblinmarket.tournament.dto.ResponseTournamentsDTO;
import com.example.goblinmarket.tournament.dto.TournamentDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseTournamentDTO insertTournament(@RequestBody @Valid TournamentDTO t) {
        return new ResponseTournamentDTO(tournamentService.insertTournament(t));
    }

    @PutMapping("{id}")
    public ResponseTournamentDTO updateTournament(@PathVariable int id, @RequestBody @Valid TournamentDTO tournamentDTO) {
        return new ResponseTournamentDTO(tournamentService.updateTournament(id, tournamentDTO));
    }
    
    @DeleteMapping("{id}")
    public void deleteTournament(@PathVariable int id){
        tournamentService.deleteTournament(id);
    }
    
}
