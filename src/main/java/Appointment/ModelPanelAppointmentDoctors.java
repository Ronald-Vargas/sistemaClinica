
package Appointment;

import ConnectionDataBase.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
    
    
}
