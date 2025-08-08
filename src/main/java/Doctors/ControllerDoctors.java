package Doctors;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class ControllerDoctors implements ActionListener {

    private PanelDoctors paneldoctors;
    private ModelDoctors modeldoctors;
    private boolean editando = false;
    private String idOriginal = "";  
    
    
    
    public ControllerDoctors(PanelDoctors paneldoctors, ModelDoctors modeldoctors) {
        this.paneldoctors = paneldoctors;
        this.modeldoctors = modeldoctors;
        
       loadDoctors();
       initializeListeners();
       
       
       this.paneldoctors.TxtSearch.addActionListener(new ActionListener() {
     @Override
            public void actionPerformed(ActionEvent e) {
                searchDoctor();
            }
            });
       
    }
    
    
    private void initializeListeners() {
        this.paneldoctors.btnAdd.addActionListener(this);
        this.paneldoctors.btnDelete.addActionListener(this);
        this.paneldoctors.btnEdit.addActionListener(this);
        this.paneldoctors.BtnContinue.addActionListener(this);
        this.paneldoctors.BtnOut.addActionListener(this);

    }
    
    
    

    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {


        // Evento al presionar "Agregar" en PanelDoctors
        if (e.getSource() == paneldoctors.btnAdd) {
        handleAddAction();
        } else if (e.getSource() == paneldoctors.btnDelete) {
            deleteDoctor();
        } else if (e.getSource() == paneldoctors.btnEdit) {
             modifydoctors();    
        } else if (e.getSource() == paneldoctors.BtnContinue) {
            registrarDoctor();
        } else if (e.getSource() == paneldoctors.BtnOut) {
        cleanfields();
        paneldoctors.jTabbedPane.setSelectedIndex(0);
        }
    }
        
        
    
    
    
    private void registrarDoctor() {
    String nombre = paneldoctors.TxtNombre.getText();
    String primerApellido = paneldoctors.TxtLastName.getText();
    String segundoApellido = paneldoctors.TxtSecondLastname.getText();
    String identificacion = paneldoctors.TxtId1.getText();
    String correo = paneldoctors.Txtmail.getText();
    String telefono = paneldoctors.TxtPhone.getText();
    String contrasena = paneldoctors.TxtPass.getText();
    String especialidad = (String) paneldoctors.ComboSpecialty.getSelectedItem();

    if (nombre.isEmpty() || primerApellido.isEmpty() || segundoApellido.isEmpty() || identificacion.isEmpty() || correo.isEmpty() || telefono.isEmpty() || contrasena.isEmpty() || especialidad.equals("--SELECCIONAR--")) {
        JOptionPane.showMessageDialog(null, "Por favor complete los campos obligatorios.");
        return;
    }

    if (editando) {
  
        boolean actualizado = modeldoctors.update(idOriginal, nombre, primerApellido, segundoApellido, correo, telefono, contrasena, especialidad);
        if (actualizado) {
            JOptionPane.showMessageDialog(null, "Doctor actualizado correctamente.");
            paneldoctors.jTabbedPane.setSelectedIndex(0);
            resetEditingState();
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

        Doctors doctor = new Doctors(nombre, primerApellido, segundoApellido, identificacion, correo, telefono, contrasena, especialidad);
        if (modeldoctors.insertDoctor(doctor)) {
            JOptionPane.showMessageDialog(null, "Doctor registrado con éxito.");
            paneldoctors.jTabbedPane.setSelectedIndex(0);
            loadDoctors();
            cleanfields();
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar doctor.");
        }
    }
}
    
    
    
    
    
    
       private void cleanfields() {
        paneldoctors.TxtNombre.setText("");
        paneldoctors.TxtLastName.setText("");
        paneldoctors.TxtSecondLastname.setText("");
        paneldoctors.TxtId1.setText("");
        paneldoctors.Txtmail.setText("");
        paneldoctors.TxtPhone.setText("");
        paneldoctors.ComboSpecialty.setSelectedIndex(0);    
        paneldoctors.TxtPass.setText("");
        }
    
    
    
    
    
    
    
    
    
    
    
     private void handleAddAction() {
        if (!editando) {
            
            paneldoctors.jTabbedPane.setSelectedIndex(1);
        } else {
            JOptionPane.showMessageDialog(null, "Ya está editando un doctor. Finalice la edición primero.");
        }
    }
    
    
    
    
     
     private void updateDoctor() {
        String nombre = paneldoctors.TxtNombre.getText().trim();
        String primerApellido = paneldoctors.TxtLastName.getText().trim();
        String segundoApellido = paneldoctors.TxtSecondLastname.getText().trim();
        String correo = paneldoctors.Txtmail.getText().trim();
        String telefono = paneldoctors.TxtPhone.getText().trim();
        String contrasena = paneldoctors.TxtPass.getText();
        String especialidad = (String) paneldoctors.ComboSpecialty.getSelectedItem();
        
        boolean ok = modeldoctors.update(idOriginal, nombre, primerApellido, segundoApellido, correo, telefono, contrasena, especialidad);
        
        if (ok) {
            JOptionPane.showMessageDialog(null, "Doctor actualizado correctamente");
            resetEditingState();
        }
    }
     
     
     
     
     
     
     private void resetEditingState() {
        editando = false;
        idOriginal = "";
        paneldoctors.BtnContinue.setText("Guardar");
        paneldoctors.BtnOut.setVisible(true);
        paneldoctors.TxtId1.setEnabled(true);
        cleanfields();
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
                doctor.getContrasena(),
                doctor.getEspecialidad()
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
            paneldoctors.TxtId1.setText(idOriginal);
            paneldoctors.TxtNombre.setText(paneldoctors.DoctorsTable.getValueAt(fila, 0).toString());
            paneldoctors.TxtLastName.setText(paneldoctors.DoctorsTable.getValueAt(fila, 1).toString());
            paneldoctors.TxtSecondLastname.setText(paneldoctors.DoctorsTable.getValueAt(fila, 2).toString());
            paneldoctors.Txtmail.setText(paneldoctors.DoctorsTable.getValueAt(fila, 4).toString());
            paneldoctors.TxtPhone.setText(paneldoctors.DoctorsTable.getValueAt(fila, 5).toString());
            paneldoctors.TxtPass.setText(paneldoctors.DoctorsTable.getValueAt(fila, 6).toString());
            paneldoctors.ComboSpecialty.setSelectedItem(paneldoctors.DoctorsTable.getValueAt(fila, 7).toString());

            // preparamos modo edición
            editando = true;
            paneldoctors.BtnContinue.setText("Guardar cambios");
            paneldoctors.BtnOut.setVisible(false);
            paneldoctors.TxtId1.setEnabled(false);     // no se cambia la PK
            paneldoctors.jTabbedPane.setSelectedIndex(1);   // volvemos al form de alta
            }

    
    }
    
 
    
    
    
    public void searchDoctor() {
    String doctor = paneldoctors.TxtSearch.getText().trim();
    
    if (doctor.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Ingrese la  identificación que desea buscar", "Campo vacío", JOptionPane.WARNING_MESSAGE);
        return;
    }



    DefaultTableModel modelo = (DefaultTableModel) paneldoctors.DoctorsTable.getModel();
    boolean encontrado = false;

    for (int i = 0; i < modelo.getRowCount(); i++) {
        String idActual = modelo.getValueAt(i, 3
        ).toString();
        if (idActual.equalsIgnoreCase(doctor)) {
            // Selecciona la fila
            paneldoctors.DoctorsTable.setRowSelectionInterval(i, i);
            // Opcional: mover scroll para que se vea
            paneldoctors.DoctorsTable.scrollRectToVisible(paneldoctors.DoctorsTable.getCellRect(i, 0, true));
            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        JOptionPane.showMessageDialog(null, "No se encontró el doctor con esa identificación", "No encontrado", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    }
    
    
    
    
    
    
    
}

