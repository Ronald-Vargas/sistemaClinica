
package Record;

import ConnectionDataBase.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


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
                    rs.getString("fechaNacimiento")
                );
                lista.add(history);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    
    
    
     
}
