package com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement;

import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.CompanyRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.ProductRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.UserRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.WarehouseRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.Company;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.Product;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.User;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.Warehouse;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.services.CompanyService;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.services.ProductService;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.services.UserService;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.services.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@SpringBootTest
class InventorymanagementApplicationTests {

	@Autowired
	CompanyRepoI companyRepoI;
	ProductRepoI productRepoI;
	WarehouseRepoI warehouseRepoI;
	UserRepoI userRepoI;

	@Autowired
	CompanyService companyService;

	@Autowired
	WarehouseService warehouseService;

	@Autowired
	UserService userService;




//	@Test @Order(1)
//	void testGetWarehouse(){
//
//		Warehouse warehouse1 = new Warehouse(1,"St Louis", companyService.findById(1));
//		Warehouse warehouse2 = new Warehouse(2,"Hostes", companyService.findById(1));
//		Warehouse warehouse3 = new Warehouse(3,"Chicago2", companyService.findById(1));
//		Warehouse warehouse4 = new Warehouse(86,"Houston", companyService.findById(1));
//		Warehouse warehouse5 = new Warehouse(87,"Chicago", companyService.findById(1));
//
//		ArrayList<Warehouse> expected = new ArrayList<Warehouse>();
//		expected.add(warehouse1);
//		expected.add(warehouse2);
//		expected.add(warehouse3);
//		expected.add(warehouse4);
//		expected.add(warehouse5);
//
//
//		assertThat(warehouseService.getWarehouses(1)).containsExactlyInAnyOrderElementsOf(expected);
//	}


	@Test
	public void getWarehouses() {

		Warehouse warehouse1 = new Warehouse(1,"St Louis", companyService.findById(1));
		Warehouse warehouse2 = new Warehouse(2,"Hostes", companyService.findById(1));
		Warehouse warehouse3 = new Warehouse(3,"Chicago2", companyService.findById(1));
		Warehouse warehouse4 = new Warehouse(86,"Houston", companyService.findById(1));
		Warehouse warehouse5 = new Warehouse(87,"Chicago", companyService.findById(1));

		List<Warehouse> expected = new ArrayList<>();
		expected.add(warehouse1);
		expected.add(warehouse2);
		expected.add(warehouse3);
		expected.add(warehouse4);
		expected.add(warehouse5);
		log.warn(expected.size() + "  " + warehouseService.getWarehouses(1).size());

		List<Warehouse> actual = warehouseService.getWarehouses(1);

		assertTrue(expected.size() == actual.size());
		assertTrue(expected.containsAll(actual));
	}

	@Test
	public void getUser() {

		User expected = new User(4, "mary.wang@global-industries.com", "$2y$04$OcUHIpSFbVYbpP2KRy3fiea3q/cSSKQCz2vDdGkH8BOG0vKBN2FB6", "Mary", "Wang", companyService.findById(4));


		User actual = userService.findUser(4);




		//assertTrue(expected.size() == actual.size());
		assertEquals(expected,actual);
	}

	@Test
	public void getCompany(){

		Company expected = new Company(1, "Bamazon", "Beattle");

		Company actual = companyService.findById(1);

		assertEquals(expected, actual);
	}
}
