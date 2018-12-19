package com.grzeszczyk;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.google.common.collect.Lists;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Dealer {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private LocalDate purchaseOfDate;
    private Integer quantity;

    @OneToMany(
            mappedBy = "dealer",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<Car> carsClientList = Lists.newArrayList();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;



    public Dealer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPurchaseOfDate() {
        return purchaseOfDate;
    }

    public void setPurchaseOfDate(LocalDate purchaseOfDate) {
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

    public List<Car> getCarsClientList() {
        return carsClientList;
    }

    public void setCarsClientList(List<Car> carsClientList) {
        this.carsClientList = carsClientList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", purchaseOfDate=" + purchaseOfDate +
                ", quantity=" + quantity +
                ", carsClientList=" + carsClientList +
                ", client=" + client +
                '}';
    }
}