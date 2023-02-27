package com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.services;

import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.WarehouseRepoI;
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

    public WarehouseService(WarehouseRepoI warehouseRepoI) {
        this.warehouseRepoI = warehouseRepoI;
    }

    public Optional<Warehouse> getRecord(Integer id){
        return warehouseRepoI.findById(id);
    }
}
