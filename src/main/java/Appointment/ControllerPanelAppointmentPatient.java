
package Appointment;

import Home.ControllerHome;
import Home.Home;
import Login.LoginPatient;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;






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
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String fechaCita = sdf.format(fechaCitaDate);
    
    LocalTime horaSeleccionada = panelappointmentpatient.ComboTime.getTime();
    String hora = horaSeleccionada.format(DateTimeFormatter.ofPattern("HH:mm"));
    String fechaRegistro = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));    
    String estado = "Pendiente";
    String area = (String) panelappointmentpatient.ComboArea.getSelectedItem();
    String idCita = "ClinicaLatina_" + System.currentTimeMillis();

    
    Appointment appointment = new Appointment(idCita, fechaCita, hora, fechaRegistro, estado, area, id);
    if (modelpanelappointmentpatient.insertAppointmentPatient(appointment)) {
            JOptionPane.showMessageDialog(null, "Cita agendada con éxito.");
            panelappointmentpatient.ComboArea.setSelectedIndex(0);
            Home home = new Home();
            ControllerHome controllerhome = new ControllerHome(home);
            home.setVisible(true);
            LoginPatient login = new LoginPatient();
            login.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Error al agendar cita.");
        }
    
    
    
    
}







    
}
