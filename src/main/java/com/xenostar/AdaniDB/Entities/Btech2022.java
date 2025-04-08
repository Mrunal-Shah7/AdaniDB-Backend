package com.xenostar.AdaniDB.Entities;


public class Btech2022 {
    private String Name;
    private String USN;
    private String Contact;
    private Long Enrollment;
    private String Division;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getUSN() {
        return USN;
    }

    public void setUSN(String USN) {
        this.USN = USN;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        this.Contact = contact;
    }

    public Long getEnrollment() {
        return Enrollment;
    }

    public void setEnrollment(Long enrollment) {
        this.Enrollment = enrollment;
    }

    public String getDivision() {
        return Division;
    }

    public void setDivision(String division) {
        this.Division = division;
    }
}