package com.example.goblinmarket.game;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.goblinmarket.game.projections.GameWithGenre;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer>{

    @Query("SELECT g.id AS id, g.name AS name, g.description AS description, g.price AS price, g.img AS img, g.studio AS studio, g.genre.id AS genre FROM Game g")
    List<GameWithGenre> findAllBy();

    @Query("SELECT g.id AS id, g.name AS name, g.description AS description, g.price AS price, g.img AS img, g.studio AS studio, g.genre.id AS genre FROM Game g WHERE g.id = :id")
    GameWithGenre findGameById(int id);

}
