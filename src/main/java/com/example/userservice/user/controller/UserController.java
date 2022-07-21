package com.example.userservice.user.controller;

import com.example.userservice.user.dto.UserDto;
import com.example.userservice.user.entity.UserEntity;
import com.example.userservice.user.service.UserService;
import com.example.userservice.user.vo.Greeting;
import com.example.userservice.user.vo.RequestUser;
import com.example.userservice.user.vo.ResponseUser;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final Environment environment;
    private final Greeting greeting;

    private final UserService userService;
    @Autowired
    public UserController(Environment environment, Greeting greeting, UserService userService) {
        this.environment = environment;
        this.greeting = greeting;
        this.userService = userService;
    }

    @GetMapping("/health_check")
    public String status() {
        return "It's Working in User Service";
    }

    @GetMapping("/welcome")
    public String welcome() {
//        return environment.getProperty("greeting.message");
        return greeting.getMessage();
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser requestUser) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = modelMapper.map(requestUser, UserDto.class);

        ResponseUser responseUser = modelMapper.map(userService.createUser(userDto), ResponseUser.class);
        return new ResponseEntity<>(responseUser, HttpStatus.CREATED);
    }
}
