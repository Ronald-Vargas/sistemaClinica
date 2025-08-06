/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Doctors;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ControllerNewDoctor implements ActionListener {
    
    
    
    private MenuNewDoctor menunewdoctor;
    private ModelDoctors modeldoctors;
    private PanelDoctors paneldoctors;
    private boolean editando = false;
    private String idOriginal = "";

    
    
    
    public ControllerNewDoctor(MenuNewDoctor menunewdoctor, ModelDoctors modeldoctors, PanelDoctors paneldoctors, boolean editando, String idOriginal) {
    this.menunewdoctor = menunewdoctor;
    this.modeldoctors = modeldoctors;
    this.paneldoctors = paneldoctors;
    this.editando = editando;
    this.idOriginal = idOriginal;
    
    this.menunewdoctor.BtnContinue.addActionListener(this);
    loadDoctors();
}
    
    
    
    
    


    @Override
    public void actionPerformed (ActionEvent e){
    if (e.getSource()==menunewdoctor.BtnContinue){
             registrarDoctor();
         }
    }
    
    
    
    
    
    
        private void registrarDoctor() {
    String nombre = menunewdoctor.TxtNombre.getText();
    String primerApellido = menunewdoctor.TxtLastName.getText();
    String segundoApellido = menunewdoctor.TxtSecondLastname.getText();
    String identificacion = menunewdoctor.TxtId1.getText();
    String correo = menunewdoctor.Txtmail.getText();
    String telefono = menunewdoctor.TxtPhone.getText();
    String contrasena = menunewdoctor.TxtPass.getText();

    if (nombre.isEmpty() || primerApellido.isEmpty() || segundoApellido.isEmpty() || identificacion.isEmpty() || correo.isEmpty() || telefono.isEmpty() || contrasena.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor complete los campos obligatorios.");
        return;
    }

    if (editando) {
        // 🛠️ ACTUALIZAR, no insertar
        boolean actualizado = modeldoctors.update(idOriginal, nombre, primerApellido, segundoApellido, correo, telefono, contrasena);
        if (actualizado) {
            JOptionPane.showMessageDialog(null, "Doctor actualizado correctamente.");
            menunewdoctor.setVisible(false);
            menunewdoctor.dispose();
            loadDoctors();
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar doctor.");
        }

    } else {
        // ➕ INSERTAR NUEVO
        if (modeldoctors.existeDoctor(identificacion)) {
            JOptionPane.showMessageDialog(null, "Ya existe un doctor con esa identificación.");
            return;
        } 

        Doctors doctor = new Doctors(nombre, primerApellido, segundoApellido, identificacion, correo, telefono, contrasena);
        if (modeldoctors.insertDoctor(doctor)) {
            JOptionPane.showMessageDialog(null, "Doctor registrado con éxito.");
            menunewdoctor.setVisible(false);
            menunewdoctor.dispose();
            loadDoctors();
            cleanfields();
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar doctor.");
        }
    }
}
        
        
        
        
        public void loadDoctors() {
        List<Doctors> lista = modeldoctors.obtainDoctors();
        DefaultTableModel tableModel = (DefaultTableModel) paneldoctors.DoctorsTable.getModel();
        tableModel.setRowCount(0); 

        for (Doctors doctor : lista) {
            tableModel.addRow(new Object[]{
                doctor.getNombre(),
                doctor.getPrimerApellido(),
                doctor.getSegundoApellido(),
                doctor.getIdentificacion(),
                doctor.getCorreo(),
                doctor.getTelefono(),
                doctor.getContrasena()
            });
        }
    }
    
        private void cleanfields() {
        menunewdoctor.TxtNombre.setText("");
        menunewdoctor.TxtLastName.setText("");
        menunewdoctor.TxtSecondLastname.setText("");
        menunewdoctor.TxtId1.setText("");
        menunewdoctor.Txtmail.setText("");
        menunewdoctor.TxtPhone.setText("");
    }

        
        
}
