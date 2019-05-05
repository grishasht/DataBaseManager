package model.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    private static final String USER_NAME = "grisha";
    private static final String USER_PASSWORD = "11111";
    private static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/filmStudio";

    public static void setConnection(){
        java.sql.Connection connection;

        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER_NAME, USER_PASSWORD);
            System.out.println("PostgreSQL JDBC Driver successfully connected");
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
