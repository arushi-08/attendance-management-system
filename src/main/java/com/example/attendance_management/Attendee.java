package com.example.attendance_management;

public class Attendee {
    private Long id;
    private String name;
    private String email_id;
    private String phone_num;
    private Organization organization;

    public Attendee(String name, Organization organization){
        this(name, null, null, organization);
    }
    public Attendee(String name, String email_id, String phone_num, Organization organization){
        this.name = name;
        this.email_id = email_id;
        this.phone_num = phone_num;
        this.organization = organization;
    }
}
