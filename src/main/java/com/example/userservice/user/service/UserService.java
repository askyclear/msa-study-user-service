package com.example.userservice.user.service;

import com.example.userservice.user.dto.UserDto;
import com.example.userservice.user.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto usrDto);
    UserDto getUserByUserId(String userId);
    Iterable<UserEntity> getUserByAll();
}
