package com.example.goblinmarket.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.goblinmarket.game.projections.GameWithGenre;
import com.example.goblinmarket.tournament.projections.TournamentWithGame;
import com.example.goblinmarket.user.projections.UserWithNothing;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    @Query("SELECT u.id AS id, u.username AS username, u.email AS email, u.pass AS pass, u.img AS img, u.birthdate AS birthdate FROM User u")
    List<UserWithNothing> findAllBy();

    @Query("SELECT u.id AS id, u.username AS username, u.email AS email, u.pass AS pass, u.img AS img, u.birthdate AS birthdate FROM User u WHERE u.id = :id")
    UserWithNothing findUserById(int id);

    @Query("""
    SELECT t.id AS id, 
           t.name AS name, 
           t.description AS description, 
           t.date AS date, 
           t.hour AS hour, 
           t.img AS img, 
           t.game.id AS game 
    FROM User u 
    JOIN u.tournaments t 
    WHERE u.id = :id
    """)
    List<TournamentWithGame> findTournamentsByUserId(int id);

    @Query("""
    SELECT g.id AS id, 
        g.name AS name, 
        g.description AS description, 
        g.price AS price,  
        g.img AS img,
        g.studio AS studio, 
        g.genre.id AS genre
    FROM User u 
    JOIN u.games g 
    WHERE u.id = :id
    """)
    List<GameWithGenre> findGamesByUserId(int id);

}
