package com.example.goblinmarket.tournament.projections;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "name", "description", "date", "hour", "img", "genre"})
public interface TournamentWithGame {
    Integer getId();
    String getName();
    String getDescription();
    LocalDate getDate();
    LocalTime getHour();
    String getImg();
    Integer getGame();
}
