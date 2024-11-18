package com.example.goblinmarket.genre.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class GenreDTO {

    @NotBlank(message = "Genre's name can not be blank")
    @Size(min = 3, message = "Genre's name must have at least three charactes")
    private String name;
}
