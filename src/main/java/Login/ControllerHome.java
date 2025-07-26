
package Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControllerHome implements ActionListener{
   
  private Home home;

    public ControllerHome(Home home) {
        this.home = home;
        
        this.home.BtnPatients.addActionListener(this);
        this.home.BtnDoctors.addActionListener(this);
    }

  
    
    
    @Override
    public void actionPerformed (ActionEvent e) {
    
    if (e.getSource() == home.BtnPatients) {
    LoginPatient loginpatient = new LoginPatient();
    loginpatient.setVisible(true);
    home.dispose();
    
    
    } else if (e.getSource() == home.BtnDoctors) {
    LoginDoctor logindoctor = new LoginDoctor();
    ControllerLoginDoctor controllerlogindoctor = new ControllerLoginDoctor(logindoctor);
    logindoctor.setVisible(true);
    home.dispose();
    
    
    
    }
    
    
    
    }
    
    
    
    
}
