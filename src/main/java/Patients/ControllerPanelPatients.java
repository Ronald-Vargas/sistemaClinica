
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

    public ControllerPanelPatients(PanelPatients panelpatients, ModelPanelPatients modelpanelpatients) {
        this.panelpatients = panelpatients;
        this.modelpanelpatients = modelpanelpatients;
        
        initializeListeners();
        loadPatients();
    }
    
    
    private void initializeListeners() {
        this.panelpatients.BtnEdit.addActionListener(this);
        this.panelpatients.BtnInfo.addActionListener(this);
        this.panelpatients.BtnDelete.addActionListener(this);
    }
    
    
    
    @Override
     public void actionPerformed(ActionEvent e) {
    
    if (e.getSource() == panelpatients.BtnEdit) {
    
    }else if (e.getSource() == panelpatients.BtnInfo) {
     
    }else if (e.getSource() == panelpatients.BtnDelete) {
    deleteDoctor();
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
                "¿Estás seguro de eliminar la informacion del paciente?, Se perdera la información.",
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
    
    
    
    
    
    
    
    
}
