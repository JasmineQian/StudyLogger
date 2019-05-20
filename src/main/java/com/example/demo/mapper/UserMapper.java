package com.example.demo.mapper;

import com.example.demo.bean.dto.User;

public interface UserMapper {

    int insert(User record);

    User findByUsername(User record);

    int checkByUsername(User record);
}
