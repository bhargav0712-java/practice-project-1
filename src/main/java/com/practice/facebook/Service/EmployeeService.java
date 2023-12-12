package com.practice.facebook.Service;

import com.practice.facebook.Entity.Employee;
import com.practice.facebook.Repo.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> getAllList() {
        return employeeRepo.findAll();
    }
    public Employee createNew(Employee employee){
        return employeeRepo.save(employee);
    }
    public Optional<Employee> findById(Long id){
         return employeeRepo.findById(id);
    }

    public Employee updateOld(Long id , Employee employee) {
       if( employeeRepo.existsById(id)){
           return employeeRepo.save(employee);
       }
       return null;
    }
    public void deleteEmp(Long id){
        employeeRepo.deleteById(id);
    }

}
