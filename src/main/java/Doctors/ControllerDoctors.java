/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Doctors;
import ConnectionDataBase.ConnectionDB;
import java.awt.event.ActionListener;

/**
 *
 * @author jimeneby
 */
public class ControllerDoctors {
    private ModelClass model;
    private menuDoctors menu;
    private String identificacionorigiona = "";

    public ControllerDoctors(ModelClass model, menuDoctors menu) {
        this.model = model;
        this.menu = menu;
        
        
        this.menu.BtnContinue.addActionListener((ActionListener) this);   
    
    
        
    }
    

}
