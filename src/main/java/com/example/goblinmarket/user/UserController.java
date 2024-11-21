package com.example.goblinmarket.user;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.goblinmarket.user.dto.ResponseUserDTO;
import com.example.goblinmarket.user.dto.ResponseUsersDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;



@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseUsersDTO getUsers() {
        return new ResponseUsersDTO(userService.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseUserDTO getUser(@PathVariable int id) {
        return new ResponseUserDTO(userService.getUser(id));
    }
    
    

}
