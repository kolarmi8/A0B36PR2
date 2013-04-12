/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author Michal
 */
public class ObsluhaSudoku implements PropertyChangeListener{
/*
    @Override
    public void inputMethodTextChanged(InputMethodEvent ime) {
        System.out.println("zmena");
    }

    @Override
    public void caretPositionChanged(InputMethodEvent ime) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
*/
    

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        System.out.println("yes");
    }
    
}
