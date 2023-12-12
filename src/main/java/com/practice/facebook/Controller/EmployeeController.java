package com.practice.facebook.Controller;

import com.practice.facebook.Entity.Employee;
import com.practice.facebook.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employees = employeeService.getAllList();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Employee> createNew(@RequestBody Employee employee){
        Employee employee1 = employeeService.createNew(employee);
        return new ResponseEntity<>(employee1, HttpStatus.CREATED);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Employee> getEmpById(@PathVariable Long id){
        Optional<Employee> employee = employeeService.findById(id);
        if(employee.isPresent()){
            Employee employee1 = employee.get();
            return new ResponseEntity<>(employee1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateOld(@PathVariable Long id, @RequestBody Employee employee){
        Employee employee1 = employeeService.updateOld(id,employee);
        if (employee1 != null){
            return new ResponseEntity<>(employee1,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        employeeService.deleteEmp(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }














 }
