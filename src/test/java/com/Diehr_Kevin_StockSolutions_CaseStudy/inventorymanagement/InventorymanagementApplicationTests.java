package com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement;

import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.CompanyRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.ProductRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.WarehouseRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.Warehouse;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.services.CompanyService;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.services.ProductService;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.services.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
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

	@Autowired
	CompanyService companyService;

	@Autowired
	WarehouseService warehouseService;



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
	public void whenTestingForOrderAgnosticEquality_ShouldBeTrue() {

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
}
