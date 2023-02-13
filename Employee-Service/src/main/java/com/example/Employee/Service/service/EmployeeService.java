package com.example.Employee.Service.service;

import com.example.Employee.Service.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployee(String email,Long id);
}
