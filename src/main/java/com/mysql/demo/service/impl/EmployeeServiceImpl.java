package com.mysql.demo.service.impl;

import com.mysql.demo.entity.Employee;
import com.mysql.demo.repository.EmployeeRepository;
import com.mysql.demo.service.EmployeeService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public String addEmployee(Employee employee) {
        if (employee == null) {
            return "null";
        }
        employeeRepository.save(employee);
        return "success";
    }
}
