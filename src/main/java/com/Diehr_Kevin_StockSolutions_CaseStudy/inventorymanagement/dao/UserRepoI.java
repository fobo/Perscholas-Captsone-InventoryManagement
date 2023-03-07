package com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.dao;

import com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepoI extends JpaRepository<User, Integer> {

    Optional<User> findById(int id);
    Optional<User> findByEmail(String name);
    Optional<User> findByCompanyId(int id);



}
