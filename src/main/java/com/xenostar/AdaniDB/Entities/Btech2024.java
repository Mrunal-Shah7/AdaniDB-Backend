package com.xenostar.AdaniDB.Entities;

import lombok.Data;

@Data
public class Btech2024 {
    private Long SR;
    private String TEMP;
    private String NAME;
    private String PROGRAM;
    private String DIVISION;

    public Long getSR() {
        return SR;
    }

    public void setSR(Long SR) {
        this.SR = SR;
    }

    public String getTEMP() {
        return TEMP;
    }

    public void setTEMP(String TEMP) {
        this.TEMP = TEMP;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getPROGRAM() {
        return PROGRAM;
    }

    public void setPROGRAM(String PROGRAM) {
        this.PROGRAM = PROGRAM;
    }

    public String getDIVISION() {
        return DIVISION;
    }

    public void setDIVISION(String DIVISION) {
        this.DIVISION = DIVISION;
    }
}