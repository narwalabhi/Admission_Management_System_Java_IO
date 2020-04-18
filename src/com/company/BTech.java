package com.company;

import java.io.Serializable;

public class BTech implements Course, Serializable {
    private final String name = "Bachelor of Technology";
    private String[] subjects = new String[]{
            "Mechanics", "C-Programming", "Mathematics", "Environmental Chemistry", "Electronics", "English"
    };

    public BTech() {
    }

    private int duration = 4;

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
