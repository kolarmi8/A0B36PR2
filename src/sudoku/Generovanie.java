
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
        this.pole = new int[9][9];        
    }

    public int[][] getPole() {
        return pole;
    }

    public void setPole(int[][] pole) {
        this.pole = pole;
    }
    public void setCelePole(int[][] cPole) {
        this.celePole=new int[9][9];
        for (int r = 0; r < 9; r++) {
            for (int s = 0; s < 9; s++) {
               if(cPole[r][s]<-10) {
                    this.celePole[r][s]=cPole[r][s]+10;
                }              
               else {
                    this.celePole[r][s]=cPole[r][s];
                }            
                
            }
        }
    }

    public int getObtiaznost() {
        return obtiaznost;
    }

    public void setObtiaznost(int obtiaznost) {
        this.obtiaznost = obtiaznost;
    }
    public void setHodnota(int i,int j,int hodnota) {
        this.pole[i][j]=hodnota;                        
    }
    public int getHodnota(int i,int j) {
        return pole[i][j];
    }
    public int[][] getCelePole() {
        return celePole;
    }
    public int getCelePole(int i, int j) {
        return Math.abs(celePole[i][j]);
    }
    
    /*
     * Vygeneruje nahodne nuly (diery) podla obtiaznosti, cim viac dier tym je sudoku tazsie,
     * Diery su generovane zrkadlovo cez stred hracieho pola
     */
    public void generuj(){
        
        
        Random rd = new Random();
        
        for (int i = 0; i < ((81-obtiaznost)/2); i++) {     

            int radek = rd.nextInt(9);
            int sloupec = rd.nextInt(9);
        
            if (pole[radek][sloupec] != 0) {                
                pole[radek][sloupec] = 0;                   
                pole[(8-radek)][(8-sloupec)] = 0;           
            } else {
                i--;
                continue;
            
        }
    
    }
        
    }
    /*
     * Funkcia vygeneruje nahodne plne pole sudoku podla pravidiel sudoku
     * Vsetky hodnoty su so znamienkom minus
     * Nakoniec sa pole prekopiruje do pola celePole
     */
    public void generujCelePole(){
        
    this.celePole=null;
    int x=0;
    
    
    Random rd = new Random();
        for (int r = 0; r < 9; r++) {
            for (int s = 0; s < 9; s++) {

            this.pole[r][s] = -(rd.nextInt(9) + 1);     
            kon=new Kontrola(r,s,pole);
            x=0;
             while(kon.getVysledek()==false){
             this.pole[r][s] = -(rd.nextInt(9) + 1);             
                 
             x++;
                 if(x==25&&r>=1){
                     for (s = 0; s < 9; s++) {
                         this.pole[r][s] = 0;                    
                         
                     }
                     s=0;
                     r--;                                   
                     break;}
             }
             
        }
        
    }
       
        this.celePole=new int[9][9];
        for (int r = 0; r < 9; r++) {
            for (int s = 0; s < 9; s++) {
        this.celePole[r][s]=pole[r][s];
            }
        }
    }
}
    
    