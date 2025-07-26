
package Login;

import General.ControllerMenuDoctor;
import General.MenuDoctor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControllerLoginDoctor implements ActionListener{
   
    
   private LoginDoctor logindoctor;

    public ControllerLoginDoctor(LoginDoctor logindoctor) {
        this.logindoctor = logindoctor;
        
        
        logindoctor.BtnEnter.addActionListener(this);
        logindoctor.BtnExit.addActionListener(this);

    }
   
   
    
    
    
      
    
    
    
    
    @Override
    public void actionPerformed (ActionEvent e) {
    
        if (e.getSource() == logindoctor.BtnEnter) {
        
        MenuDoctor menu = new MenuDoctor();
        ControllerMenuDoctor controllermenudoctor = new ControllerMenuDoctor(menu);
             
        menu.setVisible(true);
        logindoctor.dispose();
             
        
        
        } else if (e.getSource() == logindoctor.BtnExit) {
        Home home = new Home();
        home.setVisible(true);
        logindoctor.dispose();
                
        
        
        }
    
    
    }
    
    
}
