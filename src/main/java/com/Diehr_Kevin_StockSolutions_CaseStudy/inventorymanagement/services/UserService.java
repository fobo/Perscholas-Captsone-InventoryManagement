package com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.services;

import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.AuthGroupRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.CompanyRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.UserRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.AuthGroup;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.Company;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.User;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
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
        Company company2 = company.get();
        User user = new User(email, password, firstName, lastName, company2);
        userRepoI.saveAndFlush(user);

        //adds user to authgroup.
        AuthGroup authUser = new AuthGroup(email,"USER");
        authGroupRepoI.saveAndFlush(authUser);


    }

    public Integer findId(String email){
        Optional<User> user = userRepoI.findByEmail(email);
        User setUser = user.get();

        return setUser.getId();

    }


}
