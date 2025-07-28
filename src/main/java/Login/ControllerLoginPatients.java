
package Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ControllerLoginPatients implements ActionListener{
    
    
  private LoginPatient loginpatient;

    public ControllerLoginPatients(LoginPatient loginpatient) {
        this.loginpatient = loginpatient;
        
       this.loginpatient.BtnLogIn.addActionListener(this);
       this.loginpatient.BtnLogOut.addActionListener(this);
       
       
       
       
        this.loginpatient.LblRegister.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
        Register register = new Register();
        ControllerRegisterPatients controllerloginpatients = new ControllerRegisterPatients(register);
        register.setVisible(true);
        loginpatient.dispose();
        }
         });
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void actionPerformed (ActionEvent e) {
    
    
     if (e.getSource() == loginpatient.BtnLogIn) {
    
    
        
    
    
    
    
    } else if (e.getSource() == loginpatient.BtnLogOut) {
    Home home = new Home();
    ControllerHome controllerhome = new ControllerHome(home);
    home.setVisible(true);
    loginpatient.dispose();
    
    
    
    
    }
    
    
    }
    
    
    
    
    
}
