package hu.unideb.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.fxml.FXML;

public class fxcontroller {


    @FXML
    private Label label;

    public fxcontroller(Label label) {
        this.label = label;
    }

    public void handleButtonAction(ActionEvent actionEvent) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
}
