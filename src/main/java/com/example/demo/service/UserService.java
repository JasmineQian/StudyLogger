package com.example.demo.service;


import com.example.demo.bean.dto.User;

public interface UserService {

    int insert(User user);

    User getByUsername(String username);

    int checkUsername(User user);

}
