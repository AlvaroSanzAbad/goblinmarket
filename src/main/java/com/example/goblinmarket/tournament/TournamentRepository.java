package com.example.goblinmarket.tournament;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.goblinmarket.tournament.projections.TournamentWithGame;
import com.example.goblinmarket.user.projections.UserWithNothing;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Integer>{
    @Query("SELECT t.id AS id, t.name AS name, t.description AS description, t.date AS date, t.hour AS hour, t.img AS img, t.game.id AS game FROM Tournament t")
    List<TournamentWithGame> findAllBy();

    @Query("SELECT t.id AS id, t.name AS name, t.description AS description, t.date AS date, t.hour AS hour, t.img AS img, t.game.id AS game FROM Tournament t WHERE t.id = :id")
    TournamentWithGame findTournamentById(int id);

    @Query("""
    SELECT u.id AS id, 
        u.username AS username, 
        u.email AS email, 
        u.pass AS pass, 
        u.img AS img, 
        u.birthdate AS birthdate
    FROM User u
    JOIN u.tournaments t
    WHERE t.id = :id
    """)
    List<UserWithNothing> findUserByTournamentId(int id);
}
