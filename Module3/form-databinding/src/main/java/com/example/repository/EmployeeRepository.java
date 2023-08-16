package com.example.repository;

import com.example.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmployeeRepository implements IEmployeeRepository{
    private static List<Employee> employees = new ArrayList<>();
    static {
        employees.add(new Employee("NV-001","Thoi","03513151"));
        employees.add(new Employee("NV-002","Thien","03513151"));
        employees.add(new Employee("NV-003","Sang","03513151"));
    }
    @Override
    public List<Employee> display() {
        return employees;
    }

    @Override
    public void create(Employee employee) {
        employees.add(employee);
    }
}
