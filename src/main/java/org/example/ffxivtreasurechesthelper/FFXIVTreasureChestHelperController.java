package org.example.ffxivtreasurechesthelper;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.InputStream;

public class FFXIVTreasureChestHelperController {
    @FXML
    public Label title;

    @FXML
    private Label welcomeText;

    @FXML
    private Label zoneData;

    @FXML
    TextField inputCoordinate;


//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//
//
//    }

    @FXML
    protected void onCoordinateInput(){
        String inputValue = inputCoordinate.getText();
        zoneData.setText(inputValue);
    }
}