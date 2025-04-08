package com.xenostar.AdaniDB.Entities;

import lombok.Data;

@Data
public class Btech2023 {
    private Long Enrollment;
    private String Name;
    private String Division;

    public Long getEnrollment() {
        return Enrollment;
    }

    public void setEnrollment(Long enrollment) {
        this.Enrollment = enrollment;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getDivision() {
        return Division;
    }

    public void setDivision(String division) {
        this.Division = division;
    }
}