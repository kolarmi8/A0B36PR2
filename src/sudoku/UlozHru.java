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
       
    public void uloz(){
    
        if(pole!=null) {
            try {
                    FileOutputStream fos = new FileOutputStream("sudoku.bin");
                    
                    for (int r = 0; r < 9; r++) {
                         for (int s = 0; s < 9; s++) {
                             celePole[r][s]=(celePole[r][s]-10);//-10
                                if(pole[r][s]!=0) {
                                 celePole[r][s]=pole[r][s];
                             }
                             fos.write(celePole[r][s]);    // zapisuje postupne kazde pole          
                         }
                    }
                fos.close();
                } catch (IOException e) {
                    //System.out.println("Chyba");
                }
        }
    }
     
}