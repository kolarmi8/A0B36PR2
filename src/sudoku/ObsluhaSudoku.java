/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.event.DocumentEvent;


/**
 *
 * @author Michal
 */
public class ObsluhaSudoku implements javax.swing.event.DocumentListener, java.awt.event.MouseListener, java.awt.event.ActionListener, java.awt.event.ItemListener{
    
    JNumberTextField plocha[][]=new JNumberTextField[9][9];
    JLabel display;
    Generovanie gen;
    Kontrola kon;
    boolean zobrazPolia=false;
    boolean kontrolujPolia=false;
    boolean najdiCislo=false;
    int obtiaznost;
    int i;
    int j;
    Color farbaVyberu;
    
    
    public ObsluhaSudoku(JNumberTextField plocha[][]) {
        
        this.plocha=plocha;
    }

    public void setDisplay(JLabel display) {
        this.display = display;
    }


    
    @Override
    public void insertUpdate(DocumentEvent de) {
        if(kontrolujPolia==true){
        kon = new Kontrola(i,j,plocha);
        if(kon.getVysledek()==true)
            plocha[i][j].setBackground(Color.BLUE);         // cislo splna pravidla sudoku
        else
            plocha[i][j].setBackground(Color.RED);          // cislo nesplna pravidla sudoku
        }
        System.out.println("insert");
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        System.out.println("remove");
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        System.out.println("changed");
    }

    
    
    
    
    @Override
    public void mouseClicked(MouseEvent me) {
        if(kontrolujPolia==true) 
            if(plocha[i][j].getBackground()!=Color.GREEN) plocha[i][j].setBackground(Color.WHITE);  // vymaze farbu minuleho pola
        
        this.i=Character.getNumericValue(me.getSource().toString().charAt(0)) ;
        this.j=Character.getNumericValue(me.getSource().toString().charAt(1)) ;
        
        if(plocha[i][j].isEditable()==true) plocha[i][j].selectAll();               //oznaci cisla ktore je mozne prepisovat
        
        if(kontrolujPolia==true){
            if(plocha[i][j].isEditable()==true){ 
            plocha[i][j].selectAll();   
            plocha[i][j].setBackground(Color.CYAN);  // prepisovatelne pole
            }
            else plocha[i][j].setBackground(Color.MAGENTA);  // pole sa neda prepisat
            
        }
        if(najdiCislo==true){
            try{
            this.display.setText(""+gen.getCelePole(i, j));    // zobrazi cislo ktore patri do daneho stvorceka
            }
            catch(NullPointerException e){
            System.out.println("Pole nieje vygenerovane");
            }
        }
                
        System.out.println("click");
    }

    @Override
    public void mousePressed(MouseEvent me) {
        System.out.println("pressed");
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
        System.out.println("released");
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if(zobrazPolia==true){
        
        this.i=Character.getNumericValue(me.getSource().toString().charAt(0)) ;
        this.j=Character.getNumericValue(me.getSource().toString().charAt(1)) ;
        for (int s = 0; s < 9; s++) {
            plocha[s][j].setBackground(Color.GREEN);
        }
        for (int r = 0; r < 9; r++) {
            plocha[i][r].setBackground(Color.GREEN);
        }
       
        if (i >= 6) i = 6;
        else if (i < 3) i = 0;
        else i = 3;
        
        if (j >= 6) j = 6;
        else if (j < 3) j = 0;
        else j = 3;
        for (int s = i; s < 3 + i; s++) {
            for (int r = j; r < 3 + j; r++) {
                plocha[s][r].setBackground(Color.GREEN);
            }
        }
        } 
        
        System.out.println("enter");
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
        if(zobrazPolia==true){
        this.i=Character.getNumericValue(me.getSource().toString().charAt(0)) ;
        this.j=Character.getNumericValue(me.getSource().toString().charAt(1)) ;
        for (int k = 0; k < 9; k++) {
            plocha[i][k].setBackground(Color.WHITE);
        }
        for (int k = 0; k < 9; k++) {
            plocha[k][j].setBackground(Color.WHITE);
        }
        
        if (i >= 6) i = 6;
        else if (i < 3) i = 0;
        else i = 3;
        
        if (j >= 6) j = 6;
        else if (j < 3) j = 0;
        else j = 3;
        for (int s = i; s < 3 + i; s++) {
            for (int r = j; r < 3 + j; r++) {
                plocha[s][r].setBackground(Color.WHITE);
            }
        }
        }
        System.out.println("exited");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().matches("Lahke")) this.obtiaznost = 40;
        if(ae.getActionCommand().matches("Stredne")) this.obtiaznost = 30;
        if(ae.getActionCommand().matches("Tazke")) this.obtiaznost = 20;
        
        if(ae.getActionCommand().matches("Lahke")||ae.getActionCommand().matches("Stredne")||ae.getActionCommand().matches("Tazke")){
            gen= new Generovanie(obtiaznost);
            for (int s = 0; s < 9; s++) {
                for (int r = 0; r < 9; r++) {
                    plocha[r][s].setText("0");
                    plocha[r][s].setEditable(true);
                     if(gen.getHodnota(r,s)<0){
                        plocha[r][s].setText(""+Math.abs(gen.getHodnota(r,s)));
                        plocha[r][s].setEditable(false);
                    }
                }
            }      
        } 
        
        if(ae.getActionCommand().matches("Vyriesit")){
            try{
             for (int s = 0; s < 9; s++) {
                for (int r = 0; r < 9; r++) {                  
                        plocha[r][s].setText(""+gen.getCelePole(r, s));      
                    }
                }
            }
            catch(NullPointerException e){
            //display.setText("Pole nieje vygenerovane");
            System.out.println("Pole nieje vygenerovane");
            }
        }       
        if(ae.getActionCommand().matches("Koniec")) System.exit(0);    
        
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        
        if(ie.paramString().contains("Zobrazit polia")){
            if(ie.getStateChange()==1) this.zobrazPolia=true;
            if(ie.getStateChange()==2) this.zobrazPolia=false;
            }
        if(ie.paramString().contains("Kontrolovat polia")){
            if(ie.getStateChange()==1) this.kontrolujPolia=true;
            if(ie.getStateChange()==2) this.kontrolujPolia=false;
            }
       
        if(ie.paramString().contains("Najst cislo")){
            if(ie.getStateChange()==1) this.najdiCislo=true;
            if(ie.getStateChange()==2) this.najdiCislo=false;
            }
        
        }
    
    
}
