package com.sarthak.service;

import java.sql.Connection;

public class DatabaseService {
    private static final String URL = "jdbc:mysql://localhost:3306/School";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";
    private Connection connection;
}
