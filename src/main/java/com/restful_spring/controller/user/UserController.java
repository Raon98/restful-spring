package com.restful_spring.controller.user;


import com.restful_spring.common.utils.ApiResponseEntity;
import com.restful_spring.dto.user.response.UserDto;
import com.restful_spring.entity.user.User;
import com.restful_spring.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService UserService;

    @GetMapping("/{name}")
    public ApiResponseEntity<?> findByUser(@PathVariable String name){
        UserDto user = UserService.findByUser(name);
        return ApiResponseEntity.builder().code(HttpStatus.OK).message("200 ok").data(user).build();
    }

    @GetMapping("/all")
    public ApiResponseEntity<?> findAllUser(){
        List<User> user = UserService.findAllUser();
        return ApiResponseEntity.builder().code(HttpStatus.OK).message("200 ok").data(user).build();
    }

   @PostMapping
    public ApiResponseEntity<?> saveUser(@RequestBody User user){
       UserService.saveUser(user);
        return ApiResponseEntity.builder().code(HttpStatus.OK).message("200 ok").data("완료").build();
    }
}
