/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf;

import java.util.ArrayList;

/**
 *
 * @author Kristof
 */
public class Coffes {
    
    
    public ArrayList<String> makeEspresso(ArrayList<String> adatok){
        
        
        ArrayList<Integer> intadatok = new ArrayList<Integer>();
        ArrayList<String> adatokreturn = new ArrayList<String>();
        
        for(int i=1;i<adatok.size();i++){
            intadatok.add(Integer.parseInt(adatok.get(i)));
        }
        
        
        
        intadatok.set(0,intadatok.get(0)+250);
        intadatok.set(1,intadatok.get(1)-14);
        intadatok.set(2,intadatok.get(2)-0);
        intadatok.set(3,intadatok.get(3)-60);
        intadatok.set(4,intadatok.get(4)-8);
        
        
        
        adatokreturn.add(adatok.get(0));
        
        for(int i=0;i<intadatok.size();i++){
            adatokreturn.add(Integer.toString(intadatok.get(i)));
        }
        
        
        
        return adatokreturn;
    }
    
    public ArrayList<String> makeCappuccino(ArrayList<String> adatok){
        
        
        ArrayList<Integer> intadatok = new ArrayList<Integer>();
        ArrayList<String> adatokreturn = new ArrayList<String>();
        
        for(int i=1;i<adatok.size();i++){
            intadatok.add(Integer.parseInt(adatok.get(i)));
        }
        
        intadatok.set(0,intadatok.get(0)+350);
        intadatok.set(1,intadatok.get(1)-7);
        intadatok.set(2,intadatok.get(2)-30);
        intadatok.set(3,intadatok.get(3)-8);
        intadatok.set(4,intadatok.get(4)-85);
        
        adatokreturn.add(adatok.get(0));
        
        for(int i=0;i<intadatok.size();i++){
            adatokreturn.add(Integer.toString(intadatok.get(i)));
        }
        
        return adatokreturn;
        
    }
    
    public ArrayList<String> makeLatte(ArrayList<String> adatok){
       
        
        ArrayList<Integer> intadatok = new ArrayList<Integer>();
        ArrayList<String> adatokreturn = new ArrayList<String>();
        
        for(int i=1;i<adatok.size();i++){
            intadatok.add(Integer.parseInt(adatok.get(i)));
        }
        
        intadatok.set(0,intadatok.get(0)+300);
        intadatok.set(1,intadatok.get(1)-14);
        intadatok.set(2,intadatok.get(2)-60);
        intadatok.set(3,intadatok.get(3)-8);
        intadatok.set(4,intadatok.get(4)-90);
        
        adatokreturn.add(adatok.get(0));
        
        for(int i=0;i<intadatok.size();i++){
            adatokreturn.add(Integer.toString(intadatok.get(i)));
        }
        
        return adatokreturn;
    }
    
    public  ArrayList<String> makeMilkyCoffe(ArrayList<String> adatok){
        
        ArrayList<Integer> intadatok = new ArrayList<Integer>();
        ArrayList<String> adatokreturn = new ArrayList<String>();
        
        for(int i=1;i<adatok.size();i++){
            intadatok.add(Integer.parseInt(adatok.get(i)));
        }
        
        intadatok.set(0,intadatok.get(0)+400);
        intadatok.set(1,intadatok.get(1)-10);
        intadatok.set(2,intadatok.get(2)-50);
        intadatok.set(3,intadatok.get(3)-8);
        intadatok.set(4,intadatok.get(4)-100);
        
        adatokreturn.add(adatok.get(0));
        
        for(int i=0;i<intadatok.size();i++){
            adatokreturn.add(Integer.toString(intadatok.get(i)));
        }
        
        return adatokreturn;
    }
    
        
    
    
    
    
    
}
