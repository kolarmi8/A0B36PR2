/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Michal
 */
public class Credits {
    
    
    public static boolean Check(int[][] pole){
        boolean ret = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9 ; j++) {

                if (pole[i][j] == 0) {      // pokial niesu vsetky polia zaplnene
                    ret = false; break;
                }                
            }
            if(ret == false) break;
        }
        if (ret == false) return false;
        else return true;
    
    }
    
    public static void Credits(){
        System.out.println();
        System.out.println(" Y   Y  OOO  U   U   W     W III N   N ");
        System.out.println("  Y Y  O   O U   U   W     W  I  NN  N ");
        System.out.println("   Y   O   O U   U   W  W  W  I  N N N ");
        System.out.println("   Y   O   O U   U    W W W   I  N  NN ");
        System.out.println("   Y    OOO   UUU      W W   III N   N ");
    }
    
}
