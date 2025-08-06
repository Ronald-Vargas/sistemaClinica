package Doctors;

import ConnectionDataBase.ConnectionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ModelDoctors {

    private ConnectionDB conn;

    public ModelDoctors() {
        conn = new ConnectionDB();
    }

    public List<Doctors> obtainDoctors() {
        List<Doctors> lista = new ArrayList<>();

        try {
            String sql = "SELECT * FROM doctores";
            Connection conexion = conn.establecerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Doctors doctor = new Doctors(
                    rs.getString("nombre"),
                    rs.getString("primerApellido"),
                    rs.getString("segundoApellido"),
                    rs.getString("identificacion"),
                    rs.getString("correo"),
                    rs.getString("telefono"),
                    rs.getString("contrasena")
                );
                lista.add(doctor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean insertDoctor(Doctors doctor) {
        String sql = "INSERT INTO doctores (nombre, primerApellido, segundoApellido, identificacion, correo, telefono, contrasena) VALUES (?, ?, ?, ?, ?, ?,?)";

        try (Connection conexion = conn.establecerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, doctor.getNombre());
            ps.setString(2, doctor.getPrimerApellido());
            ps.setString(3, doctor.getSegundoApellido());
            ps.setString(4, doctor.getIdentificacion());
            ps.setString(5, doctor.getCorreo());
            ps.setString(6, doctor.getTelefono());
            ps.setString(7, doctor.getContrasena());
            

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar doctor: " + e.getMessage());
            return false;
        }
    }

    public boolean deletedoctor(String id) {
    String sql = "DELETE FROM Doctores WHERE Identificacion=?";
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
    public boolean update (String idOriginal, String nombre, String primerApellido, String segundoApellido, String correo, String telefono, String contrasena) {
    
        String sql = "UPDATE Doctores SET Nombre=?, PrimerApellido=?, SegundoApellido=?, Correo=?, Telefono=?, Contrasena=? WHERE Identificacion=?";
        
        try (Connection conexion = conn.establecerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, primerApellido);
            ps.setString(3, segundoApellido);
            ps.setString(4, correo);
            ps.setString(5, telefono);
            ps.setString(6, contrasena);
            ps.setString(7, idOriginal);
            

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar doctor:\n" + e.getMessage(),
                    "SQL Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}
