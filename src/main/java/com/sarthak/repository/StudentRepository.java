package com.sarthak.repository;

import com.sarthak.model.Student;

import java.sql.Connection;
import java.util.List;

public class StudentRepository implements Repository {
    /**
     * This method runs a query to adds the data for Student to the database
     *
     * @param connection Connection object for the database
     * @param student    Student details to be added
     */
    @Override
    public void addStudentData(Connection connection, Student student) {

    }

    /**
     * This method runs a select query in the database to get all details for all the students in the school
     *
     * @param connection Connection object for the database
     * @return List of Students in the school
     */
    @Override
    public List<Student> getAllStudentData(Connection connection) {
        return null;
    }

    /**
     * This method runs a delete query in the database to delete the student details
     *
     * @param connection Connection object for the database
     * @param rollNumber The roll number of the student to be deleted
     */
    @Override
    public void deleteStudentData(Connection connection, int rollNumber) {

    }

    /**
     * This method runs a select query in the database to search the student based on the roll number
     *
     * @param connection Connection object for the database
     * @param rollNumber The roll number of the student to search
     * @return The student details for the given roll number, or a blank Student object if the student is not found
     */
    @Override
    public Student searchStudentByRollNumber(Connection connection, int rollNumber) {
        return null;
    }
}
