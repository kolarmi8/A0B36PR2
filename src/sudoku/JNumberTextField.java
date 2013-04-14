/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Michal
 */
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;



public class JNumberTextField extends JTextField {
    int i;
    int j;
    
    public JNumberTextField() {
        super();
    }

    public JNumberTextField(String string) {
        super(string);
    }

    public JNumberTextField(int i) {
        super(""+i);
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public void setPoloha(int i, int j) {
        this.i = i;
        this.j = j;
    }

    
    
    @Override
    public String toString() {
        
        return ""+i+""+j;
    }

    
    
	
}
class JNumberTextFieldLimit extends PlainDocument {
  private int limit;

  JNumberTextFieldLimit(int limit) {
   super();
   this.limit = limit;
   }

  public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
    if (str == null||str.contains("0")) return;

    if ((getLength() + str.length()) <= limit) {
        if(Character.isDigit(str.charAt(0)) )
      super.insertString(offset, str, attr);
    }
  }
}