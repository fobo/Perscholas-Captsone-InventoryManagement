package com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.controllers;

import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.CompanyRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.UserRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.WarehouseRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.Company;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.User;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.Warehouse;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.services.CompanyService;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.services.UserService;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.services.WarehouseService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class WarehouseController {
    private final UserRepoI userRepoI;

    @Autowired
    CompanyRepoI companyRepoI;
    WarehouseRepoI warehouseRepoI;
    WarehouseService warehouseService;

    @Autowired
    UserService userService;
    @Autowired
    CompanyService companyService;

    @Autowired
    public WarehouseController(UserRepoI userRepoI, CompanyRepoI companyRepoI, WarehouseRepoI warehouseRepoI, WarehouseService warehouseService) {
        this.userRepoI = userRepoI;
        this.companyRepoI = companyRepoI;
        this.warehouseRepoI = warehouseRepoI;
        this.warehouseService = warehouseService;
    }

    @GetMapping("/warehousesAddRemove")
    public String warehousesAddRemove(Model model,Principal principal){

        /*
        Get email from principal
        get user id from email match
        get company id from user id match (get company id from email match?)
        get list of companies from company id match
         */
        String email = principal.getName();

        Integer userId = userService.findId(email);
        Integer companyId = companyService.findId(userId);
        List<Warehouse> warehouseList = warehouseService.getWarehouses(companyId);
        model.addAttribute("warehouses", warehouseList);
        return "warehousesAddRemove";
    }

    @GetMapping("addWarehouseForm")
    public String addWarehouse(){

        return "addWarehouseForm";
    }

    @PostMapping("/warehousesAddRemove")
    public String handleFormSubmission(@RequestParam(name = "id") Integer id,
                                       Model model,
                                       Principal principal){
        log.info(principal.getName());
        List<Warehouse> warehouseList = warehouseRepoI.findByCompanyId(id);
        model.addAttribute("warehouses", warehouseList);
        return "warehousesAddRemove";
    }

    @PostMapping("/updateWarehouse")
    public String updateWarehouse(@RequestParam(name = "city") String city,
                                  @RequestParam(name = "id") Integer id,
                                  Model model){
        System.out.println(city);
        List<Warehouse> warehouseList = warehouseRepoI.findAll();
        model.addAttribute("warehouses", warehouseList);
        return "warehousesAddRemove";
    }
    @PostMapping("/updateWarehouseCity")
    public String updateWarehouseCity(@RequestParam(name = "city") String city,
                                      @RequestParam(name="id") Integer id,
                                      @RequestParam(name="company_id") Integer company_id,
                                      Model model){
        warehouseService.updateWarehouse(id, city);

        //Returns updated list
        //This portion is supposed to update the list.
        //New method: Send company_id to front end to pull so the update returns the right list.
        List<Warehouse> warehouseList = warehouseRepoI.findByCompanyId(company_id); // Fix this weird update
        model.addAttribute("warehouses", warehouseList);
        return "warehousesAddRemove";
    }
//    @GetMapping("/getRecord/{id}")
//    public String getRecord(@PathVariable("id")int id, Model model){
//        log.warn(String.valueOf(id));
//        model.addAttribute("record",warehouseService.getRecord(id));
//        return "warehousesAddRemove";
//    }

    @PostMapping("/addWarehouse")
    public String addWarehouse(@RequestParam(name = "city") String city,
                               @RequestParam(name="company_id") Integer id){
        //request name of city and company_id from front end
        //get company object from query
        // create new object using params city, company
        log.warn(city + " " + id);
        warehouseService.addWarehouse(id, city);


        return "warehousesAddRemove";
    }

    @RequestMapping("/getRecord")
    @ResponseBody
    public Optional<Warehouse> getRecord(Integer id){
        log.warn("I am fetching one for " + id);
        return warehouseService.getRecord(id);
    }
}
