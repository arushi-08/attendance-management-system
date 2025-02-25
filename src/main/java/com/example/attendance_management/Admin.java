package com.example.attendance_management;

import org.springframework.stereotype.Component;

@Component
public class Admin {
    private Long id;
    private String username;
    private String password;
    private Organization organization;

    public Admin(String name) {
        this.username = name;
    }

    public String getUserName() {
        return this.username;
    }
}
