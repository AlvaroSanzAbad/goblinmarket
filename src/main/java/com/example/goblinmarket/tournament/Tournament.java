package com.example.goblinmarket.tournament;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.goblinmarket.game.Game;
import com.example.goblinmarket.tournament.dto.TournamentDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private LocalDate date;
    private LocalTime hour;
    private String img;

    @ManyToOne
    @JoinColumn(name = "game", referencedColumnName = "id")
    private Game game;

    static Tournament fromDTO(TournamentDTO tournamentDTO){
        Game game = new Game();
        game.setId(tournamentDTO.getGame());

        return new Tournament(0, tournamentDTO.getName(), tournamentDTO.getDescription(), tournamentDTO.getDate()
        , tournamentDTO.getHour(), tournamentDTO.getImg(), game);

    }

}
