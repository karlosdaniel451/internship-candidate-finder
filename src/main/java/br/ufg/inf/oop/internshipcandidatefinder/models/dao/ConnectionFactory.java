package br.ufg.inf.oop.internshipcandidatefinder.models.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static final String DATABASE = "test_database";
    public static final String HOST = "localhost";
    public static final String USER = "karlos";
    public static final String PASSWORD = "123456789";

    public static final String URL = String.format("jdbc:postgresql://%s/%s", HOST, DATABASE);

    public static Connection getConnectionFactory() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
