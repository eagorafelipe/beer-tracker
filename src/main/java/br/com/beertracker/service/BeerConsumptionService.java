package br.com.beertracker.service;

import br.com.beertracker.entity.BeerConsumption;
import br.com.beertracker.repository.BeerConsumptionRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class BeerConsumptionService {

    private final BeerConsumptionRepository repository;

    @Inject
    public BeerConsumptionService(BeerConsumptionRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void recordConsumption(String personName, double amountInMl) {
        BeerConsumption consumption = new BeerConsumption(personName, amountInMl);
        repository.persist(consumption);
    }

    public List<BeerConsumption> getConsumptionsRank() {
        return repository.findAll()
                .stream()
                .collect(Collectors.groupingBy(c -> c.personName, Collectors.summingDouble(c -> c.amountInMl)))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                .map(entry -> new BeerConsumption(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}