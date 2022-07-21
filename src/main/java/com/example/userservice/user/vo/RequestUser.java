package com.example.userservice.user.vo;

import lombok.Data;

@Data
public class RequestUser {
    private String email;
    private String pwd;
    private String name;
}
