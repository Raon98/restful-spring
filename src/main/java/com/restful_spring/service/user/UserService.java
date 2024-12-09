package com.restful_spring.service.user;


import com.restful_spring.dto.user.response.UserRep;
import com.restful_spring.entity.user.User;
import com.restful_spring.repository.user.UserRepository;
import com.restful_spring.repository.user.querydsl.UserRepositoryImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserRepositoryImpl userRepositoryImpl;

    @Transactional
    public List<User> findAllUser(){
        return userRepository.findAll();
    }
    @Transactional
    public UserRep findByUser(String name){
        return userRepositoryImpl.findByName(name);
    }
    @Transactional
    public void saveUser(User newuser){
        User user = User.createUser(newuser.getName(), newuser.getEmail(), newuser.getPassword());
        userRepository.save(user);
    }
}
