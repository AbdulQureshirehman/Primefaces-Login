package com.example.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.example.service.DataService;
import com.example.service.UserService;

@Component
@RequestScope // Alternatively, use @Scope("view") if you're using Spring WebFlow
public class LoginController {

    private String username;
    private String password;

    @Autowired
    private UserService userService;

    @Autowired
    private DataService dataService;

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Login method
    public void login() {
        boolean isValidUser = userService.validateUser(username, password);
        if (isValidUser) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Login successful", "Welcome!"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed", "Invalid credentials"));
        }
    }
}
