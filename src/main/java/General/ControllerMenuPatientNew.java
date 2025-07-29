
package General;

import ConnectionDataBase.ConnectionDB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;





public class ControllerMenuPatientNew implements ActionListener{
    
    
    
    private MenuPatientNew menupatientnew;
       String lastNameF = "";
       String lastNameM = "";
       String phone = "";
       String province = "";
       String age = "";
       String id = "";
       String responsible = "";
       String civilStatus = "";
       String sex = "";
       String occupation = "";
       String dateOfBirth = "";
    
       
    
    ConnectionDataBase.ConnectionDB con = new ConnectionDB();
    Connection cn = con.establecerConexion();
    
       
       
    
    public ControllerMenuPatientNew(MenuPatientNew menupatientnew) {
        this.menupatientnew = menupatientnew;
        
        this.menupatientnew.BtnContinue.addActionListener(this);
        
      // Evento cuando cambia la fecha
      menupatientnew.JDateOfBirth.getDateEditor().addPropertyChangeListener("date", evt -> calculateAge());
    }
    
    
    
   
    
    
    
    @Override
    public void actionPerformed (ActionEvent e) {
    
    if (e.getSource() == menupatientnew.BtnContinue) {
        
        if (menupatientnew.TxtLastNameF.getText().trim().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Por favor ingrese el primer apellido.");
    return;
    }
    if (menupatientnew.TxtLastNameM.getText().trim().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Por favor ingrese el segundo apellido.");
    return;
    }
    if (menupatientnew.TxtPhone.getText().trim().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Por favor ingrese el número de teléfono.");
    return;
    }
    if (menupatientnew.ComboProvince.equals("-SELECCIONAR-")) {
    JOptionPane.showMessageDialog(null, "Por favor seleccione una provincia.");
    return;
    }
    if (menupatientnew.TxtId.getText().trim().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Por favor ingrese la edad.");
    return;
    }
    if (menupatientnew.TxtResponsible.getText().trim().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Por favor ingrese el nombre del responsable.");
    return;
    }
    if (menupatientnew.ComboCivilStatus.equals("-SELECCIONAR-")) {
    JOptionPane.showMessageDialog(null, "Por favor seleccione el estado civil.");
    return;
}
if (menupatientnew.ComboSex.equals("-SELECCIONAR-")) {
    JOptionPane.showMessageDialog(null, "Por favor seleccione el sexo.");
    return;
}
if (menupatientnew.ComboOccupation.equals("-SELECCIONAR-")) {
    JOptionPane.showMessageDialog(null, "Por favor seleccione la ocupación.");
    return;
}
if (menupatientnew.JDateOfBirth.getDate() == null) {
    JOptionPane.showMessageDialog(null, "Por favor seleccione la fecha de nacimiento.");
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
       id = menupatientnew.TxtId.getText();
       
       
       
       
       
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
       dateOfBirth = sdf.format(menupatientnew.JDateOfBirth.getDate());

    
    saveUser();
    MenuPatient menupatient = new MenuPatient();
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

        age = (String.valueOf(edad));
    }
    
    
    
    
    
    
    
    
    
    
    public void saveUser() {
    
        try{
    String query = "UPDATE Pacientes SET "
    + "PrimerApellido = '"+lastNameF+"', "
    + "SegundoApellido = '"+lastNameM+"', "
    + "Telefono = '"+phone+"', "
    + "Direccion = '"+province+"', "
    + "Edad = '"+age+"', "
    + "Responsable = '"+responsible+"', "
    + "EstadoCivil = '"+civilStatus+"', "
    + "Sexo = '"+sex+"', "
    + "Ocupacion = '"+occupation+"', "
    + "FechaNacimiento = '"+dateOfBirth+"' "
    + "WHERE Identificacion = '"+id+"'";
    PreparedStatement ps = cn.prepareStatement(query);
    ps.executeUpdate();
    JOptionPane.showMessageDialog(null, "Datos registrados correctamente");
    return;
       }catch (Exception i){
        JOptionPane.showMessageDialog(null, "NO SE REGISTRARON LOS DATOS: " +i, "Error",JOptionPane.ERROR_MESSAGE);    
        return;
        }
   
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
