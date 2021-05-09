/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kristof
 */
public class Fajlkezelo {

    public void resetFile(String nev) {

        ArrayList<String> adatlista = new ArrayList<>();
        adatlista.add(nev);
        adatlista.add("0");
        adatlista.add("10000");
        adatlista.add("10000");
        adatlista.add("10000");
        adatlista.add("10000");

        ArrayList< ArrayList<String>> records = new ArrayList< ArrayList<String>>();
        records.add(adatlista);

        automataDel(nev);
        updateFile(records);

    }

    public void automataDel(String name) {
        ArrayList<String> toDel = automataSelector(name);
        ArrayList<ArrayList<String>> adatlista = readFile();

        adatlista.remove(toDel);
        createFile(adatlista);
    }

    public void automataDelAll() {
        ArrayList<ArrayList<String>> adatlista = readFile();
        ArrayList<String> nevek = new ArrayList<>();
        for (var sor : adatlista) {
            {
                for (var elem : sor) {
                    nevek.add(elem.toString());
                    break;
                }
            }

        }
        for (String item : nevek) {
            automataDel(item);
        }

    }

    public ArrayList<String> automataSelector(String name) {
        ArrayList<ArrayList<String>> adatlista = readFile();
        ArrayList<String> returnlist = new ArrayList<>();

        for (var sor : adatlista) {
            for (var elem : sor) {
                if (elem.equals(name)) {
                    returnlist = sor;
                }
            }
        }

        return returnlist;

    }

    public void createFile(ArrayList<ArrayList<String>> adatlista) {

        try {
            FileWriter myWriter = new FileWriter("ujadatok.csv");

            for (var elem : adatlista) {
                String tmp = String.join(":", elem);
                myWriter.write(tmp);
                myWriter.write("\n");
            }

            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    
   
    public ArrayList<ArrayList<String>> readFile() {

        ArrayList<ArrayList<String>> records = new ArrayList<>();

        try ( Scanner scanner = new Scanner(new File("ujadatok.csv"));) {
            while (scanner.hasNextLine()) {
                String sor = scanner.nextLine();
                String[] soradat = sor.split(":");
                ArrayList<String> tmplist = new ArrayList<>();

                for (int i = 0; i < soradat.length; i++) {
                    tmplist.add(soradat[i]);
                }
                records.add(tmplist);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return records;

    }

    public ArrayList<Integer> statpage() {
        ArrayList<ArrayList<String>> adatlista = readFile();
        ArrayList<Integer> stat = new ArrayList();
        int counter = 0, kave = 0, tej = 0, cukor = 0, viz = 0, penz = 0;
        for (var sor : adatlista) {
            counter++;
            for (int i = 1; i <= sor.size(); i++) {
                if (i == 1) {
                    penz = penz + Integer.parseInt(sor.get(i));
                }
                if (i == 2) {
                    kave = kave + Integer.parseInt(sor.get(i));
                }
                if (i == 3) {
                    viz = viz + Integer.parseInt(sor.get(i));
                }
                if (i == 4) {
                    tej = tej + Integer.parseInt(sor.get(i));
                }
                if (i == 5) {
                    cukor = cukor + Integer.parseInt(sor.get(i));
                }

            }
        }
        stat.add(counter);
        stat.add(penz);
        stat.add(kave);
        stat.add(viz);
        stat.add(tej);
        stat.add(cukor);

        return stat;
    }

    public void updateFile(ArrayList<ArrayList<String>> adatlista) {

        ArrayList<ArrayList<String>> records = new ArrayList<>();
        records = readFile();

        for (var elem : adatlista) {
            ArrayList<String> tmplista = new ArrayList<>();
            String tmp = String.join(":", elem);
            tmplista.add(tmp);
            records.add(tmplista);
        }

        try {
            FileWriter myWriter = new FileWriter("ujadatok.csv");
            ArrayList<String> outlist = new ArrayList<>();

            for (var sor : records) {
                String tmp2 = String.join(":", sor);
                outlist.add(tmp2);
            }

            String outstr = String.join("\r\n", outlist);

            myWriter.write(outstr);
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
 
    
    public ArrayList<ArrayList<String>>  readkarbantartoFile()
    {
        ArrayList<ArrayList<String>> records = new ArrayList<>();

        try ( Scanner scanner = new Scanner(new File("karbantarto.csv"));) {
            while (scanner.hasNextLine()) {
                String sor = scanner.nextLine();
                String[] soradat = sor.split(":");
                ArrayList<String> tmplist = new ArrayList<>();

                for (int i = 0; i < soradat.length; i++) {
                    tmplist.add(soradat[i]);
                }
                records.add(tmplist);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return records;
    }
    
     public void updatekarbantartoFile(ArrayList<ArrayList<String>> adatlista) {

        ArrayList<ArrayList<String>> records = new ArrayList<>();
        records = readkarbantartoFile();

        for (var elem : adatlista) {
            ArrayList<String> tmplista = new ArrayList<>();
            String tmp = String.join(":", elem);
            tmplista.add(tmp);
            records.add(tmplista);
        }

        try {
            FileWriter myWriter = new FileWriter("karbantarto.csv");
            ArrayList<String> outlist = new ArrayList<>();

            for (var sor : records) {
                String tmp2 = String.join(":", sor);
                outlist.add(tmp2);
            }

            String outstr = String.join("\r\n", outlist);

            myWriter.write(outstr);
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


}


