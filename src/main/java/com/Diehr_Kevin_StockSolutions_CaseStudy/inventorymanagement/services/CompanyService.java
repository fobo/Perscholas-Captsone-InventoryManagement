package com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.services;

import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.CompanyRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.Company;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class CompanyService {
    //TODO return company ID

    @Autowired
    CompanyRepoI companyRepoI;

    public CompanyService(CompanyRepoI companyRepoI) {
        this.companyRepoI = companyRepoI;
    }

    public Integer findId(Integer userId){

        Optional<Company> company = companyRepoI.findById(userId);
        Company setCompany = company.get();

        return setCompany.getId();

    }
}
