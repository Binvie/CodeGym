package com.example.repository;

import com.example.model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    public List<Employee> display();
    public void create(Employee employee);
}
