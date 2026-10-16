package com.klu.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.springmvc.model.User;
import com.klu.springmvc.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public User getUserById(int id) {
        return repo.findById(id).orElse(null);
    }

    public User getUserByUsername(String username) {
        return repo.findByUsername(username);
    }
}