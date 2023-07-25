package com.katsevich.mvcapp.service;

import com.katsevich.mvcapp.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public void addUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);

}
