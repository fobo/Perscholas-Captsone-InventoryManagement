package com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.services;

import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.CompanyRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.WarehouseRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.Company;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.Warehouse;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepoI warehouseRepoI;
    private final CompanyRepoI companyRepoI;

    public WarehouseService(WarehouseRepoI warehouseRepoI,
                            CompanyRepoI companyRepoI) {
        this.warehouseRepoI = warehouseRepoI;
        this.companyRepoI = companyRepoI;
    }

    public Optional<Warehouse> getRecord(Integer id){
        return warehouseRepoI.findById(id);
    }

    public void updateWarehouse(Integer id, String city){
        Optional<Warehouse> warehouse = warehouseRepoI.findById(id);
        Warehouse warehouse2;
        warehouse2 = warehouse.get();
        warehouse2.setCity(city);
        warehouseRepoI.saveAndFlush(warehouse2);
    }

    public void addWarehouse(Integer id, String city){
        System.out.println(id + " " + city);
        Optional<Company> company = companyRepoI.findById(id);
        System.out.println("company "+company);
        Company company2 = company.get();
        System.out.println("company2" + company2);
        Warehouse warehouse = new Warehouse(city, company2);
        System.out.println("warehouse "+warehouse);
        warehouseRepoI.saveAndFlush(warehouse);
    }
}
