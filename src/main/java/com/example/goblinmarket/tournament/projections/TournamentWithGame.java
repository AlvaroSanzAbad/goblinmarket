package com.example.goblinmarket.tournament.projections;

import java.time.LocalDate;
import java.time.LocalTime;

public interface TournamentWithGame {
    int getId();
    String getName();
    String getDescription();
    LocalDate getDate();
    LocalTime getHour();
    String getImg();
    int getGame();
}
