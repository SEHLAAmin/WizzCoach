package com.wizzcorp.wizzcoachback.service;

import com.wizzcorp.wizzcoachback.model.User;

import java.util.List;

public interface UserService{


    User saveUser(User user);
    void deleteUser(int id);
    List<User> userList();
}
