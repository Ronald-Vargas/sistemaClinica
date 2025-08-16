
package Validations;
import Patients.PanelPatients;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ValidationsPatientUpdate {
    
    private PanelPatients panelpatients;

    public ValidationsPatientUpdate(PanelPatients panelpatients) {
        this.panelpatients = panelpatients;
        ValidationsPatients();
    }
    
    public void ValidationsPatients (){
    
        KeyAdapter validateName = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ' || panelpatients.TxtName.getText().length() >= 15) {
                    e.consume();
                }
            } 
        };
    
        KeyAdapter validateLastNameF = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ' || panelpatients.TxtLastNameF.getText().length() >= 15) {
                    e.consume();
                }
            } 
        };
        KeyAdapter validateLastNameM = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ' || panelpatients.TxtLastNameM.getText().length() >= 15) {
                    e.consume();
                }
            }
        };
       
          
        KeyAdapter validatepPhone = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || panelpatients.TxtPhone.getText().length() >= 8) {
                    e.consume();
                }
            }
        };          
          
        KeyAdapter validateEmail = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = panelpatients.TxtEmail.getText();
                if (!(Character.isLetterOrDigit(c) || c == '@' || c == '.' || c == '_' || c == '-') 
                    || text.length() >= 50) {
                    e.consume(); 
                }
            }
        };               
          
          KeyAdapter validateAge = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || panelpatients.TxtAge.getText().length() >= 2) {
                    e.consume();
                }
            }
        };             
          
        KeyAdapter validateSex = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ' || panelpatients.TxtSex.getText().length() >= 9) {
                    e.consume();
                }
            }
        };      
                    
        KeyAdapter validateResponsable = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ' || panelpatients.TxtResponsable.getText().length() >= 15) {
                    e.consume();
                }
            } 
        };            
          
          
          
          
        panelpatients.TxtName.addKeyListener(validateName);
        panelpatients.TxtLastNameF.addKeyListener(validateLastNameF);
        panelpatients.TxtLastNameM.addKeyListener(validateLastNameM);
        panelpatients.TxtPhone.addKeyListener(validatepPhone);
        panelpatients.TxtEmail.addKeyListener(validateEmail);
        panelpatients.TxtAge.addKeyListener(validateAge);
        panelpatients.TxtSex.addKeyListener(validateSex);
        panelpatients.TxtResponsable.addKeyListener(validateResponsable);
          
          
    }
    
    
}
