package sudoku;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michal
 */
public class Okno extends JFrame{
    JLabel display;
    int obtiaznost =40;
    JNumberTextField plocha[][];
    ObsluhaSudoku oS;
    
    public Okno() throws HeadlessException {
        
        super();
        this.setBounds(100,100,500,500);
        this.setTitle("Sudoku");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.yellow);
        this.setLayout(new GridBagLayout());
        
        plocha = new JNumberTextField[9][9];
        
        ObsluhaSudoku oS = new ObsluhaSudoku(plocha);
        Generovanie gen= new Generovanie(obtiaznost);
       
        
        
        
    for(int i= 0; i < 9; i++) {
        for(int j = 0; j < 9; j++) {
            
            
            plocha[i][j] = new JNumberTextField();    
            plocha[i][j].setDocument(new JNumberTextFieldLimit(1));       
            plocha[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
            plocha[i][j].setForeground(Color.BLACK);
            plocha[i][j].setBackground(Color.WHITE);
            plocha[i][j].setHorizontalAlignment(JTextField.CENTER);
            plocha[i][j].setLocation(i, j);

            this.add(plocha[i][j],new GridBagConstraints(i, j, 1, 1, 1d, 1d, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0,0,0,0), 0, 0)) ;   
            
            //vygenerovane cisla su zaporne
            /*if(gen.getHodnota(i,j)<0){
            plocha[i][j].setText(""+Math.abs(gen.getHodnota(i,j)));
            plocha[i][j].setEditable(false);
            }
            */
            plocha[i][j].addMouseListener(oS);
            
            plocha[i][j].getDocument().addDocumentListener(oS);
            plocha[i][j].setPoloha(i, j);
        }
    }
        
        
    }

    

  
}