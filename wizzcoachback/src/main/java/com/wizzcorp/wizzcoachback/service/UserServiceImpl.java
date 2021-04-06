package com.wizzcorp.wizzcoachback.service;

import com.wizzcorp.wizzcoachback.model.Account;
import com.wizzcorp.wizzcoachback.model.User;
import com.wizzcorp.wizzcoachback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
                userRepository.deleteById(id);
    }

    @Override
    public List<User> userList() {
       return userRepository.findAll();
    }
}
