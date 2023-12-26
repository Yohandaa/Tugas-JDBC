package com.PBO11;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/nama_database";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
