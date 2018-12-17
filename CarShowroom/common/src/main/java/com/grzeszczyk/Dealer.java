package com.grzeszczyk;


import com.google.common.collect.Lists;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Dealer {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private Date purchaseOfDate;
    private Integer quantity;



    public Dealer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPurchaseOfDate() {
        return purchaseOfDate;
    }

    public void setPurchaseOfDate(Date purchaseOfDate) {
        this.purchaseOfDate = purchaseOfDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}