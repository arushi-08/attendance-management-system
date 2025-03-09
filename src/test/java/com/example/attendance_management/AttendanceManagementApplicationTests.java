package com.example.attendance_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class AttendanceManagementApplicationTests {

    @InjectMocks
    private AttendeeService attendeeService;

    @Mock
    private AttendeeRepository attendeeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addAttendee_Success() throws Exception {
        Attendee attendee = new Attendee("Alice", "Org 1");
        
        when(attendeeRepository.save(any(Attendee.class))).thenReturn(attendee);

        ResponseEntity<?> response = attendeeService.addAttendee(attendee);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Attendee added successfully", response.getBody());
        verify(attendeeRepository, times(1)).save(any(Attendee.class));
    }

    @Test
    void addAttendee_Failure() throws Exception {
        Attendee attendee = new Attendee("Bob", "Org 1");
        
        when(attendeeRepository.save(any(Attendee.class)))
            .thenThrow(new IllegalArgumentException("Error adding attendee"));

        ResponseEntity<?> response = attendeeService.addAttendee(attendee);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertTrue(response.getBody().toString().contains("Invalid input: Error adding attendee"));
        verify(attendeeRepository, times(1)).save(any(Attendee.class));
    }
}
