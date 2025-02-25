package com.example.attendance_management;

import java.util.ArrayList;
import java.util.List;

public class Register {
    private Long id;
    private Organization organization;
    private List<AttendanceRecord> attendanceRecords;

    public Register(Organization organization) {
        this.organization = organization;
        this.attendanceRecords = new ArrayList<>();
    }

    public void addAttendee(AttendanceRecord record) {
        this.attendanceRecords.add(record);
        System.out.println("Record added to register");
    }
}