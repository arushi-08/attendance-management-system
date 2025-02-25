package com.example.attendance_management;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AttendanceManagementApplication {

	@Autowired
	private Organization organization;

	@Autowired
	private AttendanceService attendanceService;

	public static void main(String[] args) {
		SpringApplication.run(AttendanceManagementApplication.class, args);
	}

	@PostMapping("/attendee/add")
	public ResponseEntity<?> addAttendee(@RequestBody String name) throws Exception {
		try {
			Attendee attendee = new Attendee(name, organization);
			attendanceService.addAttendee(attendee);
			return ResponseEntity.ok("Attendee added successfully");
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(Map.of("error", "Invalid input: " + e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
					"Failed to add attendee: " + e.getMessage());
		}
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
