package com.example.goblinmarket.user.projections;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "username", "email", "pass", "img", "birthdate"})
public interface UserWithNothing {
    int getId();
    String getUsername();
    String getEmail(); 
    String getPass();
    String getImg();
    LocalDate getBirthdate();
}
