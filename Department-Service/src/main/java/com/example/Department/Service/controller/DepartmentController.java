package com.example.Department.Service.controller;

import com.example.Department.Service.dto.DepartmentDto;
import com.example.Department.Service.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private DepartmentService departmentService;
    private ModelMapper mapper;

    DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
        this.mapper=new ModelMapper();
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
      DepartmentDto savedDepartmentDto=departmentService.saveDepartment(departmentDto);
      return new  ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);
    }
}
