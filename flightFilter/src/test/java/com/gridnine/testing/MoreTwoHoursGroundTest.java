package com.gridnine.testing;

import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.filterImpl.DepartInPast;
import com.gridnine.testing.filterImpl.MoreTwoHoursGround;
import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.FlightBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

public class MoreTwoHoursGroundTest {
    List<Flight> flights = FlightBuilder.createFlights();
    FlightFilter flightFilter = new MoreTwoHoursGround();


    @BeforeEach
    public void init() {System.out.println("test started");}

    @BeforeAll
    static void started() {System.out.println("tests started");}

    @AfterEach
    public void finished() {
        System.out.println("test completed");
    }

    @AfterAll
    static void finishedAll() {
        System.out.println("tests completed");
    }

    @Test
    public void flightFilterTest() {
        long expected = flights.size() - 2;

        long result = flights.stream().filter(flightFilter::flightFilter).count();

        Assert.assertEquals(expected, result);
    }
}
