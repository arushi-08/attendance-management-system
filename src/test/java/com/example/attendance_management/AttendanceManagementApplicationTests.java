package com.example.attendance_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


class AttendanceManagementApplicationTests {

    @Test
	void contextLoads() {
	}
    @Mock
    private Organization organization;

    @Mock
    private AttendanceService attendanceService;

    @InjectMocks
    private AttendanceManagementApplication controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addAttendee_Success() throws Exception {
        String name = "Alice";
        doNothing().when(attendanceService).addAttendee(any(Attendee.class));
        ResponseEntity<?> response = controller.addAttendee(name);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().toString().contains("Attendee added successfully"));
        verify(attendanceService, times(1)).addAttendee(any(Attendee.class));
    }

    @Test
    void addAttendee_Failure() throws Exception {
        String name = "Bob";
        doThrow(new RuntimeException("Error adding attendee")).when(attendanceService).addAttendee(any(Attendee.class));
        ResponseEntity<?> response = controller.addAttendee(name);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertTrue(response.getBody().toString().contains("Failed to add attendee"));
        verify(attendanceService, times(1)).addAttendee(any(Attendee.class));
    }
}
