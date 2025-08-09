
package Login;

import java.awt.Image;
import javax.swing.ImageIcon;


public class LoginPatient extends javax.swing.JFrame {

    
    public LoginPatient() {
        initComponents();
        initImage();
        initStyles();
    }

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        LblImg = new javax.swing.JLabel();
        Content = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtEmail = new javax.swing.JTextField();
        TxtPass = new javax.swing.JPasswordField();
        BtnLogOut = new javax.swing.JButton();
        BtnLogIn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        LblRegister = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LblImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background Login.png"))); // NOI18N
        Background.add(LblImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 800));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ingrese sesión con sus datos");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Correo");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Contraseña");

        TxtEmail.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        TxtPass.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TxtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPassActionPerformed(evt);
            }
        });

        BtnLogOut.setBackground(new java.awt.Color(204, 0, 0));
        BtnLogOut.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BtnLogOut.setForeground(new java.awt.Color(255, 255, 255));
        BtnLogOut.setText("Salir");
        BtnLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLogOutActionPerformed(evt);
            }
        });

        BtnLogIn.setBackground(new java.awt.Color(0, 204, 204));
        BtnLogIn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        BtnLogIn.setForeground(new java.awt.Color(255, 255, 255));
        BtnLogIn.setText("Iniciar Sesión");
        BtnLogIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLogInActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("¿Olvidaste tu contraseña?");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        LblRegister.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LblRegister.setForeground(new java.awt.Color(102, 102, 102));
        LblRegister.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblRegister.setText("¿Aun no tienes una cuenta? Registrate");
        LblRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LblRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LblRegisterMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ContentLayout = new javax.swing.GroupLayout(Content);
        Content.setLayout(ContentLayout);
        ContentLayout.setHorizontalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ContentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(ContentLayout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(76, 76, 76)
                            .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ContentLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(52, 52, 52)
                            .addComponent(TxtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ContentLayout.createSequentialGroup()
                            .addGap(353, 353, 353)
                            .addComponent(jLabel5))
                        .addGroup(ContentLayout.createSequentialGroup()
                            .addGap(135, 135, 135)
                            .addComponent(LblRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ContentLayout.createSequentialGroup()
                            .addGap(135, 135, 135)
                            .addComponent(BtnLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ContentLayout.createSequentialGroup()
                            .addGap(135, 135, 135)
                            .addComponent(BtnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        ContentLayout.setVerticalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ContentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(6, 6, 6)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(102, 102, 102)
                    .addGroup(ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(100, 100, 100)
                    .addGroup(ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(ContentLayout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(TxtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(12, 12, 12)
                    .addComponent(jLabel5)
                    .addGap(206, 206, 206)
                    .addComponent(LblRegister)
                    .addGap(30, 30, 30)
                    .addComponent(BtnLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(45, 45, 45)
                    .addComponent(BtnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Background.add(Content, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 600, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
    
    public void initStyles() {
    TxtEmail.putClientProperty("JTextField.placeholderText", "Ingrese su correo electronico");
    TxtPass.putClientProperty("JTextField.placeholderText", "Ingrese su contraseña");
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    
    private void TxtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtPassActionPerformed

    
    private void LblRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblRegisterMouseClicked
     
    }//GEN-LAST:event_LblRegisterMouseClicked

    private void BtnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLogInActionPerformed

    }//GEN-LAST:event_BtnLogInActionPerformed

    
    private void BtnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLogOutActionPerformed

    }//GEN-LAST:event_BtnLogOutActionPerformed

    
    
    
    
    
    public void initImage() {
    
    ImageIcon imagenOriginal = new ImageIcon("src/main/resources/Background Login.png");

        // Escalar la imagen al tamaño del JLabel
        Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(
        LblImg.getWidth(), 
        LblImg.getHeight(), 
        Image.SCALE_SMOOTH);

    // Crear el nuevo ImageIcon con la imagen escalada
    ImageIcon imagenFinal = new ImageIcon(imagenEscalada);

    // Establecer la imagen en el JLabel
    LblImg.setIcon(imagenFinal);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    public javax.swing.JButton BtnLogIn;
    public javax.swing.JButton BtnLogOut;
    public javax.swing.JPanel Content;
    private javax.swing.JLabel LblImg;
    public javax.swing.JLabel LblRegister;
    public javax.swing.JTextField TxtEmail;
    public javax.swing.JPasswordField TxtPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
