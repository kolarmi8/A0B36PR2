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
public class ObsluhaSudoku implements javax.swing.event.DocumentListener, java.awt.event.MouseListener, java.awt.event.ActionListener, java.awt.event.ItemListener {

    JNumberTextField plocha[][] = new JNumberTextField[9][9];
    JLabel display;
    Generovanie gen = new Generovanie();
    Kontrola kon;
    UlozHru uH;
    NacitajHru nH;
    boolean zobrazPolia = false;
    boolean kontrolujPolia = false;
    boolean najdiCislo = false;
    int obtiaznost;
    int i;
    int j;

    public ObsluhaSudoku(JNumberTextField plocha[][]) {

        this.plocha = plocha;
    }

    public void setDisplay(JLabel display) {
        this.display = display;
    }

    @Override
    public void insertUpdate(DocumentEvent de) {

        try {
            gen.setHodnota(i, j, Integer.parseInt(plocha[i][j].getText()));      // hodnota je v poli
        } catch (NumberFormatException e) {
            
        }
        if (kontrolujPolia == true) {
            kon = new Kontrola(i, j, gen.getPole());
            if (kon.getVysledek() == true) {
                plocha[i][j].setBackground(Color.BLUE);
            } // cislo splna pravidla sudoku
            else {
                plocha[i][j].setBackground(Color.RED);
            }          // cislo nesplna pravidla sudoku
        }
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        gen.setHodnota(i, j, 0);
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (kontrolujPolia == true) {
            if (plocha[i][j].getBackground() != Color.GREEN) {
                plocha[i][j].setBackground(Color.WHITE);
            }
        }  // vymaze farbu minuleho pola

        this.i = Character.getNumericValue(me.getSource().toString().charAt(0));
        this.j = Character.getNumericValue(me.getSource().toString().charAt(1));

        if (plocha[i][j].isEditable() == true) {
            plocha[i][j].selectAll();
        }               //oznaci cisla ktore je mozne prepisovat

        if (kontrolujPolia == true) {
            if (plocha[i][j].isEditable() == true) {
                plocha[i][j].selectAll();
                plocha[i][j].setBackground(Color.CYAN);  // prepisovatelne pole
            } else {
                plocha[i][j].setBackground(Color.MAGENTA);
            }  // pole sa neda prepisat

        }
        if (najdiCislo == true) {
            try {
                this.display.setText("                                                                                   " + gen.getCelePole(i, j));    // zobrazi cislo ktore patri do daneho stvorceka
            } catch (NullPointerException e) {
                this.display.setText("                                                HRA nieje vytvorena!");
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (zobrazPolia == true) {

            this.i = Character.getNumericValue(me.getSource().toString().charAt(0));
            this.j = Character.getNumericValue(me.getSource().toString().charAt(1));
            for (int s = 0; s < 9; s++) {
                plocha[s][j].setBackground(Color.GREEN);
            }
            for (int r = 0; r < 9; r++) {
                plocha[i][r].setBackground(Color.GREEN);
            }

            if (i >= 6) {
                i = 6;
            } else if (i < 3) {
                i = 0;
            } else {
                i = 3;
            }

            if (j >= 6) {
                j = 6;
            } else if (j < 3) {
                j = 0;
            } else {
                j = 3;
            }
            for (int s = i; s < 3 + i; s++) {
                for (int r = j; r < 3 + j; r++) {
                    plocha[s][r].setBackground(Color.GREEN);
                }
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {

        if (zobrazPolia == true) {
            this.i = Character.getNumericValue(me.getSource().toString().charAt(0));
            this.j = Character.getNumericValue(me.getSource().toString().charAt(1));
            for (int k = 0; k < 9; k++) {
                plocha[i][k].setBackground(Color.WHITE);
            }
            for (int k = 0; k < 9; k++) {
                plocha[k][j].setBackground(Color.WHITE);
            }

            if (i >= 6) {
                i = 6;
            } else if (i < 3) {
                i = 0;
            } else {
                i = 3;
            }

            if (j >= 6) {
                j = 6;
            } else if (j < 3) {
                j = 0;
            } else {
                j = 3;
            }
            for (int s = i; s < 3 + i; s++) {
                for (int r = j; r < 3 + j; r++) {
                    plocha[s][r].setBackground(Color.WHITE);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().matches("Lahke")) {
            this.obtiaznost = 40;
        }
        if (ae.getActionCommand().matches("Stredne")) {
            this.obtiaznost = 30;
        }
        if (ae.getActionCommand().matches("Tazke")) {
            this.obtiaznost = 20;
        }

        if (ae.getActionCommand().matches("Lahke") || ae.getActionCommand().matches("Stredne") || ae.getActionCommand().matches("Tazke")) {
            gen = new Generovanie();
            gen.setObtiaznost(obtiaznost);
            gen.generujCelePole();          //vygeneruje cele pole sudoku
            gen.generuj();                  //vygeneruje prazne miesta v sudoku
            for (int s = 0; s < 9; s++) {
                for (int r = 0; r < 9; r++) {
                    plocha[r][s].setText("0");
                    plocha[r][s].setEditable(true);
                    if (gen.getHodnota(r, s) < 0) {
                        plocha[r][s].setText("" + Math.abs(gen.getHodnota(r, s)));    // vsetky zaporne cisla budu neprepisovatelne
                        plocha[r][s].setEditable(false);
                    }
                }
            }
            this.display.setText("                                                                                     ");
        }

        if (ae.getActionCommand().matches("Vyriesit")) {
            try {
                for (int s = 0; s < 9; s++) {
                    for (int r = 0; r < 9; r++) {
                        plocha[r][s].setText("" + gen.getCelePole(r, s));
                    }
                }
            } catch (NullPointerException e) {
                this.display.setText("                                                HRA nieje vytvorena!");
            }
        }
        if (ae.getActionCommand().matches("Ulozit")) {
            try {
                uH = new UlozHru();
                uH.setCelePole(gen.getCelePole());
                uH.setPole(gen.getPole());
                uH.uloz();
            } catch (NullPointerException e) {
                this.display.setText("                                                HRA nieje vytvorena!");
            }
        }

        if (ae.getActionCommand().matches("Nacitat")) {
            try {
                nH = new NacitajHru();
                nH.citaj();

                try {
                    for (int s = 0; s < 9; s++) {
                        for (int r = 0; r < 9; r++) {
                            if (nH.getPole(r, s) < 0 && nH.getPole(r, s) > -10) {
                                this.plocha[r][s].setText("" + Math.abs(nH.getPole(r, s))); // nacita zaporne cisla a da ich do absolutnej hodnoty
                                this.plocha[r][s].setEditable(false);                      // nastavi zaporne cisla zo zadania sudoku na needitovatelne
                            } else {
                                this.plocha[r][s].setText("" + nH.getPole(r, s));
                                this.plocha[r][s].setEditable(true);                    // nastavi cisla ktore uzivatel upravil na upravovatelne
                            }
                        }
                    }
                } catch (NullPointerException e) {
                    this.display.setText("                                                HRA nieje vytvorena!");
                }
                gen.setCelePole(nH.getPole());       
            } catch (NullPointerException e) {
                this.display.setText("                                                HRA nieje vytvorena!");
            }
        }

        if (ae.getActionCommand().matches("Koniec")) {
            System.exit(0);
        }

    }

    @Override
    public void itemStateChanged(ItemEvent ie) {

        if (ie.paramString().contains("Zobrazit polia")) {
            if (ie.getStateChange() == 1) {
                this.zobrazPolia = true;
            }
            if (ie.getStateChange() == 2) {
                this.zobrazPolia = false;
            }
        }
        if (ie.paramString().contains("Kontrolovat polia")) {
            if (ie.getStateChange() == 1) {
                this.kontrolujPolia = true;
            }
            if (ie.getStateChange() == 2) {
                this.kontrolujPolia = false;
            }
        }

        if (ie.paramString().contains("Najst cislo")) {
            if (ie.getStateChange() == 1) {
                this.najdiCislo = true;
            }
            if (ie.getStateChange() == 2) {
                this.najdiCislo = false;
            }
        }

    }
}
