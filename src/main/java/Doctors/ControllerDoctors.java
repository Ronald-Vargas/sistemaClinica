package Doctors;

import General.MenuDoctor;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class ControllerDoctors implements ActionListener {

    private MenuNewDoctor menunewdoctor;
    private PanelDoctors paneldoctors;
    private ModelDoctors modeldoctors;
    private boolean editando = false;
    private String idOriginal = "";  
    
    
    
    public ControllerDoctors(MenuNewDoctor menunewdoctor, PanelDoctors paneldoctors, ModelDoctors modeldoctors) {
        this.menunewdoctor = menunewdoctor;
        this.paneldoctors = paneldoctors;
        this.modeldoctors = modeldoctors;
        

        this.paneldoctors.btnAdd.addActionListener(this);
        this.paneldoctors.btnDelete.addActionListener(this);
        this.paneldoctors.btnEdit.addActionListener(this);

    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {


        // Evento al presionar "Agregar" en PanelDoctors
        if (e.getSource() == paneldoctors.btnAdd) {
            if (!editando) {  // ----- INSERT -----

            menunewdoctor.setVisible(true);

            }else {
                
                String nombre = menunewdoctor.TxtNombre.getText();
                String primerApellido = menunewdoctor.TxtLastName.getText();
                String segundoApellido = menunewdoctor.TxtSecondLastname.getText();
                String correo = menunewdoctor.Txtmail.getText();
                String telefono = menunewdoctor.TxtPhone.getText();
                String contrasena = menunewdoctor.TxtPass.getText();
                
                
                boolean ok = modeldoctors.update(
                idOriginal, nombre, primerApellido, segundoApellido,correo, telefono, contrasena);
                if (ok) {
                    JOptionPane.showMessageDialog(null, "Doctor actualizado correctamente");
                }
                // restauramos estado “normal”
                editando = false;
                idOriginal = "";
                menunewdoctor.BtnContinue.setText("Guardar");
                menunewdoctor.TxtId1.setEnabled(true);
                new ControllerNewDoctor(menunewdoctor, modeldoctors, paneldoctors, false, "");

            

            }
        }else if (e.getSource() == paneldoctors.btnDelete){
        deleteDoctor();
        }else if(e.getSource() == paneldoctors.btnEdit){
        modifydoctors();    
        }
    }
    
    
    
    
    
    
    
    
    
    
    public void deleteDoctor (){
    int fila = paneldoctors.DoctorsTable.getSelectedRow();

    if (fila >= 0) {
        String idDoctor = paneldoctors.DoctorsTable.getValueAt(fila, 3).toString();
        int confirm = JOptionPane.showConfirmDialog(null,
                "¿Estás seguro de eliminar la informacion del doctor?",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean eliminado = modeldoctors.deletedoctor(idDoctor);
            if (eliminado) {
                JOptionPane.showMessageDialog(null, "Doctor eliminado correctamente.");
                loadDoctors();  // refrescar la tabla
            }
        }

    } else {
       JOptionPane.showMessageDialog(null,
                        "Seleccione un doctor de la tabla.",
                        "Sin selección", JOptionPane.ERROR_MESSAGE);
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
    

    
    
    
    
    
    public void modifydoctors(){
    int fila = paneldoctors.DoctorsTable.getSelectedRow();
            if (fila < 0) {
                JOptionPane.showMessageDialog(null,
                        "Seleccione un doctor de la tabla.",
                        "Sin selección", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
            
            idOriginal = paneldoctors.DoctorsTable.getValueAt(fila, 3).toString();
            menunewdoctor.TxtId1.setText(idOriginal);
            menunewdoctor.TxtNombre.setText(paneldoctors.DoctorsTable.getValueAt(fila, 0).toString());
            menunewdoctor.TxtLastName.setText(paneldoctors.DoctorsTable.getValueAt(fila, 1).toString());
            menunewdoctor.TxtSecondLastname.setText(paneldoctors.DoctorsTable.getValueAt(fila, 2).toString());
            menunewdoctor.Txtmail.setText(paneldoctors.DoctorsTable.getValueAt(fila, 4).toString());
            menunewdoctor.TxtPhone.setText(paneldoctors.DoctorsTable.getValueAt(fila, 5).toString());
            menunewdoctor.TxtPass.setText(paneldoctors.DoctorsTable.getValueAt(fila, 6).toString());

            // preparamos modo edición
            editando = true;
            menunewdoctor.BtnContinue.setText("Guardar cambios");
            menunewdoctor.TxtId1.setEnabled(false);     // no se cambia la PK
            menunewdoctor.setVisible(true);   // volvemos al form de alta
            new ControllerNewDoctor(menunewdoctor, modeldoctors, paneldoctors, true, idOriginal);

            }

    
    }
    
    
}

