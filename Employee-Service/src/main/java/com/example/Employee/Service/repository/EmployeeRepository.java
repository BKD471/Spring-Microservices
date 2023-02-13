package com.example.Employee.Service.repository;

import com.example.Employee.Service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByEmailOrId(String email,Long id);
}
