package com.example.Employee.Service.service.impl;

import com.example.Employee.Service.dto.EmployeeDto;
import com.example.Employee.Service.entity.Employee;
import com.example.Employee.Service.repository.EmployeeRepository;
import com.example.Employee.Service.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper mapper;

    EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
        this.mapper=new ModelMapper();
    }


    /**
     * @param employeeDto 
     * @return
     */
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        //convert dto to Entity
        Employee employeeEntity=mapper.map(employeeDto,Employee.class);
        //save entity to db
        Employee savedEmployee=employeeRepository.save(employeeEntity);
        //convert entuty to dto
        return mapper.map(savedEmployee,EmployeeDto.class);
    }

    /**
     * @param email 
     * @return
     */
    @Override
    public EmployeeDto getEmployee(String email,Long id) {
        Employee employeeEntity=employeeRepository.findByEmailOrId(email,id);
        return mapper.map(employeeEntity,EmployeeDto.class);
    }
}
