package org.example.ffxivtreasurechesthelper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class CoordinateMatcher {
    HashMap<Zone, List<Coordinate>> zoneChests = new HashMap<>();

    public CoordinateMatcher(){
        loadZones();
    }

    private void loadZones(){
        try(InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("TreasureChestCoordinates.json")){
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readValue(in, JsonNode.class);
            String jsonString = mapper.writeValueAsString(jsonNode);
            System.out.println(jsonString);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}

