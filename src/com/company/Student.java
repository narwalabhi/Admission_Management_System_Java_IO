package com.company;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private static int count = 1000;
    private int regNo;
    private String name;
    private int age;
    private Date dob;
    private Course course;

    public Student(){

    }

    public Student(String name, int age, Date dob) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.regNo = ++count;
    }

    public static void setStaticRegno(int regno) {
        count = regno;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void displaySubject(){
        course.display();
    }

    @Override
    public String toString() {
        return "Student{" +
                "regNo=" + regNo + "\n"+
                ", name='" + name + "\'\n" +
                ", age=" + age + "\n" +
                ", dob=" + dob + "\n" +
                ", course=" + course.getName() + "\n"+
                '}';
    }
}
