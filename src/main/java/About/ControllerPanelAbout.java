/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package About;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author jimeneby
 */
public class ControllerPanelAbout implements ActionListener{
    
    private PanelAbout panelabout;
    private ModelPanelAbout modelpanelabout;

    public ControllerPanelAbout(PanelAbout panelabout, ModelPanelAbout modelpanelabout) {
        this.panelabout = panelabout;
        this.modelpanelabout = modelpanelabout;
        
        initializeListeners();

    }
    
    private void initializeListeners() {
        this.panelabout.BtnUpdate.addActionListener(this);
        this.panelabout.BtnCheck.addActionListener(this);
        this.panelabout.BtnX.addActionListener(this);
    }    
    
    @Override
     public void actionPerformed(ActionEvent e) {
    
    if (e.getSource() == panelabout.BtnUpdate) {
     //modifypatiets();
    }else if (e.getSource() == panelabout.BtnCheck) {
    //deleteDoctor();
    } else if (e.getSource() == panelabout.BtnX) {
    JOptionPane.showMessageDialog(null, "Se cancelo la actualización", "Actualización de datos", JOptionPane.INFORMATION_MESSAGE);
    disableFields();
    } 

    }
     
    private void disableFields() {
    panelabout.txtName.disable();
    panelabout.txtAddress.disable();
    panelabout.txtPhone.disable();
    panelabout.txtEmail.disable();
    panelabout.BtnX.setVisible(false);
    panelabout.BtnCheck.setVisible(false);  
     }     
}
