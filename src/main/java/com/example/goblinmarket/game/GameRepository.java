package com.example.goblinmarket.game;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.goblinmarket.game.projections.GameWithGenre;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer>{

    List<GameWithGenre> findAllBy();

    GameWithGenre findGameById(int id);

}
