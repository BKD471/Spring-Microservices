package com.example.Employee.Service.service.impl;

import com.example.Employee.Service.dto.ApiResponseDto;
import com.example.Employee.Service.dto.DepartmentDto;
import com.example.Employee.Service.dto.EmployeeDto;
import com.example.Employee.Service.entity.Employee;
import com.example.Employee.Service.repository.EmployeeRepository;
import com.example.Employee.Service.service.ApiClient;
import com.example.Employee.Service.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper mapper;
    private RestTemplate restTemplate;
    private WebClient webClient;
    private ApiClient apiClient;

    EmployeeServiceImpl(EmployeeRepository employeeRepository,
                        RestTemplate restTemplate,
                        WebClient webClient,ApiClient apiClient) {
        this.employeeRepository = employeeRepository;
        this.mapper = new ModelMapper();
        this.restTemplate = restTemplate;
        this.webClient = webClient;
        this.apiClient=apiClient;
    }


    /**
     * @param employeeDto
     * @return
     */
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        //convert dto to Entity
        Employee employeeEntity = mapper.map(employeeDto, Employee.class);
        //save entity to db
        Employee savedEmployee = employeeRepository.save(employeeEntity);
        //convert entity to dto
        return mapper.map(savedEmployee, EmployeeDto.class);
    }

    /**
     * @param email
     * @return
     */
    @Override
    public ApiResponseDto getEmployee(String email, Long id) {
        //Fetch employee & convert it to Dto
        Optional<Employee> employeeEntity = Optional.of(Optional.ofNullable(employeeRepository.findByEmailOrId(email, id)).get());
        EmployeeDto employeeDto = mapper.map(employeeEntity, EmployeeDto.class);

        //Fetch corresponding department by rest-template
        //ResponseEntity<DepartmentDto> response=restTemplate.getForEntity("http://localhost:8080/api/departments/"+employeeEntity.get().getDepartmentCode(),DepartmentDto.class);
        //DepartmentDto departmentDto=response.getBody();

        //Fetch corresponding department by WebClient
        //DepartmentDto departmentDto = webClient.get().
              //uri(FETCH_DEPARTMENTS+employeeDto.getDepartmentCode()).
                  //retrieve().
                  //bodyToMono(DepartmentDto.class).block();


        //Fetch corresponding department by FeignClient
        DepartmentDto departmentDto=apiClient.getDepartmentByCode(employeeDto.getDepartmentCode());


        //Form a response
        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
}
