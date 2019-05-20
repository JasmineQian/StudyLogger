package com.example.demo.service.impl;

import com.example.demo.bean.dto.User;
import com.example.demo.mapper.ContentMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Primary
public class UserServiceImpl implements UserService {

    // 记录器
    Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private UserMapper userMapper;


    @Override
    public int insert(User user) {

        System.out.println("000000000000000000000000000000");
        System.out.println(user);

        String password = user.getPassword();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String pass = passwordEncoder.encode(password);
        user.setPassword(pass);
        System.out.println(user);

        int count = userMapper.insert(user);
        return count;
    }

    @Override
    public User getByUsername(String username) {

        User user = new User();
        user.setUsername(username);
        User user1 = userMapper.findByUsername(user);
        logger.info(user1.toString());

        if (user1 != null)
            return user1;
        else return null;

    }

    @Override
    public int checkUsername(User user) {
        int count = userMapper.checkByUsername(user);
        System.out.println("------------------");
        System.out.println(count);
        if (count == 0)
            return count;
        else
            return -1;

    }

}
