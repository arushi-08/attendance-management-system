package com.example.attendance_management;

import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    private Register register;
    private Admin admin;

    public AttendanceService(Organization organization, Admin admin) {
        this.register = new Register(organization);
        System.out.println("initializing register for organization " + organization.getName());
        System.out.println("for admin " + admin.getUserName());
        this.admin = admin;
    }

    public void addAttendee(Attendee attendee) {
        if (this.admin != null) {
            AttendanceRecord record = new AttendanceRecord();
            record.addAttendee(attendee);
            this.register.addAttendee(record);
        } else {
            throw new UnauthorizedAccessException("only admins can take attendance");
        }
    }
}
