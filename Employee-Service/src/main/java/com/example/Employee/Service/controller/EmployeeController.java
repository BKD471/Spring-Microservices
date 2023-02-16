package com.example.Employee.Service.controller;

import com.example.Employee.Service.dto.ApiResponseDto;
import com.example.Employee.Service.dto.EmployeeDto;
import com.example.Employee.Service.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployeeDto=employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<ApiResponseDto> fetchEmployee(@Valid @RequestParam(required = false) String email,
                                                         @RequestParam(required = false) Long id){
        ApiResponseDto fetchedEmployee=employeeService.getEmployee(email,id);
        return new ResponseEntity<>(fetchedEmployee,HttpStatus.OK);
    }
}
