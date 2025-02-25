package com.example.attendance_management;

public class AttendanceRecord {
    private Attendee attendee;
    private Boolean present;

    public void addAttendee(Attendee attendee){
        this.attendee = attendee;
        this.present = true;
    }
}
