package com.example.crud.service;

import com.example.crud.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUser(String  name);
    User updateUser(User user);
    void delete(Long id);
    List<User> getAllUser();
}
