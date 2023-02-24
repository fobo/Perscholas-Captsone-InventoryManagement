package com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao;

import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepoI extends JpaRepository<Product, Integer> {
    List<Product> findByCompanyId(Integer id);
}
