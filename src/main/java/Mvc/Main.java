
package Mvc;

import ConnectionDataBase.ConnectionDataBase;
import Login.ControllerHome;
import Login.Home;
import com.formdev.flatlaf.FlatLightLaf;


public class Main {

    public static void main(String[] args) {
        FlatLightLaf.setup();
        
    ConnectionDataBase objetoconexion = new ConnectionDataBase();
    objetoconexion.establecerConexion();
        
        
        Home home = new Home();
        ControllerHome controllerhome = new ControllerHome(home);
        home.setVisible(true);
        
    
    }
}
