
package Register;

import Home.Home;
import Home.ControllerHome;
import ConnectionDataBase.ConnectionDB;
import Patients.ControllerPanelPatientNew;
import Validations.ValidationsPatientNew;
import Login.ControllerLoginPatients;
import Login.LoginPatient;
import Patients.PanelPatientNew;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;




public class ControllerRegisterPatients implements ActionListener{ 
    
    private Register register;
    private PanelPatientNew panelpatientnew;
    
    String name = "";
    String id = "";
    String email = "";
    String pass = "";
    
    ConnectionDataBase.ConnectionDB con = new ConnectionDB();
    Connection cn = con.establecerConexion();
    
    
    
    
    public ControllerRegisterPatients(Register register) {
        this.register = register;
        
        
        this.register.BtnRegister.addActionListener(this);
        this.register.BtnLogOut.addActionListener(this);
        
        
        
        
        
        
        
         this.register.LblLogIn.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
        LoginPatient loginpatient = new LoginPatient();
        ControllerLoginPatients controllerloginpatients = new ControllerLoginPatients(loginpatient);
        loginpatient.setVisible(true);
        register.dispose();
        }
         });
                 
                 
                 
             
    }
   
    
    
    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed (ActionEvent e) {
    
    
    
    if (e.getSource() == register.BtnRegister) {
        
     
    
    name = register.TxtName.getText();
    email = register.TxtEmail.getText();
    pass = register.TxtPass.getText();
    id = register.TxtId.getText();
        
    if (name.isEmpty() || email.isEmpty() || pass.isEmpty() || id.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor, Complete todos los datos solicitados", "Información Incompleta", JOptionPane.ERROR_MESSAGE);
        
        
    } else {

//        //Llamado del metodo
//        EmailSender sender = new EmailSender();
//        
//        String generatedCode = String.valueOf(new Random().nextInt(900000) + 100000); 
//
//        //Enviar codigo al correo
//        boolean success = sender.sendEmail(email, "Código de Verificación", "Tu código es: " + generatedCode);   
//
//        
//    if (success) {
//        // Mensaje con el correo
//        String mensaje = "Se envió un código de verificación al correo: \n" + email + "\nIngresa el código de verificación:";
//
//        // Mostrar un JOptionPane con campo de entrada
//        String code = JOptionPane.showInputDialog(
//            null,
//            mensaje,
//            "Verificación de Correo",
//            JOptionPane.INFORMATION_MESSAGE
//        );
//
//        // Verificar código ingresado
//        if (code != null && code.equals(generatedCode)) {
//            JOptionPane.showMessageDialog(null, "Código correcto. Registro exitoso.");
            
            

           if (usuarioYaExiste(id, email)) {
    JOptionPane.showMessageDialog(null, "Ya existe una cuenta registrada con esa identificación o correo electrónico.");
    return;
}    
          
           
           
           
saveUsers();  
panelpatientnew = new PanelPatientNew(); // inicializas
ControllerPanelPatientNew controllerpanelpatientnew = new ControllerPanelPatientNew(panelpatientnew, id, register);
ValidationsPatientNew validationpatientnew = new ValidationsPatientNew(panelpatientnew);
initPanelNewPatient();     

     
      
            
          
            
//        } else {
//            JOptionPane.showMessageDialog(null, "Código incorrecto o cancelado.", "Codigo invalido", JOptionPane.ERROR_MESSAGE);
//        }
//
//        
//        
//        
//    } else {
//        JOptionPane.showMessageDialog(null, "Error al enviar el correo.");
//    }
    
    
    
    
    
    }
    
    
    
    } else if (e.getSource() == register.BtnLogOut) {
    Home home = new Home();
    ControllerHome controllerhome = new ControllerHome(home);
    home.setVisible(true);
    register.dispose();
    
    
    
    
    }
    
   
    }
    
    
    
    public void initPanelNewPatient() {
    panelpatientnew.setSize(600, 800);
    panelpatientnew.setLocation(0, 0);

    register.Content1.removeAll();
    register.Content1.add(panelpatientnew, BorderLayout.CENTER);
    register.Content1.revalidate();
    register.Content1.repaint();
    
    }
    
    
    
    
    
    
    
    
      public boolean usuarioYaExiste(String id, String correo) {
    try {
        String query = "SELECT * FROM Pacientes WHERE Identificacion = ? OR Correo = ?";
        PreparedStatement ps = cn.prepareStatement(query);
        ps.setString(1, id);
        ps.setString(2, correo);
        ResultSet rs = ps.executeQuery();
        return rs.next(); // Si hay resultados, el usuario ya existe
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al verificar el usuario: " + e.getMessage());
        return true; // Por seguridad, asumimos que existe si algo falla
    }
}
    
    
    
    
    
    
    public void saveUsers() {
    
    
    try {
    String quary = "INSERT INTO Pacientes (Identificacion,Nombre,Correo,Contrasena) VALUES ('"+id+"','"+name+"','"+email+"','"+pass+"')";
    PreparedStatement ps = cn.prepareStatement(quary);
    ps.executeUpdate();
    JOptionPane.showMessageDialog(null, "Datos registrados correctamente");
    return;
       }catch (Exception i){
        JOptionPane.showMessageDialog(null, "NO SE REGISTRARON LOS DATOS: " +i, "Error",JOptionPane.ERROR_MESSAGE);    
        return;
        }
    
    }
    
    
    
  
    
}
