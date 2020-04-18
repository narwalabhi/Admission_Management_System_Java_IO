package com.company;

import java.io.Serializable;

public class Mba implements Course, Serializable {
    private final String name = "Master of Business Administration";
    private String[] subjects = new String[]{
            "Marketing", "Business laws", "Business Management", "Human Resource Management", "Business planning", "Communication Skills"
    };
    private int duration = 2;

    public Mba() {
    }

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
