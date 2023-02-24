package com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.controllers;

import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.ProductRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.WarehouseRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.Product;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.Warehouse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class ProductController {

    WarehouseRepoI warehouseRepoI;
    ProductRepoI productRepoI;

    @Autowired
    public ProductController(WarehouseRepoI warehouseRepoI, ProductRepoI productRepoI) {
        this.warehouseRepoI = warehouseRepoI;
        this.productRepoI = productRepoI;
    }

    @PostMapping("/productsAddRemove")
    public String handleFormSubmission(@RequestParam(name = "id") Integer id, Model model){

        List<Product> productList = productRepoI.findByCompanyId(id);
        model.addAttribute("products", productList);
        return "productsAddRemove";
    }

    @GetMapping("/productsAddRemove")
    public String productsAddRemove(Model model, HttpServletRequest request){

        List<Product> productList = productRepoI.findAll();
        model.addAttribute("products", productList);

        return "productsAddRemove";
    }
}
