package hu.unideb.inf.controller;

import hu.unideb.inf.Amounts;
import hu.unideb.inf.Coffes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private Button espressoBtn;

    @FXML
    private Button cappucinoBtn;

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
    
    @FXML
    private Button resetButton;

    public Label getValueCoffee() {
        return valueCoffee;
    }

    public void startValues() {

        try {
            File fajl = new File("adatok.txt");
            if (!fajl.exists()) {

                FileWriter myWriter = new FileWriter("adatok.txt");
                myWriter.write("2000 1500 1400 1300 1200");
                myWriter.close();

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        ArrayList<String> adatlista = new ArrayList<String>();
        
        try {
            File myObj = new File("adatok.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] szamok = data.split(" ");
                
                for(int i=0;i<szamok.length;i++){
                    adatlista.add(szamok[i]);
                }
                
               
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Amounts amounts = new Amounts();
        valueMoney.setText(adatlista.get(0));
        valueCoffee.setText(adatlista.get(1));
        valueMilk.setText(adatlista.get(2));
        valueWater.setText(adatlista.get(3));
        valueSugar.setText(adatlista.get(4));
    }
    
    public ArrayList<String> getAmounts(){
        
        ArrayList<String> adatlista = new ArrayList<String>();
        
        try {
            File myObj = new File("adatok.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] szamok = data.split(" ");
                
                for(int i=0;i<szamok.length;i++){
                    adatlista.add(szamok[i]);
                }
                
               
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        return adatlista;
    }

    public void updateFile(ArrayList<String> adatlista){
        
        valueMoney.setText(adatlista.get(0));
        valueCoffee.setText(adatlista.get(1));
        valueMilk.setText(adatlista.get(2));
        valueWater.setText(adatlista.get(3));
        valueSugar.setText(adatlista.get(4));
        
         try {
            FileWriter myWriter = new FileWriter("adatok.txt");
            
            String tmp = String.join(" ", adatlista);
            myWriter.write(tmp);
            myWriter.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        
    }
    
    public void resetFile(){
        
        ArrayList<String> adatlista = new ArrayList<>();
        adatlista.add("0");
        adatlista.add("10000");
        adatlista.add("10000");
        adatlista.add("10000");
        adatlista.add("10000");
        
        updateFile(adatlista);
    }
    
    @FXML
    private void startButtonPushed(ActionEvent event) {
        startValues();
    }
    
    @FXML
    private void resetButtonPushed(ActionEvent event) {
        resetFile();
    }

    @FXML
    private void espressoBtnPush(ActionEvent event) {
        Coffes espresso = new Coffes();
        ArrayList<String> tmp = espresso.makeEspresso();
        updateFile(tmp);
        
    }
    
    @FXML
    private void cappucinoBtnPush(ActionEvent event) {
        Coffes cappucino = new Coffes();
        ArrayList<String> tmp = cappucino.makeCappuccino();
        updateFile(tmp);
        
    }
    
    

}
