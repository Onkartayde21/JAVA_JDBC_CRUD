package com.demo;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDao {
    public static void createEmployee(Employee employee) throws SQLException {
        Connection conn = DataBase.connection();
        String insertQuery = "INSERT INTO employee(id, name, email, designation, salary) VALUES(?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
        preparedStatement.setInt(1, employee.getId());
        preparedStatement.setString(2, employee.getName());
        preparedStatement.setString(3, employee.getEmail());
        preparedStatement.setString(4, employee.getDesignation());
        preparedStatement.setInt(5, employee.getSalary());
        preparedStatement.executeUpdate();
        System.out.println("Employee inserted successfully");
        preparedStatement.close();
    }

    public static void updateEmployeeName(int id, String name) throws SQLException {
        Connection conn = DataBase.connection();
        String updateNameQuery = "UPDATE employee SET name = ? WHERE id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(updateNameQuery);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2, name);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    public  static void updateEmployeeEmail(int id, String email)throws SQLException{
        Connection conn =DataBase.connection();
        String updateEmailQuery = "UPDATE employee SET email = ? WHERE id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(updateEmailQuery);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2, email);
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }
    public static void updateEmployeeDesignation(int id, String designation) throws SQLException{
        Connection conn = DataBase.connection();
        String updateDesignationQuery = "UPDATE employee SET designation = ? WHERE id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(updateDesignationQuery);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2, designation);
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }
    public static void updateEmployeeDesignationusingSalary(int salary, String designation) throws SQLException{
        Connection conn = DataBase.connection();
        String updateDesignationQuery = "UPDATE employee SET designation = ? WHERE salary >= ?";
        PreparedStatement preparedStatement = conn.prepareStatement(updateDesignationQuery);
        preparedStatement.setInt(1, salary);
        preparedStatement.setString(2, designation);
        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows>0){
            System.out.println("Employee with salary : "+ salary+ " was successfully updated");
        }else {
            System.out.println("No employee Found with salaary >= 50000");
        }
        preparedStatement.close();

    }
    public static void updateEmployeeSalary(int id, int salary) throws SQLException{
        Connection conn = DataBase.connection();
        String updateSalaryQuery = "UPDATE employee SET salary = ? WHERE id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(updateSalaryQuery);
        preparedStatement.setInt(1,id);
        preparedStatement.setInt(2, salary);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public static ArrayList<Employee> readAllEmployee() throws SQLException{
        ArrayList<Employee> employees = new ArrayList<>();
        Connection conn = DataBase.connection();
        String readAllQuery = "SELECT * from employee";
        Statement statement = conn.prepareStatement(readAllQuery);
        ResultSet resultSet = statement.executeQuery(readAllQuery);
        while (resultSet.next()){
            Employee employee = new Employee(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5));
            employees.add(employee);
        }
        System.out.println(employees);
        statement.close();
        return employees;
    }
    public static void readEmployee(int id)throws SQLException{
        Connection conn = DataBase.connection();
        String readEmployeeQuery = "SELECT * from employee WHERE id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(readEmployeeQuery);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            Employee employee = new Employee(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5));
            System.out.println(employee);
        }else {
            System.out.println("No Employee Id found");
        }
        preparedStatement.close();
    }
    public static void deleteEmployee(int id)throws SQLException{
        Connection conn = DataBase.connection();
        String deleteEmployeeQuery = "DELETE FROM employee WHERE id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(deleteEmployeeQuery);
        preparedStatement.setInt(1, id);
        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows>0){
            System.out.println("Employee with id : "+ id+ " was successfully deleted");
        }else {
            System.out.println("No employee Found with id : "+ id);
        }
    }

}

