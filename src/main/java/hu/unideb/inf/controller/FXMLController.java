package hu.unideb.inf.controller;

import hu.unideb.inf.Amounts;
import hu.unideb.inf.Coffes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLController {
    
    
    @FXML
    private Button espressoBtn;
    
    @FXML
    void espressoBtnPush(ActionEvent event){
       Coffes espresso =new Coffes();
       espresso.makeEspresso();
       
    }
    @FXML
    private Button cappucinoBtn;
    
     @FXML
    void cappucinoBtnPush(ActionEvent event){
       Coffes espresso =new Coffes();
       espresso.makeEspresso();
       
    }
    @FXML
    private Button latteBtn;

    @FXML
    private Button milkyCoffeeBtn;

    @FXML
    private TextField inputMoney;

    @FXML
    private Label valueMoney;

    @FXML
    private TextField inputCoffee;

    @FXML
    private Label valueCoffee;

    @FXML
    private TextField inputWater;

    @FXML
    private Label valueWater;

    @FXML
    private TextField inputMilk;

    @FXML
    private Label valueMilk;

    @FXML
    private TextField inputSugar;

    @FXML
    private Label valueSugar;

    @FXML
    private Button saveMoney;

    @FXML
    private Button saveCoffee;

    @FXML
    private Button saveWater;

    @FXML
    private Button saveMilk;

    @FXML
    private Button saveSugar;

    @FXML
    private TextField changeValue;

    @FXML
    private TextField paymentValue;

    @FXML
    private TextField moneyAmout;
    
    @FXML
    private Button startButton;

    public Label getValueCoffee() {
        return valueCoffee;
    }
    
    public void startValues(){
        Amounts amounts = new Amounts();
        valueCoffee.setText(Integer.toString(amounts.getSumCoffe()));
        valueMilk.setText(Integer.toString(amounts.getSumMilk()));
        valueWater.setText(Integer.toString(amounts.getSumWater()));
        valueSugar.setText(Integer.toString(amounts.getSumSugar()));
    }

    
    @FXML private void startButtonPushed(ActionEvent event) {
        startValues();
    }
    
    
    
    

}
