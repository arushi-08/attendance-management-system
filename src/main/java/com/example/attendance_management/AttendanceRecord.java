package com.example.attendance_management;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AttendanceRecord {
    private Attendee attendee;
    private Boolean present;
}
