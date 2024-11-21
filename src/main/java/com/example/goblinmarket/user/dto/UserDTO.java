package com.example.goblinmarket.user.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserDTO {
    @NotBlank(message = "You're username can not be blank")
    private String username;
    @NotBlank(message = "You're email can not be blank")
    @Email(message = "You're email does not have the correct format")
    private String email;
    @NotBlank(message = "You're password can not be blank")
    private String pass;
    @NotBlank(message = "You're profile image can not be blank")
    private String img;
    @NotBlank(message = "You're birthdate can not be blank")
    private LocalDate birthdate;
}
