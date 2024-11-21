package com.example.goblinmarket.user.dto;

import com.example.goblinmarket.user.projections.UserWithNothing;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseUserDTO {
    private UserWithNothing user;
}
