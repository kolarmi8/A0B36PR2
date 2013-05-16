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
 * 
 * Objekt tejto triedy cita zo suboru cisla 
 * Ak bolo cislo zaporne(neprepisovatelne) tak sa musi odcitat od 256 
 * pretoze zaporne cisla typu int su takto ulozene, potom sa k nim da znamienko - aby boli zase neprepisovatelne
 * 
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
                     } 
                    else {
                         gen.pole[r][s] = gen.pole[r][s];
                     } 
                 }
            }          
        fis.close();
        } catch (IOException e) {          
            
        }
    }
}
