package com.sarthak;

import com.sarthak.model.Student;
import com.sarthak.repository.StudentRepository;
import com.sarthak.service.DatabaseService;

public class Main {
    public static void main(String[] args) {
        DatabaseService databaseService = new DatabaseService();
        StudentRepository studentRepository = new StudentRepository();
        Student student = new Student();
    }
}