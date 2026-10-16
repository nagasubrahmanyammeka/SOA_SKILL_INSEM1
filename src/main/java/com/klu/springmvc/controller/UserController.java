package com.klu.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.klu.springmvc.model.User;
import com.klu.springmvc.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/{id}")
    public Object getUserById(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();

        try {
            User user = service.getUserById(id);

            if (user == null) {
                throw new Exception("User Not Found");
            }

            return new UserResponse(user.getId(), user.getUsername());

        } catch (Exception e) {
            response.put("code", 404);
            response.put("message", "User Not Found");
            return response;
        }
    }

    @GetMapping("/username/{username}")
    public Object getUserByUsername(@PathVariable String username) {
        Map<String, Object> response = new HashMap<>();

        try {
            User user = service.getUserByUsername(username);

            if (user == null) {
                throw new Exception("User Not Found");
            }

            return new UserResponse(user.getId(), user.getUsername());

        } catch (Exception e) {
            response.put("code", 404);
            response.put("message", "User Not Found");
            return response;
        }
    }

    public record UserResponse(int id, String username) {
    }
}