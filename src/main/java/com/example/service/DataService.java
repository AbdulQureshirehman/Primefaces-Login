package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class DataService {

    public Object getDataForUser(String username) {
        // Fetch data for the logged-in user from the database or other services
        return "Some user-related data";
    }
}
