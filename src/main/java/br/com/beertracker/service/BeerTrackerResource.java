package br.com.beertracker.service;

import br.com.beertracker.entity.BeerConsumption;
import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLApi
public class BeerTrackerResource {

    private final BeerConsumptionService service;

    @Inject
    public BeerTrackerResource(BeerConsumptionService service) {
        this.service = service;
    }

    @Mutation
    public void recordConsumption(String personName, double amountInMl) {
        service.recordConsumption(personName, amountInMl);
    }

    @Query
    public List<BeerConsumption> getConsumptionsRank() {
        return service.getConsumptionsRank();
    }
}