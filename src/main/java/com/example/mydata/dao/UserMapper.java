package com.example.mydata.dao;


import com.example.mydata.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();

    User findByUsername(String username);

    void save(User user);

    User loginUser(@Param("id") String id, @Param("password") String password);
}
