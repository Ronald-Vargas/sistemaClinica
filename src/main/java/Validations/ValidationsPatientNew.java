
package Validations;

import Patients.PanelPatientNew;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class ValidationsPatientNew {
   
    
  private PanelPatientNew panelpatientnew;

    public ValidationsPatientNew(PanelPatientNew panelpatientnew) {
        this.panelpatientnew = panelpatientnew;
        validationsPatientNew();
    }
  
  
    
    
  public void validationsPatientNew() {
  
      
      KeyAdapter validateId = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || panelpatientnew.TxtId.getText().length() >= 9) {
                    e.consume();
                }
            }
        }; 
      
      
      
     KeyAdapter validatePhone = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || panelpatientnew.TxtPhone.getText().length() >= 8) {
                    e.consume();
                }
            }
        }; 
      
      
  
  KeyAdapter validateLastNameF = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ' || panelpatientnew.TxtLastNameF.getText().length() >= 15) {
                    e.consume();
                }
            }
        };
  
  
  
  KeyAdapter validateLastNameM = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ' || panelpatientnew.TxtLastNameM.getText().length() >= 15) {
                    e.consume();
                }
            }
        };
  
  
  
  KeyAdapter validateResponsible = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ' || panelpatientnew.TxtResponsible.getText().length() >= 45) {
                    e.consume();
                }
            }
        };
  
  
  
  panelpatientnew.TxtId.addKeyListener(validateId);
  panelpatientnew.TxtPhone.addKeyListener(validatePhone);
  panelpatientnew.TxtLastNameF.addKeyListener(validateLastNameF);
  panelpatientnew.TxtLastNameM.addKeyListener(validateLastNameM);
  panelpatientnew.TxtResponsible.addKeyListener(validateResponsible);
  
  }
    
    
}
