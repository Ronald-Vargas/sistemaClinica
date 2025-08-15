
package Record;

import About.About;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.Color;
import java.util.Locale;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.Chunk;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.draw.DrawInterface;
import com.lowagie.text.pdf.draw.LineSeparator;
import java.awt.Desktop;



public class ControllerPanelRecord implements ActionListener{
    
   private ModelPanelRecord modelpanelrecord;
   private PanelRecord panelrecord;
   private TableRowSorter<DefaultTableModel> sorter;
   
   
   
    public ControllerPanelRecord(ModelPanelRecord modelpanelrecord, PanelRecord panelrecord) {
        this.modelpanelrecord = modelpanelrecord;
        this.panelrecord = panelrecord;
        
        loadHistory();
        initializeFilters();
        initializeListeners();
    }
    
    
    
    
    private void initializeListeners() {
        this.panelrecord.BtnDelete.addActionListener(this);
        this.panelrecord.BtnPDF.addActionListener(this);

    }
    
    
    
    
    
    
    
    @Override
    public void actionPerformed (ActionEvent e) {
    
        if(e.getSource() == panelrecord.BtnDelete) {
        deleteDoctor();
       
            
            
        } else if (e.getSource() == panelrecord.BtnPDF) {
       int fila = panelrecord.HistoryTable.getSelectedRow();

        if (fila >= 0) {
        generarReportePDF();

       } else {
       JOptionPane.showMessageDialog(null,
                        "Seleccione un registro de la tabla.",
                        "Sin selección", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    public void initializeFilters() {
    DefaultTableModel modelo = (DefaultTableModel) panelrecord.HistoryTable.getModel();
    sorter = new TableRowSorter<>(modelo);
    panelrecord.HistoryTable.setRowSorter(sorter);

    // Listener para el ComboBox de estado
    panelrecord.ComboFilter.addActionListener(e -> applyCombinedFilters());

    // Listener para el JDateChooser de fecha
    panelrecord.ComboSearch.addPropertyChangeListener("date", evt -> applyCombinedFilters());
    
     panelrecord.TxtSearchId.addKeyListener(new KeyAdapter() {
        @Override
        public void keyReleased(KeyEvent e) {
            applyCombinedFilters();
        }
    });
}
    
    
    
    
    
       
    public void deleteDoctor() {
    int fila = panelrecord.HistoryTable.getSelectedRow();

    if (fila >= 0) {
        String idHitory = panelrecord.HistoryTable.getValueAt(fila, 1).toString();
        int confirm = JOptionPane.showConfirmDialog(null,
                "¿Estás seguro de eliminar la información del registro?",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean eliminado = modelpanelrecord.deleteHistory(idHitory);
            if (eliminado) {
                JOptionPane.showMessageDialog(null, "Historial eliminado correctamente.");
                loadHistory();  
            }
        }

    } else {
       JOptionPane.showMessageDialog(null,
                        "Seleccione un registro de la tabla.",
                        "Sin selección", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    
    
    
    
    
    public void loadHistory() {
     List<History> lista = modelpanelrecord.obtainHistory();
        DefaultTableModel tableModel = (DefaultTableModel) panelrecord.HistoryTable.getModel();
        tableModel.setRowCount(0); 

        for (History history : lista) {
            tableModel.addRow(new Object[]{
                history.getIdPaciente(),
                history.getIdCita(),
                history.getArea(),
                history.getFechaPago(),
                history.getMontoFinal()



            });
        }
    
    
 
    }
    
    
    
    
    private void applyCombinedFilters() {
  List<RowFilter<Object, Object>> filtros = new ArrayList<>();

    // Filtro por fecha (columna 1)
    Date fechaSeleccionada = panelrecord.ComboSearch.getDate();

    // Filtro por estado (columna 6)
    String estadoSeleccionado = panelrecord.ComboFilter.getSelectedItem().toString();

    // Filtro por texto en TxtSearchId (columna 0)
    String textoBusqueda = panelrecord.TxtSearchId.getText().trim();

    // Agregar filtro fecha solo si hay fecha seleccionada
    if (fechaSeleccionada != null) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaTexto = sdf.format(fechaSeleccionada);
        filtros.add(RowFilter.regexFilter("^" + fechaTexto + "$", 3));
    }

    // Agregar filtro estado solo si no es "Todas"
    if (!estadoSeleccionado.equalsIgnoreCase("Todas")) {
        filtros.add(RowFilter.regexFilter("^" + estadoSeleccionado + "$", 2));
    }

    // Agregar filtro texto solo si no está vacío
    if (!textoBusqueda.isEmpty()) {
        filtros.add(RowFilter.regexFilter("(?i)" + textoBusqueda, 0));
    }

    // Si no hay filtros activos, quitar filtros para mostrar todo
    if (filtros.isEmpty()) {
        sorter.setRowFilter(null);
    } else {
        sorter.setRowFilter(RowFilter.andFilter(filtros));
    }
}
    
    
    


// === MÉTODO PRINCIPAL ===
public void generarReportePDF() {
    try {
        // Configurar documento con márgenes personalizados
        Document document = new Document(PageSize.A4.rotate(), 20, 20, 50, 50);
        
        String userHome = System.getProperty("user.home");
        File escritorio = new File(userHome, "Desktop");
        if (!escritorio.exists()) {
            escritorio.mkdirs();
        }
        
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = new File(escritorio, "Reporte_Historial_" + timestamp + ".pdf").getAbsolutePath();
        
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
        
        // Agregar eventos de página para header y footer
        writer.setPageEvent(new PdfPageEventHelper() {
            @Override
            public void onEndPage(PdfWriter writer, Document document) {
                try {
                    // Footer con número de página y fecha
                    PdfContentByte cb = writer.getDirectContent();
                    Font footerFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Color.GRAY);
                    Phrase footer = new Phrase("Página " + writer.getPageNumber() + 
                                             " | Generado el " + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()),
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
        
        // === ENCABEZADO PROFESIONAL ===
        About clinica = modelpanelrecord.getClinicaInfo();
        if (clinica != null) {
            // Logo o nombre principal
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Color.DARK_GRAY);
            Paragraph nombreClinica = new Paragraph(clinica.getNombre(), titleFont);
            nombreClinica.setAlignment(Element.ALIGN_CENTER);
            nombreClinica.setSpacingAfter(5);
            document.add(nombreClinica);
            
            // Información de contacto
            Font contactFont = FontFactory.getFont(FontFactory.HELVETICA, 10, Color.DARK_GRAY);
            Paragraph infoContacto = new Paragraph(
                "Dirección: " + clinica.getDirección() + "\n" +
                "Teléfono: " + clinica.getTelefono() + " | Correo: " + clinica.getCorreo(),
                contactFont
            );
            infoContacto.setAlignment(Element.ALIGN_CENTER);
            infoContacto.setSpacingAfter(10);
            document.add(infoContacto);
            
            // Línea separadora
            LineSeparator line = new LineSeparator();
            line.setLineWidth(1);
            line.setLineColor(Color.LIGHT_GRAY);
            document.add(new Chunk(line));
            document.add(new Paragraph("\n"));
        }
        
        // === TÍTULO DEL REPORTE ===
        Font mainTitleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, Color.DARK_GRAY);
        Paragraph titulo = new Paragraph("REPORTE DE HISTORIALES MÉDICOS", mainTitleFont);
        titulo.setAlignment(Element.ALIGN_CENTER);
        titulo.setSpacingAfter(5);
        document.add(titulo);
        
        // Fecha de generación
        Font dateFont = FontFactory.getFont(FontFactory.HELVETICA, 10, Color.GRAY);
        SimpleDateFormat sdf = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
        Paragraph fechaReporte = new Paragraph("Fecha de generación: " + sdf.format(new Date()), dateFont);
        fechaReporte.setAlignment(Element.ALIGN_CENTER);
        fechaReporte.setSpacingAfter(20);
        document.add(fechaReporte);
        
        // === INFORMACIÓN ESTADÍSTICA ===
        List<History> lista = modelpanelrecord.obtainHistory();
        if (lista != null && !lista.isEmpty()) {
            PdfPTable statsTable = new PdfPTable(4);
            statsTable.setWidthPercentage(60);
            statsTable.setHorizontalAlignment(Element.ALIGN_CENTER);
            statsTable.setSpacingAfter(20);
            
            // Encabezado de estadísticas
            Font statHeaderFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.WHITE);
            PdfPCell statHeader = new PdfPCell(new Phrase("RESUMEN ESTADÍSTICO", statHeaderFont));
            statHeader.setColspan(4);
            statHeader.setBackgroundColor(Color.DARK_GRAY);
            statHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            statHeader.setPadding(8);
            statsTable.addCell(statHeader);
            
            // Datos estadísticos
            addStatCell(statsTable, "Total de Registros", String.valueOf(lista.size()));
            
            long areasUnicas = lista.stream()
                    .map(History::getArea)
                    .filter(area -> area != null && !area.trim().isEmpty())
                    .distinct()
                    .count();
            addStatCell(statsTable, "Áreas Atendidas", String.valueOf(areasUnicas));
            
            long pacientesUnicos = lista.stream()
                    .map(History::getIdPaciente)
                    .filter(id -> id != null && !id.trim().isEmpty())
                    .distinct()
                    .count();
            addStatCell(statsTable, "Pacientes Únicos", String.valueOf(pacientesUnicos));
            
            // Calcular monto total
            try {
                double montoTotal = lista.stream()
                        .filter(h -> h.getMontoFinal() != null && !h.getMontoFinal().trim().isEmpty())
                        .mapToDouble(h -> {
                            try {
                                String monto = h.getMontoFinal()
                                        .replace("₡", "")
                                        .replace(",", "")
                                        .replace(".", "")
                                        .trim();
                                return Double.parseDouble(monto);
                            } catch (Exception e) {
                                return 0.0;
                            }
                        })
                        .sum();
                addStatCell(statsTable, "Monto Total", String.format("₡%.2f", montoTotal));
            } catch (Exception e) {
                addStatCell(statsTable, "Monto Total", "N/A");
            }
            
            document.add(statsTable);
            
            // === TABLA 1: Información de Citas y Pacientes ===
            Font subtitleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.DARK_GRAY);
            Paragraph subtitulo1 = new Paragraph("Información de Citas y Pacientes", subtitleFont);
            subtitulo1.setSpacingBefore(10);
            subtitulo1.setSpacingAfter(10);
            document.add(subtitulo1);
            
            PdfPTable table1 = new PdfPTable(9);
            table1.setWidthPercentage(100);
            table1.setSpacingAfter(20);
            
            // Anchos de columnas proporcionales
            float[] widths1 = {8f, 12f, 10f, 12f, 10f, 15f, 15f, 12f, 15f};
            table1.setWidths(widths1);
            
            String[] columnas1 = {
                "ID Cita", "Fecha Cita", "Hora", "Área", "ID Paciente", 
                "Primer Apellido", "Segundo Apellido", "Teléfono", "Correo"
            };
            
            addTableHeaders(table1, columnas1);
            
            int rowCount = 0;
            for (History h : lista) {
                addDataCell(table1, h.getIdCita(), rowCount);
                addDataCell(table1, h.getFechaCita(), rowCount);
                addDataCell(table1, h.getHoraCita(), rowCount);
                addDataCell(table1, h.getArea(), rowCount);
                addDataCell(table1, h.getIdPaciente(), rowCount);
                addDataCell(table1, h.getPrimerApellido(), rowCount);
                addDataCell(table1, h.getSegundoApellido(), rowCount);
                addDataCell(table1, h.getTelefono(), rowCount);
                addDataCell(table1, h.getCorreo(), rowCount);
                rowCount++;
            }
            
            document.add(table1);
            
            // === TABLA 2: Información Personal y Financiera ===
            Paragraph subtitulo2 = new Paragraph("Información Personal y Financiera", subtitleFont);
            subtitulo2.setSpacingBefore(10);
            subtitulo2.setSpacingAfter(10);
            document.add(subtitulo2);
            
            PdfPTable table2 = new PdfPTable(9);
            table2.setWidthPercentage(100);
            
            float[] widths2 = {20f, 8f, 15f, 12f, 8f, 15f, 12f, 12f, 12f};
            table2.setWidths(widths2);
            
            String[] columnas2 = {
                "Dirección", "Edad", "Responsable", "Estado Civil", 
                "Sexo", "Ocupación", "F. Nacimiento", "F. Pago", "Monto"
            };
            
            addTableHeaders(table2, columnas2);
            
            rowCount = 0;
            for (History h : lista) {
                addDataCell(table2, h.getDireccion(), rowCount);
                addDataCell(table2, h.getEdad(), rowCount);
                addDataCell(table2, h.getResponsable(), rowCount);
                addDataCell(table2, h.getEstadoCivil(), rowCount);
                addDataCell(table2, h.getSexo(), rowCount);
                addDataCell(table2, h.getOcupacion(), rowCount);
                addDataCell(table2, h.getFechaNacimiente(), rowCount);
                addDataCell(table2, h.getFechaPago(), rowCount);
                addDataCell(table2, h.getMontoFinal(), rowCount);
                rowCount++;
            }
            
            document.add(table2);
        } else {
            // Mensaje cuando no hay datos
            Font noDataFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Color.RED);
            Paragraph noData = new Paragraph("No hay datos disponibles para generar el reporte.", noDataFont);
            noData.setAlignment(Element.ALIGN_CENTER);
            document.add(noData);
        }
        
        // === PIE DE PÁGINA FINAL ===
        document.add(new Paragraph("\n"));
        LineSeparator finalLine = new LineSeparator();
        finalLine.setLineWidth(1);
        finalLine.setLineColor(Color.LIGHT_GRAY);
        document.add(new Chunk(finalLine));
        
        Font footerTextFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Color.GRAY);
        Paragraph footer = new Paragraph(
            "\nReporte generado automáticamente por el Sistema de Gestión Médica\n" +
            "Este documento contiene información confidencial y debe ser tratado con la debida seguridad.",
            footerTextFont
        );
        footer.setAlignment(Element.ALIGN_CENTER);
        document.add(footer);
        
        document.close();
        
        // Abrir PDF automáticamente
        abrirPDFAutomaticamente(filePath);
        
        // Mensaje de éxito mejorado
        JOptionPane.showMessageDialog(null, 
            "✅ PDF generado exitosamente\n" +
            "📁 Ubicación: " + filePath + "\n" +
            "📊 Total de registros: " + (lista != null ? lista.size() : 0) + "\n" +
            "🔍 El archivo se ha abierto automáticamente",
            "Reporte Generado", 
            JOptionPane.INFORMATION_MESSAGE);
            
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, 
            "❌ Error al generar el PDF:\n" + e.getMessage(),
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}

// === MÉTODOS AUXILIARES ===
private void addTableHeaders(PdfPTable table, String[] headers) {
    Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 9, Color.WHITE);
    for (String header : headers) {
        PdfPCell cell = new PdfPCell(new Phrase(header, headerFont));
        cell.setBackgroundColor(Color.DARK_GRAY);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setPadding(6);
        table.addCell(cell);
    }
}

private void addDataCell(PdfPTable table, String data, int rowIndex) {
    Font dataFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Color.BLACK);
    String cellData = (data != null && !data.trim().isEmpty()) ? data.trim() : "-";
    PdfPCell cell = new PdfPCell(new Phrase(cellData, dataFont));
    cell.setPadding(4);
    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
    
    // Alternar colores de fila para mejor legibilidad
    if (rowIndex % 2 == 0) {
        cell.setBackgroundColor(new Color(248, 249, 250));
    }
    table.addCell(cell);
}

private void addStatCell(PdfPTable table, String label, String value) {
    Font labelFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, Color.DARK_GRAY);
    Font valueFont = FontFactory.getFont(FontFactory.HELVETICA, 10, Color.BLACK);
    
    PdfPCell labelCell = new PdfPCell(new Phrase(label, labelFont));
    labelCell.setBackgroundColor(Color.LIGHT_GRAY);
    labelCell.setPadding(5);
    labelCell.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(labelCell);
    
    PdfPCell valueCell = new PdfPCell(new Phrase(value, valueFont));
    valueCell.setPadding(5);
    valueCell.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(valueCell);
}

// === MÉTODO PARA ABRIR PDF AUTOMÁTICAMENTE ===
private void abrirPDFAutomaticamente(String filePath) {
    try {
        File pdfFile = new File(filePath);
        
        // Verificar que el archivo existe
        if (!pdfFile.exists()) {
            System.err.println("El archivo PDF no existe: " + filePath);
            return;
        }
        
        // Verificar si Desktop es soportado
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            
            // Verificar si la acción OPEN es soportada
            if (desktop.isSupported(Desktop.Action.OPEN)) {
                desktop.open(pdfFile);
                System.out.println("PDF abierto automáticamente: " + filePath);
            } else {
                // Fallback: usar métodos específicos del sistema operativo
                abrirPorSistemaOperativo(filePath);
            }
        } else {
            // Fallback: usar métodos específicos del sistema operativo
            abrirPorSistemaOperativo(filePath);
        }
        
    } catch (Exception e) {
        System.err.println("Error al abrir PDF automáticamente: " + e.getMessage());
        
        // Ofrecer abrir manualmente
        int respuesta = JOptionPane.showConfirmDialog(null,
            "No se pudo abrir el PDF automáticamente.\n" +
            "¿Desea abrir la carpeta donde se guardó el archivo?",
            "Abrir Carpeta",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
            
        if (respuesta == JOptionPane.YES_OPTION) {
            abrirCarpetaContenedora(filePath);
        }
    }
}

// Método alternativo usando comandos del sistema operativo
private void abrirPorSistemaOperativo(String filePath) {
    try {
        String os = System.getProperty("os.name").toLowerCase();
        ProcessBuilder pb;
        
        if (os.contains("win")) {
            // Windows
            pb = new ProcessBuilder("cmd", "/c", "start", "\"\"", filePath);
        } else if (os.contains("mac")) {
            // macOS
            pb = new ProcessBuilder("open", filePath);
        } else {
            // Linux/Unix
            pb = new ProcessBuilder("xdg-open", filePath);
        }
        
        pb.start();
        System.out.println("PDF abierto usando comando del sistema operativo");
        
    } catch (Exception e) {
        System.err.println("Error al abrir PDF por sistema operativo: " + e.getMessage());
    }
}

// Método para abrir la carpeta contenedora si falla abrir el PDF
private void abrirCarpetaContenedora(String filePath) {
    try {
        File file = new File(filePath);
        File parentDir = file.getParentFile();
        
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(parentDir);
        } else {
            // Fallback por sistema operativo
            String os = System.getProperty("os.name").toLowerCase();
            ProcessBuilder pb;
            
            if (os.contains("win")) {
                pb = new ProcessBuilder("explorer", parentDir.getAbsolutePath());
            } else if (os.contains("mac")) {
                pb = new ProcessBuilder("open", parentDir.getAbsolutePath());
            } else {
                pb = new ProcessBuilder("xdg-open", parentDir.getAbsolutePath());
            }
            
            pb.start();
        }
        
        System.out.println("Carpeta abierta: " + parentDir.getAbsolutePath());
        
    } catch (Exception e) {
        System.err.println("Error al abrir carpeta: " + e.getMessage());
    }
    
    
   
    
}

}


