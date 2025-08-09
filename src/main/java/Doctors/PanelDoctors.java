
package Doctors;

/**
 *
 * @author ronal
 */
public class PanelDoctors extends javax.swing.JPanel {

    
    public PanelDoctors() {
        initComponents();
        initStyles();
        lockTable();
    }

    
    public void lockTable() {
    // Oculta la barra de pestañas
    jTabbedPane.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {
        @Override
        protected int calculateTabAreaHeight(int tabPlacement, int horizRunCount, int maxTabHeight) {
            return 0;
        }
    });

   
    }
    
    
    
    
    
    
    
    public void initStyles() {
    TxtSearch.putClientProperty("JComponent.roundRect", true); 
    TxtSearch.putClientProperty("JComponent.arc", 15);       
    TxtSearch.putClientProperty("JTextField.placeholderText", "Ingrese una identificación");
    btnDelete.putClientProperty( "JButton.buttonType" , "roundRect" ); 
    btnEdit.putClientProperty( "JButton.buttonType" , "roundRect" ); 
    btnAdd.putClientProperty( "JButton.buttonType" , "roundRect" ); 
    BtnContinue.putClientProperty( "JButton.buttonType" , "roundRect" ); 
    BtnOut.putClientProperty( "JButton.buttonType" , "roundRect" ); 

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        TxtSearch = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        panelRound7 = new Mvc.PanelRound();
        jScrollPane7 = new javax.swing.JScrollPane();
        DoctorsTable = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        Lbl13 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        TxtLastName = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        Lbl12 = new javax.swing.JLabel();
        TxtId1 = new javax.swing.JTextField();
        TxtSecondLastname = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        Txtmail = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        TxtPhone = new javax.swing.JTextField();
        Lbl15 = new javax.swing.JLabel();
        ComboSpecialty = new javax.swing.JComboBox<>();
        TxtPass = new javax.swing.JPasswordField();
        Lbl14 = new javax.swing.JLabel();
        BtnOut = new javax.swing.JButton();
        BtnContinue = new javax.swing.JButton();

        setRequestFocusEnabled(false);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 102, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Lista de medicos");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 25, 955, -1));

        TxtSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel4.add(TxtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 200, 31));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busqueda.png"))); // NOI18N
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 40, 31));

        panelRound7.setBackground(new java.awt.Color(255, 255, 255));
        panelRound7.setRoundBottomLeft(75);
        panelRound7.setRoundBottomRight(75);
        panelRound7.setRoundTopLeft(75);
        panelRound7.setRoundTopRight(75);

        DoctorsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Primer Apellido", "Segundo Apellido", "Identificación", "Correo", "Telefono", "Contraseña", "Especialidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(DoctorsTable);

        btnAdd.setBackground(new java.awt.Color(51, 204, 0));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Agregar");

        btnEdit.setBackground(new java.awt.Color(255, 153, 51));
        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Editar");

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Borrar");

        javax.swing.GroupLayout panelRound7Layout = new javax.swing.GroupLayout(panelRound7);
        panelRound7.setLayout(panelRound7Layout);
        panelRound7Layout.setHorizontalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(233, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
        );
        panelRound7Layout.setVerticalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jPanel4.add(panelRound7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 1000, 530));

        jTabbedPane.addTab("tab1", jPanel4);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Registra tus datos");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 1014, 38));

        jLabel32.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Completa toda la información solicitada para registrarte como doctor.");
        jPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 56, 1014, 29));

        Lbl13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Lbl13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl13.setText("Nombre");
        jPanel2.add(Lbl13, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 142, 200, -1));

        jLabel33.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Primer apellido");
        jPanel2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 142, 200, -1));

        TxtNombre.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(TxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 183, 200, 30));

        TxtLastName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(TxtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 183, 200, 30));

        jLabel34.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Segundo apellido");
        jPanel2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 243, 200, -1));

        Lbl12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Lbl12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl12.setText("Identificación");
        jPanel2.add(Lbl12, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 243, 200, -1));

        TxtId1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(TxtId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 284, 200, 30));

        TxtSecondLastname.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(TxtSecondLastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 284, 200, 30));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Correo");
        jPanel2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 344, 200, -1));

        Txtmail.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(Txtmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 385, 200, 30));

        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Telefono");
        jPanel2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 344, 200, -1));

        TxtPhone.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(TxtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 385, 200, 30));

        Lbl15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Lbl15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl15.setText("Especialidad");
        jPanel2.add(Lbl15, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 445, 200, -1));

        ComboSpecialty.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ComboSpecialty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--SELECCIONAR--", "Medico General", "Odontologo", "Pediatra", "Dermatologo", "Psiquiatra", "Nutricionista" }));
        jPanel2.add(ComboSpecialty, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 486, 200, 30));
        jPanel2.add(TxtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 486, 200, 30));

        Lbl14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Lbl14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl14.setText("Contraseña");
        jPanel2.add(Lbl14, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 445, 200, -1));

        BtnOut.setBackground(new java.awt.Color(255, 0, 0));
        BtnOut.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnOut.setForeground(new java.awt.Color(255, 255, 255));
        BtnOut.setText("Cancelar");
        jPanel2.add(BtnOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 640, 200, 32));

        BtnContinue.setBackground(new java.awt.Color(0, 204, 0));
        BtnContinue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnContinue.setForeground(new java.awt.Color(255, 255, 255));
        BtnContinue.setText("Continuar");
        jPanel2.add(BtnContinue, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 580, 200, 32));

        jTabbedPane.addTab("tab2", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnContinue;
    public javax.swing.JButton BtnOut;
    public javax.swing.JComboBox<String> ComboSpecialty;
    public javax.swing.JTable DoctorsTable;
    public javax.swing.JLabel Lbl12;
    public javax.swing.JLabel Lbl13;
    public javax.swing.JLabel Lbl14;
    public javax.swing.JLabel Lbl15;
    public javax.swing.JTextField TxtId1;
    public javax.swing.JTextField TxtLastName;
    public javax.swing.JTextField TxtNombre;
    public javax.swing.JPasswordField TxtPass;
    public javax.swing.JTextField TxtPhone;
    public javax.swing.JTextField TxtSearch;
    public javax.swing.JTextField TxtSecondLastname;
    public javax.swing.JTextField Txtmail;
    public javax.swing.JButton btnAdd;
    public javax.swing.JButton btnDelete;
    public javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane7;
    public javax.swing.JTabbedPane jTabbedPane;
    private Mvc.PanelRound panelRound7;
    // End of variables declaration//GEN-END:variables
}
