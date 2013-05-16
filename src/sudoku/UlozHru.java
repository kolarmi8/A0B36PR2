/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Michal
 */
public class UlozHru {
    int[][] pole=new int[9][9];
    int[][] celePole=new int[9][9];
    public UlozHru() {
    }

    public void setPole(int[][] pole) {
        this.pole = pole;
    }
    public void setCelePole(int[][] celePole) {
        this.celePole = celePole;
    }
    /*
     * Metoda uklada jednotlive polia, tie ktore su prepisovatelne ostanu prepisovatelne, 
     * neprepisovatelne dostanu zapornu hodnotu
     * Polia ktore boli vygenerovane ale neskor sa stali dierami, su zapisane zaporne -10
     */
    public void uloz(){
    
        if(pole!=null) {
            try {
                    FileOutputStream fos = new FileOutputStream("sudoku.bin");
                    
                    for (int r = 0; r < 9; r++) {
                         for (int s = 0; s < 9; s++) {
                             celePole[r][s]=(celePole[r][s]-10);
                                if(pole[r][s]!=0) {
                                 celePole[r][s]=pole[r][s];
                             }
                             fos.write(celePole[r][s]);            
                         }
                    }
                fos.close();
                } catch (IOException e) {
                    
                }
        }
    }
     
}