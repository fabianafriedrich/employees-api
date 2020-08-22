package com.hitech.health.employeesapi.service;

import com.hitech.health.employeesapi.model.Employee;
import com.hitech.health.employeesapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/*Service Layer to handle business rules if it have to
 * And communicate with repository layer*/
@Service
public class EmployeeService {

    /*Spring Dependence Injection */
    @Autowired
    private EmployeeRepository employeeRepository;

    /*Method to save user on database*/
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    /*Method to list all user on database*/
    public List<Employee> listAll(){
        return employeeRepository.findAll();
    }

    /*Method to find user by id on database*/
    public Employee findByCode(Long code){
        return employeeRepository.findById(code).orElseThrow(() -> new EntityNotFoundException(code.toString()));
    }
    /*Method to update user on database*/
    public void update(Employee employee){
        employeeRepository.save(employee);
    }

    /*Method to delete user on database*/
    public void delete(Employee employee){
        employeeRepository.delete(employee);
    }

    public Employee findByEmail(String email){
        return employeeRepository.findByEmail(email);
    }
}
