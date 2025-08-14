
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

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista de pacientes");

        TxtSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busqueda.png"))); // NOI18N

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
                .addComponent(BtnInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addGap(151, 151, 151)
                .addComponent(BtnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addGap(266, 266, 266))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        Lbl13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Lbl13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl13.setText("Nombre");
        Lbl13.setMaximumSize(null);
        Lbl13.setMinimumSize(null);
        Lbl13.setPreferredSize(null);

        jLabel33.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Primer apellido");
        jLabel33.setMaximumSize(null);
        jLabel33.setMinimumSize(null);
        jLabel33.setPreferredSize(null);

        TxtNombre.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TxtNombre.setMargin(new java.awt.Insets(6, 2, 6, 6));
        TxtNombre.setMaximumSize(null);

        TxtLastNameF.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TxtLastNameF.setMargin(null);
        TxtLastNameF.setMaximumSize(null);
        TxtLastNameF.setPreferredSize(null);

        jLabel34.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Telefono");
        jLabel34.setMaximumSize(null);
        jLabel34.setMinimumSize(null);
        jLabel34.setPreferredSize(null);

        Lbl12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Lbl12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl12.setText("Correo");
        Lbl12.setMaximumSize(null);
        Lbl12.setMinimumSize(null);
        Lbl12.setPreferredSize(null);

        TxtPhone.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TxtPhone.setMargin(null);
        TxtPhone.setMaximumSize(null);
        TxtPhone.setPreferredSize(null);

        TxtEmail.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TxtEmail.setMargin(null);
        TxtEmail.setMaximumSize(null);
        TxtEmail.setMinimumSize(null);
        TxtEmail.setPreferredSize(null);

        jLabel35.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Responsable");
        jLabel35.setMaximumSize(null);
        jLabel35.setMinimumSize(null);
        jLabel35.setPreferredSize(null);

        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Estado Civil");
        jLabel36.setMaximumSize(null);
        jLabel36.setMinimumSize(null);
        jLabel36.setPreferredSize(null);

        TxtResponsable.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TxtResponsable.setMargin(null);
        TxtResponsable.setMaximumSize(null);
        TxtResponsable.setRequestFocusEnabled(false);

        TxtCivilStats.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TxtCivilStats.setMargin(null);
        TxtCivilStats.setMaximumSize(null);

        Lbl14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Lbl14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl14.setText("Segundo apellido");
        Lbl14.setMaximumSize(null);
        Lbl14.setMinimumSize(null);
        Lbl14.setPreferredSize(null);

        TxtLastNameM.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TxtLastNameM.setMargin(null);
        TxtLastNameM.setMaximumSize(null);
        TxtLastNameM.setMinimumSize(null);
        TxtLastNameM.setPreferredSize(null);

        jLabel37.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Provincia");
        jLabel37.setMaximumSize(null);
        jLabel37.setMinimumSize(null);
        jLabel37.setPreferredSize(null);

        jLabel38.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Identificación");
        jLabel38.setMaximumSize(null);
        jLabel38.setMinimumSize(null);
        jLabel38.setPreferredSize(null);

        TxtId.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TxtId.setMargin(null);
        TxtId.setMaximumSize(null);
        TxtId.setMinimumSize(null);
        TxtId.setPreferredSize(null);

        lable.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lable.setText("Edad");
        lable.setMaximumSize(null);
        lable.setMinimumSize(null);
        lable.setPreferredSize(null);

        TxtAge.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TxtAge.setMargin(null);
        TxtAge.setMaximumSize(null);
        TxtAge.setMinimumSize(null);

        jLabel39.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Sexo");
        jLabel39.setMaximumSize(null);
        jLabel39.setMinimumSize(null);
        jLabel39.setPreferredSize(null);

        TxtSex.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TxtSex.setMargin(null);
        TxtSex.setMaximumSize(null);
        TxtSex.setMinimumSize(null);
        TxtSex.setPreferredSize(null);

        jLabel40.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Ocupación");
        jLabel40.setMaximumSize(null);
        jLabel40.setMinimumSize(null);
        jLabel40.setPreferredSize(null);

        TxtOcupation.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TxtOcupation.setMargin(null);
        TxtOcupation.setMaximumSize(null);
        TxtOcupation.setMinimumSize(null);
        TxtOcupation.setPreferredSize(null);

        BtnUpdate.setBackground(new java.awt.Color(51, 51, 255));
        BtnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        BtnUpdate.setText("Actualizar");

        BtnX.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        BtnX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/circulo-marca-x.png"))); // NOI18N

        BtnCheck.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnCheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/checked.png"))); // NOI18N

        ComboProvince.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ComboProvince.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "San José", "Alajuela", "Cartago", "Heredia", "Guanacaste", "Puntarenas", "Limón" }));
        ComboProvince.setMaximumSize(null);
        ComboProvince.setMinimumSize(null);
        ComboProvince.setPreferredSize(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(Lbl13, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(Lbl14, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(TxtLastNameF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(TxtLastNameM, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(Lbl12, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(lable, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(TxtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(ComboProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(TxtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(TxtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(TxtCivilStats, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(TxtSex, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(TxtOcupation, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(307, 307, 307)
                .addComponent(BtnX, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(BtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(BtnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lbl13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbl14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtLastNameF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtLastNameM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbl12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(ComboProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCivilStats, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtSex, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtOcupation, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(271, 271, 271)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(BtnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(BtnX, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))
                .addGap(51, 51, 51))
        );

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
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
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
