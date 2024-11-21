package com.example.goblinmarket.user.dto;

import java.util.List;

import com.example.goblinmarket.user.projections.UserWithNothing;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseUsersDTO {
    private List<UserWithNothing> users;
}
