package com.example.organizationservice.service.impl;

import com.example.organizationservice.dto.OrganizationDto;
import com.example.organizationservice.entity.Organization;
import com.example.organizationservice.mapper.OrganizationMapper;
import com.example.organizationservice.repository.OrganizationRepository;
import com.example.organizationservice.service.OrganizationService;
import org.springframework.stereotype.Service;


@Service
public class OrganizationServiceImpl implements OrganizationService {
    private OrganizationRepository organizationRepository;
    OrganizationServiceImpl(OrganizationRepository organizationRepository){
        this.organizationRepository=organizationRepository;
    }
    /**
     * @param organizationDto
     * @return
     */
    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization org= OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrganization=organizationRepository.save(org);
        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    /**
     * @param organizationCode
     * @return
     */
    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization fetchedOrganization= organizationRepository.
                        findOrganizationByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationDto(fetchedOrganization);
    }
}
