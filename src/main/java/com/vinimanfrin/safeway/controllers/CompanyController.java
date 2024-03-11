package com.vinimanfrin.safeway.controllers;

import com.vinimanfrin.safeway.dtos.CompanyDetailDTO;
import com.vinimanfrin.safeway.dtos.CompanyInputDTO;
import com.vinimanfrin.safeway.models.Company;
import com.vinimanfrin.safeway.services.company.CompanyService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping
    @Transactional
    public ResponseEntity<CompanyDetailDTO> saveCompany(@RequestBody CompanyInputDTO companyInput){
        var company = new Company(companyInput);
        var companySaved = companyService.saveCompany(company);
        var uri = buildImageURL(companySaved);
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDetailDTO> getCompany(@PathVariable("id") String id){
        var company = companyService.getCompany(id);
        return ResponseEntity.ok(new CompanyDetailDTO(company));
    }

    private URI buildImageURL(Company company){
        String companyPath = "/"+company.getId();
        return ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path(companyPath)
                .build()
                .toUri();
    }
}
