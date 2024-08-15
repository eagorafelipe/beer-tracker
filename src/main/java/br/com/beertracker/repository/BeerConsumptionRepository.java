package br.com.beertracker.repository;

import br.com.beertracker.entity.BeerConsumption;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BeerConsumptionRepository implements PanacheRepository<BeerConsumption> {
}