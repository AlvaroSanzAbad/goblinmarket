package com.example.goblinmarket.game;

import com.example.goblinmarket.game.dto.GameDTO;
import com.example.goblinmarket.genre.Genre;

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
public class Game {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private double price;
    private String img;
    private String studio;

    @ManyToOne
    @JoinColumn(name = "genre", referencedColumnName = "id")
    private Genre genre;
    
    static Game fromDTO(GameDTO gameDTO){
        Genre genre = new Genre();
        genre.setId(gameDTO.getGenre());
        return new Game(0, gameDTO.getName(), gameDTO.getDescription(), 
        gameDTO.getPrice(), gameDTO.getImg(), gameDTO.getStudio(), genre);
    }
    
}
