package org.example.ffxivtreasurechesthelper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.InputStream;

public class FFXIVTreasureChestHelperController {
    @FXML
    private Label welcomeText;

    @FXML
    private Label zoneData;

    @FXML
    TextField inputCoordinate;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        zoneData.setText(loadZones());
    }

    private String loadZones(){
        try(InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("TreasureChestCoordinates.json")){
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readValue(in, JsonNode.class);
            return mapper.writeValueAsString(jsonNode);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}