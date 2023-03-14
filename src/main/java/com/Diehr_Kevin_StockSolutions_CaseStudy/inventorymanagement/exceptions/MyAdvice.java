package com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.exceptions;

import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.UserRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@ControllerAdvice
@Slf4j
public class MyAdvice {
    private final UserRepoI userRepoI;

    public MyAdvice(UserRepoI userRepoI) {
        this.userRepoI = userRepoI;
    }
    @ModelAttribute
    public void initModel(Model model, HttpServletRequest request, HttpSession http){
        Principal p = request.getUserPrincipal();

        User user = null;
        if(p != null){
            user =  userRepoI.findByEmail(p.getName()).get();
            http.setAttribute("User", user);
            log.warn("MyAdvice: current user in session:  " + user.getEmail());

        } else {
            log.warn("MyAdvice: principal was null");
        }
    }
    @ExceptionHandler({Exception.class, AccessDeniedException.class})
    public RedirectView exceptionHandle(Exception ex){

        log.debug("error happened");
        ex.printStackTrace();
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8080/error"); // redirects user to error page when they hit an error.
        return redirectView;
    }
}
