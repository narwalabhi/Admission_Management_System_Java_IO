package com.company;

import java.io.Serializable;

public class Bca implements Course, Serializable {
    private final String name = "Bachelor of Technology";
    private String[] subjects = new String[]{
            "Computer Fundamentals", "C-Programming", "Mathematics", "Operating Systems", "Digital Computer Fundamentals", "English"
    };

    public Bca() {
    }

    private int duration = 3;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public void display() {
        for(int i = 0; i < subjects.length; i++){
            System.out.println((i+1) + ". " + subjects[i]);
        }
    }
}
