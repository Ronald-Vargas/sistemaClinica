package Doctors;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class ControllerDoctors implements ActionListener {

    private MenuNewDoctor menunewdoctor;
    private PanelDoctors panel;
    private ModelDoctors modeldoctors;
    private boolean editando = false;
    private String idOriginal = "";  
    
    
    
    public ControllerDoctors(MenuNewDoctor menunewdoctor, PanelDoctors panel, ModelDoctors modeldoctors) {
        this.menunewdoctor = menunewdoctor;
        this.panel = panel;
        this.modeldoctors = modeldoctors;
        

        this.panel.btnAdd.addActionListener(this);
        this.panel.btnDelete.addActionListener(this);
        this.panel.btnEdit.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        // Evento al presionar "Agregar" en PanelDoctors
        if (e.getSource() == panel.btnAdd) {
            if (!editando) {  // ----- INSERT -----

            menunewdoctor.setVisible(true);
            MenuNewDoctor menunewdoctor = new MenuNewDoctor();
            ModelDoctors modeldoctors = new ModelDoctors();
            PanelDoctors paneldoctors = new PanelDoctors();
                    
            ControllerNewDoctor controllernewdoctor = new ControllerNewDoctor(menunewdoctor, modeldoctors, paneldoctors);
            }else {
                
                String nombre = menunewdoctor.TxtNombre.getText();
                String primerApellido = menunewdoctor.TxtLastName.getText();
                String segundoApellido = menunewdoctor.TxtSecondLastname.getText();
                String correo = menunewdoctor.Txtmail.getText();
                String telefono = menunewdoctor.TxtPhone.getText();
                
                
                boolean ok = modeldoctors.update(
                idOriginal, nombre, primerApellido, segundoApellido,correo, telefono);
                if (ok) {
                    JOptionPane.showMessageDialog(null, "Doctor actualizado correctamente");
                }
                // restauramos estado “normal”
                editando = false;
                idOriginal = "";
                menunewdoctor.BtnContinue.setText("Guardar");
                menunewdoctor.TxtId1.setEnabled(true);
            

            }
        }else if (e.getSource() == panel.btnDelete){
        deleteDoctor();
        }else if(e.getSource() == panel.btnEdit){
        modifydoctors();    
        }
    }
    
    public void deleteDoctor (){
    int fila = panel.DoctorsTable.getSelectedRow();

    if (fila >= 0) {
        String idDoctor = panel.DoctorsTable.getValueAt(fila, 3).toString();
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
        DefaultTableModel tableModel = (DefaultTableModel) panel.DoctorsTable.getModel();
        tableModel.setRowCount(0); 

        for (Doctors doctor : lista) {
            tableModel.addRow(new Object[]{
                doctor.getNombre(),
                doctor.getPrimerApellido(),
                doctor.getSegundoApellido(),
                doctor.getIdentificacion(),
                doctor.getCorreo(),
                doctor.getTelefono()
            });
        }
    }
    

    public void modifydoctors(){
    int fila = panel.DoctorsTable.getSelectedRow();
            if (fila < 0) {
                JOptionPane.showMessageDialog(null,
                        "Seleccione un doctor de la tabla.",
                        "Sin selección", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
            
            idOriginal = panel.DoctorsTable.getValueAt(fila, 3).toString();
            menunewdoctor.TxtId1.setText(idOriginal);
            menunewdoctor.TxtNombre.setText(panel.DoctorsTable.getValueAt(fila, 0).toString());
            menunewdoctor.TxtLastName.setText(panel.DoctorsTable.getValueAt(fila, 1).toString());
            menunewdoctor.TxtSecondLastname.setText(panel.DoctorsTable.getValueAt(fila, 2).toString());
            menunewdoctor.Txtmail.setText(panel.DoctorsTable.getValueAt(fila, 4).toString());
            menunewdoctor.TxtPhone.setText(panel.DoctorsTable.getValueAt(fila, 5).toString());

            // preparamos modo edición
            editando = true;
            menunewdoctor.BtnContinue.setText("Guardar cambios");
            menunewdoctor.TxtId1.setEnabled(false);     // no se cambia la PK
            menunewdoctor.setVisible(true);   // volvemos al form de alta
            }

    
    }
    
    
}

