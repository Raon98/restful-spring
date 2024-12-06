package com.restful_spring.repository.user;

import com.restful_spring.entity.user.User;
import com.restful_spring.repository.user.querydsl.UserCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserCustomRepository {

    Optional<User> findByName(String name);

    User save(User user);

    List<User> findAll();
}

