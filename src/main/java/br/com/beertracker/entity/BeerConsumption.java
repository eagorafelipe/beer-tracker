package br.com.beertracker.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class BeerConsumption extends PanacheEntity {

    public String personName;
    public double amountInMl;

    public BeerConsumption() {
    }

    public BeerConsumption(String personName, double amountInMl) {
        this.personName = personName;
        this.amountInMl = amountInMl;
    }
}