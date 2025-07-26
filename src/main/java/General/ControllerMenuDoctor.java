
package General;

import About.PanelAbout;
import Box.PanelBox;
import Doctors.PanelDoctors;
import Login.LoginDoctor;
import Patients.PanelPatients;
import Quotes.PanelQoutes;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControllerMenuDoctor implements ActionListener{
    
    
   private MenuDoctor menu;

    public ControllerMenuDoctor(MenuDoctor menu) {
        this.menu = menu;
        
        
        menu.BtnBox.addActionListener(this);
        menu.BtnQuotes.addActionListener(this);
        menu.BtnPatients.addActionListener(this);
        menu.BtnDoctors.addActionListener(this);
        menu.BtnLogout.addActionListener(this);
        menu.BtnAbout.addActionListener(this);
        
        initQuotes();

    }
    
    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed (ActionEvent e) {
    
    
    if (e.getSource() == menu.BtnBox) {
    initBox();
    
    
    
    } else if (e.getSource() == menu.BtnQuotes) {
    initQuotes();
    
    } else if (e.getSource() == menu.BtnPatients) {
    initPatients();
    
    } else if (e.getSource() == menu.BtnDoctors) {
    initDoctors();
    
    } else if (e.getSource() == menu.BtnLogout) {
        LoginDoctor logindoctor = new LoginDoctor();
        logindoctor.setVisible(true);
        menu.dispose();
        
    } else if (e.getSource() == menu.BtnAbout) {
    initAbot();
    
    }
    
    
    
    
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
    public void initBox() {
    PanelBox panelbox = new PanelBox();
    panelbox.setSize(1020, 720);
    panelbox.setLocation(0,0);
  
    
    menu.Content.removeAll();
    menu.Content.add(panelbox, BorderLayout.CENTER);
    menu.Content.revalidate();
    menu.Content.repaint();

}
    
    
    
    
    
    public void initQuotes() {
    PanelQoutes panelquotes = new PanelQoutes();
    panelquotes.setSize(1020, 720);
    panelquotes.setLocation(0,0);
  
    
    menu.Content.removeAll();
    menu.Content.add(panelquotes, BorderLayout.CENTER);
    menu.Content.revalidate();
    menu.Content.repaint();

}
    
    
    
  public void initPatients() {
    PanelPatients panelpatients = new PanelPatients();
    panelpatients.setSize(1020, 720);
    panelpatients.setLocation(0,0);
  
    
    menu.Content.removeAll();
    menu.Content.add(panelpatients, BorderLayout.CENTER);
    menu.Content.revalidate();
    menu.Content.repaint();

}  
    
   
  
  
  public void initDoctors() {
    PanelDoctors paneldoctors = new PanelDoctors();
    paneldoctors.setSize(1020, 720);
    paneldoctors.setLocation(0,0);
  
    
    menu.Content.removeAll();
    menu.Content.add(paneldoctors, BorderLayout.CENTER);
    menu.Content.revalidate();
    menu.Content.repaint();

}  
  
  
  public void initAbot() {
    PanelAbout panelabout = new PanelAbout();
    panelabout.setSize(1020, 720);
    panelabout.setLocation(0,0);
  
    
    menu.Content.removeAll();
    menu.Content.add(panelabout, BorderLayout.CENTER);
    menu.Content.revalidate();
    menu.Content.repaint();

}  
  
  
  
  
}
