
package Sistem;

import About.PanelAbout;
import Appointment.ControllerPanelAppointmentDoctors;
import Appointment.ModelPanelAppointmentDoctors;
import Record.PanelRecord;
import Doctors.ControllerDoctors;
import Doctors.ModelDoctors;
import Doctors.PanelDoctors;
import Login.LoginDoctor;
import Patients.PanelPatients;
import Appointment.PanelAppointmentDoctors;
import Login.ControllerLoginDoctor;
import Patients.ControllerPanelPatients;
import Patients.ModelPanelPatients;
import Validations.ValidationsDoctors;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControllerSistemDoctors implements ActionListener{
    
    
   private SistemDoctors menudoctor;

    public ControllerSistemDoctors(SistemDoctors menudoctor) {
        this.menudoctor = menudoctor;
        
        
        menudoctor.BtnBox.addActionListener(this);
        menudoctor.BtnQuotes.addActionListener(this);
        menudoctor.BtnPatients.addActionListener(this);
        menudoctor.BtnDoctors.addActionListener(this);
        menudoctor.BtnLogout.addActionListener(this);
        menudoctor.BtnAbout.addActionListener(this);
        
        initQuotes();

    }
    
    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed (ActionEvent e) {
    
    
    if (e.getSource() == menudoctor.BtnBox) {
    initBox();
    
    
    
    } else if (e.getSource() == menudoctor.BtnQuotes) {
    initQuotes();
    
    } else if (e.getSource() == menudoctor.BtnPatients) {
    initPatients();
    
    } else if (e.getSource() == menudoctor.BtnDoctors) {
    initDoctors();
    
    } else if (e.getSource() == menudoctor.BtnLogout) {
        LoginDoctor logindoctor = new LoginDoctor();
        ControllerLoginDoctor controllerlogindoctor = new ControllerLoginDoctor(logindoctor);
        logindoctor.setVisible(true);
        menudoctor.dispose();
        
    } else if (e.getSource() == menudoctor.BtnAbout) {
    initAbot();
    
    }
    
    
    
    
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
    public void initBox() {
    PanelRecord panelbox = new PanelRecord();
    panelbox.setSize(1020, 720);
    panelbox.setLocation(0,0);
  
    
    menudoctor.Content.removeAll();
    menudoctor.Content.add(panelbox, BorderLayout.CENTER);
    menudoctor.Content.revalidate();
    menudoctor.Content.repaint();

}
    
    
    
    
    
    public void initQuotes() {
    PanelAppointmentDoctors panelappointmentdoctors = new PanelAppointmentDoctors();
    panelappointmentdoctors.setSize(1020, 720);
    panelappointmentdoctors.setLocation(0,0);
  
    ModelPanelAppointmentDoctors modelpanelappointmentdoctors = new ModelPanelAppointmentDoctors();
    ControllerPanelAppointmentDoctors controllerpanelappointmentdoctors = new ControllerPanelAppointmentDoctors(modelpanelappointmentdoctors, panelappointmentdoctors);
    menudoctor.Content.removeAll();
    menudoctor.Content.add(panelappointmentdoctors, BorderLayout.CENTER);
    menudoctor.Content.revalidate();
    menudoctor.Content.repaint();

}
    
    
    
  public void initPatients() {
    PanelPatients panelpatients = new PanelPatients();
    ModelPanelPatients modelpanelpatients = new ModelPanelPatients();
    ControllerPanelPatients controllerpanelpatients = new ControllerPanelPatients(panelpatients, modelpanelpatients);
    panelpatients.setSize(1020, 720);
    panelpatients.setLocation(0,0);
  
    
    menudoctor.Content.removeAll();
    menudoctor.Content.add(panelpatients, BorderLayout.CENTER);
    menudoctor.Content.revalidate();
    menudoctor.Content.repaint();

}  
    
   
  
  
  public void initDoctors() {
    PanelDoctors paneldoctors = new PanelDoctors();
    ModelDoctors modeldoctors = new ModelDoctors();
    ControllerDoctors controllerdoctors = new ControllerDoctors(paneldoctors, modeldoctors);
    ValidationsDoctors validationsdoctors = new ValidationsDoctors(paneldoctors);
    boolean editando = false;
    String idOriginal = "";
    paneldoctors.setSize(1020, 720);
    paneldoctors.setLocation(0,0);
  
    
    menudoctor.Content.removeAll();
    menudoctor.Content.add(paneldoctors, BorderLayout.CENTER);
    menudoctor.Content.revalidate();
    menudoctor.Content.repaint();

}  
  
  
  public void initAbot() {
    PanelAbout panelabout = new PanelAbout();
    panelabout.setSize(1020, 720);
    panelabout.setLocation(0,0);
  
    
    menudoctor.Content.removeAll();
    menudoctor.Content.add(panelabout, BorderLayout.CENTER);
    menudoctor.Content.revalidate();
    menudoctor.Content.repaint();

}  
  
  
  
  
}
