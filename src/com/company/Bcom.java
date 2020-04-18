package com.company;

import java.io.Serializable;

public class Bcom implements Course, Serializable {
    private final String name = "Bachelor of Technology";
    private String[] subjects = new String[]{
        "Accountancy", "Statistics", "Management", "Human Resource", "Economics", "English"
    };

    public Bcom() {
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
