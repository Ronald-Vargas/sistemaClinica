
package Appointment;

import ConnectionDataBase.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class ModelPanelAppointmentPatient {

    
    
    private ConnectionDB conn;

    
    public ModelPanelAppointmentPatient() {
      conn = new ConnectionDB();
    }
    
    
    
    public boolean insertAppointmentPatient(Appointment appointment) { 
        
        
 String sql = "INSERT INTO Citas (fechaCita, hora, fechaRegistro, estado, area, PacienteID) VALUES (?, ?, ?, ?, ?, ?)";

try (Connection conexion = conn.establecerConexion();
     PreparedStatement ps = conexion.prepareStatement(sql)) {

    ps.setString(1, appointment.getFechaCita());
    ps.setString(2, appointment.getHora());
    ps.setString(3, appointment.getFechaRegistro());
    ps.setString(4, appointment.getEstado());
    ps.setString(5, appointment.getArea());
    ps.setString(6, appointment.getId()); 

    ps.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agendar cita: " + e.getMessage());
            return false;
        }
    }
    
    
}
