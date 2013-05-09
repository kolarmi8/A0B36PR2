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
    Generovanie gen = new Generovanie();

    public NacitajHru() {
    }   
    public int[][] getPole() {
        return gen.pole;
    }
    public int getPole(int r, int s) {
        return gen.pole[r][s];
    }
    public void citaj(){ 
    try {
            FileInputStream fis = new FileInputStream("sudoku.bin");
            
            for (int r = 0; r < 9; r++) {
                 for (int s = 0; s < 9; s++) {
                    if((gen.pole[r][s]=fis.read())>10) {
                         gen.pole[r][s] = -(256-gen.pole[r][s]);
                     } // pre zaporne cisla
                    else {
                         gen.pole[r][s] = gen.pole[r][s];
                     } 
                 }
            }          
        fis.close();
        } catch (IOException e) {
            //System.out.println("Soubor sa nenasiel.");
            
        }
    }
}
