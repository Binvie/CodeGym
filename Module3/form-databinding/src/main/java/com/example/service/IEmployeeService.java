package com.example.service;

import com.example.model.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> display();
    public void create(Employee employee);
}
