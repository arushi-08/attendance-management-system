package com.example.attendance_management;

import org.springframework.stereotype.Component;

@Component
public class Organization {
    private String name;
    private String type;

    public Organization(String name) {
        this(name, null);
    }

    public Organization(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
