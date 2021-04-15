package hu.unideb.inf.controller;

import hu.unideb.inf.Coffes;
import hu.unideb.inf.MainApp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class FXMLController {
    
    @FXML
    private AnchorPane karbantartpanel;
    
    @FXML
    private AnchorPane automatakpanel;
    
    @FXML
    private AnchorPane createdelpanel;
    
    @FXML
    private AnchorPane pane0;
    
    @FXML
    private MenuItem defaultautomata;
    
    
    
    @FXML
    private Label automataname;
    
    @FXML
    private MenuButton chooseAutomata;

    
    @FXML
    private Tab defaulttab;
    
    @FXML
    private TabPane tabs;
    
    @FXML
    private Tab creatdeltab;
    
    @FXML
    private TextField regname;

    @FXML
    private TextField regmoney;

    @FXML
    private TextField regcoffee;

    @FXML
    private TextField regwater;

    @FXML
    private TextField regmilk;

    @FXML
    private TextField regsugar;

    @FXML
    private Button regbtn;

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
    
    public static String fajlnev="adatok.txt";

    public void startValues() {

        try {
            File fajl = new File(fajlnev);
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
            File myObj = new File(fajlnev);
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

       
        valueMoney.setText(adatlista.get(0));
        valueCoffee.setText(adatlista.get(1));
        valueMilk.setText(adatlista.get(2));
        valueWater.setText(adatlista.get(3));
        valueSugar.setText(adatlista.get(4));
    }
    
    public ArrayList<String> getAmounts(){
        
        ArrayList<String> adatlista = new ArrayList<String>();
        
        try {
            File myObj = new File(fajlnev);
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
            FileWriter myWriter = new FileWriter(fajlnev);
            
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
    
     @FXML
    private void latteBtnPush(ActionEvent event) {
        Coffes latte = new Coffes();
        ArrayList<String> tmp = latte.makeLatte();
        updateFile(tmp);
        
    }
    
     @FXML
    private void milkyBtnPush(ActionEvent event) {
        Coffes milky = new Coffes();
        ArrayList<String> tmp = milky.makeMilkyCoffe();
        updateFile(tmp);
        
    }
    
     @FXML
    private void saveMoneyBtnPush(ActionEvent event) {
        String tmp=inputMoney.getText();
        ArrayList<String> adatok = getAmounts();
        adatok.set(0,tmp);
        updateFile(adatok);
    }
    
     @FXML
    private void saveCoffeeBtnPush(ActionEvent event) {
        String tmp=inputCoffee.getText();
        ArrayList<String> adatok = getAmounts();
        adatok.set(1,tmp);
        updateFile(adatok);
    }
    
     @FXML
    private void saveWaterBtnPush(ActionEvent event) {
        String tmp=inputWater.getText();
        ArrayList<String> adatok = getAmounts();
        adatok.set(3,tmp);
        updateFile(adatok);
    }
    
     @FXML
    private void saveMilkBtnPush(ActionEvent event) {
        String tmp=inputMilk.getText();
        ArrayList<String> adatok = getAmounts();
        adatok.set(2,tmp);
        updateFile(adatok);
    }
    
     @FXML
    private void saveSugarBtnPush(ActionEvent event) {
        String tmp=inputSugar.getText();
        ArrayList<String> adatok = getAmounts();
        adatok.set(4,tmp);
        updateFile(adatok);
    }
    
     @FXML
    private void regbtnpush(ActionEvent event) throws IOException {
        
        String tmp=regname.getText();
        if(tmp==""){
            tmp="Nevtelen";
        }
        
        MenuItem menuItemtmp = new MenuItem();
        menuItemtmp.setId(tmp+"menu");
        menuItemtmp.setText(tmp);
        chooseAutomata.getItems().add(menuItemtmp);
        final String tmp2=tmp;
        menuItemtmp.setOnAction(e -> {
                
		changeautomata(tmp2);
	});
        
        
        ArrayList<String> adatoktofile = new ArrayList<String>();
        
        adatoktofile.add(regmoney.getText());
        adatoktofile.add(regcoffee.getText());
        adatoktofile.add(regmilk.getText());
        adatoktofile.add(regwater.getText());
        adatoktofile.add(regsugar.getText());
        
        for(int i=0;i<adatoktofile.size();i++){
            if(adatoktofile.get(i)==""){
                adatoktofile.set(i,"0");
            }
        }
       
        try {
            File fajl = new File("adatok"+tmp);
            FileWriter myWriter = new FileWriter("adatok"+tmp+".txt");
            
            String tofile = String.join(" ", adatoktofile);
            myWriter.write(tofile);
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        
    }
    
    
    public void changeautomata(String nev) {
        automataname.setText(nev);
        fajlnev="adatok"+nev+".txt";
        startValues();
        
    }
    
    @FXML
    private void switchtodefault(ActionEvent event) {
        automataname.setText("DE-IK kávéautomata");
        fajlnev="adatok.txt";
        startValues();
        
    }
    
    

}
