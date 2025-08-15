package About;

import ConnectionDataBase.ConnectionDB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ControllerPanelAbout implements ActionListener {

    private PanelAbout panelabout;
    private ModelPanelAbout modelpanelabout;

    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;

    ConnectionDB con = new ConnectionDB();
    Connection cn = con.establecerConexion();

    public ControllerPanelAbout(PanelAbout panelabout, ModelPanelAbout modelpanelabout) {
        this.panelabout = panelabout;
        this.modelpanelabout = modelpanelabout;

        panelabout.Btnsave.addActionListener(this);
        panelabout.BtnCheck.addActionListener(this);
        panelabout.BtnX.addActionListener(this);

        loadData();
        disableFields();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == panelabout.Btnsave) {
            enableFields(); 
        }

        else if (e.getSource() == panelabout.BtnCheck) {
            if (validateFields()) {
                nombre = panelabout.txtName.getText().trim();
                direccion = panelabout.txtAddress.getText().trim();
                telefono = panelabout.txtPhone.getText().trim();
                correo = panelabout.txtEmail.getText().trim();

                savedata(); 
                disableFields(); 
            }
        }

        else if (e.getSource() == panelabout.BtnX) {
            loadData(); 
            disableFields();
        }
    }

    private void enableFields() {
        panelabout.txtName.enable(true);
        panelabout.txtAddress.enable(true);
        panelabout.txtPhone.enable(true);
        panelabout.txtEmail.enable(true);
        panelabout.BtnCheck.setVisible(true);
        panelabout.BtnX.setVisible(true);
    }

    private void disableFields() {
        panelabout.txtName.disable();
        panelabout.txtAddress.disable();
        panelabout.txtPhone.disable();
        panelabout.txtEmail.disable();
        panelabout.BtnCheck.setVisible(false);
        panelabout.BtnX.setVisible(false);
    }

    private boolean validateFields() {
        if (panelabout.txtName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre.");
            return false;
        }
        if (panelabout.txtAddress.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese la dirección.");
            return false;
        }
        if (panelabout.txtPhone.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese el teléfono.");
            return false;
        }
        if (panelabout.txtEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese el correo.");
            return false;
        }
        return true;
    }

    private void loadData() {
        try {
            String query = "SELECT TOP 1 NombreClinica, Direccion, Telefono, Correo FROM ClinicaInfo";
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                panelabout.txtName.setText(rs.getString("NombreClinica"));
                panelabout.txtAddress.setText(rs.getString("Direccion"));
                panelabout.txtPhone.setText(rs.getString("Telefono"));
                panelabout.txtEmail.setText(rs.getString("Correo"));
            } else {
                // Si la tabla está vacía, limpiar campos
                panelabout.txtName.setText("");
                panelabout.txtAddress.setText("");
                panelabout.txtPhone.setText("");
                panelabout.txtEmail.setText("");
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos: " + e.getMessage());
        }
    }

    public void savedata() {
        try {
            String checkQuery = "SELECT COUNT(*) FROM ClinicaInfo";
            PreparedStatement psCheck = cn.prepareStatement(checkQuery);
            ResultSet rs = psCheck.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            rs.close();
            psCheck.close();

            if (count == 0) {
                String insertQuery = "INSERT INTO ClinicaInfo (NombreClinica, Direccion, Telefono, Correo) VALUES (?, ?, ?, ?)";
                PreparedStatement psInsert = cn.prepareStatement(insertQuery);
                psInsert.setString(1, nombre);
                psInsert.setString(2, direccion);
                psInsert.setString(3, telefono);
                psInsert.setString(4, correo);
                psInsert.executeUpdate();
                psInsert.close();
            } else {
                String updateQuery = "UPDATE ClinicaInfo SET NombreClinica = ?, Direccion = ?, Telefono = ?, Correo = ?";
                PreparedStatement psUpdate = cn.prepareStatement(updateQuery);
                psUpdate.setString(1, nombre);
                psUpdate.setString(2, direccion);
                psUpdate.setString(3, telefono);
                psUpdate.setString(4, correo);
                psUpdate.executeUpdate();
                psUpdate.close();
            }

            JOptionPane.showMessageDialog(null, "Datos guardados correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO SE REGISTRARON LOS DATOS: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
