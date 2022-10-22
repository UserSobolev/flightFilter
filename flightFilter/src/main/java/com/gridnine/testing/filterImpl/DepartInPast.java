package com.gridnine.testing.filterImpl;

import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.Segment;
import java.time.LocalDateTime;

public class DepartInPast implements FlightFilter {
    /**
     * 1. исключены вылет до текущего момента времени
     */
    @Override
    public boolean flightFilter(Flight flight) {
        for (Segment segment : flight.getSegments()) {
            if (segment.getDepartureDate().isBefore(LocalDateTime.now())) {
                return false;
            }
        }
        return true;
    }
}
