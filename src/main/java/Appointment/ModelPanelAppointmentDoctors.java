
package Appointment;

import ConnectionDataBase.ConnectionDB;
import Patients.Patients;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;


public class ModelPanelAppointmentDoctors {
    
    
     private ConnectionDB conn;

    public ModelPanelAppointmentDoctors() {
    conn = new ConnectionDB();
    }
     
     
    
    
    
     public List<Appointment> obtainAppointment() {
        List<Appointment> lista = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Citas";
            Connection conexion = conn.establecerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Appointment appointment = new Appointment(
                    rs.getString("idCita"),
                    rs.getString("fechaCita"),
                    rs.getString("hora"),
                    rs.getString("PacienteID"),
                    rs.getString("area"),
                    rs.getString("fechaRegistro"),
                    rs.getString("estado")

                );
                lista.add(appointment);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    
    
    
      public boolean deleteAppointment (String id) {
    String sql = "DELETE FROM Citas WHERE IDCita=?";
        try (Connection conexion = conn.establecerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

        ps.setString(1, id);
        return ps.executeUpdate() > 0;

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,
                "Error eliminando Doctor:\n" + e.getMessage(),
                "SQL Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
      
    
      
      
      
      
      
      
      
      
      
      
      
      
      
      
   public boolean actualizarEstadoCita(String idCita, String nuevoEstado) {
    String sql = "UPDATE Citas SET Estado = ? WHERE IDCita = ?";
    try (Connection conexion = conn.establecerConexion();
         PreparedStatement ps = conexion.prepareStatement(sql)) {

        ps.setString(1, nuevoEstado);
        ps.setString(2, idCita);

        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
      
      
      
      public boolean update (String idCita, String fechaCita, String hora, String idPaciente, String especialiadad, String fechaRegistro) {
    
        String sql = "UPDATE Citas SET FechaCita=?, PacienteID=?, FechaRegistro=?, Hora=?, Area=? WHERE IDCita=?";
        
        try (Connection conexion = conn.establecerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, fechaCita);
            ps.setString(2, idPaciente);
            ps.setString(3, fechaRegistro);
            ps.setString(4, hora);
            ps.setString(5, especialiadad);
            ps.setString(6, idCita);

            
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar cita:\n" + e.getMessage(),
                    "SQL Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

      
      
      
      public Patients cargarDatosPaciente(String idPaciente) {
    String sql = "SELECT Identificacion, Nombre, PrimerApellido, SegundoApellido, Correo, Telefono, Direccion, Edad, Responsable, EstadoCivil, Sexo, Ocupacion, FechaNacimiento FROM Pacientes WHERE Identificacion = ?";

    try (Connection conexion = conn.establecerConexion();
         PreparedStatement ps = conexion.prepareStatement(sql)) {

        ps.setString(1, idPaciente);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Patients(
                rs.getString("Identificacion"),    // identificacion
                rs.getString("Nombre"),
                rs.getString("PrimerApellido"),
                rs.getString("SegundoApellido"),
                rs.getString("Correo"),
                rs.getString("Telefono"),
                rs.getString("Direccion"),
                rs.getString("Edad"),
                rs.getString("Responsable"),
                rs.getString("EstadoCivil"),
                rs.getString("Sexo"),
                rs.getString("Ocupacion"),
                rs.getString("FechaNacimiento")
            );
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,
                "Error al cargar datos del paciente:\n" + e.getMessage(),
                "SQL Error", JOptionPane.ERROR_MESSAGE);
    }
    return null; // si no encuentra datos
}
      
      
      
      
      
      
      
      
}

      
      
      
      
      
      
      
      
      
      
      
      

