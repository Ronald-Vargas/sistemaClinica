
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

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Clinica Latina");

        LblAbout.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        LblAbout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblAbout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblAbout, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel LblAbout;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
