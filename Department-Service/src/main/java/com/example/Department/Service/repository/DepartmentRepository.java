package com.example.Department.Service.repository;

import com.example.Department.Service.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
