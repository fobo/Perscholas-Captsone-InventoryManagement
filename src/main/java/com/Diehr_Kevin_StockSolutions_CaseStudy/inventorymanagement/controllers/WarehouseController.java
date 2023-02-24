package com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.controllers;

import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.CompanyRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.ProductRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.WarehouseRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.Company;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.Warehouse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class WarehouseController {

    CompanyRepoI companyRepoI;
    WarehouseRepoI warehouseRepoI;

    @Autowired
    public WarehouseController(CompanyRepoI companyRepoI, WarehouseRepoI warehouseRepoI) {
        this.companyRepoI = companyRepoI;
        this.warehouseRepoI = warehouseRepoI;
    }
    @GetMapping("/warehousesAddRemove")
    public String warehousesAddRemove(Model model, HttpServletRequest request){

        List<Warehouse> warehouseList = warehouseRepoI.findAll();
        model.addAttribute("warehouses", warehouseList);
        return "warehousesAddRemove";
    }

    @PostMapping("/warehousesAddRemove")
    public String handleFormSubmission(@RequestParam(name = "id") Integer id, Model model){

        List<Warehouse> warehouseList = warehouseRepoI.findByCompanyId(id);
        model.addAttribute("warehouses", warehouseList);
        return "warehousesAddRemove";
    }

    @PostMapping("/updateWarehouse")
    public String updateWarehouse(@RequestParam(name = "city") String city, @RequestParam(name = "id") Integer id, Model model){
        System.out.println(city);
        List<Warehouse> warehouseList = warehouseRepoI.findAll();
        model.addAttribute("warehouses", warehouseList);
        return "warehousesAddRemove";
    }
}
