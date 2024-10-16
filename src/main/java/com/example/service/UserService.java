package com.example.service;

import org.springframework.stereotype.Service;

@Service  // Marks this class as a service component
public class UserService {

    public boolean validateUser(String username, String password) {
        // Simplified login validation logic
        return "user".equals(username) && "password".equals(password);
    }
}
