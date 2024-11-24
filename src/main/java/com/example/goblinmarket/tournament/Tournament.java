package com.example.goblinmarket.tournament;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.example.goblinmarket.game.Game;
import com.example.goblinmarket.tournament.dto.TournamentDTO;
import com.example.goblinmarket.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    @ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(
        name = "user_in_tournament",
        joinColumns = @JoinColumn(name = "tournament"),
        inverseJoinColumns = @JoinColumn(name = "user")
    )
    private List<User> users;

    static Tournament fromDTO(TournamentDTO tournamentDTO){
        Game game = new Game();
        game.setId(tournamentDTO.getGame());

        return new Tournament(0, tournamentDTO.getName(), tournamentDTO.getDescription(), tournamentDTO.getDate()
        , tournamentDTO.getHour(), tournamentDTO.getImg(), game, null);

    }

}
