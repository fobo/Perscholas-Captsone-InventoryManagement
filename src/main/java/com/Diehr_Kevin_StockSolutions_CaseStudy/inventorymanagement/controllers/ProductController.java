package com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.controllers;

import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.ProductRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.WarehouseRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.Product;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.Warehouse;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.services.CompanyService;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.services.ProductService;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Slf4j
@Controller
public class ProductController {

    WarehouseRepoI warehouseRepoI;
    ProductRepoI productRepoI;

    @Autowired
    UserService userService;
    @Autowired
    CompanyService companyService;
    @Autowired
    ProductService productService;
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
    public String productsAddRemove(Model model, Principal principal){
        String email = principal.getName();
        Integer userId = userService.findId(email);
        Integer companyId = companyService.findId(userId);
        List<Product> productList = productService.getProducts(companyId);
        model.addAttribute("products", productList);

        return "productsAddRemove";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@RequestParam(name = "id") Integer id, @RequestParam(name = "productName") String productName, @RequestParam(name = "productDescription") String productDescription, @RequestParam(name = "quantity") Integer quantity, Principal principal, Model model){
        productService.updateProduct(id, productName, productDescription, quantity);
        String email = principal.getName();
        Integer userId = userService.findId(email);
        Integer companyId = companyService.findId(userId);
        List<Product> productList = productService.getProducts(companyId);
        model.addAttribute("products", productList);
        return "productsAddRemove";
    }

    @PostMapping("/deleteProduct")
    public String deleteProduct(@RequestParam(name = "id") Integer id, Model model, Principal principal){
        productService.deleteProduct(id);
        String email = principal.getName();
        Integer userId = userService.findId(email);
        Integer companyId = companyService.findId(userId);
        List<Product> productList = productService.getProducts(companyId);
        model.addAttribute("products", productList);
        return "productsAddRemove";
    }

    @GetMapping("/addProductForm")
    public String addProductForm(){

        return "addProductForm";
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestParam(name = "warehouse_id") Integer warehouse_id, @RequestParam(name = "productName") String productName, @RequestParam(name = "productDescription") String productDescription, @RequestParam(name = "quantity") Integer quantity, Principal principal, Model model){
       log.warn("ENTERING ADD PRODUCT");

        String email = principal.getName();
       Integer userId = userService.findId(email);
        productService.addProduct(userId, warehouse_id, productName, productDescription, quantity);
        Integer companyId = companyService.findId(userId);
        List<Product> productList = productService.getProducts(companyId);
        model.addAttribute("products", productList);
        return "productsAddRemove";
    }
}
