package com.demo;

public class Employee {
    private int id;
    private String name;
    private String email;
    private String designation;
    private int salary;

    //Constructor
    public Employee(int id, String name, String email, String designation, int salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.designation = designation;
        this.salary = salary;

    }

    //Getter Setter
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getDesignation() {return designation;}
    public void setDesignation(String designation) {this.designation = designation;}

    public int getSalary() {return salary;}
    public void setSalary(int salary) {this.salary = salary;}

    //tostring
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                '}';
    }
}
