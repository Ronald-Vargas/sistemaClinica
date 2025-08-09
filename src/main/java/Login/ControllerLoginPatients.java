
package Login;

import Appointment.ControllerPanelAppointmentPatient;
import Appointment.ModelPanelAppointmentPatient;
import Appointment.PanelAppointmentPatient;
import Register.ControllerRegisterPatients;
import Home.Home;
import Home.ControllerHome;
import Validations.ValidationsPatients;
import Register.Register;
import ConnectionDataBase.ConnectionDB;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class ControllerLoginPatients implements ActionListener{
    
    
  private LoginPatient loginpatient;
  private PanelAppointmentPatient panelappointmentpatient;
  
  
  ConnectionDataBase.ConnectionDB con = new ConnectionDB();
  Connection cn = con.establecerConexion();
    
  

    public ControllerLoginPatients(LoginPatient loginpatient) {
        this.loginpatient = loginpatient;
        
       this.loginpatient.BtnLogIn.addActionListener(this);
       this.loginpatient.BtnLogOut.addActionListener(this);
       
       
       
       
        this.loginpatient.LblRegister.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
        Register register = new Register();
        ControllerRegisterPatients controllerloginpatients = new ControllerRegisterPatients(register);
        ValidationsPatients validationpatients = new ValidationsPatients(register);
        register.setVisible(true);
        loginpatient.dispose();
        }
         });
    }
    
    
    
    
    
    
    public void actionPerformed (ActionEvent e) {
    
    
     if (e.getSource() == loginpatient.BtnLogIn) {
    validationLogIn();
    
    
    
    
    
    
    } else if (e.getSource() == loginpatient.BtnLogOut) {
    Home home = new Home();
    ControllerHome controllerhome = new ControllerHome(home);
    home.setVisible(true);
    loginpatient.dispose();
    
    
    
    
    }
    
    
    }
    
    
    
    
    
     public void validationLogIn() {
    String email = loginpatient.TxtEmail.getText();
    String pass = loginpatient.TxtPass.getText();
    
    if (email.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, Complete todos los datos solicitados", "Información Incompleta", JOptionPane.ERROR_MESSAGE);

    } else {
    
        
       try {
            String query = "SELECT Identificacion FROM Pacientes WHERE Correo = ? AND Contrasena = ?";
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, email); 
            ps.setString(2, pass);  
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String id = rs.getString("Identificacion"); 
                JOptionPane.showMessageDialog(null, "Inicio de sesión aprobado", "Inicio de Sesión", JOptionPane.INFORMATION_MESSAGE);

                panelappointmentpatient = new PanelAppointmentPatient(); 
                ModelPanelAppointmentPatient modelpanelappointmentpatient = new ModelPanelAppointmentPatient();
                ControllerPanelAppointmentPatient controllerpanelappointmentpatient = new ControllerPanelAppointmentPatient(
                        panelappointmentpatient, modelpanelappointmentpatient, id
                );
                initPanelAppointmentPatient();
            } else {
                JOptionPane.showMessageDialog(null, "Correo o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception i) {
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión: " + i.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
     
    }
    
   
    }
    
    
    
    
    
    private void initPanelAppointmentPatient() {
    panelappointmentpatient.setSize(600, 800);
    panelappointmentpatient.setLocation(0, 0);

    loginpatient.Content.removeAll();
    loginpatient.Content.add(panelappointmentpatient, BorderLayout.CENTER);
    loginpatient.Content.revalidate();
    loginpatient.Content.repaint();
    
    
    
    }
    
    
    
    
    
    
    
}
