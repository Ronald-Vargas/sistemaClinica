
package Sistem;


import Home.Home;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;


public class SistemDoctors extends javax.swing.JFrame {

   
    public SistemDoctors() {
        initComponents();

        initHour();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        BackgroundMenus = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        BtnPatients = new javax.swing.JButton();
        BtnDoctors = new javax.swing.JButton();
        BtnQuotes = new javax.swing.JButton();
        BtnAbout = new javax.swing.JButton();
        BtnLogout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        BtnBox = new javax.swing.JButton();
        Header = new javax.swing.JPanel();
        Content = new javax.swing.JPanel();
        Header1 = new javax.swing.JPanel();
        LblDate = new javax.swing.JLabel();
        LblCopy = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackgroundMenus.setBackground(new java.awt.Color(40, 39, 38));
        BackgroundMenus.setForeground(new java.awt.Color(43, 42, 42));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Clinica Latina");

        BtnPatients.setBackground(new java.awt.Color(40, 39, 38));
        BtnPatients.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        BtnPatients.setForeground(new java.awt.Color(204, 204, 204));
        BtnPatients.setText("Pacientes");
        BtnPatients.setBorderPainted(false);
        BtnPatients.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnPatients.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        BtnDoctors.setBackground(new java.awt.Color(40, 39, 38));
        BtnDoctors.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        BtnDoctors.setForeground(new java.awt.Color(204, 204, 204));
        BtnDoctors.setText("Medicos");
        BtnDoctors.setBorderPainted(false);
        BtnDoctors.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnDoctors.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        BtnQuotes.setBackground(new java.awt.Color(40, 39, 38));
        BtnQuotes.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        BtnQuotes.setForeground(new java.awt.Color(204, 204, 204));
        BtnQuotes.setText("Citas");
        BtnQuotes.setBorderPainted(false);
        BtnQuotes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnQuotes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        BtnAbout.setBackground(new java.awt.Color(40, 39, 38));
        BtnAbout.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        BtnAbout.setForeground(new java.awt.Color(204, 204, 204));
        BtnAbout.setText("Acerca de");
        BtnAbout.setBorderPainted(false);
        BtnAbout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAbout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        BtnLogout.setBackground(new java.awt.Color(40, 39, 38));
        BtnLogout.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        BtnLogout.setForeground(new java.awt.Color(204, 204, 204));
        BtnLogout.setText("Cerrar Sesión");
        BtnLogout.setBorderPainted(false);
        BtnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnLogout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLogoutActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(234, 225, 225));
        jLabel2.setText("Configuraciones");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(234, 225, 225));
        jLabel3.setText("Administración");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(234, 225, 225));
        jLabel4.setText("Usuarios");

        BtnBox.setBackground(new java.awt.Color(40, 39, 38));
        BtnBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        BtnBox.setForeground(new java.awt.Color(204, 204, 204));
        BtnBox.setText("Caja");
        BtnBox.setBorderPainted(false);
        BtnBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnBox.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout BackgroundMenusLayout = new javax.swing.GroupLayout(BackgroundMenus);
        BackgroundMenus.setLayout(BackgroundMenusLayout);
        BackgroundMenusLayout.setHorizontalGroup(
            BackgroundMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundMenusLayout.createSequentialGroup()
                .addComponent(BtnPatients, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundMenusLayout.createSequentialGroup()
                .addGroup(BackgroundMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnDoctors, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnAbout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BackgroundMenusLayout.createSequentialGroup()
                        .addGroup(BackgroundMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(BackgroundMenusLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(BackgroundMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(BackgroundMenusLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(208, 208, 208))
            .addGroup(BackgroundMenusLayout.createSequentialGroup()
                .addGroup(BackgroundMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(BtnQuotes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BackgroundMenusLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(BackgroundMenusLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(208, 208, 208))
        );
        BackgroundMenusLayout.setVerticalGroup(
            BackgroundMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundMenusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(BtnQuotes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnBox, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(BackgroundMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundMenusLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150))
                    .addGroup(BackgroundMenusLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnPatients, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnDoctors, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(BtnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Header.setBackground(new java.awt.Color(255, 255, 255));
        Header.setLayout(new java.awt.BorderLayout());

        Content.setBackground(new java.awt.Color(240, 247, 248));
        Content.setLayout(new java.awt.BorderLayout());

        Header1.setBackground(new java.awt.Color(255, 255, 255));

        LblDate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        LblDate.setForeground(new java.awt.Color(40, 39, 38));
        LblDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblDate.setText("Hoy es {dayname} {day} de {month} de {year}");

        javax.swing.GroupLayout Header1Layout = new javax.swing.GroupLayout(Header1);
        Header1.setLayout(Header1Layout);
        Header1Layout.setHorizontalGroup(
            Header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Header1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Header1Layout.setVerticalGroup(
            Header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LblDate, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        LblCopy.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        LblCopy.setForeground(new java.awt.Color(40, 39, 38));
        LblCopy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblCopy.setText("© Copyright 2025");

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addComponent(BackgroundMenus, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Header1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGap(1026, 1026, 1026)
                        .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(LblCopy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundMenus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addComponent(Header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGap(738, 738, 738)
                        .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblCopy)
                        .addGap(7, 7, 7))))
        );

        getContentPane().add(Background, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLogoutActionPerformed

    }//GEN-LAST:event_BtnLogoutActionPerformed

   
    
    
    
    
    
    public void initHour() {
    LocalDate today = LocalDate.now();
    String dayName = today.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
    int day = today.getDayOfMonth();
    String month = today.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
    int year = today.getYear();
        
    String Date = "Hoy es " + dayName + " " + day + " de " + month + " de " + year;
    LblDate.setText(Date);
    
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
            java.util.logging.Logger.getLogger(SistemDoctors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SistemDoctors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SistemDoctors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SistemDoctors.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SistemDoctors().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JPanel BackgroundMenus;
    public javax.swing.JButton BtnAbout;
    public javax.swing.JButton BtnBox;
    public javax.swing.JButton BtnDoctors;
    public javax.swing.JButton BtnLogout;
    public javax.swing.JButton BtnPatients;
    public javax.swing.JButton BtnQuotes;
    public javax.swing.JPanel Content;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Header1;
    public javax.swing.JLabel LblCopy;
    public javax.swing.JLabel LblDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
}
