package com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyExceptions extends Exception{

    public MyExceptions(String message) {
        super(message);
    }
}
