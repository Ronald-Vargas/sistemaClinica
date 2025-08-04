package Doctors;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class ControllerDoctors implements ActionListener {

    private ModelDoctors model;
    private menuDoctors menu;
    private PanelDoctors panel;

    public ControllerDoctors(ModelDoctors model, menuDoctors menu, PanelDoctors panel) {
        this.model = model;
        this.menu = menu;
        this.panel = panel;

        // Escuchar botón continuar del menú de ingreso
        this.menu.BtnContinue.addActionListener(this);

        // Escuchar botón agregar del panel de tabla
        this.panel.btnAgregar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Evento al presionar "Continuar" en menuDoctors
        if (e.getSource() == menu.BtnContinue) {
            registrarDoctor();
        }

        // Evento al presionar "Agregar" en PanelDoctors
        else if (e.getSource() == panel.btnAgregar) {
            mostrarPanelIngreso();
        }
    }
 
    private void registrarDoctor() {
        // Obtener datos de los campos
        String nombre = menu.TxtNombre.getText();
        String primerApellido = menu.TxtLastName.getText();
        String segundoApellido = menu.TxtSecondLastname.getText();
        String identificacion = menu.TxtId1.getText();
        String correo = menu.Txtmail.getText();
        String telefono = menu.TxtPhone.getText();

        if (nombre.isEmpty() || primerApellido.isEmpty() || identificacion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor complete los campos obligatorios.");
            return;
        }

        Doctors doctor = new Doctors(null, nombre, primerApellido, segundoApellido, identificacion, correo, telefono);

        // Insertar en la base de datos
        if (model.insertDoctor(doctor)) {
            JOptionPane.showMessageDialog(null, "Doctor registrado con éxito.");
            menu.setVisible(false);
            panel.setVisible(true);
            loadDoctors(); // recargar la tabla
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar doctor.");
        }
    }

    private void mostrarPanelIngreso() {
        // Cambiar de panel: mostrar formulario, ocultar tabla
        menu.setVisible(true);
        panel.setVisible(false);
        limpiarFormulario();
    }

    private void limpiarFormulario() {
        menu.TxtNombre.setText("");
        menu.TxtLastName.setText("");
        menu.TxtSecondLastname.setText("");
        menu.TxtId1.setText("");
        menu.Txtmail.setText("");
        menu.TxtPhone.setText("");
    }

    public void loadDoctors() {
        List<Doctors> lista = model.obtainDoctors();
        DefaultTableModel tableModel = (DefaultTableModel) panel.tablaDoctores.getModel();
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
    
    public void initDoctors() {
    menuDoctors PanelDoctors = new menuDoctors();
    PanelDoctors.setSize(1020, 720);
    PanelDoctors.setLocation(0,0);
  
   }  
}
