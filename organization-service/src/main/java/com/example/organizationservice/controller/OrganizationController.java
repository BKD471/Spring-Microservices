package com.example.organizationservice.controller;

import com.example.organizationservice.dto.OrganizationDto;
import com.example.organizationservice.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

  private OrganizationService organizationService;

  OrganizationController(OrganizationService organizationService){
      this.organizationService=organizationService;
  }

  @PostMapping("/save")
  ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
       OrganizationDto savedOrganization=organizationService.saveOrganization(organizationDto);
       return  new ResponseEntity<>(savedOrganization,HttpStatus.CREATED);
  }

  @GetMapping("/{organizationCode}")
  ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable(name="organizationCode")
                                                        String code){
      OrganizationDto fetchedOrg=organizationService.getOrganizationByCode(code);
      return new ResponseEntity<>(fetchedOrg,HttpStatus.OK);
  }
}
