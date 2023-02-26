package com.example.Employee.Service.mapper;

import com.example.Employee.Service.dto.EmployeeDto;
import com.example.Employee.Service.entity.Employee;

public class EmployeeMapper {

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employee=new Employee(employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(), employeeDto.getDepartmentCode(),
                employeeDto.getOrganizationCode());
        return employee;
    }

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        EmployeeDto employeeDto=new EmployeeDto(employee.getId(),
                employee.getFirstName(),
                employee.getLastName(), employee.getEmail(),
                employee.getDepartmentCode(), employee.getOrganizationCode());
        return employeeDto;
    }
}
