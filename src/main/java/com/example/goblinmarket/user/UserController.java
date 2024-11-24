package com.example.goblinmarket.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.goblinmarket.user.dto.ResponseUserDTO;
import com.example.goblinmarket.user.dto.ResponseUsersDTO;
import com.example.goblinmarket.user.dto.UserDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



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
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUserDTO insertUser(@RequestBody UserDTO u) {
        return new ResponseUserDTO(userService.insertUser(u));
    }

    @PutMapping("/{id}")
    public ResponseUserDTO updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        return new ResponseUserDTO(userService.updateUser(id, userDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

}
