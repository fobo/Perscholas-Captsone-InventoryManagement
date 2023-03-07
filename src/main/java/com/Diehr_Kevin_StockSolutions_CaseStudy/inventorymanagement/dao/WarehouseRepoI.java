package com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao;

import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.User;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WarehouseRepoI extends JpaRepository<Warehouse, Integer> {
    List<Warehouse> findByCompanyId(int id);
    Optional <Warehouse> findById(Integer id);

}
