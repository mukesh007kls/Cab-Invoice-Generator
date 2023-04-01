package org.example;

import java.util.Objects;

public class Summary {
    public double averageFarePerRide;
    public int numberOfRides;
    public  double totalFare;

    public Summary(int numberOfRides, double totalFare) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.averageFarePerRide = this.totalFare/this.numberOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Summary summary = (Summary) o;
        return Double.compare(summary.averageFarePerRide, averageFarePerRide) == 0 && numberOfRides == summary.numberOfRides && Double.compare(summary.totalFare, totalFare) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(averageFarePerRide, numberOfRides, totalFare);
    }
}
