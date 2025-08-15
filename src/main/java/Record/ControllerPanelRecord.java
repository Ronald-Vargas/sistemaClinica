
package Record;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;



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
       

    }
    
    
    
    
    
    
    
    @Override
    public void actionPerformed (ActionEvent e) {
    
        if(e.getSource() == panelrecord.BtnDelete) {
        deleteDoctor();
       
            
            
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
    
    
    
    
    
    
   
    
}


