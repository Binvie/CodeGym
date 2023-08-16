package com.example.service;

import com.example.model.Employee;
import com.example.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Override
    public List<Employee> display() {
        return employeeRepository.display();
    }

    @Override
    public void create(Employee employee) {
        employeeRepository.create(employee);
    }
}
