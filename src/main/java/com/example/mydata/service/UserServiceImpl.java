package com.example.mydata.service;


import com.example.mydata.dao.UserMapper;
import com.example.mydata.dto.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper mapper;

    public UserServiceImpl(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<User> findAll() {
        List<User> users = mapper.findAll();
        return users;
    }

    @Override
    public User loginUser(Map<String, String> loginData) {
        return mapper.loginUser(loginData.get("id"), loginData.get("password"));
    }

}
