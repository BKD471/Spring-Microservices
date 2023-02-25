package com.example.Department.Service.mapper;

import com.example.Department.Service.dto.DepartmentDto;
import com.example.Department.Service.entity.Department;

public class DepartmentMapper {

    public static DepartmentDto mapToDepartmentDto(Department department){
        DepartmentDto departmentDto=new DepartmentDto(department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode());

        return departmentDto;
    }

    public static Department mapToDepartment(DepartmentDto departmentDto){
        Department department=new Department(departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentCode(),
                departmentDto.getDepartmentDescription());

        return department;
    }
}
