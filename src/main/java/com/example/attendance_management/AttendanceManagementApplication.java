package com.example.attendance_management;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AttendanceManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceManagementApplication.class, args);
	}

}
// web application that manages the attendance of any student in school or
// college,
// also employees in an organization. It has an admin feature that holds the
// access
// to do any kind of changes like update, delete, and add user records to the
// list.

/*
 * core logic
 * entities:
 * Attendees
 * Organizations
 * Admin
 * 
 * service layer
 * AttendanceService
 * AdminService
 * 
 * data access layer
 * AttendeeRepository
 * OrganizationRepository
 * AdminRepository
 */
