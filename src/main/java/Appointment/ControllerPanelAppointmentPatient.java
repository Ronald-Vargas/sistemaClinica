
package Appointment;

import Home.ControllerHome;
import Home.Home;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;






public class ControllerPanelAppointmentPatient implements ActionListener{
    
    
private PanelAppointmentPatient panelappointmentpatient; 
private ModelPanelAppointmentPatient modelpanelappointmentpatient;
private String id;


    public ControllerPanelAppointmentPatient(PanelAppointmentPatient panelappointmentpatient, ModelPanelAppointmentPatient modelpanelappointmentpatient, String id) {
        this.panelappointmentpatient = panelappointmentpatient;
        this.modelpanelappointmentpatient = modelpanelappointmentpatient;
        this.id = id; 
        
        panelappointmentpatient.TxtId.setText(id);
        initializeListeners();
    }


    
private void initializeListeners() {
this.panelappointmentpatient.BtnOut.addActionListener(this);
this.panelappointmentpatient.BtnAdd.addActionListener(this);
}
   



    
    
    
    
    
    
    
@Override
public void actionPerformed (ActionEvent e) {


    if(e.getSource() == panelappointmentpatient.BtnAdd) {
    agendarCita();
    
        
    } else if (e.getSource() == panelappointmentpatient.BtnOut) {
    Home home = new Home();
    ControllerHome controllerhome = new ControllerHome(home);
    home.setVisible(true);
    
    }



}





public void agendarCita() {

    
    Date fechaCitaDate = panelappointmentpatient.ComboCalendar.getDate();
    LocalTime horaSeleccionada = panelappointmentpatient.ComboTime.getTime();
    String area = (String) panelappointmentpatient.ComboArea.getSelectedItem();
    
     if (fechaCitaDate == null || horaSeleccionada == null || area.equals("--SELECCIONAR--")) {
    JOptionPane.showMessageDialog(null, "Por favor, Complete todos los datos solicitados", "Campos vacios", JOptionPane.ERROR_MESSAGE); 
    return;
    }
     
     
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String fechaCita = sdf.format(fechaCitaDate);
    String hora = horaSeleccionada.format(DateTimeFormatter.ofPattern("HH:mm"));
    String fechaRegistro = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));    
    String estado = "Pendiente";
    String idCita = "ClinicaLatina_" + System.currentTimeMillis();

Appointment appointment = new Appointment(idCita, fechaCita, hora, fechaRegistro, estado, area, id);
if (modelpanelappointmentpatient.insertAppointmentPatient(appointment)) {
    JOptionPane.showMessageDialog(null, "Cita agendada con éxito.");

    // Crear panel personalizado
    JPanel panel = new JPanel(new BorderLayout(10, 10));
    JLabel label = new JLabel("Número de cita:");
    JTextField txtCita = new JTextField(idCita);
    txtCita.setEditable(false);

    JButton btnCopiar = new JButton("Copiar");
    btnCopiar.addActionListener(e -> {
        StringSelection seleccion = new StringSelection(txtCita.getText());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(seleccion, null);
        JOptionPane.showMessageDialog(null, "Número de cita copiado al portapapeles.");
    });

    panel.add(label, BorderLayout.NORTH);
    panel.add(txtCita, BorderLayout.CENTER);
    panel.add(btnCopiar, BorderLayout.SOUTH);

    JOptionPane.showMessageDialog(null, panel, "GUARDAR ESTE NÚMERO", JOptionPane.INFORMATION_MESSAGE);

            panelappointmentpatient.ComboArea.setSelectedIndex(0);
            Home home = new Home();
            ControllerHome controllerhome = new ControllerHome(home);
            home.setVisible(true);
            panelappointmentpatient.setVisible(false);
    
        } else {
            JOptionPane.showMessageDialog(null, "Error al agendar cita.");
        }
    
    
}
    



    
}
