package com.example.attendance_management;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Controller
@RequestMapping("/attendee")
public class AttendeeService {

    @Autowired
    private AttendeeRepository attendeeRepository;

    @PostMapping("/add")
	public ResponseEntity<?> addAttendee(@Valid @RequestBody Attendee attendee) throws Exception {
		try {
			attendeeRepository.save(attendee);
			return ResponseEntity.ok("Attendee added successfully");
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(Map.of("error", "Invalid input: " + e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
					"Failed to add attendee: " + e.getMessage());
		}
	}

}