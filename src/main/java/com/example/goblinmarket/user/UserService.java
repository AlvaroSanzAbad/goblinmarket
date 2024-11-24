package com.example.goblinmarket.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.goblinmarket.user.dto.UserDTO;
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

    public UserWithNothing insertUser(UserDTO userDTO){
        User user = userRepository.save(User.fromDTO(userDTO));
        return userRepository.findUserById(user.getId());
    }

    public UserWithNothing updateUser(int id, UserDTO userDTO){
        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User's not found");
        }
        User user = User.fromDTO(userDTO);
        user.setId(id);
        userRepository.save(user);

        return userRepository.findUserById(user.getId());
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
}
