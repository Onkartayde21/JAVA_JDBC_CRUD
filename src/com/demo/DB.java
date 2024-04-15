package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DB {
    public void createDB()
    {

        try {
            //Load the driver
            String url = "jdbc:mysql://localhost:3306/";
            String userName = "root";
            String password = "Voda@*8Root";

            //establish connection
            Connection connection = DriverManager.getConnection(url, userName, password);
            Statement statement = connection.createStatement();
            String query = "create database EmployeeManagement";
            statement.execute(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void createTable(){
        try {
            //Load the driver
            String url = "jdbc:mysql://localhost:3306/EmployeeManagement";
            String userName = "root";
            String password = "Voda@*8Root";

            //establish connection
            Connection connection = DriverManager.getConnection(url, userName, password);
            Statement statement = connection.createStatement();
            String query = "create table employee(id int(6), name varchar(200), email varchar(200), designation varchar(200), salary int(6))";
            statement.execute(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
