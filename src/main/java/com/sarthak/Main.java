package com.sarthak;

import com.sarthak.model.Student;
import com.sarthak.repository.StudentRepository;
import com.sarthak.service.DatabaseService;
import com.sarthak.service.DisplayService;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DatabaseService databaseService = new DatabaseService();
        StudentRepository studentRepository = new StudentRepository();
        Student student = new Student();
        int choice = 0;
        do {
            DisplayService.displayMenu();
            try {
                databaseService.connect();
                Connection connection = databaseService.getConnection();
            } catch (SQLException e) {
                System.err.println("!!Database Connection Failed!!");
            }
        } while (choice != 0);
    }
}