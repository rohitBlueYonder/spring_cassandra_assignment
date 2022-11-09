package com.spring.cassandra.springCassandra.Controller;


import com.spring.cassandra.springCassandra.model.Employee;
import com.spring.cassandra.springCassandra.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// when backend and database are on different ports->(enable this)
@CrossOrigin(origins = "http://localhost:8083")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    public EmployeeController(EmployeeService service){
        this.employeeService = service;
    }


    @PostMapping("/add-employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/get-all-employee")
    public List<Employee> getAlLEmployee()
    {
        return employeeService.getAllEmployee();
    }

    @DeleteMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable("id") int id)
    {
        return employeeService.deleteEmployee(id);
    }

    @PutMapping("/edit-employee")
    public ResponseEntity<Employee> editEmployee(@RequestBody Employee employee){
        return employeeService.editEmployee(employee);
    }
}
