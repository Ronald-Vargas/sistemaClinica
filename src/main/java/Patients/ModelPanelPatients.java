
package Patients;

import ConnectionDataBase.ConnectionDB;
import Doctors.Doctors;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ModelPanelPatients {
   
    
    
   private ConnectionDB conn;

    public ModelPanelPatients() {
    conn = new ConnectionDB();
    }

    
    
    
    
    public List<Patients> obtainPatients() {
        List<Patients> lista = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Pacientes";
            Connection conexion = conn.establecerConexion();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Patients patients = new Patients(
                    rs.getString("identificacion"),
                    rs.getString("nombre"),
                    rs.getString("primerApellido"),
                    rs.getString("segundoApellido"),
                    rs.getString("correo"),
                    rs.getString("telefono"),
                    rs.getString("direccion"),
                    rs.getString("edad"),
                    rs.getString("responsable"),
                    rs.getString("estadoCivil"),
                    rs.getString("sexo"),
                    rs.getString("ocupacion"),
                    rs.getString("fechaNacimiento")
                );
                lista.add(patients);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    
    
    
    
    
    public boolean deletePatient(String id) {
    String sql = "DELETE FROM Pacientes WHERE Identificacion=?";
        try (Connection conexion = conn.establecerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

        ps.setString(1, id);
        return ps.executeUpdate() > 0;

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,
                "Error eliminando Paciente:\n" + e.getMessage(),
                "SQL Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
    
    
    
    
    
    public boolean update (String idOriginal, String nombre, String primerApellido, String segundoApellido, String correo, String telefono, String direccion, String edad, String responsable, String estadoCivil, String sexo, String ocupacion, String fechaNacimiento) {
    
        String sql = "UPDATE Pacientes SET Nombre=?, PrimerApellido=?, SegundoApellido=?, Correo=?, Telefono=?, direccion=?, edad=?, responsable=?, estadoCivil=?, sexo=?, ocupacion=?, fechaNacimiento=? WHERE Identificacion=?";
        
        try (Connection conexion = conn.establecerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, primerApellido);
            ps.setString(3, segundoApellido);
            ps.setString(4, correo);
            ps.setString(5, telefono);
            ps.setString(6, direccion);
            ps.setString(7, edad);
            ps.setString(8, responsable);
            ps.setString(9, estadoCivil);
            ps.setString(10, sexo);
            ps.setString(11, ocupacion);
            ps.setString(12, fechaNacimiento);
            ps.setString(13, idOriginal);
            

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar paciente:\n" + e.getMessage(),
                    "SQL Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    
    
    
    public Patients obtenerPacientePorId(String identificacion) {
    Patients paciente = null;

    try {
        String sql = "SELECT * FROM Pacientes WHERE identificacion = ?";
        Connection conexion = conn.establecerConexion();
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, identificacion);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            paciente = new Patients(
                rs.getString("identificacion"),
                rs.getString("nombre"),
                rs.getString("primerApellido"),
                rs.getString("segundoApellido"),
                rs.getString("correo"),
                rs.getString("telefono"),
                rs.getString("direccion"),
                rs.getString("edad"),
                rs.getString("responsable"),
                rs.getString("estadoCivil"),
                rs.getString("sexo"),
                rs.getString("ocupacion"),
                rs.getString("fechaNacimiento")
            );
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return paciente;
}
    
    
    
    
    
    
    
    
    
    
    
    
}
