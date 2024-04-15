package com.demo;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
    static Connection connection = null;
    public static Connection connection() {
        try {
            //Load the driver
            String url = "jdbc:mysql://localhost:3306/EmployeeManagement";
            String userName = "root";
            String password = "Voda@*8Root";

            //establish connection
            connection = DriverManager.getConnection(url, userName, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}