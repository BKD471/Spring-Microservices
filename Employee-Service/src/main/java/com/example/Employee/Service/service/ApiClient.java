package com.example.Employee.Service.service;

import com.example.Employee.Service.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static com.example.Employee.Service.constants.UriConstants.BASE_URL;

@FeignClient(name="DEPARTMENT-SERVICE")
public interface ApiClient {
    @GetMapping("api/departments/{departmentCode}")
    DepartmentDto getDepartmentByCode(@PathVariable(name="departmentCode") String code);
}
