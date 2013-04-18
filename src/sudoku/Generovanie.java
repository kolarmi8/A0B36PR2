
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
public final class Generovanie {
    int[][] pole; 
    int[][] celePole;
    int obtiaznost;
    Kontrola kon;

    public Generovanie() {
    }
     
    public Generovanie(int obtiaznost) {
        this.pole = new int[9][9];
        this.obtiaznost = obtiaznost;
        //this.pole[1][1]=1;
        GenerujCelePole();
        Generuj();
    }

    public int[][] getPole() {
        return pole;
    }

    public void setPole(int[][] pole) {
        this.pole = pole;
    }

    public int getObtiaznost() {
        return obtiaznost;
    }

    public void setObtiaznost(int obtiaznost) {
        this.obtiaznost = obtiaznost;
    }
    
    public int getHodnota(int i,int j) {
        return pole[i][j];
    }
    public int getCelePole(int i, int j) {
        return Math.abs(celePole[i][j]);
    }
    
    
    public void Generuj(){
        
        
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
    
    public void GenerujCelePole(){
        
    this.celePole=null;
    int x=0;
    
    
    Random rd = new Random();
        for (int r = 0; r < 9; r++) {
            for (int s = 0; s < 9; s++) {

            this.pole[r][s] = -(rd.nextInt(9) + 1);     //zapor pre konzolu         // zapise nahodne zaporne cislo, aby ho uzivatel nemohol prepisovat
            kon=new Kontrola(r,s,pole);
            x=0;
             while(kon.getVysledek()==false){
             this.pole[r][s] = -(rd.nextInt(9) + 1);             // prepisuje cisla pokial nebude kontrola true
                 
             x++;
                 if(x==25&&r>=1){
                     for (s = 0; s < 9; s++) {
                         this.pole[r][s] = 0;                    // ak sa program zacykli, vymaze cely riadok 
                         
                     }
                     s=0;
                     r--;                                   // nastavi na 0 stlpec a vrati o jeden riadok
                     break;}
             }
             
        }
        
    }
        // prekopiruje do celehoPola
        this.celePole=new int[9][9];
        for (int r = 0; r < 9; r++) {
            for (int s = 0; s < 9; s++) {
        this.celePole[r][s]=pole[r][s];
            }
        }
        
    }
    
    
    }
    
    

