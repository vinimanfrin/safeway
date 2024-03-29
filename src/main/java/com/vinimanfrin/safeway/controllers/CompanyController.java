package com.vinimanfrin.safeway.controllers;

import com.vinimanfrin.safeway.dtos.company.CompanyDetailDTO;
import com.vinimanfrin.safeway.dtos.company.CompanyInputDTO;
import com.vinimanfrin.safeway.models.Company;
import com.vinimanfrin.safeway.services.company.CompanyServiceImp;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyServiceImp companyService;

    @PostMapping
    @Transactional
    public ResponseEntity saveCompany(@RequestBody @Valid CompanyInputDTO companyInput){
        var company = new Company(companyInput);
        var companySaved = companyService.saveCompany(company);
        var uri = buildUrl(companySaved);
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDetailDTO> getCompany(@PathVariable("id") String id){
        var company = companyService.getCompany(id);
        return ResponseEntity.ok(new CompanyDetailDTO(company));
    }

    private URI buildUrl(Company company){
        String companyPath = "/"+company.getId();
        return ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path(companyPath)
                .build()
                .toUri();
    }
}
