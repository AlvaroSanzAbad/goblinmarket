package com.example.goblinmarket.game;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.goblinmarket.game.projections.GameWithGenre;
import com.example.goblinmarket.game.projections.GameWithoutGenre;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer>{

    List<GameWithoutGenre> findAllBy();

    Optional<GameWithGenre> findGameById(int id);

}
