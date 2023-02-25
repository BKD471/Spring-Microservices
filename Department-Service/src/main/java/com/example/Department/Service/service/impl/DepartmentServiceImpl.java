package com.example.Department.Service.service.impl;

import com.example.Department.Service.dto.DepartmentDto;
import com.example.Department.Service.entity.Department;
import com.example.Department.Service.mapper.DepartmentMapper;
import com.example.Department.Service.repository.DepartmentRepository;
import com.example.Department.Service.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    private  ModelMapper mapper;

    DepartmentServiceImpl(DepartmentRepository departmentRepository){
        this.departmentRepository=departmentRepository;
        mapper=new ModelMapper();
    }
    @Override
    public  DepartmentDto saveDepartment(DepartmentDto departmentDto){
        //Converting Dto to Entity
        Department departmentEntity= DepartmentMapper.mapToDepartment(departmentDto);
        //saving entity to  database
        Department savedDepartment=departmentRepository.save(departmentEntity);
        //converting entity to Dto
        DepartmentDto saveDepartmentDto=DepartmentMapper.mapToDepartmentDto(savedDepartment);
        return saveDepartmentDto;
    }

    /**
     * @param code 
     * @return
     */
    @Override
    public DepartmentDto getDepartmentByCode(String code) {
       Optional<Department> departmentEntity= Optional.of(Optional.ofNullable(departmentRepository.findByDepartmentCode(code)).get());
       return DepartmentMapper.mapToDepartmentDto(departmentEntity.get());
    }
}
