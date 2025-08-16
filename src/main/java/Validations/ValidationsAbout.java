package Validations;
import About.PanelAbout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class ValidationsAbout {
    
    private PanelAbout panelabout;

    public ValidationsAbout(PanelAbout panelabout) {
        this.panelabout = panelabout;
        ValidationsAbout();
    }
    
    public void ValidationsAbout() {
    
          
    KeyAdapter validateName = new KeyAdapter() {
              public void keyTyped(KeyEvent e) {
                  char c = e.getKeyChar();
                  if (!Character.isLetter(c) && c != ' ' || panelabout.txtName.getText().length() >= 15) {
                      e.consume();
                  }
              }
          };
    
    KeyAdapter validateAddress = new KeyAdapter() {
              public void keyTyped(KeyEvent e) {
                  char c = e.getKeyChar();
                  if (!Character.isLetter(c) && c != ' ' || panelabout.txtAddress.getText().length() >= 100) {
                      e.consume();
                  }
              }
          };    
    
     KeyAdapter validatePhone = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || panelabout.txtPhone.getText().length() >= 8) {
                    e.consume();
                }
            }
        };   
    
        KeyAdapter validateEmail = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = panelabout.txtEmail.getText();
                if (!(Character.isLetterOrDigit(c) || c == '@' || c == '.' || c == '_' || c == '-') 
                    || text.length() >= 50) {
                    e.consume(); 
                }
            }
        };               
                
    
        panelabout.txtName.addKeyListener(validateName);
        panelabout.txtAddress.addKeyListener(validateAddress);
        panelabout.txtPhone.addKeyListener(validatePhone);
        panelabout.txtEmail.addKeyListener(validateEmail);

    
    
    
    }
    
    
    
    
    
}
