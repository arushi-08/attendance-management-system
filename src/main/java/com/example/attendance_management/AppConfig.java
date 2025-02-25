package com.example.attendance_management;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Organization organization() {
        return new Organization("University of Pittsburgh");
    }

    @Bean
    public Admin admin() {
        return new Admin("Jean Wenner");
    }

}
