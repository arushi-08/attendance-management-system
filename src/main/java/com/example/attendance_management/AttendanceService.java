package com.example.attendance_management;

import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    private Register register;

    public AttendanceService(Organization organization) {
        this.register = new Register(organization);
    }

    public void addAttendee(Attendee attendee) {
        AttendanceRecord record = new AttendanceRecord();
        record.addAttendee(attendee);
        this.register.addAttendee(record);
    }
}
