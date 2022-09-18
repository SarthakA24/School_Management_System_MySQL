package com.sarthak.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    private static final String URL = "jdbc:mysql://localhost:3306/School";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";
    private Connection connection;

    public DatabaseService() {
        this.connection = null;
    }

    public Connection getConnection() {
        return connection;
    }

    /**
     * This method establishes a connection with the database
     *
     * @throws SQLException Throws SQL exception if the database connection fails
     */
    public void connect() throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        if (connection != null) System.out.println("Database Connected!!");
        else System.err.println("!!Database Connection Failed!!");
    }
}
