package com.example.Department.Service.controller;

import com.example.Department.Service.dto.DepartmentDto;
import com.example.Department.Service.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private DepartmentService departmentService;
    private ModelMapper mapper;

    DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
        this.mapper=new ModelMapper();
    }

    @PostMapping("/save")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
      DepartmentDto savedDepartmentDto=departmentService.saveDepartment(departmentDto);
      return new  ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);
    }

    @GetMapping("/{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable(name="departmentCode") String code){
      DepartmentDto fetchedDepartment=departmentService.getDepartmentByCode(code);
      return new ResponseEntity<>(fetchedDepartment,HttpStatus.OK);
    }
}
