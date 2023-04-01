package org.example;

public enum RideCategory {
    NORMAL_RIDE(10,1,5),PREMIUM_RIDE(15,2,20);
    public double costPerKm;
    public int costPerMin;
    public double minTotalFare;

    RideCategory(double costPerKm, int costPerMin, double minTotalFare) {
        this.costPerKm = costPerKm;
        this.costPerMin = costPerMin;
        this.minTotalFare = minTotalFare;
    }
}
