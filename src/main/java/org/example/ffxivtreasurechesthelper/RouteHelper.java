package org.example.ffxivtreasurechesthelper;

import java.util.*;

public class RouteHelper {

    HashMap<Zone, List<Coordinate>> chestsByZone;
    CoordinateParser parser;
    CoordinateMatcher matcher;

    public RouteHelper(){
        chestsByZone = new HashMap<>();
        parser = new CoordinateParser();
        matcher = new CoordinateMatcher();
    }

    public void addChest(String input){
        Coordinate chest = parser.parseUserInput(input);
        List<Coordinate> zoneChests = chestsByZone.getOrDefault(chest.getZone(), new ArrayList<>());
        zoneChests.add(chest);
        chestsByZone.put(chest.getZone(), zoneChests);
    }
}
