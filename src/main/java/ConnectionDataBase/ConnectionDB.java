
package ConnectionDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class ConnectionDB {
 
    
    Connection Conectar = null;
    
    
    String usuario = "userSQL";
    String contrasena = "root123";
    String bd = "sistemaClinica";
    String ip = "localhost";
    String puerto = "1433";
    
    
    
    
     String cadena = "jdbc:sqlserver://"+ip+":"+puerto+"/"+bd;
    
    
    public Connection establecerConexion() {
  
  
      try {
          String cadena = "jdbc:sqlserver://localhost:"+puerto+";"+"databaseName="+bd+";encrypt=false";
          Conectar = DriverManager.getConnection(cadena,usuario,contrasena);
          JOptionPane.showMessageDialog(null, "Se conecto correctamente a la base de datos");
      } catch (Exception e) {
          JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos: "+e.toString());
      }
    return Conectar;
  
  
  }  
    
    
    
    
    
    
    
}
