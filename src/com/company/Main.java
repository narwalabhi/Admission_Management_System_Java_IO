package com.company;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static final String fileName = "students.dat";
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        setRegno();
        System.out.println("**********Admission Management System**********");
        int choice = 0;
        while(choice != 6){
            System.out.println(
                    "1. New Admission.\n"
                   +"2. Update Student Data.\n"
                   +"3. View Students.\n"
                   +"4. Remove Student.\n"
                   +"5. Remove All Students.\n"
                   +"6. Exit"
            );
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                   if(addStudent()){
                       System.out.println("Student added successfully!");
                   }else {
                       System.out.println("Student couldn't be added!");
                   }
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    viewStudents();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    deleteAllStudentss();
                    break;
                case 6:

            }
        }
    }

    private static void setRegno() throws IOException, ClassNotFoundException {
        File file = new File(fileName);
        if(!file.exists()){
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        int regno = 0;
        Student student = null;
        boolean ifExist = true;
        while(ifExist){
            if(fileInputStream.available() != 0){
                student = (Student) objectInputStream.readObject();
                System.out.println(student);
                regno = student.getRegNo();
            }
            else{
                ifExist =false;
            }
        }
        Student.setStaticRegno(regno);
        fileInputStream.close();
    }

    private static void deleteAllStudentss() {
        File file = new File(fileName);
        if(file.delete()){
            System.out.println("Data deleted!");
        }else{
            System.out.println("Failed to delete.");
        }
    }

    private static void viewStudents() throws IOException, ClassNotFoundException {
         File file = new File(fileName);
        if(!file.exists()){
            System.out.println("No data found!");
        }else{
            System.out.println("Student Data: ");
        }
        FileInputStream fileInputStream = new FileInputStream(file));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Student student = null;
        boolean ifExist = true;
        while(ifExist){
            if(fileInputStream.available() != 0){
                student = (Student) objectInputStream.readObject();
                System.out.println(student);
            }
            else{
                ifExist =false;
            }
        }
        fileInputStream.close();
    }

    private static boolean deleteStudent() throws IOException, ClassNotFoundException {
        System.out.println("Enter reg no:");
        int regno = scanner.nextInt();
        File file = new File(fileName);
        File file1 = new File("temp.dat");
        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        FileInputStream fileInputStream = new FileInputStream(new File(fileName));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Student student = null;
        boolean ifExist = true, found = false;
        while(ifExist){
            if(fileInputStream.available() != 0){
                student = (Student) objectInputStream.readObject();
                if(student.getRegNo() == regno){
                    scanner.nextLine();
                    System.out.println("Student Found!\n" + "Do you want to delete?(y/n)");
//                    System.out.println(student);
                    found = true;
                    char c = scanner.nextLine().charAt(0);
                    if(c == 'y' || c == 'Y'){
                        continue;
                    }
                    Student obj = StudentBuilder();
                    obj.setRegNo(student.getRegNo());
                    objectOutputStream.writeObject(obj);
                }else{
                    objectOutputStream.writeObject(student);
                }
            }
            else{
                ifExist =false;
            }
        }
        if(!found){
            System.out.println("Student Not Found!");
        }
        if(file.delete()){
            if(file1.renameTo(new File(fileName))){
                System.out.println("Data Deleted successfully!");
            }
        }
        fileInputStream.close();
        return true;
    }

    private static boolean updateStudent() throws IOException, ClassNotFoundException {
        System.out.println("Enter reg no:");
        int regno = scanner.nextInt();
        File file = new File(fileName);
        File file1 = new File("temp.dat");
        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        FileInputStream fileInputStream = new FileInputStream(new File(fileName));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Student student = null;
        boolean ifExist = true, found = false;
        while(ifExist){
            if(fileInputStream.available() != 0){
                student = (Student) objectInputStream.readObject();
                if(student.getRegNo() == regno){
                    System.out.println("Student Found!");
//                    System.out.println(student);
                    found = true;
                    Student obj = StudentBuilder();
                    obj.setRegNo(student.getRegNo());
                    objectOutputStream.writeObject(obj);
                }else{
                    objectOutputStream.writeObject(student);
                }
            }
            else{
                ifExist =false;
            }
        }
        if(!found){
            System.out.println("Student Not Found!");
        }
        if(file.delete()){
            if(file1.renameTo(new File(fileName))){
                System.out.println("Data Updated successfully!");
            }
        }
        fileInputStream.close();
        return true;
    }

    private static boolean addStudent() throws IOException {
        File file = new File(fileName);
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        if(file.exists()){
            fileOutputStream = new FileOutputStream(file,true);
            objectOutputStream = new AppendingObjectOutputStream(fileOutputStream);
        }else{
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
        }
        Student student = StudentBuilder();
        try{
            objectOutputStream.writeObject(student);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        objectOutputStream.close();
        fileOutputStream.close();
        return true;
    }

    private static Student StudentBuilder(){
        scanner.nextLine();
        System.out.println("Enter Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Age:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter DOB(dd/mm/yyyy):");
        String strDob = scanner.nextLine();
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(strDob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Student student = new Student(name, age, date);
        scanner.nextLine();
        System.out.println("Select Course:");
        System.out.println(
                "1. Bachelor of Technology\n" +
                        "2. Master of Business Administration\n" +
                        "3. Bachelor of Commerce\n" +
                        "4. Bachelor of Business Administration\n" +
                        "5. Bachelor of Computer Application");
        int ch = scanner.nextInt();
        switch (ch){
            case 1:
                BTech bTech = new BTech();
                student.setCourse(bTech);
                break;
            case 2:
                Mba mba = new Mba();
                student.setCourse(mba);
                break;
            case 3:
                Bcom bcom = new Bcom();
                student.setCourse(bcom);
                break;
            case 4:
                Bba bba = new Bba();
                student.setCourse(bba);
                break;
            case 5:
                Bca bca = new Bca();
                student.setCourse(bca);
                break;
            default:
                System.out.println("It's okay you can decide later! :) ");
        }
        return student;
    }
}
