package com.example.organizationservice.repository;

import com.example.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrganizationRepository extends JpaRepository<Organization,Long> {
}
