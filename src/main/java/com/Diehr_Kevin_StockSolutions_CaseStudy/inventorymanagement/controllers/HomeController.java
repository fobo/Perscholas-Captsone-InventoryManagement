package com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.controllers;


import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.CompanyRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.ProductRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.WarehouseRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.User;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.services.CompanyService;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.UserRepoI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Controller
@Slf4j
public class HomeController {

    UserRepoI userRepoI;
    CompanyRepoI companyRepoI;
    ProductRepoI productRepoI;
    WarehouseRepoI warehouseRepoI;
    @Autowired
    UserService userService;
    CompanyService companyService;


    @Autowired
    public HomeController(UserRepoI userRepoI, CompanyRepoI companyRepoI, ProductRepoI productRepoI, WarehouseRepoI warehouseRepoI){
        this.userRepoI = userRepoI;
        this.companyRepoI = companyRepoI;
        this.productRepoI = productRepoI;
        this.warehouseRepoI = warehouseRepoI;
    }


//    @GetMapping({"/aboutus/{id}"})
//    public String aboutus(@PathVariable(name = "id", required = false) int id, Model model, HttpServletRequest request){
//
//
//        List<User> users;
//        if (id == 0) {
//            // If the id is not provided in the URL, retrieve all users
//            users = userRepoI.findAll();
//        } else {
//            // If an id is provided, retrieve the user with that id
//            Optional<User> user = userRepoI.findById(id);
//            if (user.isPresent()) {
//                users = Collections.singletonList(user.get());
//            } else {
//                users = Collections.emptyList();
//            }
//        }
//        model.addAttribute("allUser", users);
//        return "aboutus";
//    }

    @GetMapping({"/login"})
    public String login(){

        return "login";
    }
//    @GetMapping({"/login/processing"})
//    public String redirect(){
//
//        return "warehousesAddRemove";
//    }


    @GetMapping(value = {"/", "index"})
    public String homePage(Principal principal){
    //TODO Add some welcome message for login

        log.info("i am in the index controller method");

        return "login";
    }





}
