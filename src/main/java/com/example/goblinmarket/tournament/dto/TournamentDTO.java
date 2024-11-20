package com.example.goblinmarket.tournament.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TournamentDTO {

    @NotBlank(message = "Tournament's name can not be blank")
    @Size(min = 2, message = "Tournament's name must have at least two characters")
    private String name;
    @NotBlank(message = "Tournament's description can not be blank")
    private String description;
    @NotNull
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}", message = "Tournament's date does not have the correct format")
    private LocalDate date;
    @NotNull
    @Pattern(regexp = "^\\d{2}:\\d{2}", message = "Tournament's hour does not have the correct format")
    private LocalTime hour;
    @NotBlank(message = "Tournament's image can not be blank")
    private String img;
    @Positive(message = "Tournaments's game must be a positive value")
    private int game;
}
