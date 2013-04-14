/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.event.DocumentEvent;


/**
 *
 * @author Michal
 */
public class ObsluhaSudoku implements javax.swing.event.DocumentListener,java.awt.event.MouseListener{
    
    JNumberTextField plocha[][]=new JNumberTextField[9][9];
    int i;
    int j;
    
    public ObsluhaSudoku(JNumberTextField plocha[][]) {
        
        this.plocha=plocha;
    }

    

    
    
    
    
    @Override
    public void insertUpdate(DocumentEvent de) {
        
        plocha[i][j].setBackground(Color.BLUE);
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
        this.i=Character.getNumericValue(me.getSource().toString().charAt(0)) ;
        this.j=Character.getNumericValue(me.getSource().toString().charAt(1)) ;
        plocha[i][j].setBackground(Color.RED);
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
        
        System.out.println(me.getSource().toString().charAt(0));
        System.out.println("enter");
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
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
        
        System.out.println("exited");
    }

    

    
    
}