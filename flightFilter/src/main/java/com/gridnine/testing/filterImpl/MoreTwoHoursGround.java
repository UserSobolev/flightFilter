package com.gridnine.testing.filterImpl;

import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.flight.Flight;
import java.time.temporal.ChronoUnit;

public class MoreTwoHoursGround implements FlightFilter {
    /**
     3. исключены - "перелеты где общее время, проведённое на земле превышает два
     часа (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним)"
     */
    @Override
    public boolean flightFilter(Flight flight) {
        if (flight.getSegments().size() > 1) {
            long timeGround = 0;

            for (int i = 0; i < flight.getSegments().size() - 1; i++) {
                timeGround += flight.getSegments().get(i).getArrivalDate()
                        .until(flight.getSegments().get(i + 1).getDepartureDate(), ChronoUnit.MINUTES);
            }
          
            int minutesPerHour = 60;
            return timeGround / minutesPerHour <= 2;
        }
        return true;
    }
}
