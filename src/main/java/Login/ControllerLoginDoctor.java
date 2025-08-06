
package Login;

import ConnectionDataBase.ConnectionDB;
import General.ControllerMenuDoctor;
import General.MenuDoctor;
import General.MenuAppointmentPatient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class ControllerLoginDoctor implements ActionListener{
   
    
   private LoginDoctor logindoctor;

   ConnectionDataBase.ConnectionDB con = new ConnectionDB();
   Connection cn = con.establecerConexion();
   
   
   
   
    public ControllerLoginDoctor(LoginDoctor logindoctor) {
        this.logindoctor = logindoctor;
        
        
        logindoctor.BtnEnter.addActionListener(this);
        logindoctor.BtnExit.addActionListener(this);

    }
   
   
    
    
    
      
    
    
    
    
    @Override
    public void actionPerformed (ActionEvent e) {
    
        if (e.getSource() == logindoctor.BtnEnter) {
        
            validationLogin();
     
        
        } else if (e.getSource() == logindoctor.BtnExit) {
        Home home = new Home();
        home.setVisible(true);
        logindoctor.dispose();
                
        
        
        }
    
    
    }
    
    
    
    
    public void validationLogin() {
    
    String email = logindoctor.TxtEmail.getText();
    String pass = logindoctor.TxtPass.getText();    
    
    if (email.isEmpty() || pass.isEmpty()) {
           JOptionPane.showMessageDialog(null, "Por favor, Complete todos los datos solicitados", "Información Incompleta", JOptionPane.ERROR_MESSAGE);

 
    } else {
    
    
    
        try {
            
        String query = "SELECT Correo, Contrasena FROM Doctores WHERE Correo = ? AND Contrasena = ?";
        PreparedStatement ps = cn.prepareStatement(query);
        ps.setString(1, email); 
        ps.setString(2, pass);  
        ResultSet rs = ps.executeQuery();

            
            
         if (rs.next()) {
        JOptionPane.showMessageDialog(null, "Inicio de sesión aprobado", "Inicio de Sesión", JOptionPane.INFORMATION_MESSAGE);
        
        
        MenuDoctor menudoctor = new MenuDoctor();
        ControllerMenuDoctor controllermenudoctor = new ControllerMenuDoctor(menudoctor);
        menudoctor.setVisible(true);
        logindoctor.dispose();
        
        
        
        
        
    } else {
    JOptionPane.showMessageDialog(null, "Correo o Contraseña Incorrectos", "Error", JOptionPane.ERROR_MESSAGE);    
    }
        
            
            
            
            
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error al iniciar sesión: " +e , "Error", JOptionPane.ERROR_MESSAGE); 
        }
    
    
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
    }
    
    
    
    
    
}
