
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.Random;

/**
 *
 * @author Michal
 */
public class Generovanie {
    public static void Generuj(int[][] pole, int obtiaznost){
        
        Random rd = new Random();
        
        for (int i = 0; i < ((81-obtiaznost)/2); i++) {     // vsetky polia - obtiaznost 

            int radek = rd.nextInt(9);
            int sloupec = rd.nextInt(9);
               
            
                      
            if (pole[radek][sloupec] != 0) {                // ked uz nieje vymazany
                pole[radek][sloupec] = 0;                   // vymaze cislo v nahodnom riadku a stlpci
                pole[(8-radek)][(8-sloupec)] = 0;           // vymaze cislo v nahodnom riadku a stlpci zrkadlene
            } else {
                i--;
                continue;
            
        }
    
    }
    }
    
    public static void GenerujCelePole(int[][] pole){
        
    
    int x=0;
    Random rd = new Random();
        for (int r = 0; r < 9; r++) {
            for (int s = 0; s < 9; s++) {

            pole[r][s] = -(rd.nextInt(9) + 1);              // zapise nahodne zaporne cislo, aby ho uzivatel nemohol prepisovat
            x=0;
             while(Kontrola.Kontroluj(r, s, pole)==false){
             pole[r][s] = -(rd.nextInt(9) + 1);             // prepisuje cisla pokial nebude kontrola true
                 x++;
                 if(x==25&&r>=1){
                     for (s = 0; s < 9; s++) {
                         pole[r][s] = 0;                    // ak sa program zacykli, vymaze cely riadok 
                         
                     }
                     s=0;
                     r--;                                   // nastavi na 0 stlpec a vrati o jeden riadok
                     break;}
             }
             
        }
        
    }
    }
    
    
    }
    
    

