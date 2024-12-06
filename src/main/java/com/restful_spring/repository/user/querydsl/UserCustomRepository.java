package com.restful_spring.repository.user.querydsl;

import com.restful_spring.entity.user.User;

import java.util.List;
import java.util.Optional;

public interface UserCustomRepository {
    User save(User user);
    Optional<User> findByName(String name);
    Optional<User> findById(Long id);
    List<User> findAll();
}
