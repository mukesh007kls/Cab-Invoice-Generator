package org.example;

public class CabInvoiceGenerator {
    private static final int COST_PER_KM = 10;
    private static final int COST_PER_MIN = 1;
    private static final double MINIMUM_FARE = 5;

    public double calculateTotalFare(double distance, int time) {
        double totalFare;
        totalFare = COST_PER_KM * distance + COST_PER_MIN * time;
        if (totalFare < MINIMUM_FARE) {
            totalFare = MINIMUM_FARE;
        }
        return totalFare;
    }
}