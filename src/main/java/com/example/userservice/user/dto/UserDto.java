package com.example.userservice.user.dto;

import com.example.userservice.user.vo.ResponseOrder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserDto {
    private String email;
    private String pwd;
    private String name;
    private String userId;
    private LocalDateTime createdAt;
    private String encryptedPwd;
    private List<ResponseOrder> orders;
}
