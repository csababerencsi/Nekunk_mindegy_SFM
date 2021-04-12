/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf;

import hu.unideb.inf.controller.FXMLController;
import java.util.ArrayList;

/**
 *
 * @author Kristof
 */
public class Coffes {
    
    
    public ArrayList<String> makeEspresso(){
        
        FXMLController control = new FXMLController();
        
        Amounts amounts = new Amounts();
        
        ArrayList<String> adatok = control.getAmounts();
        ArrayList<Integer> intadatok = new ArrayList<Integer>();
        ArrayList<String> adatokreturn = new ArrayList<String>();
        
        for(int i=0;i<adatok.size();i++){
            intadatok.add(Integer.parseInt(adatok.get(i)));
        }
        
        intadatok.set(0,intadatok.get(0)-250);
        intadatok.set(1,intadatok.get(1)-14);
        intadatok.set(2,intadatok.get(2)-0);
        intadatok.set(3,intadatok.get(3)-60);
        intadatok.set(4,intadatok.get(4)-8);
        
        
        for(int i=0;i<intadatok.size();i++){
            adatokreturn.add(Integer.toString(intadatok.get(i)));
        }
        
        return adatokreturn;
    }
    
    public void makeCappuccino(){
        Amounts amounts = new Amounts();
     
        amounts.setSumCoffe(amounts.getSumCoffe()-7);
        amounts.setSumWater(amounts.getSumWater()-30);
        amounts.setSumSugar(amounts.getSumSugar()-8);
        amounts.setSumMilk(amounts.getSumMilk()-85);
    }
    
    public void makeLatte(){
        Amounts amounts = new Amounts();
     
        amounts.setSumCoffe(amounts.getSumCoffe()-14);
        amounts.setSumWater(amounts.getSumWater()-60);
        amounts.setSumSugar(amounts.getSumSugar()-8);
        amounts.setSumMilk(amounts.getSumMilk()-90);
    }
    
    public void makeMilkyCoffe(){
        Amounts amounts = new Amounts();
     
        amounts.setSumCoffe(amounts.getSumCoffe()-10);
        amounts.setSumWater(amounts.getSumWater()-50);
        amounts.setSumSugar(amounts.getSumSugar()-8);
        amounts.setSumMilk(amounts.getSumMilk()-100);
    }
    
    
    
    
    
}
