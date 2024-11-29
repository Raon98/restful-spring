package com.restful_spring.controller.user;


import com.restful_spring.common.utils.ApiResponseEntity;
import com.restful_spring.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService UserService;

    @GetMapping("/user")
    public ApiResponseEntity<?> User(){

        String User = UserService.User();
        return ApiResponseEntity.builder().code(HttpStatus.OK).message("200 ok").data(User).build();
    }
}
