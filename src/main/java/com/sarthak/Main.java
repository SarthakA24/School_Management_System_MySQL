package com.sarthak;

import com.sarthak.model.Student;
import com.sarthak.repository.StudentRepository;
import com.sarthak.service.DatabaseService;
import com.sarthak.service.DisplayService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseService databaseService = new DatabaseService();
        StudentRepository studentRepository = new StudentRepository();
        int choice;
        do {
            try {
                databaseService.connect();
                Connection connection = databaseService.getConnection();
                DisplayService.displayMenu();
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
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
                    }
                    case 2 -> {
                        System.out.println("You have selected - \"2. Display all the students in the school.\"");
                        List<Student> studentList = studentRepository.getAllStudentData(connection);
                        if (studentList.size() == 0) {
                            System.err.println("There are no students enrolled in the School!");
                            choice = 0;
                        } else {
                            System.out.println("All Students enrolled in the School are - ");
                            studentList.forEach(System.out::println);
                        }
                    }
                    case 3 -> {
                        System.out.println("You have selected - \"3. Find a student's details.\"");
                        System.out.println("Please enter the Roll Number for the Student to search - ");
                        int rollNumberToSearch = scanner.nextInt();
                        Student studentByRollNumber = studentRepository.searchStudentByRollNumber(connection, rollNumberToSearch);
                        if (studentByRollNumber == null) {
                            System.out.println("Student not Found with the Roll Number = " + rollNumberToSearch);
                            choice = 0;
                        }
                        System.out.println(studentByRollNumber);
                    }
                    case 4 -> {
                        System.out.println("You have selected - \"4. Remove a student from the school.\"");
                        System.out.println("Please enter the Roll Number for the Student to remove - ");
                        int rollNumberToRemove = scanner.nextInt();
                        Student studentByRollNumber = studentRepository.searchStudentByRollNumber(connection, rollNumberToRemove);
                        if (studentByRollNumber == null) {
                            System.out.println("Student not Found with the Roll Number = " + rollNumberToRemove);
                            choice = 0;
                        } else {
                            studentRepository.deleteStudentData(connection, rollNumberToRemove);
                        }
                    }
                    case 5 -> System.out.println("Exit!");
                    default -> {
                        System.out.println("Invalid Input!! Please try Again");
                        choice = 0;
                    }
                }
            } catch (SQLException e) {
                System.err.println("!!!Error connecting with database!!!");
                choice = 0;
            }
        } while (choice != 5);
    }
}