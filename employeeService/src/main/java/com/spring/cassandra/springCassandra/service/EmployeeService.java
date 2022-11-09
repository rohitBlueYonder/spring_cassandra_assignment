package com.spring.cassandra.springCassandra.service;

import com.spring.cassandra.springCassandra.model.Employee;
import com.spring.cassandra.springCassandra.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public ResponseEntity<Employee> addEmployee(Employee employee){
        try{
            Employee tempEmployee = employeeRepository.save(employee);
            return new ResponseEntity<>(tempEmployee, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<Employee> getAllEmployee()
    {
        return employeeRepository.findAll();
    }

    public String deleteEmployee(int id)
    {
        if(employeeRepository.existsById(id))
        {
            employeeRepository.deleteById(id);
            return "Employee with id " + id + " successfully deleted.";
        }

        else
            return "User not found";
    }

    public ResponseEntity<Employee> editEmployee(Employee employee){
        try{
            Employee temp = employeeRepository.findById(employee.getId()).get();
            temp.setName(employee.getName());
            temp.setState(employee.getState());
            Employee tempEmployee = employeeRepository.save(temp);
            return new ResponseEntity<>(tempEmployee, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
