
package Patients;

import Doctors.Doctors;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ControllerPanelPatients implements ActionListener{
  
    
 private PanelPatients panelpatients;
 private ModelPanelPatients modelpanelpatients;
 private String idOriginal = "";  


    public ControllerPanelPatients(PanelPatients panelpatients, ModelPanelPatients modelpanelpatients) {
        this.panelpatients = panelpatients;
        this.modelpanelpatients = modelpanelpatients;
        
        initializeListeners();
        loadPatients();
        
        
        
         this.panelpatients.TxtSearch.addActionListener(new ActionListener() {
     @Override
            public void actionPerformed(ActionEvent e) {
                searchPatient();
            }
            });
        
        
    }
    
    
    private void initializeListeners() {
        this.panelpatients.BtnInfo.addActionListener(this);
        this.panelpatients.BtnDelete.addActionListener(this);
        this.panelpatients.BtnUpdate.addActionListener(this);
        this.panelpatients.BtnCheck.addActionListener(this);
        this.panelpatients.BtnX.addActionListener(this);
    }
    
    
    
    @Override
     public void actionPerformed(ActionEvent e) {
    
    if (e.getSource() == panelpatients.BtnInfo) {
     modifypatiets();
    }else if (e.getSource() == panelpatients.BtnDelete) {
    deleteDoctor();
    } else if (e.getSource() == panelpatients.BtnUpdate) {
    enableFields();
    } else if (e.getSource() == panelpatients.BtnCheck) {
    updatePatient();
    } else if (e.getSource() == panelpatients.BtnX) {
    JOptionPane.showMessageDialog(null, "Se cancelo la actualización", "Actualización de datos", JOptionPane.INFORMATION_MESSAGE);
    panelpatients.jTabbedPane1.setSelectedIndex(0);
    disableFields();
    } 
    
    
  
    }
    
     
     
     
     
     
     
    public void loadPatients() {
        List<Patients> lista = modelpanelpatients.obtainPatients();
        DefaultTableModel tableModel = (DefaultTableModel) panelpatients.PatientsTable.getModel();
        tableModel.setRowCount(0); 

        for (Patients patients : lista) {
            tableModel.addRow(new Object[]{
                patients.getNombre(),
                patients.getPrimerApellido(),
                patients.getSegundoApellido(),
                patients.getIdentificacion(),
                patients.getCorreo(),
                patients.getTelefono()

            });
        }
    } 
     
     
    
    
    public void deleteDoctor() {
    int fila = panelpatients.PatientsTable.getSelectedRow();

    if (fila >= 0) {
        String idDoctor = panelpatients.PatientsTable.getValueAt(fila, 3).toString();
        int confirm = JOptionPane.showConfirmDialog(null,
                "¿Estás seguro de eliminar la información del paciente?, Se perdera la información.",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean eliminado = modelpanelpatients.deletePatient(idDoctor);
            if (eliminado) {
                JOptionPane.showMessageDialog(null, "Paciente eliminado correctamente.");
                loadPatients();  
            }
        }

    } else {
       JOptionPane.showMessageDialog(null,
                        "Seleccione un paciente de la tabla.",
                        "Sin selección", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    
    
    
    
    
    
   public void modifypatiets() {
    int fila = panelpatients.PatientsTable.getSelectedRow();
    if (fila < 0) {
        JOptionPane.showMessageDialog(null,
                "Seleccione un paciente de la tabla.",
                "Sin selección", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Suponiendo que la identificación está en la columna 0
    String identificacion = panelpatients.PatientsTable.getValueAt(fila, 3).toString();

    Patients paciente = modelpanelpatients.obtenerPacientePorId(identificacion);

    if (paciente != null) {
        
        panelpatients.TxtId.setText(paciente.getIdentificacion());
        panelpatients.TxtNombre.setText(paciente.getNombre());
        panelpatients.TxtLastNameF.setText(paciente.getPrimerApellido());
        panelpatients.TxtLastNameM.setText(paciente.getSegundoApellido());
        panelpatients.TxtPhone.setText(paciente.getTelefono());
        panelpatients.TxtEmail.setText(paciente.getCorreo());
        panelpatients.ComboProvince.setSelectedItem(paciente.getDireccion()); 
        panelpatients.TxtAge.setText(paciente.getEdad());
        panelpatients.TxtResponsable.setText(paciente.getResponsable());
        panelpatients.TxtCivilStats.setSelectedItem(paciente.getEstadoCivil());
        panelpatients.TxtSex.setText(paciente.getSexo());
        panelpatients.TxtOcupation.setSelectedItem(paciente.getOcupacion());

        disableFields();
        panelpatients.jTabbedPane1.setSelectedIndex(1);
    } else {
        JOptionPane.showMessageDialog(null, "No se encontró el paciente en la base de datos.");
    }
}
    
    
   
   private void updatePatient() {
        idOriginal = panelpatients.TxtId.getText().trim();
        String nombre = panelpatients.TxtNombre.getText().trim();
        String primerApellido = panelpatients.TxtLastNameF.getText().trim();
        String segundoApellido = panelpatients.TxtLastNameM.getText().trim();
        String correo = panelpatients.TxtEmail.getText().trim();
        String telefono = panelpatients.TxtPhone.getText().trim();
        String direccion = (String) panelpatients.ComboProvince.getSelectedItem();
        String edad = panelpatients.TxtAge.getText().trim();
        String responsable = panelpatients.TxtResponsable.getText().trim();
        String estadoCivil = (String) panelpatients.TxtCivilStats.getSelectedItem();
        String sexo = panelpatients.TxtSex.getText().trim();
        String ocupacion = (String) panelpatients.TxtOcupation.getSelectedItem();
        String fechaNacimiento = null;
        
        boolean ok = modelpanelpatients.update(idOriginal, nombre, primerApellido, segundoApellido, correo, telefono, direccion, edad, responsable, estadoCivil, sexo, ocupacion, fechaNacimiento);
        
        if (ok) {
            JOptionPane.showMessageDialog(null, "Paciente actualizado correctamente");
            panelpatients.jTabbedPane1.setSelectedIndex(0);
            loadPatients();
        }
    }
   
   
   
   
   public void searchPatient() {
    String patient = panelpatients.TxtSearch.getText().trim();
    
    if (patient.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Ingrese la  identificación que desea buscar", "Campo vacío", JOptionPane.WARNING_MESSAGE);
        return;
    }



    DefaultTableModel modelo = (DefaultTableModel) panelpatients.PatientsTable.getModel();
    boolean encontrado = false;

    for (int i = 0; i < modelo.getRowCount(); i++) {
        String idActual = modelo.getValueAt(i, 3
        ).toString();
        if (idActual.equalsIgnoreCase(patient)) {
            panelpatients.PatientsTable.setRowSelectionInterval(i, i);
            panelpatients.PatientsTable.scrollRectToVisible(panelpatients.PatientsTable.getCellRect(i, 0, true));
            encontrado = true;
            break;
        }
    }

    if (!encontrado) {
        JOptionPane.showMessageDialog(null, "No se encontró el paciente con esa identificación", "No encontrado", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    }
   
   
   
   
   
   
    
    
    
    private void disableFields() {
    panelpatients.TxtId.disable();
    panelpatients.TxtNombre.disable();
    panelpatients.TxtLastNameF.disable();
    panelpatients.TxtLastNameM.disable();
    panelpatients.TxtPhone.disable();      
    panelpatients.TxtEmail.disable();
    panelpatients.ComboProvince.disable();       
    panelpatients.TxtAge.disable();
    panelpatients.TxtResponsable.disable();
    panelpatients.TxtCivilStats.disable();
    panelpatients.TxtSex.disable();
    panelpatients.TxtOcupation.disable();  
    panelpatients.BtnX.setVisible(false);
    panelpatients.BtnCheck.setVisible(false);  
     }
    
    
    private void enableFields() {
    panelpatients.TxtNombre.enable(true);
    panelpatients.TxtLastNameF.enable(true);
    panelpatients.TxtLastNameM.enable(true);
    panelpatients.TxtPhone.enable(true);      
    panelpatients.TxtEmail.enable(true);
    panelpatients.ComboProvince.enable(true);       
    panelpatients.TxtAge.enable(true);
    panelpatients.TxtResponsable.enable(true);
    panelpatients.TxtCivilStats.enable(true);
    panelpatients.TxtSex.enable(true);
    panelpatients.TxtOcupation.enable(true); 
    panelpatients.BtnX.setVisible(true);
    panelpatients.BtnCheck.setVisible(true);  
     }
    
    
    
    
    
    
    
}
