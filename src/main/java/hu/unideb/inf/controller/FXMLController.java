package hu.unideb.inf.controller;

import hu.unideb.inf.Coffes;
import hu.unideb.inf.Fajlkezelo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class FXMLController {
    @FXML
    private Button logoutbtn;
    @FXML
    private TextField loginuser;
    
    @FXML
    private PasswordField loginpass;
    
    @FXML
    private Button loginbtn;
    

    @FXML
    private Label espressocounter;

    @FXML
    private Label cappuccinocounter;

    @FXML
    private Label lattecounter;

    @FXML
    private Label milkycoffeecounter;
    
    @FXML
    private TextField inputdel;
    
    @FXML
    private Button delselected;
    
    
        
        
    @FXML
    public BarChart<?, ?> graphstat;

    @FXML
    public CategoryAxis statX;

    @FXML
    public NumberAxis statY;


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
    private TextField karbantartonev;
    
    @FXML
    private PasswordField karbantartojelszo;

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
    
    @FXML
    private Label summoneyId;
    
    @FXML
    private Label coffeeId;
    
    @FXML
    private Label waterId;
    
    @FXML
    private Label milkId;
    
    @FXML
    private Label sugarId;
    


    
    @FXML
    public void initialize() {
        startValues();
        
    }
    
    @FXML
    private void logincheck(ActionEvent event) {
        
        String user=loginuser.getText();
        String pass=loginpass.getText();
        
        Fajlkezelo f = new Fajlkezelo();
        ArrayList<ArrayList<String>> records = f.readkarbantartoFile();
        int tmp=0;
        
        for(var sor:records){
            if( (sor.get(0).equals(user)) && (sor.get(1).equals(pass)) ){
                tmp++;
            }
        }
        
        if(tmp==1){
            onoffhandler(true);
        }
    }
    @FXML
    private void logoutcheck(ActionEvent event) {
        onoffhandler(false);
        loginpass.setText("");
        loginuser.setText("");
    }
    
    
    
           
    @FXML
    private void deleteselected(ActionEvent event) {
        
        int hiba=0;
        
        Fajlkezelo f = new Fajlkezelo();
        
        String name = inputdel.getText();
        
        for(var automata:f.readFile()){
             String tmp = automata.get(0);
             
             if(!(name.equals(tmp))){
                 hiba++;
             }
        }
        
        if(hiba==0){
            f.automataDel(name);
        
            chooseAutomata.getItems().clear();
            startValues();
        refresher();
        }
        
        
    }   
    
    
    
    public void onoffhandler(boolean valtozo){
        
        inputMoney.setVisible(valtozo);
        inputCoffee.setVisible(valtozo);
        inputWater.setVisible(valtozo);
        inputMilk.setVisible(valtozo);
        inputSugar.setVisible(valtozo);
        
        saveMoney.setVisible(valtozo);
        saveCoffee.setVisible(valtozo);
        saveWater.setVisible(valtozo);
        saveMilk.setVisible(valtozo);
        saveSugar.setVisible(valtozo);
        
        valueMoney.setVisible(valtozo);
        valueCoffee.setVisible(valtozo);
        valueWater.setVisible(valtozo);
        valueMilk.setVisible(valtozo);
        valueSugar.setVisible(valtozo);
        
        summoneyId.setVisible(valtozo);
        coffeeId.setVisible(valtozo);
        waterId.setVisible(valtozo);
        milkId.setVisible(valtozo);
        sugarId.setVisible(valtozo);
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
        
        
        if((graphstat.getData().size())!=0){
            
            graphstat.getData().clear();
             
        }
        
        

        statX.setCategories(FXCollections.<String>observableArrayList(Arrays.asList
        ("Pénz", "Kávé", "Tej", "Cukor", "Víz"))); 
        statX.setLabel("Készlet");  

         
        statY.setLabel("Mennyiségek");
        
        graphstat.setTitle("Statisztika");
        
        XYChart.Series dataSeries1 = new XYChart.Series();
        //dataSeries1.setName("");

        dataSeries1.getData().add(new XYChart.Data("Pénz", statok.get(1)));
        dataSeries1.getData().add(new XYChart.Data("Kávé", statok.get(2)));
        dataSeries1.getData().add(new XYChart.Data("Tej", statok.get(3)));
        dataSeries1.getData().add(new XYChart.Data("Cukor", statok.get(4)));
        dataSeries1.getData().add(new XYChart.Data("Víz", statok.get(5)));
        
        
        
        graphstat.getData().add(dataSeries1);
        //graphstat.getData().removeAll(dataSeries1);
        
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
        
    }

    @FXML
    private void cappucinoBtnPush(ActionEvent event) {
        coffeButtonHandler("cappuccino");
        
    }

    @FXML
    private void latteBtnPush(ActionEvent event) {
        coffeButtonHandler("latte");
        
    }

    @FXML
    private void milkyBtnPush(ActionEvent event) {
        coffeButtonHandler("milkycoffe");
        
    }

    @FXML
    private void saveMoneyBtnPush(ActionEvent event) {
        String nev = automataname.getText();
        String value = inputMoney.getText();
        int itemIndex = 1;
        saveButtonHandler(nev, value, itemIndex);
        
    }

    @FXML
    private void saveCoffeeBtnPush(ActionEvent event) {
        String nev = automataname.getText();
        String value = inputCoffee.getText();
        int itemIndex = 2;
        saveButtonHandler(nev, value, itemIndex);
        
    }

    @FXML
    private void saveWaterBtnPush(ActionEvent event) {
        String nev = automataname.getText();
        String value = inputWater.getText();
        int itemIndex = 3;
        saveButtonHandler(nev, value, itemIndex);
        
    }

    @FXML
    private void saveMilkBtnPush(ActionEvent event) {
        String nev = automataname.getText();
        String value = inputMilk.getText();
        int itemIndex = 4;
        saveButtonHandler(nev, value, itemIndex);
        
    }

    @FXML
    private void saveSugarBtnPush(ActionEvent event) {
        String nev = automataname.getText();
        String value = inputSugar.getText();
        int itemIndex = 5;
        saveButtonHandler(nev, value, itemIndex);
        
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
    private void registerbtnpush(ActionEvent event)
    {
        ArrayList<String> adatoktofile3 = new ArrayList<String>();
        
         if (karbantartonev.getText().equals("")) {
             System.out.println("Adjon meg egy nevet!!!");

        } else {
            adatoktofile3.add(karbantartonev.getText());
        }
         
         if (karbantartojelszo.getText().equals("")) {
             System.out.println("Adjon meg egy jelszot!!!");

        } else {
            adatoktofile3.add(karbantartojelszo.getText());
        }
         ArrayList<ArrayList<String>> nagyadatoktofile3 = new ArrayList<ArrayList<String>>();
         nagyadatoktofile3.add(adatoktofile3);
         
         if(adatoktofile3.size()==2){
         Fajlkezelo fajl=new Fajlkezelo();
         fajl.updatekarbantartoFile(nagyadatoktofile3);
         }
         
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
        
    }

    @FXML
    private void switchtodefault(ActionEvent event) {
        String nev = "DE-IK kaveautomata";
        labelSwitcher(nev);
        
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
        refresher();
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
                String tmp = espressocounter.getText();
                int counter = Integer.parseInt(tmp);
                counter++;
                String s=Integer.toString(counter);
                espressocounter.setText(s);
                break;
            }
            case "cappuccino": {
                adatlista = coffees.makeCappuccino(adatlista);
                String tmp = cappuccinocounter.getText();
                int counter = Integer.parseInt(tmp);
                counter++;
                String s=Integer.toString(counter);
                cappuccinocounter.setText(s);
                break;
            }
            case "latte": {
                adatlista = coffees.makeLatte(adatlista);
                String tmp = lattecounter.getText();
                int counter = Integer.parseInt(tmp);
                counter++;
                String s=Integer.toString(counter);
                lattecounter.setText(s);
                break;
            }
            case "milkycoffe": {
                adatlista = coffees.makeMilkyCoffe(adatlista);
                String tmp = milkycoffeecounter.getText();
                int counter = Integer.parseInt(tmp);
                counter++;
                String s=Integer.toString(counter);
                milkycoffeecounter.setText(s);
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
        refresher();
    }

}
