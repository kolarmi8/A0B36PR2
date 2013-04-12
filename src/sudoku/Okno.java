package sudoku;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
    public Okno() throws HeadlessException {
        
        super();
        this.setBounds(100,100,500,500);
        this.setTitle("Sudoku");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.yellow);
        this.setLayout(new GridBagLayout());
        
        ObsluhaSudoku oS = new ObsluhaSudoku();
        
        JTextField board[][] = new JTextField[9][9];
    for(int i= 0; i < 9; i++) {

        for(int j = 0; j < 9; j++) {

            board[i][j] = new JTextField();
            board[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
            board[i][j].setForeground(Color.BLACK);
            board[i][j].setBackground(Color.WHITE);
            board[i][j].setHorizontalAlignment(JTextField.CENTER);
            
            //board[i][j].addInputMethodListener(oS);
           
            
            
            this.add(board[i][j],new GridBagConstraints(i, j, 1, 1, 1d, 1d, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0,0,0,0), 0, 0)) ;   
        }
    }
    }

  
}