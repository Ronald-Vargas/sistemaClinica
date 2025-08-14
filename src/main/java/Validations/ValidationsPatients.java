
package Validations;

import Register.Register;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class ValidationsPatients {

private Register register;

    public ValidationsPatients(Register register) {
        this.register = register;
        validationsRegister();
    }




  public void validationsRegister() {
  
  
  KeyAdapter validateId = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || register.TxtId.getText().length() >= 9) {
                    e.consume();
                }
            }
        };
    
    
    
    KeyAdapter validateName = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ' || register.TxtName.getText().length() >= 15) {
                    e.consume();
                }
            }
        };
  
  
  
   KeyAdapter validateEmail = new KeyAdapter() {
       public void keyTyped(KeyEvent e) {
       char c = e.getKeyChar();
        String symbols = "!@#$%&*.,-_ ";

        if (!(Character.isLetterOrDigit(c) || symbols.indexOf(c) >= 0) || register.TxtEmail.getText().length() >= 100) {
            e.consume();
        }
  }
        };
     
  
  
  
  KeyAdapter validatePass = new KeyAdapter() {
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        String symbols = "!@#$%&*.,-_ ";

        if (!(Character.isLetterOrDigit(c) || symbols.indexOf(c) >= 0) || register.TxtPass.getText().length() >= 250) {
            e.consume();
        }
    }
};
  
  
  register.TxtId.addKeyListener(validateId);
  register.TxtName.addKeyListener(validateName);
  register.TxtEmail.addKeyListener(validateEmail);
  register.TxtPass.addKeyListener(validatePass);
  
  
  
  
  }  
    
    
}
