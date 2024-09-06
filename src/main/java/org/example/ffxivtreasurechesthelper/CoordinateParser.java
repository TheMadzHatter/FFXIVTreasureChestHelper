package org.example.ffxivtreasurechesthelper;

public class CoordinateParser {
    public CoordinateParser(){

    }

    public Coordinate parse(String enteredCoordinate){
        String[] parts = enteredCoordinate.split("[(),]");
        return new Coordinate(Zone.valueOf(parts[0].trim()), Double.parseDouble(parts[1].trim()), Double.parseDouble(parts[2].trim()));
    }
}
