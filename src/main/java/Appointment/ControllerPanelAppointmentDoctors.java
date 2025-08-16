
package Appointment;

import Patients.Patients;
import Record.History;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.LineSeparator;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
    generarComprobanteAsistencia();

    
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
    




















































public void generarComprobanteAsistencia() {
    int fila = panelappointmentdoctors.AppointmentTable.getSelectedRow();
    if (fila < 0) {
        JOptionPane.showMessageDialog(null,
                "Seleccione una cita de la tabla para generar el comprobante.",
                "Sin selección", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Obtener datos de la cita seleccionada
    String idCita = panelappointmentdoctors.AppointmentTable.getValueAt(fila, 0).toString();
    String fechaCita = panelappointmentdoctors.AppointmentTable.getValueAt(fila, 1).toString();
    String hora = panelappointmentdoctors.AppointmentTable.getValueAt(fila, 2).toString();
    String idPaciente = panelappointmentdoctors.AppointmentTable.getValueAt(fila, 3).toString();
    String area = panelappointmentdoctors.AppointmentTable.getValueAt(fila, 4).toString();
    String fechaRegistro = panelappointmentdoctors.AppointmentTable.getValueAt(fila, 5).toString();
    String estado = panelappointmentdoctors.AppointmentTable.getValueAt(fila, 6).toString();

    // Cargar datos completos del paciente
    Patients paciente = modelpanelappointmentdoctors.cargarDatosPaciente(idPaciente);
    if (paciente == null) {
        JOptionPane.showMessageDialog(null,
                "No se pudieron cargar los datos del paciente.",
                "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        // Configurar documento
        Document document = new Document(PageSize.A4, 40, 40, 50, 50);
        
        String userHome = System.getProperty("user.home");
        File escritorio = new File(userHome, "Desktop");
        if (!escritorio.exists()) {
            escritorio.mkdirs();
        }
        
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = new File(escritorio, "Comprobante_Asistencia_" + idCita + "_" + timestamp + ".pdf").getAbsolutePath();
        
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
        
        // Footer automático con número de página
        writer.setPageEvent(new PdfPageEventHelper() {
            @Override
            public void onEndPage(PdfWriter writer, Document document) {
                try {
                    PdfContentByte cb = writer.getDirectContent();
                    com.lowagie.text.Font footerFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Color.GRAY);
                    Phrase footer = new Phrase("Comprobante generado el " + 
                                             new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()),
                                             footerFont);
                    ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, footer,
                                             document.getPageSize().getWidth() / 2,
                                             document.bottom() - 10, 0);
                } catch (Exception e) {
                    System.err.println("Error en footer: " + e.getMessage());
                }
            }
        });
        
        document.open();
        
        // === ENCABEZADO DEL COMPROBANTE ===
        com.lowagie.text.Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, Color.DARK_GRAY);
        Paragraph titulo = new Paragraph("COMPROBANTE DE ASISTENCIA MÉDICA", titleFont);
        titulo.setAlignment(Element.ALIGN_CENTER);
        titulo.setSpacingAfter(10);
        document.add(titulo);
        
        // Línea decorativa
        LineSeparator line1 = new LineSeparator();
        line1.setLineWidth(2);
        line1.setLineColor(Color.DARK_GRAY);
        document.add(new Chunk(line1));
        document.add(new Paragraph("\n"));
        
        // Número de comprobante
        com.lowagie.text.Font numberFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, Color.BLACK);
        Paragraph numeroComprobante = new Paragraph("Comprobante N°: " + idCita, numberFont);
        numeroComprobante.setAlignment(Element.ALIGN_RIGHT);
        numeroComprobante.setSpacingAfter(20);
        document.add(numeroComprobante);
        
        // === INFORMACIÓN DEL PACIENTE ===
        com.lowagie.text.Font sectionFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, Color.DARK_GRAY);
        Paragraph seccionPaciente = new Paragraph("INFORMACIÓN DEL PACIENTE", sectionFont);
        seccionPaciente.setSpacingAfter(10);
        document.add(seccionPaciente);
        
        // Tabla de datos del paciente
        PdfPTable tablaPaciente = new PdfPTable(2);
        tablaPaciente.setWidthPercentage(100);
        tablaPaciente.setWidths(new float[]{30f, 70f});
        tablaPaciente.setSpacingAfter(20);
        
        addInfoRow(tablaPaciente, "Identificación:", paciente.getIdentificacion());
        addInfoRow(tablaPaciente, "Nombre completo:", paciente.getNombre() + " " + 
                   paciente.getPrimerApellido() + " " + paciente.getSegundoApellido());
        addInfoRow(tablaPaciente, "Edad:", paciente.getEdad() + " años");
        addInfoRow(tablaPaciente, "Sexo:", paciente.getSexo());
        addInfoRow(tablaPaciente, "Teléfono:", paciente.getTelefono());
        addInfoRow(tablaPaciente, "Correo:", paciente.getCorreo());
        addInfoRow(tablaPaciente, "Dirección:", paciente.getDireccion());
        
        document.add(tablaPaciente);
        
        // === INFORMACIÓN DE LA CITA ===
        Paragraph seccionCita = new Paragraph("INFORMACIÓN DE LA CITA MÉDICA", sectionFont);
        seccionCita.setSpacingAfter(10);
        document.add(seccionCita);
        
        PdfPTable tablaCita = new PdfPTable(2);
        tablaCita.setWidthPercentage(100);
        tablaCita.setWidths(new float[]{30f, 70f});
        tablaCita.setSpacingAfter(20);
        
        addInfoRow(tablaCita, "Código de Cita:", idCita);
        addInfoRow(tablaCita, "Fecha de Cita:", formatearFecha(fechaCita));
        addInfoRow(tablaCita, "Hora:", hora);
        addInfoRow(tablaCita, "Especialidad:", area);
        addInfoRow(tablaCita, "Estado:", estado);
        addInfoRow(tablaCita, "Fecha de Registro:", formatearFecha(fechaRegistro));
        
        document.add(tablaCita);
        
        // === INFORMACIÓN DE PAGO (si aplica) ===
        if ("Atendida".equalsIgnoreCase(estado)) {
            Paragraph seccionPago = new Paragraph("INFORMACIÓN DE PAGO", sectionFont);
            seccionPago.setSpacingAfter(10);
            document.add(seccionPago);
            
            // Calcular montos según especialidad
            double monto = calcularMontoPorEspecialidad(area);
            double iva = monto * 0.13;
            double montoFinal = monto + iva;
            
            PdfPTable tablaPago = new PdfPTable(2);
            tablaPago.setWidthPercentage(100);
            tablaPago.setWidths(new float[]{30f, 70f});
            tablaPago.setSpacingAfter(20);
            
            addInfoRow(tablaPago, "Monto Base:", String.format("₡%.3f", monto));
            addInfoRow(tablaPago, "IVA (13%):", String.format("₡%.3f", iva));
            addInfoRow(tablaPago, "TOTAL PAGADO:", String.format("₡%.3f", montoFinal));
            addInfoRow(tablaPago, "Fecha de Pago:", formatearFecha(new Date()));
            
            document.add(tablaPago);
        }
        
        // === CERTIFICACIÓN ===
        document.add(new Paragraph("\n\n"));
        LineSeparator line2 = new LineSeparator();
        line2.setLineWidth(1);
        line2.setLineColor(Color.LIGHT_GRAY);
        document.add(new Chunk(line2));
        
        com.lowagie.text.Font certFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Color.BLACK);
        Paragraph certificacion = new Paragraph(
            "\nCERTIFICACIÓN\n\n" +
            "Por medio del presente documento se certifica que el paciente arriba mencionado " +
            ("Atendida".equalsIgnoreCase(estado) ? "ASISTIÓ" : "TIENE PROGRAMADA") +
            " su cita médica en la especialidad de " + area + 
            " el día " + formatearFecha(fechaCita) + " a las " + hora + ".\n\n" +
            "Este comprobante es válido para fines laborales, académicos y administrativos que lo requieran.",
            certFont
        );
        certificacion.setAlignment(Element.ALIGN_JUSTIFIED);
        certificacion.setSpacingAfter(30);
        document.add(certificacion);
        
        // === FIRMA Y SELLO ===
        com.lowagie.text.Font firmaFont = FontFactory.getFont(FontFactory.HELVETICA, 10, Color.BLACK);
        
        // Crear tabla para firmas
        PdfPTable tablaFirmas = new PdfPTable(2);
        tablaFirmas.setWidthPercentage(100);
        tablaFirmas.setWidths(new float[]{50f, 50f});
        
        // Celda izquierda - Firma del médico
        PdfPCell celdaFirmaMedico = new PdfPCell();
        celdaFirmaMedico.setBorder(Rectangle.NO_BORDER);
        celdaFirmaMedico.setHorizontalAlignment(Element.ALIGN_CENTER);
        celdaFirmaMedico.addElement(new Paragraph("\n\n\n"));
        celdaFirmaMedico.addElement(new Paragraph("_______________________________", firmaFont));
        celdaFirmaMedico.addElement(new Paragraph("Firma del Médico", firmaFont));
        celdaFirmaMedico.addElement(new Paragraph("Dr./Dra. [Nombre del Médico]", firmaFont));
        celdaFirmaMedico.addElement(new Paragraph("Código Médico: [Número]", firmaFont));
        
        // Celda derecha - Sello de la clínica
        PdfPCell celdaSello = new PdfPCell();
        celdaSello.setBorder(Rectangle.NO_BORDER);
        celdaSello.setHorizontalAlignment(Element.ALIGN_CENTER);
        celdaSello.addElement(new Paragraph("\n\n\n"));
        celdaSello.addElement(new Paragraph("_______________________________", firmaFont));
        celdaSello.addElement(new Paragraph("Sello de la Clínica", firmaFont));
        
        tablaFirmas.addCell(celdaFirmaMedico);
        tablaFirmas.addCell(celdaSello);
        
        document.add(tablaFirmas);
        
        // === PIE DE PÁGINA FINAL ===
        document.add(new Paragraph("\n"));
        com.lowagie.text.Font disclaimerFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Color.GRAY);
        Paragraph disclaimer = new Paragraph(
            "Este es un documento generado automáticamente por el Sistema de Gestión Médica.\n" +
            "Para verificar la autenticidad de este comprobante, contacte a la clínica con el código: " + idCita,
            disclaimerFont
        );
        disclaimer.setAlignment(Element.ALIGN_CENTER);
        document.add(disclaimer);
        
        document.close();
        
        // Abrir automáticamente
        abrirPDFAutomaticamente(filePath);
        
        // Mensaje de éxito
        JOptionPane.showMessageDialog(null,
            "✅ Comprobante generado exitosamente\n" +
            "📁 Ubicación: " + filePath + "\n" +
            "👤 Paciente: " + paciente.getNombre() + " " + paciente.getPrimerApellido() + "\n" +
            "📅 Cita: " + formatearFecha(fechaCita) + " - " + hora,
            "Comprobante Generado",
            JOptionPane.INFORMATION_MESSAGE);
            
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null,
                "❌ Error al generar el comprobante:\n" + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}

// === MÉTODOS AUXILIARES ===
private void addInfoRow(PdfPTable table, String label, String value) {
        com.lowagie.text.Font labelFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, Color.DARK_GRAY);
        com.lowagie.text.Font valueFont = FontFactory.getFont(FontFactory.HELVETICA, 10, Color.BLACK);
    
    PdfPCell labelCell = new PdfPCell(new Phrase(label, labelFont));
    labelCell.setBackgroundColor(new Color(248, 249, 250));
    labelCell.setPadding(8);
    labelCell.setBorder(Rectangle.BOX);
    labelCell.setBorderWidth(0.5f);
    labelCell.setBorderColor(Color.LIGHT_GRAY);
    
    PdfPCell valueCell = new PdfPCell(new Phrase(value != null ? value : "N/A", valueFont));
    valueCell.setPadding(8);
    valueCell.setBorder(Rectangle.BOX);
    valueCell.setBorderWidth(0.5f);
    valueCell.setBorderColor(Color.LIGHT_GRAY);
    
    table.addCell(labelCell);
    table.addCell(valueCell);
}

private double calcularMontoPorEspecialidad(String especialidad) {
    switch (especialidad) {
        case "Medico General": return 50000;
        case "Odontologo": return 30000;
        case "Pediatra": return 40000;
        case "Dermatologo": return 50000;
        case "Psiquiatra": return 50000;
        case "Nutricionista": return 25000;
        default: return 35000;
    }
}

private String formatearFecha(String fecha) {
    try {
        SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatoSalida = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
        Date date = formatoEntrada.parse(fecha);
        return formatoSalida.format(date);
    } catch (Exception e) {
        return fecha; // Si no se puede formatear, devolver la fecha original
    }
}

private String formatearFecha(Date fecha) {
    SimpleDateFormat formatoSalida = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
    return formatoSalida.format(fecha);
}

// Método para abrir PDF automáticamente (reutilizar del código anterior)
private void abrirPDFAutomaticamente(String filePath) {
    try {
        File pdfFile = new File(filePath);
        
        if (!pdfFile.exists()) {
            System.err.println("El archivo PDF no existe: " + filePath);
            return;
        }
        
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.OPEN)) {
                desktop.open(pdfFile);
                System.out.println("Comprobante abierto automáticamente: " + filePath);
            }
        }
        
    } catch (Exception e) {
        System.err.println("Error al abrir comprobante automáticamente: " + e.getMessage());
    }
}




    
}