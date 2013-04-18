package sudoku;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
    int obtiaznost =20;
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
        //Generovanie gen= new Generovanie(obtiaznost);
       
        
    for(int i= 0; i < 9; i++) {
        for(int j = 0; j < 9; j++) {
            
            
            plocha[i][j] = new JNumberTextField();    
            plocha[i][j].setDocument(new JNumberTextFieldLimit(1));       
            plocha[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
                if(i==0) plocha[i][j].setBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, Color.DARK_GRAY));
                if(j==0) plocha[i][j].setBorder(BorderFactory.createMatteBorder(3, 1, 1, 1, Color.DARK_GRAY));
                if(i==0&&j==0) plocha[i][j].setBorder(BorderFactory.createMatteBorder(3, 3, 1, 1, Color.DARK_GRAY));
                if(i==2||i==5||i==8) plocha[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 3, Color.DARK_GRAY));
                if(j==2||j==5||j==8) plocha[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 3, 1, Color.DARK_GRAY));
                if((j==2||j==5||j==8)&&(i==2||i==5||i==8)) plocha[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, Color.DARK_GRAY));
                if((j==2||j==5||j==8)&&i==0) plocha[i][j].setBorder(BorderFactory.createMatteBorder(1, 3, 3, 1, Color.DARK_GRAY));
                if(j==0&&(i==2||i==5||i==8)) plocha[i][j].setBorder(BorderFactory.createMatteBorder(3, 1, 1, 3, Color.DARK_GRAY));
            plocha[i][j].setForeground(Color.BLACK);
            plocha[i][j].setBackground(Color.WHITE);
            plocha[i][j].setHorizontalAlignment(JTextField.CENTER);

            this.add(plocha[i][j],new GridBagConstraints(i, (j+1), 1, 1, 1d, 1d, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0,0,0,0), 0, 0)) ;   
            
            //vygenerovane cisla su zaporne
            /*
            if(gen.getHodnota(i,j)<0){
            plocha[i][j].setText(""+Math.abs(gen.getHodnota(i,j)));
            plocha[i][j].setEditable(false);
            }
            */
            plocha[i][j].addMouseListener(oS);
            
            plocha[i][j].getDocument().addDocumentListener(oS);
            plocha[i][j].setPoloha(i, j);
        }
    }
    
    display = new JLabel();
    display.setHorizontalAlignment(JLabel.CENTER); 
    display.setText("0");
    //this.add(display,new GridBagConstraints(8, 0, 1, 1, 1d, 0.1d, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0,10,0,0), 0, 0));
    oS.setDisplay(display);
    

        JMenuBar menu = new JMenuBar();
        menu.setSize(20, 10);
        JMenu menuOkno = new JMenu("Okno");
            JMenuItem exit = new JMenuItem("Koniec");
            JMenuItem save = new JMenuItem("Ulozit");
            JMenuItem load = new JMenuItem("Nacitat");
            JMenu newGame = new JMenu("Nova hra");
                JMenuItem dificulty1 = new JMenuItem("Lahke");
                JMenuItem dificulty2 = new JMenuItem("Stredne");
                JMenuItem dificulty3 = new JMenuItem("Tazke");
                dificulty1.addActionListener(oS);
                dificulty2.addActionListener(oS);
                dificulty3.addActionListener(oS);
            load.addActionListener(oS);
            save.addActionListener(oS);
            exit.addActionListener(oS);
            newGame.add(dificulty1);
            newGame.add(dificulty2);
            newGame.add(dificulty3);
        menuOkno.add(newGame);
        menuOkno.add(load);    
        menuOkno.add(save);
        menuOkno.add(exit);
        menu.add(menuOkno);
        
        JMenu menuNastavenia = new JMenu("Nastavenia");
            JCheckBoxMenuItem cbMenuPolia = new JCheckBoxMenuItem("Zobrazit polia");
            cbMenuPolia.addItemListener(oS);
            JCheckBoxMenuItem cbMenuKontrola = new JCheckBoxMenuItem("Kontrolovat polia");
            cbMenuKontrola.addItemListener(oS);
            JCheckBoxMenuItem cbMenuCislo = new JCheckBoxMenuItem("Najst cislo");
            cbMenuCislo.addItemListener(oS);
            
        menuNastavenia.add(cbMenuPolia);
        menuNastavenia.add(cbMenuKontrola);
        menuNastavenia.add(cbMenuCislo);   
        menu.add(menuNastavenia);
            System.out.println(""+menu.getUIClassID());
            System.out.println(""+display.getUI());
            
            JMenuItem riesenie = new JMenuItem("Vyriesit");
            
            System.out.println(""+riesenie.getUI());
         //    riesenie.setUI(new MetalMenuItemUI(););
            riesenie.addActionListener(oS);
        menu.add(riesenie);
        menu.add(display);
        
            
        this.add(menu,new GridBagConstraints(0, 0, 9, 1, 1d, 0.1d, GridBagConstraints.WEST, GridBagConstraints.REMAINDER, new Insets(2,1,0,1), 1, 1));
        
        
        
    
    }
}