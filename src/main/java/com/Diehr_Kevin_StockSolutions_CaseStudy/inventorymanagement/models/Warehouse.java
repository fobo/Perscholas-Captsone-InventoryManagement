package com.Diehr_Kevin_StockSolutions_CaseStudy.inventorymanagement.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "warehouses")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "city", nullable = false, length = 45)
    private String city;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Warehouse warehouse)) return false;
        return Objects.equals(id, warehouse.id) && Objects.equals(city, warehouse.city) && Objects.equals(company, warehouse.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, company);
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", company=" + company +
                '}';
    }
}