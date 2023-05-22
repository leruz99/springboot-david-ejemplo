package com.example.crud.service;

import com.example.crud.entity.User;
import com.example.crud.repository.UserRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRespository userRespository;

    public UserServiceImpl(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    @Override
    public User saveUser(User user) {
        return userRespository.save(user);
    }

    @Override
    public User getUser(String name) {
        return userRespository.findByName(name);
    }

    @Override
    public User updateUser(User user) {
        return userRespository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRespository.deleteById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userRespository.findAll();
    }
}
