package hu.unideb.inf.controller;

import hu.unideb.inf.Coffes;
import hu.unideb.inf.Fajlkezelo;
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
    private Label errorindicator;

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
    private Label automatacounter;

    @FXML
    private Label sumMoney;

    @FXML
    private Label sumCoffee;

    @FXML
    private Label sumMilk;

    @FXML
    private Label sumSugar;

    @FXML
    private Label sumWater;

    public Label getValueCoffee() {
        return valueCoffee;
    }

    @FXML
    public void initialize() {
        startValues();
    }
    
    public void refresher(){
        Fajlkezelo f = new Fajlkezelo();
        ArrayList<Integer> statok = new ArrayList();
        statok = f.statpage();

        automatacounter.setText(statok.get(0).toString());
        sumMoney.setText(statok.get(1).toString());
        sumCoffee.setText(statok.get(2).toString());
        sumWater.setText(statok.get(3).toString());
        sumMilk.setText(statok.get(4).toString());
        sumSugar.setText(statok.get(5).toString());
    }

    public void startValues() {

        Fajlkezelo f = new Fajlkezelo();
        ArrayList< ArrayList<String>> records = f.readFile();

        for (var automata : records) {
            String tmp = automata.get(0);

            MenuItem menuItemtmp = new MenuItem();
            menuItemtmp.setId(tmp + "menu");
            menuItemtmp.setText(tmp);

            if (!(chooseAutomata.getItems().contains(menuItemtmp))) {
                chooseAutomata.getItems().add(menuItemtmp);
                final String tmp2 = tmp;
                menuItemtmp.setOnAction(e -> {
                    changeautomata(tmp2);
                });
            }

        }
        
        refresher();

    }

    

    @FXML
    private void espressoBtnPush(ActionEvent event) {
        coffeButtonHandler("espresso");
        refresher();
    }

    @FXML
    private void cappucinoBtnPush(ActionEvent event) {
        coffeButtonHandler("cappuccino");
        refresher();
    }

    @FXML
    private void latteBtnPush(ActionEvent event) {
        coffeButtonHandler("latte");
        refresher();
    }

    @FXML
    private void milkyBtnPush(ActionEvent event) {
        coffeButtonHandler("milkycoffe");
        refresher();
    }

    @FXML
    private void saveMoneyBtnPush(ActionEvent event) {
        String nev = automataname.getText();
        String value = inputMoney.getText();
        int itemIndex = 1;
        saveButtonHandler(nev, value, itemIndex);
        refresher();
    }

    @FXML
    private void saveCoffeeBtnPush(ActionEvent event) {
        String nev = automataname.getText();
        String value = inputCoffee.getText();
        int itemIndex = 2;
        saveButtonHandler(nev, value, itemIndex);
        refresher();
    }

    @FXML
    private void saveWaterBtnPush(ActionEvent event) {
        String nev = automataname.getText();
        String value = inputWater.getText();
        int itemIndex = 3;
        saveButtonHandler(nev, value, itemIndex);
        refresher();
    }

    @FXML
    private void saveMilkBtnPush(ActionEvent event) {
        String nev = automataname.getText();
        String value = inputMilk.getText();
        int itemIndex = 4;
        saveButtonHandler(nev, value, itemIndex);
        refresher();
    }

    @FXML
    private void saveSugarBtnPush(ActionEvent event) {
        String nev = automataname.getText();
        String value = inputSugar.getText();
        int itemIndex = 5;
        saveButtonHandler(nev, value, itemIndex);
        refresher();
    }

    @FXML
    private void regbtnpush(ActionEvent event) throws IOException {

        String tmp = regname.getText();
        if (tmp == "") {
            tmp = "Nevtelen";
        }

        MenuItem menuItemtmp = new MenuItem();
        menuItemtmp.setId(tmp + "menu");
        menuItemtmp.setText(tmp);
        chooseAutomata.getItems().add(menuItemtmp);
        final String tmp2 = tmp;
        menuItemtmp.setOnAction(e -> {

            changeautomata(tmp2);
        });

        ArrayList<String> adatoktofile2 = new ArrayList<String>();

        if (regname.getText().equals("")) {
            adatoktofile2.add("Nevtelen");

        } else {
            adatoktofile2.add(regname.getText());
        }
        if (regmoney.getText().equals("")) {
            adatoktofile2.add("0");
        } else {
            adatoktofile2.add(regmoney.getText());
        }
        if (regcoffee.getText().equals("")) {
            adatoktofile2.add("0");
        } else {
            adatoktofile2.add(regcoffee.getText());
        }
        if (regwater.getText().equals("")) {
            adatoktofile2.add("0");
        } else {
            adatoktofile2.add(regwater.getText());
        }
        if (regmilk.getText().equals("")) {
            adatoktofile2.add("0");
        } else {
            adatoktofile2.add(regmilk.getText());
        }
        if (regsugar.getText().equals("")) {
            adatoktofile2.add("0");
        } else {
            adatoktofile2.add(regsugar.getText());
        }

        ArrayList<ArrayList<String>> nagyadatoktofile2 = new ArrayList<ArrayList<String>>();
        nagyadatoktofile2.add(adatoktofile2);

        Fajlkezelo fajlok = new Fajlkezelo();
        fajlok.updateFile(nagyadatoktofile2);
        refresher();

    }

    @FXML
    private void delbtnpush(ActionEvent event) {

        Fajlkezelo file = new Fajlkezelo();
        file.automataDelAll();
        for (var item : chooseAutomata.getItems()) {
            item.setVisible(false);
        }

        automataname.setText("Válassz automatát!");
        valueMoney.setText("0");
        valueCoffee.setText("0");
        valueWater.setText("0");
        valueMilk.setText("0");
        valueSugar.setText("0");
        refresher();

    }

    public void changeautomata(String nev) {
        Fajlkezelo f = new Fajlkezelo();
        ArrayList<String> adatlista = f.automataSelector(nev);
        labelSwitcher(nev);
        refresher();
    }

    @FXML
    private void switchtodefault(ActionEvent event) {
        String nev = "DE-IK kaveautomata";
        labelSwitcher(nev);
        refresher();
    }

    public void labelSwitcher(String nev) {
        Fajlkezelo f = new Fajlkezelo();
        ArrayList<String> adatlista = f.automataSelector(nev);

        automataname.setText(adatlista.get(0));
        valueMoney.setText(adatlista.get(1));
        valueCoffee.setText(adatlista.get(2));
        valueWater.setText(adatlista.get(3));
        valueMilk.setText(adatlista.get(4));
        valueSugar.setText(adatlista.get(5));
    }

    public void saveButtonHandler(String nev, String value, int itemIndex) {
        Fajlkezelo f = new Fajlkezelo();

        ArrayList<String> adatok = f.automataSelector(nev);
        adatok.set(itemIndex, value);

        f.automataDel(nev);

        ArrayList<ArrayList<String>> nagyadatoktofile2 = new ArrayList<ArrayList<String>>();
        nagyadatoktofile2.add(adatok);

        Fajlkezelo fajlok = new Fajlkezelo();
        fajlok.updateFile(nagyadatoktofile2);

        automataname.setText(adatok.get(0));
        valueMoney.setText(adatok.get(1));
        valueCoffee.setText(adatok.get(2));
        valueWater.setText(adatok.get(3));
        valueMilk.setText(adatok.get(4));
        valueSugar.setText(adatok.get(5));
    }

    public void coffeButtonHandler(String type) {

        Coffes coffees = new Coffes();
        Fajlkezelo f = new Fajlkezelo();
        String nev = automataname.getText();
        ArrayList<String> adatlista = f.automataSelector(nev);
        ArrayList<Integer> prevadatok = new ArrayList<>();
        ArrayList<Integer> actualadatok = new ArrayList<>();

        for (int i = 1; i < adatlista.size(); i++) {
            prevadatok.add(Integer.parseInt(adatlista.get(i)));
        }

        switch (type) {
            case "espresso": {
                adatlista = coffees.makeEspresso(adatlista);
                break;
            }
            case "cappuccino": {
                adatlista = coffees.makeCappuccino(adatlista);
                break;
            }
            case "latte": {
                adatlista = coffees.makeLatte(adatlista);
                break;
            }
            case "milkycoffe": {
                adatlista = coffees.makeMilkyCoffe(adatlista);
                break;
            }
            default:
                break;
        }

        for (int i = 1; i < adatlista.size(); i++) {
            actualadatok.add(Integer.parseInt(adatlista.get(i)));
        }

        int indicator = 0;

        for (int i = 0; i < prevadatok.size(); i++) {

            if (prevadatok.get(i) - actualadatok.get(i) != 0) {

                indicator++;

            }
        }

        f.automataDel(nev);

        ArrayList<ArrayList<String>> nagyadatoktofile2 = new ArrayList<ArrayList<String>>();
        nagyadatoktofile2.add(adatlista);
        f.updateFile(nagyadatoktofile2);

        if (indicator == 0) {

            errorindicator.setText("Hiba: Nincs elegendő alapanyag!");
            errorindicator.setVisible(true);
        } else {

            errorindicator.setVisible(false);
        }

        valueMoney.setText(adatlista.get(1));
        valueCoffee.setText(adatlista.get(2));
        valueWater.setText(adatlista.get(3));
        valueMilk.setText(adatlista.get(4));
        valueSugar.setText(adatlista.get(5));
    }

}
