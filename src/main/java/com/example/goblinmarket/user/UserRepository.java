package com.example.goblinmarket.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.goblinmarket.user.projections.UserWithNothing;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    @Query("SELECT u.id AS id, u.username AS username, u.email AS email, u.pass AS pass, u.img AS img, u.birthdate AS birthdate FROM User u")
    List<UserWithNothing> findAllBy();

    @Query("SELECT u.id AS id, u.username AS username, u.email AS email, u.pass AS pass, u.img AS img, u.birthdate AS birthdate FROM User u WHERE u.id = :id")
    UserWithNothing findUserById(int id);
}
