/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orszagok;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author Axmart
 */
public class Orszagok {

    /**
     * @param args the command line arguments
     */
    static public ArrayList<Orszag> orszagokLista = new ArrayList();
    public static void main(String[] args) throws FileNotFoundException, IOException {
       
        
        System.setProperty("file.encoding", "UTF8");
        BufferedReader fileReader = new BufferedReader(new FileReader("orszagok.txt"));
        
        String sor;
        
        String[] tempTomb;
        
        while((sor =fileReader.readLine())!= null){
            
            tempTomb = sor.split(";");
            orszagokLista.add(new Orszag(tempTomb[0],tempTomb[1],Integer.parseInt(tempTomb[2]),Integer.parseInt(tempTomb[3]),tempTomb[4]));
            
        }
        
        fileReader.close();
        
        
        cFeladat();
        dFeladat();
        eFeladat();
        fFeladat();
        gFeladat();
        hFeladat();

        
    }

    private static void cFeladat() {
        System.out.println("C feladat \n");
        
       for(Orszag o : orszagokLista){
            System.out.println(o.nev + "," + o.allamforma +","+ o.foldresz);
        }
        
        
    }

    private static void dFeladat() {
        System.out.println("\nD feladat \n");
        
        for(Orszag o : orszagokLista){
            
            if(o.allamforma.contains("köztársaság")){
                System.out.println(o.nev);
            }
            
        }
        
    }

    private static void eFeladat() {
        
        System.out.println("\nE feladat \n");
        
        int nemKoztarsasagokSzama=0;
        ArrayList<String> nemKoztarsasagAllamformak = new ArrayList();
        
        for(Orszag o : orszagokLista){
            
            if(!o.allamforma.contains("köztársaság")){
                nemKoztarsasagokSzama ++;
                if(!nemKoztarsasagAllamformak.contains(o.allamforma)){
                    nemKoztarsasagAllamformak.add(o.allamforma);
                }
            }
            
        }
        
        System.out.println("A nem koztarsasagu orszagok szama:  " + nemKoztarsasagokSzama);
        System.out.println("A nem koztarsasagu allamformak:  ");
        for(String allamforma : nemKoztarsasagAllamformak){
            System.out.println(allamforma);
        }
        
        
        
        
        
        
    }

    private static void fFeladat() {
        
        System.out.println("\nF feladat \n");
        
        int osszesTerulet = 0;
        int osszesLakos = 0;
        for(Orszag o : orszagokLista){
            
            osszesTerulet += o.terulet;
            osszesLakos += o.ezerLakos;
            
            
            
        }
        
        System.out.println("Az orszagok osszes terulete: "+ osszesTerulet);
        System.out.println("Az orszagok osszes lakossaga: "+ osszesLakos + " Ezer fo");
        
        
        
    }

    private static void gFeladat() {
        System.out.println("\nG feladat \n");
        
        Pair<String,Integer> legkisebbTeruletuOrszag = new Pair<>("hiba",Integer.MAX_VALUE);
        
        for(Orszag o : orszagokLista){
            
            if (legkisebbTeruletuOrszag.getValue() > o.terulet) {
                legkisebbTeruletuOrszag = new Pair<> (o.nev,o.terulet);
            }
            
        }
        
        System.out.println("A legkisebb teruletu orszag neve : " + legkisebbTeruletuOrszag.getKey());
        
        
    }

    private static void hFeladat() {
        System.out.println("\nH feladat \n");
        
        for(Orszag o : orszagokLista){
            
            if (o.foldresz.contains("Afrika")) {
                System.out.println("Orszag neve : "+o.nev + "\t Nepsuruseg: " + (o.ezerLakos*1000/o.terulet) + " fo/km2");
                
            }
            
        }
        
        
    }
    
    
    
}
