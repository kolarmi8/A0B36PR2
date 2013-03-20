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
public class Vystup {
     public static void Vypis(int[][] pole){       // vypis prvkov pola
        System.out.println("End║ 1 │ 2 │ 3 ║ 4 │ 5 │ 6 ║ 7 │ 8 │ 9 ║");
        System.out.println("===║══════════════════════════");
        for (int r = 0; r < 9; r++) {
            for (int s = 0; s < 9; s++) {

                if (s == 0) {
                    System.out.print(" "+(r + 1) + " ║ ");
                }
                

                if (pole[r][s] != 0) {
                    System.out.print(Math.abs(pole[r][s])); // vypise absolutnu hodnotu
                    if (s == 2 || s == 5 || s == 8)System.out.print(" ║ ");                    
                    else System.out.print(" │ ");            
                } else {                                    // ak je nula, vypise medzeru
                    if (s == 2 || s == 5 || s == 8)System.out.print("  ║ ");
                    else System.out.print("  │ ");
                    
                }
            }
            System.out.println();
            if (r == 2 || r == 5 || r == 8)System.out.println("===║══════════════════════════");
            else System.out.println("---║──────────────────────────");
            


        }
  
    }
     
    public static void uloz(int[][] pole){
    
    
    
    try {
            FileOutputStream fos = new FileOutputStream("output.bin");
            
            for (int r = 0; r < 9; r++) {
                 for (int s = 0; s < 9; s++) {
                     fos.write(pole[r][s]);    // zapisuje postupne kazde pole          
                 }
            }
        fos.close();
        } catch (IOException e) {
        }
    }
     
     
     
}
