package br.com.beertracker.service;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.fail;

@QuarkusTest
class BeerConsumptionServiceTest {

    @Inject
    BeerConsumptionService service;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testRecordAndRank() {
        try {
            service.recordConsumption("person1", 350.00);
            service.recordConsumption("person2", 300.00);
            service.recordConsumption("person1", 300.00);
            service.recordConsumption("person2", 300.00);

            var rank = service.getConsumptionsRank();

            assertThat("size records", rank.size(), is(2));

        } catch (Exception e) {
            fail(e);
        }
    }
}