package com.example.goblinmarket.genre;

import java.util.ArrayList;
import java.util.List;

import com.example.goblinmarket.game.Game;
import com.example.goblinmarket.genre.dto.GenreDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
    List<Game> games = new ArrayList<>();

    static Genre fromDTO(GenreDTO genreDTO){
        return new Genre(0, genreDTO.getName(), null);
    }
}
