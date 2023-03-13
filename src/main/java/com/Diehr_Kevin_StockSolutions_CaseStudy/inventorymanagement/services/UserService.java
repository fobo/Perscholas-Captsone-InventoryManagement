package com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.services;

import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.AuthGroupRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.CompanyRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.UserRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.AuthGroup;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.Company;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.User;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
@Slf4j
public class UserService {

    @Autowired
    private final CompanyRepoI companyRepoI;
    private final UserRepoI userRepoI;
    private final AuthGroupRepoI authGroupRepoI;

    public UserService(CompanyRepoI companyRepoI,
                       UserRepoI userRepoI,
                       AuthGroupRepoI authGroupRepoI) {
        this.companyRepoI = companyRepoI;
        this.userRepoI = userRepoI;
        this.authGroupRepoI = authGroupRepoI;
    }

    public void addUser(Integer company_id, String email, String password, String firstName, String lastName) {

        Optional<Company> company = companyRepoI.findById(company_id);
        Company setCompany = company.get();
        User user = new User(email, password, firstName, lastName, setCompany);
        userRepoI.saveAndFlush(user);
        log.warn("Adding user");
        //adds user to authgroup.
        AuthGroup authUser = new AuthGroup(email,"USER");
        authGroupRepoI.saveAndFlush(authUser);

        log.warn("Adding user to Auth Group");

    }

    public void updateUser(Integer id, String email, String firstName, String lastName){
        Optional<User> user = userRepoI.findById(id);
        User setUser = user.get();
        setUser.setEmail(email);
        setUser.setFirst_name(firstName);
        setUser.setLast_name(lastName);
        userRepoI.saveAndFlush(setUser);

    }

    public void deleteUser(Integer id){
        userRepoI.deleteById(id);
    }

    public List<User> getUsers(){
//        List<User> userList = userRepoI.findAll();
        return userRepoI.findAll();
    }


    public Integer findId(String email){
//        Optional<User> user = userRepoI.findByEmail(email);
//        User setUser = user.get();

        return userRepoI.findByEmail(email).get().getId();

    }


}
