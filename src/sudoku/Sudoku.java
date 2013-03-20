/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.*;

/**
 *
 * @author Michal
 */
public class Sudoku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here







        int pole[][] = new int[9][9];
        
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Chcete spustit novu hru?");
            String scan = sc.next() ;
            if ("ano".equals(scan)) {
                Vstup.NovaHra(pole);  // vygeneruje novu hru
                break;
            } 
            
            else if ("nie".equals(scan)) {
                System.out.println("Chcete nacitat ulozenu hru?");
                scan = sc.next() ;
                if ("ano".equals(scan)) {
                    Vstup.citaj(pole); // nacita ulozenu hru
                    break;
                }
                
                else if ("nie".equals(scan)) {
                    System.out.println("Chcete hru ukoncit?");
                    scan = sc.next() ;
                    if ("ano".equals(scan)) {                       
                        System.exit(0); // ukonci program
                        
                    } 
                    
                    else if ("nie".equals(scan)) {
                        continue; // vrati na zaciatok
                    } else {
                        System.out.println("chybny vstup");
                    }
                } 
                
                else {
                    System.out.println("chybny vstup");
                }
            } else {
                System.out.println("chybny vstup");
            }
        }
        
        Vstup.Vpisuj(pole);
        while(true){
        
        
        
        System.out.println("Chcete hru ulozit?");
        String scan = sc.next() ;
                    if ("ano".equals(scan)) {  // ulozi hru
                        Vystup.uloz(pole);
                        System.out.println("Hra bola ulozena.");
                        System.out.println("Chcete v hre pokracovat?");
                        scan = sc.next() ;
                        if ("ano".equals(scan)) {
                            Vstup.Vpisuj(pole);         // vypise pole                   
                            continue;
                        }
                        else if ("nie".equals(scan)) break;  // koniec
                        else System.out.println("chybny vstup");
                    } 
                    
                    else if ("nie".equals(scan)) {
                        System.out.println("Chcete hru ukoncit?");
                        scan = sc.next() ;
                        if ("ano".equals(scan)) break;  // ukonci hru
                        else if ("nie".equals(scan)) {
                            Vstup.Vpisuj(pole);         // vypise pole
                            continue;                       } 
                        else System.out.println("chybny vstup");
                    }
                    
                    else {System.out.println("chybny vstup");}
        }
        
        
        
    }
}
