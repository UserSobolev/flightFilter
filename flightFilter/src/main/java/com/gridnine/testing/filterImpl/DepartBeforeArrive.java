package com.gridnine.testing.filterImpl;

import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.Segment;
public class DepartBeforeArrive implements FlightFilter {
    /**
     *  2. исключен - "имеются сегменты с датой прилёта раньше даты вылета"
     */

    @Override
    public boolean flightFilter(Flight flight) {
        for (Segment segment : flight.getSegments()) {
            if (segment.getDepartureDate().isAfter(segment.getArrivalDate())) {
                return false;
            }
        }
        return true;
    }
}
