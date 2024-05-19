package com.example.mydata.service;

import com.example.mydata.dto.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> findAll();

    User loginUser(Map<String, String> loginData);
}
