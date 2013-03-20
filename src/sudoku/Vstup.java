/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Michal
 */
public class Vstup {
    static Scanner sc = new Scanner(System.in);
   
    public static void NovaHra(int[][] pole){
        
        
        System.out.println("Obtiaznost: 1 najtazsia, 2 stredna, 3 najlahsia ");
        System.out.print("Vyberte obtiaznost: ");
        int scan= sc.nextInt();
        int obtiaznost;
        switch(scan){
             case 1: obtiaznost = 17;
                break;
             case 2: obtiaznost = 29;
                break;
             case 3: obtiaznost = 39;
                break;
             
        default: obtiaznost = 39; System.out.println("Zla hodnota, obtiaznost sa nastavila na najlahsiu");
        }
        
        Generovanie.GenerujCelePole(pole);
         //   Vystup.Vypis(pole);
         //   System.out.println("");
        Generovanie.Generuj(pole, obtiaznost);
            //Vystup.zapis(pole);
            //Vystup.Vypis(pole);
            //Generovanie.Overuj(pole);
        
        
}
    
    public static void Vpisuj(int[][] pole){
    int err, i;
    
        do {
            Vystup.Vypis(pole);
            
            if(Credits.Check(pole)==true) {   // ak bude cele sudoku vyplnene
                Credits.Credits();          
                System.exit(0);
            } 
            
            
            System.out.println("zadajte suradnice a hodnotu: riadok stlpec cislo (1-9)");
            
            i = 0;
            int num[] = new int[3];
            err = 0;
            
           Scanner s = new Scanner(System.in);   // ak zadam viac cisel 
            
           while(i<3){
                
                if (s.hasNextInt()){
                int x = s.nextInt();
                    if (x > 9 || x < 0) {     // ked je vstup iny ako (0-9)
                        num[0]=1; 
                        num[1]=1;
                        err = 1; 
                        break;
                    }
                    num[i] = x;
                    i++;                
                }
                else {             // ak vstup nieje int       
                    num[0]=1; 
                    num[1]=1;
                    err = 1; 
                    break;
                }                
            }
            
   
            
            if (num[0] == 0 || num[1] == 0) {
                err = 2;
            }
            if (num[0] == 0 && num[1] == 0 && num[2] == 0) {
                err = 5;
            }

            if (err == 0) {
                int radek = num[0] - 1; 
                int stloupec = num[1] - 1; 
                int cislo = num[2];    
                int tmp;
                if (pole[radek][stloupec] >= 0) {  // zaporne cisla su v zadani programu
                    tmp = pole[radek][stloupec];                 
                    pole[radek][stloupec] = cislo;
                    if (Kontrola.Kontroluj(radek, stloupec, pole) == false) {
                        pole[radek][stloupec] = tmp;    // ked nesplnuje pravidla sudoku vrati povodne cislo
                        err = 4;
                    }
                    
                } else {
                    err = 3;
                }
            }


            switch (err) {
                case 1:
                    System.out.println("Zly vstup, zadajte cisla z intervalu (1-9), 0 - vymaze hodnotu, 0 0 0 - koniec hry");
                    break;
                case 2:
                    System.out.println("Zadali ste 0 stlpec alebo riadok, cislo 0 vymaze cislo na zadanej pozici");
                    break;
                case 3:
                    System.out.println("Nemozete prepisovat vopred zadane cisla");
                    break;
                case 4:
                    System.out.println("Cislo nevyhovuje pravidlam sudoku");
                    break;
                default:
                    continue;
            }

        } while (err != 5); // ked su tri nuly
    
    }
    
    
    public static void citaj(int[][] pole){
    
    
    
    
    try {
            FileInputStream fis = new FileInputStream("output.bin");
            
            for (int r = 0; r < 9; r++) {
                 for (int s = 0; s < 9; s++) {
                     
             
             if((pole[r][s]=fis.read())>10) pole[r][s] = -(256-pole[r][s]); // pre zaporne cisla
                 }
            }
        fis.close();
        } catch (IOException e) {
            System.out.println("Soubor sa nenasiel.");
            
        }
    }
    
    
}