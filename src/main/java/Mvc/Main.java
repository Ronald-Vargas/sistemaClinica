
package Mvc;

import ConnectionDataBase.ConnectionDB;
import Login.ControllerHome;
import Login.Home;
import com.formdev.flatlaf.FlatLightLaf;


public class Main {

    public static void main(String[] args) {
        FlatLightLaf.setup();
        
    ConnectionDB objetoconexion = new ConnectionDB();
    objetoconexion.establecerConexion();
        
        
        Home home = new Home();
        ControllerHome controllerhome = new ControllerHome(home);
        home.setVisible(true);
        
    
    }
}
