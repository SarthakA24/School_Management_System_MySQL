package com.sarthak.repository;

import com.sarthak.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements Repository {
    /**
     * This method runs a query to adds the data for Student to the database
     *
     * @param connection Connection object for the database
     * @param student    Student details to be added
     */
    @Override
    public void addStudentData(Connection connection, Student student) throws SQLException {
        String insertQuery = "INSERT INTO `School`.`Student` " +
                "(`first_name`, `last_name`, `address`, `pin_code`, `guardian_name`, `contact_number`, `guardian_contact_number`) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setInt(4, student.getPinCode());
            preparedStatement.setString(5, student.getGuardianName());
            preparedStatement.setString(6, String.valueOf(student.getContactNumber()));
            preparedStatement.setString(7, String.valueOf(student.getGuardianContactNumber()));
            preparedStatement.executeUpdate();
        }
    }

    /**
     * This method runs a select query in the database to get all details for all the students in the school
     *
     * @param connection Connection object for the database
     * @return List of Students in the school
     */
    @Override
    public List<Student> getAllStudentData(Connection connection) throws SQLException {
        List<Student> studentList = new ArrayList<>();
        String selectQuery = "SELECT * FROM `School`.`Student`;";
        try (Statement statement = connection.createStatement()) {
            ResultSet studentResultSet = statement.executeQuery(selectQuery);
            while (studentResultSet.next()) {
                Student student = new Student();
                student.setFirstName(studentResultSet.getString("first_name"));
                student.setLastName(studentResultSet.getString("last_name"));
                student.setAddress(studentResultSet.getString("address"));
                student.setPinCode(studentResultSet.getInt("pin_code"));
                student.setGuardianName(studentResultSet.getString("guardian_name"));
                student.setContactNumber(Long.parseLong(studentResultSet.getString("contact_number")));
                student.setGuardianContactNumber(Long.parseLong(studentResultSet.getString("guardian_contact_number")));
                studentList.add(student);
            }
        }
        return studentList;
    }

    /**
     * This method runs a delete query in the database to delete the student details
     *
     * @param connection Connection object for the database
     * @param rollNumber The roll number of the student to be deleted
     */
    @Override
    public void deleteStudentData(Connection connection, int rollNumber) throws SQLException {
        String deleteQuery = "DELETE FROM `School`.`Student` WHERE (`roll_number` = ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, rollNumber);
            preparedStatement.executeUpdate();
        }
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
