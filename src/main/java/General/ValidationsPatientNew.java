
package General;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class ValidationsPatientNew {
   
    
  private MenuPatientNew menupatientnew;

    public ValidationsPatientNew(MenuPatientNew menupatientnew) {
        this.menupatientnew = menupatientnew;
        validationsPatientNew();
    }
  
  
  public void validationsPatientNew() {
  
      
      KeyAdapter validateId = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || menupatientnew.TxtId.getText().length() >= 9) {
                    e.consume();
                }
            }
        }; 
      
      
      
     KeyAdapter validatePhone = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || menupatientnew.TxtPhone.getText().length() >= 8) {
                    e.consume();
                }
            }
        }; 
      
      
  
  KeyAdapter validateLastNameF = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ' || menupatientnew.TxtLastNameF.getText().length() >= 15) {
                    e.consume();
                }
            }
        };
  
  
  
  KeyAdapter validateLastNameM = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ' || menupatientnew.TxtLastNameM.getText().length() >= 15) {
                    e.consume();
                }
            }
        };
  
  
  
  KeyAdapter validateResponsible = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ' || menupatientnew.TxtResponsible.getText().length() >= 45) {
                    e.consume();
                }
            }
        };
  
  
  
  menupatientnew.TxtId.addKeyListener(validateId);
  menupatientnew.TxtPhone.addKeyListener(validatePhone);
  menupatientnew.TxtLastNameF.addKeyListener(validateLastNameF);
  menupatientnew.TxtLastNameM.addKeyListener(validateLastNameM);
  menupatientnew.TxtResponsible.addKeyListener(validateResponsible);
  
  }
    
    
}
