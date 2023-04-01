package org.example;

public class Rides {
    public double distance;
    public int time;
    public RideCategory rideCategory;
    public Rides(){

    }
    public Rides(double distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public Rides(double distance, int time, RideCategory rideCategory) {
        this.distance = distance;
        this.time = time;
        this.rideCategory = rideCategory;
    }
}
