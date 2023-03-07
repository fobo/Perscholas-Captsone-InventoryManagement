package com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.controllers;

import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.UserRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.security.MySecurityConfig;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class UserController {
//    This controller controls anything to do with the user.
//    User login, User Creation, User Deletion, and User Editing

    //TODO Send request to admin page to approve user (Scope)
    //TODO Add user to database
    //TODO Improve login form frontend
    UserRepoI userRepoI;
    UserService userService;
    MySecurityConfig mySecurityConfig;

    @Autowired
    public UserController(UserRepoI userRepoI) {
        this.userRepoI = userRepoI;
    }

    @GetMapping({"/register"})
    public String register(){
        //Sends user to register page


        return "register";
    }

    @PostMapping({"registerUser"})
    public String registerUser(@RequestParam(name = "email")String email, @RequestParam(name = "password")String password, @RequestParam(name = "first_name")String first_name, @RequestParam(name = "last_name")String last_name, @RequestParam(name = "company_id")Integer company_id){
        //Adds user to auth_group and user tables

        userService.addUser(company_id,email,password,first_name,last_name);

        //TODO Add feature to confirm register
        return "login";
    }
}
