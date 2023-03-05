package com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.security;

import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.AuthGroupRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao.UserRepoI;
import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.AuthGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserDetailsService implements UserDetailsService {
    UserRepoI userRepoI;
    AuthGroupRepoI authGroupRepoI;

    @Autowired
    public AppUserDetailsService(UserRepoI userRepoI, AuthGroupRepoI authGroupRepoI) {
        this.userRepoI = userRepoI;
        this.authGroupRepoI = authGroupRepoI;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<AuthGroup> authGroupList = authGroupRepoI.findByEmail(username);


        return new AppUserPrincipal(userRepoI.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("did not find email"))
                ,authGroupList);
    }
}
