package org.example.ffxivtreasurechesthelper;

public class Coordinate {

    private Zone zone;
    private double x;
    private double y;

    public Coordinate(Zone zone, double x, double y) {
        this.zone = zone;
        this.x = x;
        this.y = y;
    }

    public Zone getZone() {
        return zone;
    }

    public double getX() {
        return x;
    }

    public double getY(){
        return y;
    }
}
