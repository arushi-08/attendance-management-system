package com.example.attendance_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AttendanceManagementApplication implements CommandLineRunner {

	@Autowired
	private AttendanceService attendanceService;

	@Autowired
	private Organization organization;

	public static void main(String[] args) {
		SpringApplication.run(AttendanceManagementApplication.class, args);
	}

	@Override
	public void run(String[] args) throws Exception {
		Attendee attendee = new Attendee("Arushi", organization);
		attendanceService.addAttendee(attendee);
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
