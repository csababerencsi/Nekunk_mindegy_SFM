/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf;

/**
 *
 * @author Kristof
 */
public class Coffes {
    
    
    public void makeEspresso(){
        Amounts amounts = new Amounts();
     
        amounts.setSumCoffe(amounts.getSumCoffe()-14);
        amounts.setSumWater(amounts.getSumWater()-60);
        amounts.setSumSugar(amounts.getSumSugar()-8);
        amounts.setSumMilk(amounts.getSumMilk()-0);
        
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
