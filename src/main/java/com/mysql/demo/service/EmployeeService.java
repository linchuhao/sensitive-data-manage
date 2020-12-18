package com.mysql.demo.service;

import com.mysql.demo.entity.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    String addEmployee(Employee employee);
}
