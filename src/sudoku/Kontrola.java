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
    
    
    static boolean Kontroluj(int radek, int sloupec, int[][] pole){
    
        if(KontrolujRadek(radek, pole)==false || KontrolujSloupec(sloupec, pole)==false || KontrolujCtverec(radek, sloupec, pole)==false ){
        return false;  // ked aspon jedna metoda je false
        }
        return true; 
        
    }
    static boolean KontrolujRadek(int radek, int[][] pole) {
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

    static boolean KontrolujSloupec(int sloupec, int[][] pole) {
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

    static boolean KontrolujCtverec(int radek, int sloupec, int[][] pole) {
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
