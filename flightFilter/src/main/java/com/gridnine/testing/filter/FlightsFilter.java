package com.gridnine.testing.filter;

import com.gridnine.testing.filterImpl.DepartBeforeArrive;
import com.gridnine.testing.filterImpl.DepartInPast;
import com.gridnine.testing.filterImpl.MoreTwoHoursGround;
import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.FlightBuilder;

import java.util.List;

public class FlightsFilter {
    private final List<Flight> listOfFlights;
    DepartInPast departInPast = new DepartInPast();
    DepartBeforeArrive departBeforeArrive = new DepartBeforeArrive();
    MoreTwoHoursGround moreTwoHoursGround = new MoreTwoHoursGround();

    public FlightsFilter() {
        this.listOfFlights = FlightBuilder.createFlights();
    }

    public void getFilters(int filterNo) {
        switch (filterNo) {
            case 1 -> {
                System.out.println("исключены вылеты до текущего момента времени:");
                listOfFlights.stream()
                        .filter(departInPast::flightFilter)
                        .forEach(System.out::println);
            }
            case 2 -> {
                System.out.println("исключены перелеты с дата прилёта раньше даты вылета:");
                listOfFlights.stream()
                        .filter(departBeforeArrive::flightFilter)
                        .forEach(System.out::println);
            }
            case 3 -> {
                System.out.println("исключены пересадки больше 2 часов:");
                listOfFlights.stream()
                        .filter(moreTwoHoursGround::flightFilter)
                        .forEach(System.out::println);
            }
        }
    }
}
