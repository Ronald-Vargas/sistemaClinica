
package Appointment;

import Patients.Patients;
import Record.History;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    
     // Variables de pago
    private double monto = 0;
    private double iva = 0;
    private double montoFinal = 0;
    private String montoFinalStr = "";
  
    

    public ControllerPanelAppointmentDoctors(ModelPanelAppointmentDoctors modelpanelappointmentdoctors, PanelAppointmentDoctors panelappointmentdoctors) {
        this.modelpanelappointmentdoctors = modelpanelappointmentdoctors;
        this.panelappointmentdoctors = panelappointmentdoctors;
        
        initializeListeners();
        loadAppointment();
        initializeFilters();
        
        
    }
    
    
    
    
    public void initializeListeners() {
    this.panelappointmentdoctors.BtnEdit.addActionListener(this);
    this.panelappointmentdoctors.BtnPDF.addActionListener(this);
    this.panelappointmentdoctors.BtnDelete.addActionListener(this);
    this.panelappointmentdoctors.BtnUpdate.addActionListener(this);
    this.panelappointmentdoctors.BtnX.addActionListener(this);
    this.panelappointmentdoctors.BtnRegistrarPago.addActionListener(this);
    this.panelappointmentdoctors.BtnCancel.addActionListener(this);
    this.panelappointmentdoctors.BtnPagar.addActionListener(this);
    }
    
    
    
    
    public void initializeFilters() {
    DefaultTableModel modelo = (DefaultTableModel) panelappointmentdoctors.AppointmentTable.getModel();
    sorter = new TableRowSorter<>(modelo);
    panelappointmentdoctors.AppointmentTable.setRowSorter(sorter);

    // Listener para el ComboBox de estado
    panelappointmentdoctors.ComboFilter.addActionListener(e -> applyCombinedFilters());

    // Listener para el JDateChooser de fecha
    panelappointmentdoctors.ComboSearch.addPropertyChangeListener("date", evt -> applyCombinedFilters());
    
     panelappointmentdoctors.TxtSearchId.addKeyListener(new KeyAdapter() {
        @Override
        public void keyReleased(KeyEvent e) {
            applyCombinedFilters();
        }
    });
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
    } else if (e.getSource() == panelappointmentdoctors.BtnRegistrarPago) {
    realizarPago();
    } else if (e.getSource() == panelappointmentdoctors.BtnCancel) {
     JOptionPane.showMessageDialog(null, "Se cancelo el cobro de la cita", "", JOptionPane.INFORMATION_MESSAGE);
     panelappointmentdoctors.jTabbedPane1.setSelectedIndex(0);
     cleanFields();
    } else if (e.getSource() == panelappointmentdoctors.BtnPagar) {
    pagarCita();

    }
    
    
    
    }
    
    
    
    
    
    public void loadAppointment() {
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
    
    
    
    
    
    private void pagarCita() {
    String idCita = panelappointmentdoctors.TxtIdCita4.getText();
    if (idCita.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No hay cita seleccionada para pagar.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Fecha y hora del pago
    LocalDateTime ahora = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String fechaPago = ahora.format(formatter);

    // Actualizar estado a Atendida
    boolean actualizado = modelpanelappointmentdoctors.actualizarEstadoCita(idCita, "Atendida");
    if (!actualizado) {
        JOptionPane.showMessageDialog(null, "No se pudo actualizar el estado de la cita.", "Error SQL", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Guardar fecha de pago
    modelpanelappointmentdoctors.registrarFechaPago(idCita, fechaPago);

    // Obtener datos completos de cita y paciente
    Appointment cita = modelpanelappointmentdoctors.obtenerCitaPorId(idCita);
    if (cita == null) {
        JOptionPane.showMessageDialog(null, "No se encontró la cita para registrar el historial.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    Patients paciente = modelpanelappointmentdoctors.cargarDatosPaciente(cita.getId());
    if (paciente == null) {
        JOptionPane.showMessageDialog(null, "No se encontró el paciente para registrar el historial.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Crear objeto History usando montoFinalStr calculado
    History historial = new History(
        cita.getIdCita(),
        cita.getFechaCita(),
        cita.getHora(),
        cita.getArea(),
        paciente.getIdentificacion(),
        paciente.getPrimerApellido(),
        paciente.getSegundoApellido(),
        paciente.getTelefono(),
        paciente.getCorreo(),
        paciente.getDireccion(),
        paciente.getEdad(),
        paciente.getResponsable(),
        paciente.getEstadoCivil(),
        paciente.getSexo(),
        paciente.getOcupacion(),
        paciente.getFechaNacimiento(),
        fechaPago,
        montoFinalStr
    );

    // Insertar historial
    boolean insertado = modelpanelappointmentdoctors.insertarHistorial(historial);
    if (!insertado) {
        JOptionPane.showMessageDialog(null, "No se pudo registrar el historial.", "Error SQL", JOptionPane.ERROR_MESSAGE);
        return;
    }

    JOptionPane.showMessageDialog(null, "Pago registrado y cita marcada como Atendida.");
    loadAppointment();
    panelappointmentdoctors.jTabbedPane1.setSelectedIndex(0);
    cleanFields();
}
    
    
    
    
    
    public void deleteAppointment() {
    int fila = panelappointmentdoctors.AppointmentTable.getSelectedRow();

    if (fila >= 0) {
        String idCita = panelappointmentdoctors.AppointmentTable.getValueAt(fila, 0).toString();
        int confirm = JOptionPane.showConfirmDialog(null,
                "¿Estás seguro de eliminar la información de la cita?",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean eliminado = modelpanelappointmentdoctors.deleteAppointment(idCita);
            if (eliminado) {
                JOptionPane.showMessageDialog(null, "Cita eliminada correctamente.");
                loadAppointment();  
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
            loadAppointment();
        }
    }
    
    
    
    
    
    private void cleanFields() {
    panelappointmentdoctors.TxtIdPaciente.setText("");
    panelappointmentdoctors.TxtIdCita.setText("");
    panelappointmentdoctors.TxtMonto.setText("");
    panelappointmentdoctors.TxtIVA.setText("");
    panelappointmentdoctors.TxtMontoFinal.setText("");

    }
    
    
    
    
    
    
    
    
    
    
    
   public void realizarPago() {
    int fila = panelappointmentdoctors.AppointmentTable.getSelectedRow();
    if (fila < 0) {
        JOptionPane.showMessageDialog(null,
                "Seleccione una cita de la tabla.",
                "Sin selección", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Obtener datos de la tabla
    String idCita = panelappointmentdoctors.AppointmentTable.getValueAt(fila, 0).toString();
    String idPaciente = panelappointmentdoctors.AppointmentTable.getValueAt(fila, 3).toString();
    String especialidad = panelappointmentdoctors.AppointmentTable.getValueAt(fila, 4).toString();
    String fechaCita = panelappointmentdoctors.AppointmentTable.getValueAt(fila, 1).toString();
    String hora = panelappointmentdoctors.AppointmentTable.getValueAt(fila, 2).toString();
    String estado = panelappointmentdoctors.AppointmentTable.getValueAt(fila, 6).toString();

    // Calcular montos según especialidad
    double monto = 0;
    switch (especialidad) {
        case "Medico General": monto = 50000; break;
        case "Odontologo": monto = 30000; break;
        case "Pediatra": monto = 40000; break;
        case "Dermatologo": monto = 50000; break;
        case "Psiquiatra": monto = 50000; break;
        case "Nutricionista": monto = 25000; break;
    }

    double iva = monto * 0.13;
    double montoFinal = monto + iva;

    // Formatear a String para mostrar
    panelappointmentdoctors.TxtMonto.setText(String.format("%.3f", monto));
    panelappointmentdoctors.TxtIVA.setText(String.format("%.3f", iva));
    panelappointmentdoctors.TxtMontoFinal.setText(String.format("%.3f", montoFinal));

    // Llenar campos de pago
    panelappointmentdoctors.TxtIdCita4.setText(idCita);
    panelappointmentdoctors.TxtIdPaciente4.setText(idPaciente);
    panelappointmentdoctors.ComboEspecialidad4.setText(especialidad);
    panelappointmentdoctors.ComboFechaCita4.setText(fechaCita);
    panelappointmentdoctors.ComboHora4.setText(hora);
    panelappointmentdoctors.ComboEstado4.setText(estado);

    // Datos del paciente
    Patients paciente = modelpanelappointmentdoctors.cargarDatosPaciente(idPaciente);
    if (paciente != null) {
        panelappointmentdoctors.TxtNombre4.setText(paciente.getNombre());
        panelappointmentdoctors.TxtPrimerApellido4.setText(paciente.getPrimerApellido());
        panelappointmentdoctors.TxtSegundoApellido4.setText(paciente.getSegundoApellido());
    }

    // Guardar montoFinal en variable de instancia para pagarCita()
    this.montoFinalStr = String.format("%.3f", montoFinal);

    // Cambiar pestaña a pago
    panelappointmentdoctors.jTabbedPane1.setSelectedIndex(2);
}
    
    
    
    
   
    
    
    
    
     public void modifyAppointment() {
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
    
    
    
    
    
    
    

private void applyCombinedFilters() {
  List<RowFilter<Object, Object>> filtros = new ArrayList<>();

    // Filtro por fecha (columna 1)
    Date fechaSeleccionada = panelappointmentdoctors.ComboSearch.getDate();

    // Filtro por estado (columna 6)
    String estadoSeleccionado = panelappointmentdoctors.ComboFilter.getSelectedItem().toString();

    // Filtro por texto en TxtSearchId (columna 0)
    String textoBusqueda = panelappointmentdoctors.TxtSearchId.getText().trim();

    // Agregar filtro fecha solo si hay fecha seleccionada
    if (fechaSeleccionada != null) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaTexto = sdf.format(fechaSeleccionada);
        filtros.add(RowFilter.regexFilter("^" + fechaTexto + "$", 1));
    }

    // Agregar filtro estado solo si no es "Todas"
    if (!estadoSeleccionado.equalsIgnoreCase("Todas")) {
        filtros.add(RowFilter.regexFilter("^" + estadoSeleccionado + "$", 6));
    }

    // Agregar filtro texto solo si no está vacío
    if (!textoBusqueda.isEmpty()) {
        filtros.add(RowFilter.regexFilter("(?i)" + textoBusqueda, 3));
    }

    // Si no hay filtros activos, quitar filtros para mostrar todo
    if (filtros.isEmpty()) {
        sorter.setRowFilter(null);
    } else {
        sorter.setRowFilter(RowFilter.andFilter(filtros));
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
}