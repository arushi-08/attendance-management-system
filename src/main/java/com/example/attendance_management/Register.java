package com.example.attendance_management;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private Organization organization;
    private List<AttendanceRecord> attendanceRecords;

    public void addAttendee(AttendanceRecord record) {
        this.attendanceRecords.add(record);
        System.out.println("Record added to register ");
    }
}