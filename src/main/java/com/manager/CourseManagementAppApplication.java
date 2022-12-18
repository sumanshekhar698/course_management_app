package com.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)//used to exclude Security
@SpringBootApplication
public class CourseManagementAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseManagementAppApplication.class, args);
    }

}
