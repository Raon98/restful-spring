package com.restful_spring.service.user;


import com.restful_spring.entity.user.User;
import com.restful_spring.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAllUser(){
        return userRepository.findAll();
    }
    public User findByUser(String name){
        return userRepository.findByName(name).orElse(null);
    }
    public void saveUser(User newuser){
        User user = User.createUser(newuser.getName(), newuser.getEmail(), newuser.getPassword());
        userRepository.save(user);
    }
}
