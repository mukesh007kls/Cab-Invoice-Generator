package org.example;

import java.beans.beancontext.BeanContextServiceAvailableEvent;
import java.util.HashMap;

public class CabInvoiceGenerator {
    private static final int COST_PER_KM = 10;
    private static final int COST_PER_MIN = 1;
    private static final double MINIMUM_FARE = 5;

    HashMap<String, Rides[]> ridesRepos = new HashMap<>();

    public double calculateTotalFare(double distance, int time) {
        double totalFare;
        totalFare = COST_PER_KM * distance + COST_PER_MIN * time;
        if (totalFare < MINIMUM_FARE) {
            totalFare = MINIMUM_FARE;
        }
        return totalFare;
    }

    public double calculateFareForMultipleRides(Rides[] rides) {
        double totalFare = 0;
        for (Rides x : rides) {
            totalFare += this.calculateTotalFare(x.distance, x.time);
        }
        return totalFare;
    }

    public Summary calculateFareForMultipleRidesSummary(Rides[] rides) {
        double totalFare = 0;
        for (Rides x : rides) {
            totalFare += this.calculateTotalFare(x.distance, x.time);
        }
        return new Summary(rides.length, totalFare);
    }

    public Summary calculateFareForMultipleRidersSummary(String userID) {
        Rides[] rides = ridesRepos.get(userID);
        return calculateFareForMultipleRidesSummary(rides);
    }

    public void addRide(String userId, Rides[] rides) {
        ridesRepos.put(userId, rides);
    }

    public double calculateFareForPremiumAndNormal(RideCategory category, double distance, int time) {
        double totalFare = distance * category.costPerKm + time * category.costPerMin;
        return Math.max(totalFare, category.minTotalFare);
    }


    public Summary getSummaryForCategory(String userId) {
        Rides[] rides = ridesRepos.get(userId);
        double totalFare = 0;
        for (Rides x : rides) {
            totalFare += this.calculateFareForPremiumAndNormal(x.rideCategory, x.distance, x.time);
        }
        return new Summary(rides.length, totalFare);
    }
}