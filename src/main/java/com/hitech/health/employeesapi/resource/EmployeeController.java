package com.hitech.health.employeesapi.resource;

import com.hitech.health.employeesapi.enums.Roles;
import com.hitech.health.employeesapi.model.Employee;
import com.hitech.health.employeesapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


import java.security.Principal;
import java.util.List;

/*Controller Layer to handle all the HTTP requests*/
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    /*HTTP Get method to list employees*/
    @GetMapping
    public List<Employee> getAll(){
        return employeeService.listAll();
    }

    /*HTTP Get method to find employee by code*/
    @GetMapping(value = "/{code}")
    public ResponseEntity<Employee> findById(@PathVariable Long code){
        Employee employee = employeeService.findByCode(code);
        return ResponseEntity.ok(employee);
    }

    /*HTTP Put method to update employee*/
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Valid Employee employee) {
//        if(!employee.getPassword().startsWith("$2a") ){
//            employee.setPassword(new BCryptPasswordEncoder().encode(employee.getPassword()));
//        }
        employeeService.update(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }

    /*HTTP Delete method to remove employee by code*/
    @DeleteMapping (value = "/{code}")
    public ResponseEntity delete(@PathVariable Long code){
        employeeService.delete(employeeService.findByCode(code));
        return new ResponseEntity<Employee>(HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody Employee employee){
        Employee employeeDB = employeeService.findByEmail(employee.getEmail());
        if(employeeDB != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        employee.setRole(Roles.USER);
//        employee.setPassword(new BCryptPasswordEncoder().encode(employee.getPassword()));
        try {
            return new ResponseEntity<>(employeeService.save(employee), HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /*Principal class is the current logged in user*/
//    @GetMapping("/login")
//    public ResponseEntity<?> getEmployee(Principal principal){
//        if(principal == null){
//            //logout will also use here so we should return ok http status.
//            return ResponseEntity.ok(principal);
//        }
////        UsernamePasswordAuthenticationToken authenticationToken =
////                (UsernamePasswordAuthenticationToken) principal;
//
//        Employee employee = employeeService.findByEmail(authenticationToken.getName());
////        employee.setToken(tokenProvider.generateToken(authenticationToken));
//
//        return new ResponseEntity<>(employee, HttpStatus.OK);
//    }

}
