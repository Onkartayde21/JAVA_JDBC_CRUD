package com.demo;


import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
//Before compiling the file uncomment the below code block to create database and table with fields
/*        DB d =new DB();
        d.createDB();
        d.createTable();*/

        System.out.println("Employee Management System");
        System.out.println("Enter the operation to be performed : ");
        System.out.println("1 : Create Employee");
        System.out.println("2 : Read Employee");
        System.out.println("3 : Update Employee");
        System.out.println("4 : Delete Employee");

        Scanner sc = new Scanner(System.in);
        int operation = sc.nextInt();

        if(operation == 1){
            System.out.println("Enter Employee Id, Employee Name,  Email id, Designation, Salary");
            int id = sc.nextInt();
            String name = sc.nextLine();
            String email = sc.nextLine();
            String designation = sc.nextLine();
            sc.nextLine();
            int salary = sc.nextInt();
            Employee employee= new Employee(id, name, email, designation, salary);
            EmployeeDao.createEmployee(employee);

        } else if (operation==2) {
            System.out.println("Enter the read operation : 1. Read All Employees   2. Read a specific Employee");
            int op = sc.nextInt();
            if (op == 1) {
                EmployeeDao.readAllEmployee();
            } else if (op == 2) {
                System.out.println("Enter employee id : ");
                int eid = sc.nextInt();
                EmployeeDao.readEmployee(eid);
            }
        } else if (operation==3) {
            System.out.println("Enter the employee Id of an employee to be updated : ");
            int eid = sc.nextInt();
            System.out.println("What do you want to update : 1.Name, 2.Email, 3.Designation, 4.Salary");
            int option = sc.nextInt();
            if(option ==1){
                System.out.println("Enter id and updated name of employee");
                int id = sc.nextInt();
                String name = sc.nextLine();
                EmployeeDao.updateEmployeeName(id, name);
            } else if (option == 2) {
                System.out.println("Enter id and updated email of employee");
                int id = sc.nextInt();
                String email = sc.nextLine();
                EmployeeDao.updateEmployeeEmail(id, email);
            }else if (option == 3) {
                System.out.println("Specify the basis to update designation :  1. Id, 2.Salary");
                int dop= sc.nextInt();
                if(dop == 1){
                    System.out.println("Enter id and updated designation of employee");
                    int id = sc.nextInt();
                    String designation = sc.nextLine();
                    EmployeeDao.updateEmployeeDesignation(id, designation);
                } else if (dop == 2) {
                    System.out.println("Enter salary and updated designation of employee");
                    int salary = sc.nextInt();
                    String designation = sc.nextLine();
                    EmployeeDao.updateEmployeeDesignationusingSalary(salary, designation);
                }else {
                    System.out.println("Incorrect input");
                }
            } else if (option == 4) {
                System.out.println("Enter the id and updated salary of employee : ");
                int id = sc.nextInt();
                int salary = sc.nextInt();
                EmployeeDao.updateEmployeeSalary(id, salary);
            }else {
                System.out.println("Incorrect input ");
            }
        } else if (operation==4) {
            System.out.println("Enter the employee id of employee : ");
            int id = sc.nextInt();
            EmployeeDao.deleteEmployee(id);
        }else {
            System.out.println("Irrelevent option chosen, closing the app");
            System.exit(404);
        }


    }
}
