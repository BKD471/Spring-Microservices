package com.example.organizationservice.mapper;

import com.example.organizationservice.dto.OrganizationDto;
import com.example.organizationservice.entity.Organization;

public class OrganizationMapper {
    public static Organization mapToOrganization(OrganizationDto organizationDto) {
        Organization org = new Organization(
                organizationDto.getId(), organizationDto.getOrganizationName(),
                organizationDto.getOrganizationDescription(),
                organizationDto.getOrganizationCode(), organizationDto.getCreatedDate());
        return org;
    }

    public static OrganizationDto mapToOrganizationDto(Organization organization) {
        OrganizationDto orgDto = new OrganizationDto(
                organization.getId(), organization.getOrganizationName(),
                organization.getOrganizationDescription(), organization.getOrganizationCode(),
                organization.getCreatedDate());
        return orgDto;
    }
}
