package com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.services;


import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.CompanyRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.ProductRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.WarehouseRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.Company;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.Product;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.Warehouse;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class ProductService {
    @Autowired
    private final ProductRepoI productRepoI;
    private final CompanyRepoI companyRepoI;
    private final WarehouseRepoI warehouseRepoI;

    public ProductService(ProductRepoI productRepoI,
                          CompanyRepoI companyRepoI,
                          WarehouseRepoI warehouseRepoI) {
        this.productRepoI = productRepoI;
        this.companyRepoI = companyRepoI;
        this.warehouseRepoI = warehouseRepoI;
    }

    public List<Product> getProducts(Integer companyId){

        List<Product> productList = productRepoI.findByCompanyId(companyId);
        return productList;
    }


    public void updateProduct(Integer id, String productName, String productDescription, Integer quantity){
        Optional<Warehouse> warehouse = warehouseRepoI.findById(id);
        Warehouse setWarehouse = warehouse.get();
        Optional<Product> product = productRepoI.findById(id);
        Product setProduct = product.get();
        setProduct.setProductName(productName);
        setProduct.setProductDescription(productDescription);
        setProduct.setQuantity(quantity);
        setProduct.setWarehouse(setWarehouse);

        //Product product = new Product(setWarehouse, setCompany, productName, productDescription, quantity);
        productRepoI.saveAndFlush(setProduct);

    }
}
