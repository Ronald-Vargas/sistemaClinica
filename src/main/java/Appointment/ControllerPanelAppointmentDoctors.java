
package Appointment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;





public class ControllerPanelAppointmentDoctors implements ActionListener {


    private ModelPanelAppointmentDoctors modelpanelappointmentdoctors;
    private PanelAppointmentDoctors panelappointmentdoctors;
    private TableRowSorter<DefaultTableModel> sorter;
    private String idOriginal = ""; 
    
    

    public ControllerPanelAppointmentDoctors(ModelPanelAppointmentDoctors modelpanelappointmentdoctors, PanelAppointmentDoctors panelappointmentdoctors) {
        this.modelpanelappointmentdoctors = modelpanelappointmentdoctors;
        this.panelappointmentdoctors = panelappointmentdoctors;
        
        initializeListeners();
        loadDoctors();
        initializeFilters();
        
        
    }
    
    
    
    
    public void initializeListeners() {
    this.panelappointmentdoctors.BtnEdit.addActionListener(this);
    this.panelappointmentdoctors.BtnPDF.addActionListener(this);
    this.panelappointmentdoctors.BtnDelete.addActionListener(this);
    this.panelappointmentdoctors.BtnUpdate.addActionListener(this);
    this.panelappointmentdoctors.BtnX.addActionListener(this);

    }
    
    
    
    
    public void initializeFilters() {
    DefaultTableModel modelo = (DefaultTableModel) panelappointmentdoctors.AppointmentTable.getModel();
    sorter = new TableRowSorter<>(modelo);
    panelappointmentdoctors.AppointmentTable.setRowSorter(sorter);

    // Listener para el ComboBox de estado
    panelappointmentdoctors.ComboFilter.addActionListener(e -> applyCombinedFilters());

    // Listener para el JDateChooser de fecha
    panelappointmentdoctors.ComboSearch.addPropertyChangeListener("date", evt -> applyCombinedFilters());
}
    
    
    
    
    
    
    
    @Override
    public void actionPerformed (ActionEvent e) {
    
    if (e.getSource() == panelappointmentdoctors.BtnEdit) {
    modifyAppointment();
    
    } else if (e.getSource() == panelappointmentdoctors.BtnPDF) {
    
    
    } else if (e.getSource() == panelappointmentdoctors.BtnDelete) {
    deleteAppointment();
    } else if (e.getSource() == panelappointmentdoctors.BtnUpdate) {
    updateAppointment();
    
    } else if (e.getSource() == panelappointmentdoctors.BtnX) {
    JOptionPane.showMessageDialog(null, "Se cancelo la actualización de la cita", "", JOptionPane.INFORMATION_MESSAGE);
    panelappointmentdoctors.jTabbedPane1.setSelectedIndex(0);
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
    
    
    
    
    
    
    
    
    private void updateAppointment() {
        Date fechaCitaDate = panelappointmentdoctors.ComboFechaCita.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaCita = sdf.format(fechaCitaDate);
        
        String hora = panelappointmentdoctors.ComboHora.getText().trim(); // elimina espacios

        // Si la columna en SQL es TIME, conviene que sea HH:mm
        if (hora.matches("^\\d{1}:\\d{2}$")) { 
        hora = "0" + hora; // agrega cero si es de una sola cifra
        }       
        String idPaciente = panelappointmentdoctors.TxtIdPaciente.getText().trim();
        String especialiadad = (String) panelappointmentdoctors.ComboEspecialidad.getSelectedItem();
        Date fechaRegistroDate = panelappointmentdoctors.ComboFechaRegistro.getDate();
        String fechaRegistro = sdf.format(fechaRegistroDate);
        
        boolean ok = modelpanelappointmentdoctors.update(idOriginal, fechaCita, hora, idPaciente, especialiadad, fechaRegistro);
        
        if (ok) {
            JOptionPane.showMessageDialog(null, "Cita actualizada correctamente");
            panelappointmentdoctors.jTabbedPane1.setSelectedIndex(0);
            cleanFields();
            loadDoctors();
        }
    }
    
    
    
    
    
    private void cleanFields() {
    panelappointmentdoctors.TxtIdPaciente.setText("");
    panelappointmentdoctors.TxtIdCita.setText("");
   
    }
    
    
    
    
    
    
    
    
    
    
    
    
     public void modifyAppointment(){
    int fila = panelappointmentdoctors.AppointmentTable.getSelectedRow();
    if (fila < 0) {
        JOptionPane.showMessageDialog(null,
                "Seleccione una cita de la tabla.",
                "Sin selección", JOptionPane.ERROR_MESSAGE);
        return;
    }

    idOriginal = panelappointmentdoctors.AppointmentTable.getValueAt(fila, 0).toString();
    panelappointmentdoctors.TxtIdCita.setText(idOriginal);

    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); // Ajustar al formato real de la tabla
    try {
        String fechaCitaStr = panelappointmentdoctors.AppointmentTable.getValueAt(fila, 1).toString();
        Date fechaCita = formato.parse(fechaCitaStr);
        panelappointmentdoctors.ComboFechaCita.setDate(fechaCita);

        panelappointmentdoctors.ComboHora.setText(panelappointmentdoctors.AppointmentTable.getValueAt(fila, 2).toString());
        panelappointmentdoctors.TxtIdPaciente.setText(panelappointmentdoctors.AppointmentTable.getValueAt(fila, 3).toString());
        panelappointmentdoctors.ComboEspecialidad.setSelectedItem(panelappointmentdoctors.AppointmentTable.getValueAt(fila, 4).toString());

        String fechaRegistroStr = panelappointmentdoctors.AppointmentTable.getValueAt(fila, 5).toString();
        Date fechaRegistro = formato.parse(fechaRegistroStr);
        panelappointmentdoctors.ComboFechaRegistro.setDate(fechaRegistro);

    } catch (ParseException e) {
        e.printStackTrace();
    }

    panelappointmentdoctors.jTabbedPane1.setSelectedIndex(1);
    }
    
    
    
    
    
    
    
   // Método que aplica ambos filtros
private void applyCombinedFilters() {
    List<RowFilter<Object, Object>> filtros = new ArrayList<>();

    // 1️⃣ Filtro por fecha (columna 1)
    Date fechaSeleccionada = panelappointmentdoctors.ComboSearch.getDate();
    if (fechaSeleccionada != null) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // ajusta formato
        String fechaTexto = sdf.format(fechaSeleccionada);
        filtros.add(RowFilter.regexFilter("^" + fechaTexto + "$", 1));
    }

    // 2️⃣ Filtro por estado (columna 6)
    String estadoSeleccionado = panelappointmentdoctors.ComboFilter.getSelectedItem().toString();
    if (!estadoSeleccionado.equalsIgnoreCase("Todas")) {
        filtros.add(RowFilter.regexFilter("^" + estadoSeleccionado + "$", 6));
    }

    // Aplica filtros combinados
    if (filtros.isEmpty()) {
        sorter.setRowFilter(null);
    } else {
        sorter.setRowFilter(RowFilter.andFilter(filtros));
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
}
