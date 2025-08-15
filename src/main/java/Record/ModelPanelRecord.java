
package Record;

import ConnectionDataBase.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ModelPanelRecord {
    
    
     private ConnectionDB conn;

    public ModelPanelRecord() {
    conn = new ConnectionDB();
    }
     
     
    public List<History> obtainHistory() {
        List<History> lista = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Historial";
            Connection conexion = conn.establecerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                History history = new History(
                    rs.getString("IDCita"),
                    rs.getString("FechaCita"),
                    rs.getString("HoraCita"),
                    rs.getString("Area"),
                    rs.getString("IDPaciente"),
                    rs.getString("PrimerApellido"),
                    rs.getString("SegundoApellido"),
                    rs.getString("telefono"),
                    rs.getString("correo"),
                    rs.getString("direccion"),
                    rs.getString("edad"),
                    rs.getString("responsable"),
                    rs.getString("estadoCivil"),
                    rs.getString("sexo"),
                    rs.getString("ocupacion"),
                    rs.getString("fechaNacimiento"),
                    rs.getString("fechaPago"),
                    rs.getString("Monto")
                );
                lista.add(history);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    
    
    
     public boolean deleteHistory(String id) {
    String sql = "DELETE FROM Historial WHERE IDCita=?";
        try (Connection conexion = conn.establecerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

        ps.setString(1, id);
        return ps.executeUpdate() > 0;

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,
                "Error eliminando registro:\n" + e.getMessage(),
                "SQL Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
    
    
    
    
    
    
     
}
