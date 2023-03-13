package com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
@Slf4j
public class MyAdvice {

    @ModelAttribute
    public void initModel(Model model){
        model.addAttribute("msg","hello world");

    }
}
