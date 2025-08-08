
package Validations;

import Doctors.PanelDoctors;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class ValidationsDoctors {
    
    
    private PanelDoctors paneldoctors;

    public ValidationsDoctors(PanelDoctors paneldoctors) {
        this.paneldoctors = paneldoctors;
        
        validationsDoctors();
    }
    
    
    
    public void validationsDoctors() {
    
    
    
    KeyAdapter validateId = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || paneldoctors.TxtId1.getText().length() >= 9) {
                    e.consume();
                }
            }
        }; 
      
      
      
     KeyAdapter validatePhone = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || paneldoctors.TxtPhone.getText().length() >= 8) {
                    e.consume();
                }
            }
        };
    
    
    
     KeyAdapter validateName = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ' || paneldoctors.TxtNombre.getText().length() >= 15) {
                    e.consume();
                }
            }
        };
     
     
     
     KeyAdapter validateLastNameF = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ' || paneldoctors.TxtLastName.getText().length() >= 20) {
                    e.consume();
                }
            }
        };
     
     
     
     
     KeyAdapter validateLastNameM = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ' || paneldoctors.TxtSecondLastname.getText().length() >= 20) {
                    e.consume();
                }
            }
        };
     
     
     
     
     KeyAdapter validateEmail = new KeyAdapter() {
       public void keyTyped(KeyEvent e) {
       char c = e.getKeyChar();
        String symbols = "!@#$%&*.,-_ ";

        if (!(Character.isLetterOrDigit(c) || symbols.indexOf(c) >= 0) || paneldoctors.Txtmail.getText().length() >= 100) {
            e.consume();
        }
  }
        };
     
     
     
     
     
     KeyAdapter validatePass = new KeyAdapter() {
           public void keyTyped(KeyEvent e) {
       char c = e.getKeyChar();
        String symbols = "!@#$%&*.,-_ ";

        if (!(Character.isLetterOrDigit(c) || symbols.indexOf(c) >= 0) || paneldoctors.TxtPass.getText().length() >= 100) {
            e.consume();
        }
  }
        };
     
    
    paneldoctors.TxtId1.addKeyListener(validateId);
    paneldoctors.TxtPhone.addKeyListener(validatePhone);
    paneldoctors.TxtNombre.addKeyListener(validateName);
    paneldoctors.TxtLastName.addKeyListener(validateLastNameF);
    paneldoctors.TxtSecondLastname.addKeyListener(validateLastNameM);
    paneldoctors.Txtmail.addKeyListener(validateEmail);
    paneldoctors.TxtPass.addKeyListener(validatePass);

    }
    
    
    
    
    
    
}
