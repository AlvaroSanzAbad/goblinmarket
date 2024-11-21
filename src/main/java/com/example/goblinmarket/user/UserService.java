package com.example.goblinmarket.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.goblinmarket.user.projections.UserWithNothing;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<UserWithNothing> getUsers(){
        return userRepository.findAllBy();
    }

    public UserWithNothing getUser(int id){
        return userRepository.findUserById(id);
    }
}
