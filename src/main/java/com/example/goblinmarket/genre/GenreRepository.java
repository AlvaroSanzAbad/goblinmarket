package com.example.goblinmarket.genre;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.goblinmarket.genre.projections.GenreWithGames;
import com.example.goblinmarket.genre.projections.GenreWithoutGames;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer>{

    List<GenreWithoutGames> findAllBy();

    Optional<GenreWithGames> findGenreById(int id);
}
