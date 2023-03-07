package com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao;

import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepoI extends JpaRepository<Company, Integer> {
    //TODO pull company by id from user

    Optional<Company> findById(Integer id);
}
