
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
import Register.EmailSender;
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
        
        this.loginpatient.LblOlvideContrasena.addMouseListener (new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
        forgotPassword();
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
    
    
    
    
    
    
    private void forgotPassword() {
    String email = loginpatient.TxtEmail.getText().trim();

    // 1. Validar campo vacío
    if (email.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor, ingrese su correo electrónico.", "Campo vacío", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        // 2. Verificar si existe el correo
        String query = "SELECT Identificacion FROM Pacientes WHERE Correo = ?";
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
        String updateQuery = "UPDATE Pacientes SET Contrasena = ? WHERE Correo = ?";
        PreparedStatement psUpdate = cn.prepareStatement(updateQuery);
        psUpdate.setString(1, nuevaPass);
        psUpdate.setString(2, email);
        psUpdate.executeUpdate();

        JOptionPane.showMessageDialog(null, "Contraseña actualizada con éxito. Ahora puede iniciar sesión.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Error en recuperación: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
                
                
                int confirm = JOptionPane.showConfirmDialog(null,
                "¿Ya tienes una cita agendada?",
                "Seleccionar opcion", JOptionPane.YES_NO_OPTION);
                
                if (confirm == JOptionPane.NO_OPTION) {
                

                panelappointmentpatient = new PanelAppointmentPatient(); 
                ModelPanelAppointmentPatient modelpanelappointmentpatient = new ModelPanelAppointmentPatient();
                ControllerPanelAppointmentPatient controllerpanelappointmentpatient = new ControllerPanelAppointmentPatient( panelappointmentpatient, modelpanelappointmentpatient, id);
                initPanelAppointmentPatient();
                } else if (confirm == JOptionPane.YES_OPTION) {
               
                String idCita = JOptionPane.showInputDialog(null, "Ingrese la indentificación de la cita:", "Modificar cita", JOptionPane.QUESTION_MESSAGE);
                
                try {
            
                String queryIdCita = "SELECT * FROM Citas WHERE IDCita = ?";
                ps = cn.prepareStatement(queryIdCita);
                ps.setString(1, idCita);
                rs = ps.executeQuery();

        if (!rs.next()) {
            JOptionPane.showMessageDialog(null, "La identificacion no está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
                
                }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Eror al buscar la cita", "Error en la base de datos", JOptionPane.ERROR_MESSAGE);
                return;
                }
                
                int confirm2 = JOptionPane.showConfirmDialog(null,
                "¿Desea eliminar esta cita?",
                "Seleccionar opcion", JOptionPane.YES_NO_OPTION);
                
                if (confirm2 == JOptionPane.YES_OPTION) {
                deletedoctor(idCita);
                JOptionPane.showMessageDialog(null, "Cita aliminada con exito", "", JOptionPane.INFORMATION_MESSAGE);
                } else if (confirm2 == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Se cancelo la eliminacion de la cita");
                
                }
 
                }
                
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
    
    
     public boolean deletedoctor(String idCita) {
    String sql = "DELETE FROM Citas WHERE IDCita=?";
        try (Connection conexion = con.establecerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

        ps.setString(1, idCita);
        return ps.executeUpdate() > 0;

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,
                "Error eliminando cita:\n" + e.getMessage(),
                "SQL Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
    
    
    
    
}
