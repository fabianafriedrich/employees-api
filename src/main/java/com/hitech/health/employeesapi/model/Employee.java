package com.hitech.health.employeesapi.model;

import com.hitech.health.employeesapi.enums.Roles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    private String name;

    private String email;

    private String password;

    private String profession;

    private String city;

    private String branch;

    private Roles role;

    /*Default Constructor*/
    public Employee() {
    }

    /*Parameterized Constructor*/
    public Employee(Long code, String name, String email, String password, String profession,
                    String city, String branch, Roles role) {

        this.code = code;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profession = profession;
        this.city = city;
        this.branch = branch;
        this.role = role;
    }

    /*Getters and Setters*/
    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return code.equals(employee.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profession='" + profession + '\'' +
                ", city='" + city + '\'' +
                ", branch='" + branch + '\'' +
                ", roles='" + role + '\'' +
                '}';
    }
}
