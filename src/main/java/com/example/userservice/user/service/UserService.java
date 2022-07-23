package com.example.userservice.user.service;

import com.example.userservice.user.dto.UserDto;
import com.example.userservice.user.entity.UserEntity;

public interface UserService {
    UserDto createUser(UserDto usrDto);
    UserDto getUserByUserId(String userId);
    Iterable<UserEntity> getUserByAll();
}
