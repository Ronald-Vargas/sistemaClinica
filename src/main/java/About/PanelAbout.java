
package About;


public class PanelAbout extends javax.swing.JPanel {

    
    public PanelAbout() {
        initComponents();
        initStyles();
    }

   public void initStyles() {
   
   
    LblAbout.setText("<html>"
      + "<div style='width:840px; font-family:\"Times New Roman\"; font-size:12px; color:#333333; text-align:justify;'>"
    
    + "<p><b>Clínica Latina</b> nace con una visión clara: transformar la atención médica en una experiencia humana, accesible y eficiente.</p><br><br>"
    
    + "<p>Con años de experiencia atendiendo a miles de pacientes, comprendimos que la salud no solo depende de buenos médicos, "
    + "sino también de sistemas modernos<br> que faciliten el acceso a la atención profesional.</p><br><br>"
    
    + "<p>Por eso desarrollamos este sistema de gestión de citas, una plataforma diseñada con empatía y tecnología, "
    + "para que cada paciente pueda agendar<br> sus consultas de forma rápida, sencilla y desde cualquier lugar.</p><br><br>"
    
    + "<p>Con solo unos clics, puedes seleccionar el profesional de tu preferencia, elegir el horario más conveniente "
    + "y recibir confirmaciones automáticas<br> directamente en tu correo electrónico o teléfono móvil.</p><br><br>"
    
    + "<p>Además, entendemos la importancia de llevar un historial clínico organizado. Este sistema guarda tus citas, diagnósticos "
    + "y recomendaciones, accesibles para ti<br> y para el equipo médico, mejorando la calidad de atención.</p><br><br>"
    
    + "<p>También recibirás recordatorios automáticos para no olvidar tus citas, y podrás modificarlas o cancelarlas en cualquier momento, "
    + "sin necesidad de hacer llamadas<br> ni esperar en fila.</p><br><br>"
    
    + "<p>Todo esto lo construimos pensando en tu comodidad, tu tiempo y tu salud. Esta herramienta representa nuestro compromiso contigo, "
    + "porque en Clínica Latina queremos<br> cuidarte mejor, desde el primer clic hasta el momento de tu atención médica.</p><br><br>"
    
    + "<p><b>Gracias por confiar en nosotros.</b></p><br>"
    
    + "<p><b>Bienvenido a una nueva era en la atención médica.</b></p>"
    
    + "</div></html>");
   
   
   
   }
    
   
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        LblAbout = new javax.swing.JLabel();
        BtnUpdate = new javax.swing.JButton();
        BtnCheck = new javax.swing.JButton();
        BtnX = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Clinica Latina");

        LblAbout.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        LblAbout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        BtnUpdate.setBackground(new java.awt.Color(51, 51, 255));
        BtnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        BtnUpdate.setText("Actualizar");

        BtnCheck.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnCheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/checked.png"))); // NOI18N

        BtnX.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        BtnX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/circulo-marca-x.png"))); // NOI18N

        jLabel2.setText("Nombre");

        jLabel3.setText("Dirección ");

        jLabel4.setText("Telefono");

        jLabel5.setText("Correo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LblAbout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(317, 317, 317)
                                .addComponent(BtnX, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(BtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(BtnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(92, 92, 92)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LblAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(9, 9, 9)
                                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnX, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(BtnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                        .addGap(39, 39, 39))))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnCheck;
    public javax.swing.JButton BtnUpdate;
    public javax.swing.JButton BtnX;
    public javax.swing.JLabel LblAbout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JTextField txtAddress;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtName;
    public javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
