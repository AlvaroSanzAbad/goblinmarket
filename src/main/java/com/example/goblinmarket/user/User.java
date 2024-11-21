package com.example.goblinmarket.user;

import java.time.LocalDate;
import java.util.List;

import com.example.goblinmarket.tournament.Tournament;
import com.example.goblinmarket.user.dto.UserDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String email; 
    private String pass;
    private String img;
    private LocalDate birthdate;

    @ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    })
    @JoinTable(
        name = "user_in_tournament",
        joinColumns = @JoinColumn(name = "user"),
        inverseJoinColumns = @JoinColumn(name = "tournament")
    )
    private List<Tournament> tournaments;

    static User fromDTO(UserDTO userDTO){
        return new User(0, userDTO.getUsername(), userDTO.getEmail(), userDTO.getPass(),
        userDTO.getImg(), userDTO.getBirthdate(), null);
    }
}
