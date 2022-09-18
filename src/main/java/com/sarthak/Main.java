package com.sarthak;

import com.sarthak.model.Student;
import com.sarthak.repository.StudentRepository;
import com.sarthak.service.DatabaseService;
import com.sarthak.service.DisplayService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseService databaseService = new DatabaseService();
        StudentRepository studentRepository = new StudentRepository();
        int choice = 0;
        do {
            try {
                Connection connection = databaseService.getConnection();
                DisplayService.displayMenu();
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();
                if (choice == 1) {
                    System.out.println("You have selected - \"1. Add a student to the school.\"");
                    System.out.println("Please Enter the Details of the Student - ");
                    System.out.println("Enter the First Name - ");
                    Student student = new Student();
                    student.setRollNumber(0);
                    student.setFirstName(scanner.nextLine());
                    System.out.println("Enter the Last Name - ");
                    student.setLastName(scanner.nextLine());
                    System.out.println("Enter the address - ");
                    student.setAddress(scanner.nextLine());
                    System.out.println("Enter the pin code - ");
                    student.setPinCode(scanner.nextInt());
                    System.out.println("Enter the Guardian's Name - ");
                    student.setGuardianName(scanner.nextLine());
                    System.out.println("Enter Student's contact number - ");
                    student.setContactNumber(scanner.nextLong());
                    System.out.println("Enter Guardian's contact number - ");
                    student.setGuardianContactNumber(scanner.nextLong());
                    studentRepository.addStudentData(connection, student);
                } else if (choice == 2) {

                }
            } catch (SQLException e) {
                System.err.println("!!!Error connecting with database!!!");
                choice = 0;
            }
        } while (choice != 0);
    }
}