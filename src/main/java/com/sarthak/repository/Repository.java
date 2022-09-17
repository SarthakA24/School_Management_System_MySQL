package com.sarthak.repository;

import com.sarthak.model.Student;

import java.sql.Connection;
import java.util.List;

public interface Repository {
    void addStudentData(Connection connection, Student student);

    List<Student> getAllStudentData(Connection connection);

    void deleteStudentData(Connection connection, int rollNumber);

    Student searchStudentByRollNumber(Connection connection, int rollNumber);

    void deleteStudent(Connection connection, int rollNumber);
}
