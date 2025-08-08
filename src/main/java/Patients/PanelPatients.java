
package Patients;


public class PanelPatients extends javax.swing.JPanel {

    
    public PanelPatients() {
        initComponents();
        initStyles();
        lockTable();
    }

    
    public void lockTable() {
    // Oculta la barra de pestañas
    jTabbedPane1.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {
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
    BtnDelete.putClientProperty( "JButton.buttonType" , "roundRect" ); 
    BtnInfo.putClientProperty( "JButton.buttonType" , "roundRect" ); 

    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        panelRound1 = new Mvc.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        PatientsTable = new javax.swing.JTable();
        BtnDelete = new javax.swing.JButton();
        BtnInfo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Lbl13 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        TxtLastNameF = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        Lbl12 = new javax.swing.JLabel();
        TxtPhone = new javax.swing.JTextField();
        TxtEmail = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        TxtResponsable = new javax.swing.JTextField();
        TxtCivilStats = new javax.swing.JTextField();
        Lbl14 = new javax.swing.JLabel();
        TxtLastNameM = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        TxtId = new javax.swing.JTextField();
        lable = new javax.swing.JLabel();
        TxtAge = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        TxtSex = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        TxtOcupation = new javax.swing.JTextField();
        BtnUpdate = new javax.swing.JButton();
        BtnX = new javax.swing.JButton();
        BtnCheck = new javax.swing.JButton();
        ComboProvince = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(1010, 700));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista de pacientes");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 25, 969, -1));

        TxtSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(TxtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 200, 32));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busqueda.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 40, 32));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(75);
        panelRound1.setRoundBottomRight(75);
        panelRound1.setRoundTopLeft(75);
        panelRound1.setRoundTopRight(75);

        PatientsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Primer Apellido", "Segundo Apellido", "Identificación", "Correo", "Telefono"
            }
        ));
        jScrollPane1.setViewportView(PatientsTable);

        BtnDelete.setBackground(new java.awt.Color(255, 0, 0));
        BtnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnDelete.setForeground(new java.awt.Color(255, 255, 255));
        BtnDelete.setText("Borrar");

        BtnInfo.setBackground(new java.awt.Color(51, 51, 255));
        BtnInfo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnInfo.setForeground(new java.awt.Color(255, 255, 255));
        BtnInfo.setText("Información");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(BtnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151)
                .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(274, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 1000, 530));

        jTabbedPane1.addTab("tab1", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Lbl13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl13.setText("Nombre");
        jPanel2.add(Lbl13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 44, 200, -1));

        jLabel33.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Primer apellido");
        jPanel2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 44, 200, -1));

        TxtNombre.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(TxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 85, 200, 30));

        TxtLastNameF.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(TxtLastNameF, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 85, 200, 30));

        jLabel34.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Telefono");
        jPanel2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 145, 200, -1));

        Lbl12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Lbl12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl12.setText("Correo");
        jPanel2.add(Lbl12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 145, 200, -1));

        TxtPhone.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(TxtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 186, 200, 30));

        TxtEmail.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(TxtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 186, 200, 30));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Responsable");
        jPanel2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 248, 200, -1));

        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Estado Civil");
        jPanel2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 248, 200, -1));

        TxtResponsable.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(TxtResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 289, 200, 30));

        TxtCivilStats.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(TxtCivilStats, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 289, 200, 30));

        Lbl14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Lbl14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl14.setText("Segundo apellido");
        jPanel2.add(Lbl14, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 44, 200, -1));

        TxtLastNameM.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(TxtLastNameM, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 85, 200, 30));

        jLabel37.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Provincia");
        jPanel2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 145, 200, -1));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Identificación");
        jPanel2.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(776, 44, 200, -1));

        TxtId.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(TxtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 83, 200, 30));

        lable.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lable.setText("Edad");
        jPanel2.add(lable, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 145, 200, -1));

        TxtAge.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(TxtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 188, 200, 30));

        jLabel39.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Sexo");
        jPanel2.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 249, 200, -1));

        TxtSex.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(TxtSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 289, 200, 30));

        jLabel40.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Ocupación");
        jPanel2.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 249, 200, -1));

        TxtOcupation.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel2.add(TxtOcupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 289, 200, 30));

        BtnUpdate.setBackground(new java.awt.Color(51, 51, 255));
        BtnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        BtnUpdate.setText("Actualizar");
        jPanel2.add(BtnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 579, 180, 50));

        BtnX.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        BtnX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/circulo-marca-x.png"))); // NOI18N
        jPanel2.add(BtnX, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 579, 50, 50));

        BtnCheck.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnCheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/checked.png"))); // NOI18N
        jPanel2.add(BtnCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(637, 579, 51, 50));

        ComboProvince.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ComboProvince.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "San José", "Alajuela", "Cartago", "Heredia", "Guanacaste", "Puntarenas", "Limón" }));
        jPanel2.add(ComboProvince, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 187, 200, 30));

        jTabbedPane1.addTab("tab2", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnCheck;
    public javax.swing.JButton BtnDelete;
    public javax.swing.JButton BtnInfo;
    public javax.swing.JButton BtnUpdate;
    public javax.swing.JButton BtnX;
    public javax.swing.JComboBox<String> ComboProvince;
    public javax.swing.JLabel Lbl12;
    public javax.swing.JLabel Lbl13;
    public javax.swing.JLabel Lbl14;
    public javax.swing.JTable PatientsTable;
    public javax.swing.JTextField TxtAge;
    public javax.swing.JTextField TxtCivilStats;
    public javax.swing.JTextField TxtEmail;
    public javax.swing.JTextField TxtId;
    public javax.swing.JTextField TxtLastNameF;
    public javax.swing.JTextField TxtLastNameM;
    public javax.swing.JTextField TxtNombre;
    public javax.swing.JTextField TxtOcupation;
    public javax.swing.JTextField TxtPhone;
    public javax.swing.JTextField TxtResponsable;
    public javax.swing.JTextField TxtSearch;
    public javax.swing.JTextField TxtSex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JLabel lable;
    private Mvc.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
