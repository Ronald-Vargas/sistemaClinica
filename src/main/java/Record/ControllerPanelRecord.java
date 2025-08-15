
package Record;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;



public class ControllerPanelRecord {
    
   private ModelPanelRecord modelpanelrecord;
   private PanelRecord panelrecord;
   private TableRowSorter<DefaultTableModel> sorter;
   
   
   
    public ControllerPanelRecord(ModelPanelRecord modelpanelrecord, PanelRecord panelrecord) {
        this.modelpanelrecord = modelpanelrecord;
        this.panelrecord = panelrecord;
        
        loadHistory();
        initializeFilters();
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
    
    
    
    
    
    
   
    
}


