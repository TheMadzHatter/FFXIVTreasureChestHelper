package org.example.ffxivtreasurechesthelper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CoordinateMatcher {
    HashMap<Zone, List<Coordinate>> zoneChests = new HashMap<>();
    CoordinateParser parser;

    public CoordinateMatcher(){
        parser = new CoordinateParser();
        loadZones();
    }

    private void loadZones(){
        try(InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("TreasureChestCoordinates.json")){
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readValue(in, JsonNode.class);
            Iterator<String> fieldNames = jsonNode.fieldNames();
            while(fieldNames.hasNext()){
                String zoneName = fieldNames.next();
                List<String> z = mapper.convertValue(jsonNode.get(zoneName), ArrayList.class);
                List<Coordinate> zoneCoordinates = new ArrayList<>();
                Zone zone = Zone.valueOf(zoneName);
                for(String cord : z){
                    zoneCoordinates.add(parser.parseZoneData(zone,cord));
                }
                zoneChests.put(zone, zoneCoordinates);
            }
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public Coordinate match(Coordinate inputCoordinate){
        Coordinate chestCoordinate = null;
        double minDistance = Double.MAX_VALUE;
        for(Coordinate zoneCoordinate : zoneChests.get(inputCoordinate.getZone())){
            double aa = Math.pow(Math.abs(inputCoordinate.getX() - zoneCoordinate.getX()),2);
            double bb = Math.pow(Math.abs(inputCoordinate.getY() - zoneCoordinate.getY()),2);
            double distance= Math.sqrt(aa + bb);
            if(distance< minDistance){
                minDistance = distance;
                chestCoordinate = zoneCoordinate;
            }
        }
        return chestCoordinate;
    }
}

