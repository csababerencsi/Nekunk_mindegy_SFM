package hu.unideb.inf;

import hu.unideb.inf.controller.FXMLController;
import javafx.scene.control.Label;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kristof
 */
public class Amounts {
    private int sumCoffe=1500;
    private int sumMilk=1400;
    private int sumWater=1300;
    private int sumSugar=1200;
    
  
    public int getSumCoffe() {
        return sumCoffe;
    }

    public int getSumMilk() {
        return sumMilk;
    }

    public int getSumWater() {
        return sumWater;
    }

    public int getSumSugar() {
        return sumSugar;
    }

    public void setSumCoffe(int sumCoffe) {
        this.sumCoffe = sumCoffe;
    }

    public void setSumMilk(int sumMilk) {
        this.sumMilk = sumMilk;
    }

    public void setSumWater(int sumWater) {
        this.sumWater = sumWater;
    }

    public void setSumSugar(int sumSugar) {
        this.sumSugar = sumSugar;
    }
    
    
}
