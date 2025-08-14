
package Login;

import Home.Home;
import ConnectionDataBase.ConnectionDB;
import Sistem.ControllerSistemDoctors;
import Sistem.SistemDoctors;
import Home.ControllerHome;
import Register.EmailSender;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

        
        
        
        this.logindoctor.LblOlvideContrasena.addMouseListener (new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
        forgotPassword();
        }
        
        
        
        
        });

        
        
    }
   
   
    
    
    
      
    
    
    
    
    @Override
    public void actionPerformed (ActionEvent e) {
    
        if (e.getSource() == logindoctor.BtnEnter) {
        
            validationLogin();
     
        
        } else if (e.getSource() == logindoctor.BtnExit) {
        Home home = new Home();
        ControllerHome controllerhome = new ControllerHome(home);
        home.setVisible(true);
        logindoctor.dispose();
                
        
        
        }
    
    
    }
    
    
    
    
    
    private void forgotPassword() {
    String email = logindoctor.TxtEmail.getText().trim();

    // 1. Validar campo vacío
    if (email.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor, ingrese su correo electrónico.", "Campo vacío", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        // 2. Verificar si existe el correo
        String query = "SELECT Identificacion FROM Doctores WHERE Correo = ?";
        PreparedStatement ps = cn.prepareStatement(query);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            JOptionPane.showMessageDialog(null, "El correo no está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 3. Generar código aleatorio
        int codigo = (int) (Math.random() * 900000) + 100000; // 6 dígitos
        String codigoStr = String.valueOf(codigo);

        // 4. Enviar código por correo
        EmailSender emailSender = new EmailSender();
        boolean enviado = emailSender.sendEmail(email, "Recuperación de contraseña", "Su código de verificación es: " + codigoStr);

        if (!enviado) {
            JOptionPane.showMessageDialog(null, "No se pudo enviar el correo. Intente más tarde.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        

        // 5. Solicitar código (máximo 3 intentos)
        boolean verificado = false;
        for (int intentos = 0; intentos < 3; intentos++) {
            String ingreso = JOptionPane.showInputDialog(null, "Ingrese el código enviado a su correo:", "Verificación", JOptionPane.QUESTION_MESSAGE);
            if (ingreso == null) return; // Usuario canceló
            if (ingreso.trim().equals(codigoStr)) {
                verificado = true;
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Código incorrecto. Intentos restantes: " + (2 - intentos), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (!verificado) {
            JOptionPane.showMessageDialog(null, "Se agotaron los intentos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 6. Solicitar nueva contraseña
        String nuevaPass = JOptionPane.showInputDialog(null, "Ingrese la nueva contraseña:", "Cambio de contraseña", JOptionPane.QUESTION_MESSAGE);
        if (nuevaPass == null || nuevaPass.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Contraseña no válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 7. Actualizar en la base de datos
        String updateQuery = "UPDATE Doctores SET Contrasena = ? WHERE Correo = ?";
        PreparedStatement psUpdate = cn.prepareStatement(updateQuery);
        psUpdate.setString(1, nuevaPass);
        psUpdate.setString(2, email);
        psUpdate.executeUpdate();

        JOptionPane.showMessageDialog(null, "Contraseña actualizada con éxito. Ahora puede iniciar sesión.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Error en recuperación: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
        
        
        SistemDoctors menudoctor = new SistemDoctors();
        ControllerSistemDoctors controllermenudoctor = new ControllerSistemDoctors(menudoctor);
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
