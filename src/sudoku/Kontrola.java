/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Michal
 */
public class Kontrola {
    int radek;
    int sloupec;
    int[][] pole;
    JNumberTextField[][] plocha;

    public Kontrola() {
       
    }
    
    
    
    public Kontrola(int radek, int sloupec, JNumberTextField[][] plocha) {
        pole=new int[9][9];
        this.radek = radek;
        this.sloupec = sloupec;
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (plocha[i][j].getText().isEmpty())
                    this.pole[i][j]=0;
                else
                    this.pole[i][j] = Integer.decode(plocha[i][j].getText());
            }
        }
        
        
    }

    public Kontrola(int radek, int sloupec, int[][] pole) {
        this.radek = radek;
        this.sloupec = sloupec;
        this.pole = pole;
        
    }
    public boolean getVysledek() {
         if(KontrolujRadek()==false || KontrolujSloupec()==false || KontrolujCtverec()==false ){
                return false;  // ked aspon jedna metoda je false
            }
                return true; 
    }
    
    public void setKontrola(int radek, int sloupec, int[][] pole) {
        this.radek = radek;
        this.sloupec = sloupec;
        this.pole = pole;
    }
    
    public int getRadek() {
        return radek;
    }

    public void setRadek(int radek) {
        this.radek = radek;
    }

    public int getSloupec() {
        return sloupec;
    }

    public void setSloupec(int sloupec) {
        this.sloupec = sloupec;
    }

    public int[][] getPole() {
        return pole;
    }

    public void setPole(int[][] pole) {
        this.pole = pole;
    }
    
     
    boolean KontrolujRadek() {
        Map<Integer, Integer> mapa = new HashMap<Integer, Integer>();
        int ret = 1;
        for (int i = 0; i < 9; i++) {
            if (pole[radek][i] == 0) {
                continue;
            }
            if (!mapa.containsKey(Math.abs(pole[radek][i]))) {
                mapa.put(Math.abs(pole[radek][i]), 1);       // ak mapa neobsahuje cislo tak ho zapise
            } else {
                ret = 0;
                break;

            }

        }
        if (ret == 0) {
            return false;
        } else {
            return true;
        }
    }

    boolean KontrolujSloupec() {
        Map<Integer, Integer> mapa = new HashMap<Integer, Integer>();
        int ret = 1;
        for (int i = 0; i < 9; i++) {
            if (pole[i][sloupec] == 0) {
                continue;
            }
            if (!mapa.containsKey(Math.abs(pole[i][sloupec]))) {
                mapa.put(Math.abs(pole[i][sloupec]), 1);           // ak mapa neobsahuje cislo tak ho zapise

            } else {
                ret = 0;
                break;

            }

        }
        if (ret == 0) {
            return false;
        } else {
            return true;
        }
    }

    boolean KontrolujCtverec() {
        Map<Integer, Integer> mapa = new HashMap<Integer, Integer>();
        int a, b;
        if (radek >= 6) {
            a = 6;
        } 
        else if (radek < 3) {
            a = 0;
        }
        else {
            a = 3;
        }

        if (sloupec >= 6) {
            b = 6;
        } 
        else if (sloupec < 3) {
            b = 0;
        }
        else {
            b = 3;
        }
        int ret = 1;

        for (int i = a; i < 3 + a; i++) {
            for (int j = b; j < 3 + b; j++) {

                if (pole[i][j] == 0) {
                    continue;
                }
                if (!mapa.containsKey(Math.abs(pole[i][j]))) {  
                    mapa.put(Math.abs(pole[i][j]), 1);           // ak mapa neobsahuje cislo tak ho zapise
                } else {
                    ret = 0;
                    break;

                }
            }
        }
        if (ret == 0) {
            return false;
        } else {
            return true;
        }

    }

    
}