package com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.controllers;

import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.CompanyRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.WarehouseRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.Warehouse;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.services.WarehouseService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class WarehouseController {

    CompanyRepoI companyRepoI;
    WarehouseRepoI warehouseRepoI;
    WarehouseService warehouseService;
    @Autowired
    public WarehouseController(CompanyRepoI companyRepoI, WarehouseRepoI warehouseRepoI, WarehouseService warehouseService) {
        this.companyRepoI = companyRepoI;
        this.warehouseRepoI = warehouseRepoI;
        this.warehouseService = warehouseService;
    }
    @GetMapping("/warehousesAddRemove")
    public String warehousesAddRemove(Model model){
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
    @PostMapping("/updateWarehouseCity")
    public String updateWarehouseCity(@RequestParam(name = "city") String city, @RequestParam(name="id") Integer id, Model model){
        warehouseService.updateWarehouse(id, city);

        //Returns updated list
        List<Warehouse> warehouseList = warehouseRepoI.findByCompanyId(id); // Fix this weird update
        model.addAttribute("warehouses", warehouseList);
        return "warehousesAddRemove";
    }
//    @GetMapping("/getRecord/{id}")
//    public String getRecord(@PathVariable("id")int id, Model model){
//        log.warn(String.valueOf(id));
//        model.addAttribute("record",warehouseService.getRecord(id));
//        return "warehousesAddRemove";
//    }



    @RequestMapping("/getRecord")
    @ResponseBody
    public Optional<Warehouse> getRecord(Integer id){
        log.warn("I am fetching one for " + id);
        return warehouseService.getRecord(id);
    }
}
