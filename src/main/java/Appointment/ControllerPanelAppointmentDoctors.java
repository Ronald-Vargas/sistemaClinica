
package Appointment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;





public class ControllerPanelAppointmentDoctors implements ActionListener {


    private ModelPanelAppointmentDoctors modelpanelappointmentdoctors;
    private PanelAppointmentDoctors panelappointmentdoctors;

    public ControllerPanelAppointmentDoctors(ModelPanelAppointmentDoctors modelpanelappointmentdoctors, PanelAppointmentDoctors panelappointmentdoctors) {
        this.modelpanelappointmentdoctors = modelpanelappointmentdoctors;
        this.panelappointmentdoctors = panelappointmentdoctors;
        
        initializeListeners();
        loadDoctors();
    }
    
    
    
    
    public void initializeListeners() {
    this.panelappointmentdoctors.BtnEdit.addActionListener(this);
    this.panelappointmentdoctors.BtnPDF.addActionListener(this);
    this.panelappointmentdoctors.BtnDelete.addActionListener(this);
    
    
    }
    
    
    
    @Override
    public void actionPerformed (ActionEvent e) {
    
    if (e.getSource() == panelappointmentdoctors.BtnEdit) {
    
    
    } else if (e.getSource() == panelappointmentdoctors.BtnPDF) {
    
    
    } else if (e.getSource() == panelappointmentdoctors.BtnDelete) {
    deleteAppointment();
    }
    
    
    
    }
    
    
    
    
    
    public void loadDoctors() {
        List<Appointment> lista = modelpanelappointmentdoctors.obtainAppointment();
        DefaultTableModel tableModel = (DefaultTableModel) panelappointmentdoctors.AppointmentTable.getModel();
        tableModel.setRowCount(0); 

        for (Appointment appointment : lista) {
            tableModel.addRow(new Object[]{
                appointment.getIdCita(),
                appointment.getFechaCita(),
                appointment.getHora(),
                appointment.getFechaRegistro(),
                appointment.getEstado(),
                appointment.getArea(),
                appointment.getId()


            });
        }
    }
    
    
    
    
    
    
    public void deleteAppointment() {
    int fila = panelappointmentdoctors.AppointmentTable.getSelectedRow();

    if (fila >= 0) {
        String idCita = panelappointmentdoctors.AppointmentTable.getValueAt(fila, 0).toString();
        int confirm = JOptionPane.showConfirmDialog(null,
                "¿Estás seguro de eliminar la informacion de la cita?",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean eliminado = modelpanelappointmentdoctors.deleteAppointment(idCita);
            if (eliminado) {
                JOptionPane.showMessageDialog(null, "Cita eliminado correctamente.");
                loadDoctors();  
            }
        }

    } else {
       JOptionPane.showMessageDialog(null,
                        "Seleccione una cita de la tabla.",
                        "Sin selección", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
