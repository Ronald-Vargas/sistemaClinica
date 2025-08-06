
package Patients;

import Patients.MenuPatientNew;
import Appointment.MenuAppointmentPatient;
import ConnectionDataBase.ConnectionDB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;





public class ControllerMenuPatientNew implements ActionListener{
    
    
    
    private MenuPatientNew menupatientnew;
     
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
    
       
       
    
    public ControllerMenuPatientNew(MenuPatientNew menupatientnew, String id) {
        this.menupatientnew = menupatientnew;
        this.id = id;
        
        this.menupatientnew.BtnContinue.addActionListener(this);
        
         // Asignar y bloquear campo de ID
        menupatientnew.TxtId.setText(id);
        
        
        
      // Evento cuando cambia la fecha
      menupatientnew.JDateOfBirth.getDateEditor().addPropertyChangeListener("date", evt -> calculateAge());
    }
    
    
    
   
    
    
    
    @Override
    public void actionPerformed (ActionEvent e) {
    
    if (e.getSource() == menupatientnew.BtnContinue) {
        
        if (menupatientnew.TxtLastNameF.getText().trim().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Por favor, ingrese el primer apellido.");
    return;
    }
    if (menupatientnew.TxtLastNameM.getText().trim().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Por favor, ingrese el segundo apellido.");
    return;
    }
    if (menupatientnew.TxtPhone.getText().trim().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Por favor, ingrese el número de teléfono.");
    return;
    }
    if (menupatientnew.ComboProvince.getSelectedItem().equals("-SELECCIONAR-")) {
    JOptionPane.showMessageDialog(null, "Por favor, seleccione una provincia.");
    return;
}
    if (menupatientnew.TxtId.getText().trim().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Por favor, ingrese la identificación.");
    return;
    }
    
    if (menupatientnew.ComboCivilStatus.getSelectedItem().equals("-SELECCIONAR-")) {
    JOptionPane.showMessageDialog(null, "Por favor, seleccione el estado civil.");
    return;
}

if (menupatientnew.ComboSex.getSelectedItem().equals("-SELECCIONAR-")) {
    JOptionPane.showMessageDialog(null, "Por favor, seleccione el sexo.");
    return;
}

if (menupatientnew.ComboOccupation.getSelectedItem().equals("-SELECCIONAR-")) {
    JOptionPane.showMessageDialog(null, "Por favor, seleccione la ocupación.");
    return;
}
if (menupatientnew.JDateOfBirth.getDate() == null) {
    JOptionPane.showMessageDialog(null, "Por favor, seleccione la fecha de nacimiento.");
    return;
}


       lastNameF = menupatientnew.TxtLastNameF.getText().trim();
       lastNameM = menupatientnew.TxtLastNameM.getText().trim();
       phone = menupatientnew.TxtPhone.getText().trim();
       province = (String) menupatientnew.ComboProvince.getSelectedItem();
       responsible = menupatientnew.TxtResponsible.getText().trim();
       civilStatus = (String) menupatientnew.ComboCivilStatus.getSelectedItem();
       sex = (String) menupatientnew.ComboSex.getSelectedItem();
       occupation = (String) menupatientnew.ComboOccupation.getSelectedItem();
       
       
       
       
       
      Date fecha = menupatientnew.JDateOfBirth.getDate();
      java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
    
    saveUser();
    MenuAppointmentPatient menupatient = new MenuAppointmentPatient();
    menupatient.setVisible(true);
    menupatientnew.dispose();
    
       
       
    
    
    
    
    }
    
    
    
    
    
    
    
    
    }
    
    
    
    private void calculateAge() {
        Date fechaNacimiento = menupatientnew.JDateOfBirth.getDate();
        if (fechaNacimiento == null) return;

        Calendar nacimiento = Calendar.getInstance();
        nacimiento.setTime(fechaNacimiento);

        Calendar hoy = Calendar.getInstance();

        int edad = hoy.get(Calendar.YEAR) - nacimiento.get(Calendar.YEAR);

        // Si aún no ha cumplido años este año
        if (hoy.get(Calendar.DAY_OF_YEAR) < nacimiento.get(Calendar.DAY_OF_YEAR)) {
            edad--;
        }

        age = (String.valueOf(edad--));
        
      
    if (edad-- >= 18) {
        menupatientnew.TxtResponsible.setText("");
        menupatientnew.TxtResponsible.setEditable(false); // Bloquear edición
 
        
    } else {
       menupatientnew.TxtResponsible.setEditable(true); // Habilitar edición si es menor
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
        Date fecha = menupatientnew.JDateOfBirth.getDate();
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
