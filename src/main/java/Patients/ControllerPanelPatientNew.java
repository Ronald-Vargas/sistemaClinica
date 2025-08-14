
package Patients;

import Appointment.ControllerPanelAppointmentPatient;
import Appointment.ModelPanelAppointmentPatient;
import Appointment.PanelAppointmentPatient;
import ConnectionDataBase.ConnectionDB;
import Register.Register;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;





public class ControllerPanelPatientNew implements ActionListener{
    
    
    
    private PanelPatientNew panelpatientnew;
    private PanelAppointmentPatient panelappointmentpatient;
    private Register register;

    
       private String id;
       String lastNameF = "";
       String lastNameM = "";
       String phone = "";
       String province = "";
       String age = "";
       String responsible = "";
       String civilStatus = "";
       String sex = "";
       String occupation = "";
       String dateOfBirth = "";
    
       
    
    ConnectionDataBase.ConnectionDB con = new ConnectionDB();
    Connection cn = con.establecerConexion();
    
       
       
    
    public ControllerPanelPatientNew (PanelPatientNew panelpatientnew, String id, Register register) {
        this.panelpatientnew = panelpatientnew;
        this.id = id;
        this.register = register;
        
        this.panelpatientnew.BtnContinue.addActionListener(this);
        
         // Asignar y bloquear campo de ID
        panelpatientnew.TxtId.setText(id);
        
        
        
      // Evento cuando cambia la fecha
      panelpatientnew.JDateOfBirth.getDateEditor().addPropertyChangeListener("date", evt -> calculateAge());
    }
    
    
    
   
    
    
    
    @Override
    public void actionPerformed (ActionEvent e) {
    
    if (e.getSource() == panelpatientnew.BtnContinue) {
        
        if (panelpatientnew.TxtLastNameF.getText().trim().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Por favor, ingrese el primer apellido.");
    return;
    }
    if (panelpatientnew.TxtLastNameM.getText().trim().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Por favor, ingrese el segundo apellido.");
    return;
    }
    if (panelpatientnew.TxtPhone.getText().trim().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Por favor, ingrese el número de teléfono.");
    return;
    }
    if (panelpatientnew.ComboProvince.getSelectedItem().equals("-SELECCIONAR-")) {
    JOptionPane.showMessageDialog(null, "Por favor, seleccione una provincia.");
    return;
}
    if (panelpatientnew.TxtId.getText().trim().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Por favor, ingrese la identificación.");
    return;
    }
    
    if (panelpatientnew.ComboCivilStatus.getSelectedItem().equals("-SELECCIONAR-")) {
    JOptionPane.showMessageDialog(null, "Por favor, seleccione el estado civil.");
    return;
}

if (panelpatientnew.ComboSex.getSelectedItem().equals("-SELECCIONAR-")) {
    JOptionPane.showMessageDialog(null, "Por favor, seleccione el sexo.");
    return;
}

if (panelpatientnew.ComboOccupation.getSelectedItem().equals("-SELECCIONAR-")) {
    JOptionPane.showMessageDialog(null, "Por favor, seleccione la ocupación.");
    return;
}
if (panelpatientnew.JDateOfBirth.getDate() == null) {
    JOptionPane.showMessageDialog(null, "Por favor, seleccione la fecha de nacimiento.");
    return;
}


       lastNameF = panelpatientnew.TxtLastNameF.getText().trim();
       lastNameM = panelpatientnew.TxtLastNameM.getText().trim();
       phone = panelpatientnew.TxtPhone.getText().trim();
       province = (String) panelpatientnew.ComboProvince.getSelectedItem();
       responsible = panelpatientnew.TxtResponsible.getText().trim();
       civilStatus = (String) panelpatientnew.ComboCivilStatus.getSelectedItem();
       sex = (String) panelpatientnew.ComboSex.getSelectedItem();
       occupation = (String) panelpatientnew.ComboOccupation.getSelectedItem();
       
       
       
       
       
      Date fecha = panelpatientnew.JDateOfBirth.getDate();
      java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
    
    saveUser();
    panelappointmentpatient = new PanelAppointmentPatient(); // inicializas
    ModelPanelAppointmentPatient modelpanealappointmentpatient = new ModelPanelAppointmentPatient();
    initPanelAppointmentPatient();
    ControllerPanelAppointmentPatient controllerpanelappointmentpatient = new ControllerPanelAppointmentPatient(panelappointmentpatient, modelpanealappointmentpatient, id);
       
       
    

    
    }
    
    
    
    
    }
    
    
    
    
    public void initPanelAppointmentPatient() {
    panelappointmentpatient.setSize(600, 800);
    panelappointmentpatient.setLocation(0, 0);

    register.Content1.removeAll();
    register.Content1.add(panelappointmentpatient, BorderLayout.CENTER);
    register.Content1.revalidate();
    register.Content1.repaint();
   
    }
    
    
    
    
    
    
    
    
    
    
    
   private void calculateAge() {
    Date fechaNacimiento = panelpatientnew.JDateOfBirth.getDate();
    if (fechaNacimiento == null) return;
    
    Calendar nacimiento = Calendar.getInstance();
    nacimiento.setTime(fechaNacimiento);
    Calendar hoy = Calendar.getInstance();
    
    int edad = hoy.get(Calendar.YEAR) - nacimiento.get(Calendar.YEAR);
    
    // Verificación más precisa considerando mes y día
    if (hoy.get(Calendar.MONTH) < nacimiento.get(Calendar.MONTH) || 
        (hoy.get(Calendar.MONTH) == nacimiento.get(Calendar.MONTH) && 
         hoy.get(Calendar.DAY_OF_MONTH) < nacimiento.get(Calendar.DAY_OF_MONTH))) {
        edad--;
    }
    
    // Asignar la edad calculada
    age = String.valueOf(edad);
    
    // Verificar si es mayor o menor de edad
    if (edad >= 18) {
        panelpatientnew.TxtResponsible.setText("");
        panelpatientnew.TxtResponsible.setEditable(false); // Bloquear edición
    } else {
        panelpatientnew.TxtResponsible.setEditable(true); // Habilitar edición si es menor
    }
}
    
    
    
    
    
    
    
    
    public void saveUser() {
    
        try {
        String query = "UPDATE Pacientes SET "
            + "PrimerApellido = ?, "
            + "SegundoApellido = ?, "
            + "Telefono = ?, "
            + "Direccion = ?, "
            + "Edad = ?, "
            + "Responsable = ?, "
            + "EstadoCivil = ?, "
            + "Sexo = ?, "
            + "Ocupacion = ?, "
            + "FechaNacimiento = ? "
            + "WHERE Identificacion = ?";

        PreparedStatement ps = cn.prepareStatement(query);
        ps.setString(1, lastNameF);
        ps.setString(2, lastNameM);
        ps.setString(3, phone);
        ps.setString(4, province);
        ps.setString(5, age);
        ps.setString(6, responsible);
        ps.setString(7, civilStatus);
        ps.setString(8, sex);
        ps.setString(9, occupation);

        // Fecha segura
        Date fecha = panelpatientnew.JDateOfBirth.getDate();
        java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
        ps.setDate(10, sqlDate);

        ps.setString(11, id);

        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Datos registrados correctamente");
       }catch (Exception i){
        JOptionPane.showMessageDialog(null, "NO SE REGISTRARON LOS DATOS: " +i, "Error",JOptionPane.ERROR_MESSAGE);    
        return;
        }
   
    
    
    }
    
    
    
   
}
