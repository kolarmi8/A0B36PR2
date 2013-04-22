/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author Michal
 */
public class NacitajHru {
    int[][] pole=new int[9][9];
    public NacitajHru() {
    }
    
    public void setPole(int[][] pole) {
        this.pole = pole;
    }

    public int[][] getPole() {
        return pole;
    }
    public int getPole(int r, int s) {
        return (pole[r][s]);
    }
    
    public void citaj(){ 
    try {
            FileInputStream fis = new FileInputStream("sudoku.bin");
            
            for (int r = 0; r < 9; r++) {
                 for (int s = 0; s < 9; s++) {
                     
             
             if((pole[r][s]=fis.read())>10) this.pole[r][s] = -(256-pole[r][s]); // pre zaporne cisla
             else this.pole [r][s] = pole[r][s]; 
                 }
            }
            
            //System.out.println("nacitane");
        fis.close();
        } catch (IOException e) {
            //System.out.println("Soubor sa nenasiel.");
            
        }
    }
}
