package com.sarthak.repository;

import com.sarthak.model.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repository {
    /**
     * This method runs a query to adds the data for Student to the database
     *
     * @param connection Connection object for the database
     * @param student    Student details to be added
     */
    void addStudentData(Connection connection, Student student) throws SQLException;

    /**
     * This method runs a select query in the database to get all details for all the students in the school
     *
     * @param connection Connection object for the database
     * @return List of Students in the school
     */
    List<Student> getAllStudentData(Connection connection) throws SQLException;

    /**
     * This method runs a delete query in the database to delete the student details
     *
     * @param connection Connection object for the database
     * @param rollNumber The roll number of the student to be deleted
     */
    void deleteStudentData(Connection connection, int rollNumber) throws SQLException;

    /**
     * This method runs a select query in the database to search the student based on the roll number
     *
     * @param connection Connection object for the database
     * @param rollNumber The roll number of the student to search
     * @return The student details for the given roll number, or a blank Student object if the student is not found
     */
    Student searchStudentByRollNumber(Connection connection, int rollNumber);
}
