
package Appointment;

import Home.ControllerHome;
import Home.Home;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;






public class ControllerPanelAppointmentPatient implements ActionListener{
    
    
private PanelAppointmentPatient panelappointmentpatient;    
private String id = "";



    public ControllerPanelAppointmentPatient(PanelAppointmentPatient panelappointmentpatient, String id) {
        this.panelappointmentpatient = panelappointmentpatient;
        this.id = id;
        
    }




    
    
    
    
    
    
    
@Override
public void actionPerformed (ActionEvent e) {


    if(e.getSource() == panelappointmentpatient.BtnAdd) {
    
    
        
        
        
    } else if (e.getSource() == panelappointmentpatient.BtnOut) {
    Home home = new Home();
    ControllerHome controllerhome = new ControllerHome(home);
    home.setVisible(true);
    
    }



}





    
}
