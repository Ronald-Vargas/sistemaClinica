
package Appointment;

import com.github.lgooddatepicker.components.TimePickerSettings;
import java.awt.Color;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;


public class PanelAppointmentDoctors extends javax.swing.JPanel {

    public PanelAppointmentDoctors() {
        initComponents();
        initStyles();
        initCalendar();
        initTimePicker();
        lockTable();
    }

    
    public void initStyles() {
       BtnDelete.putClientProperty( "JButton.buttonType" , "roundRect" ); 
       BtnEdit.putClientProperty( "JButton.buttonType" , "roundRect" ); 
      
    }
    
    
    public void initCalendar() {
    ComboFechaCita.getJCalendar().getDayChooser().addDateEvaluator(new com.toedter.calendar.IDateEvaluator() {
        @Override
        public boolean isInvalid(Date date) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);

            // Obtener la fecha actual sin hora
            Calendar today = Calendar.getInstance();
            today.set(Calendar.HOUR_OF_DAY, 0);
            today.set(Calendar.MINUTE, 0);
            today.set(Calendar.SECOND, 0);
            today.set(Calendar.MILLISECOND, 0);

            // Deshabilitar sábados y domingos
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            boolean isWeekend = (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY);

            // Deshabilitar fechas pasadas
            boolean isPastDate = cal.before(today);

            return isWeekend || isPastDate;
        }

        @Override
        public Color getInvalidForegroundColor() {
            return Color.GRAY;
        }

        @Override
        public Color getInvalidBackroundColor() {
            return Color.LIGHT_GRAY;
        }

        @Override
        public String getInvalidTooltip() {
            return "Día no disponible";
        }

        @Override
        public boolean isSpecial(Date date) {
            return false;
        }

        @Override
        public Color getSpecialForegroundColor() {
            return null;
        }

        @Override
        public Color getSpecialBackroundColor() {
            return null;
        }

        @Override
        public String getSpecialTooltip() {
            return null;
        }
    });
}
    
    
    public void initTimePicker() {
    TimePickerSettings settings = ComboHora.getSettings();
    settings.generatePotentialMenuTimes(TimePickerSettings.TimeIncrement.ThirtyMinutes, LocalTime.of(8, 0), LocalTime.of(16, 0));
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
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ComboSearch = new com.toedter.calendar.JDateChooser();
        panelRound1 = new Mvc.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        AppointmentTable = new javax.swing.JTable();
        BtnEdit = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        BtnPDF = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ComboFilter = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        Lbl13 = new javax.swing.JLabel();
        TxtIdCita = new javax.swing.JTextField();
        Lbl14 = new javax.swing.JLabel();
        ComboFechaCita = new com.toedter.calendar.JDateChooser();
        Lbl15 = new javax.swing.JLabel();
        ComboHora = new com.github.lgooddatepicker.components.TimePicker();
        Lbl16 = new javax.swing.JLabel();
        TxtIdPaciente = new javax.swing.JTextField();
        Lbl17 = new javax.swing.JLabel();
        ComboEspecialidad = new javax.swing.JComboBox<>();
        Lbl18 = new javax.swing.JLabel();
        ComboFechaRegistro = new com.toedter.calendar.JDateChooser();
        BtnUpdate = new javax.swing.JButton();
        BtnX = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setMinimumSize(new java.awt.Dimension(1022, 716));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1022, 716));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista de citas");
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));

        jLabel3.setText("Citas el dia:");
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(75);
        panelRound1.setRoundBottomRight(75);
        panelRound1.setRoundTopLeft(75);
        panelRound1.setRoundTopRight(75);

        AppointmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "IDCita", "Fecha Cita", "Hora", "IDPaciente", "Especialidad", "Fecha Registro", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(AppointmentTable);

        BtnEdit.setText("Editar");
        BtnEdit.setBackground(new java.awt.Color(255, 153, 51));
        BtnEdit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnEdit.setForeground(new java.awt.Color(255, 255, 255));

        BtnDelete.setText("Borrar");
        BtnDelete.setBackground(new java.awt.Color(255, 0, 0));
        BtnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnDelete.setForeground(new java.awt.Color(255, 255, 255));

        BtnPDF.setText("Reporte PDF");
        BtnPDF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        BtnPDF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnPDF.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(BtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(BtnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel4.setText("Estado");
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        ComboFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Pendiente", "Atendida" }));
        ComboFilter.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1020, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 15, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(187, 187, 187)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(264, 264, 264)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(187, 187, 187)
                            .addComponent(ComboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(182, 182, 182)
                            .addComponent(ComboFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 16, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 685, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 8, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(28, 28, 28)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(jLabel4)))
                    .addGap(6, 6, 6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(ComboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(ComboFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(31, 31, 31)
                    .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 9, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        Lbl13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl13.setText("ID Cita");
        Lbl13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        TxtIdCita.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TxtIdCita.setEnabled(false);

        Lbl14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl14.setText("Fecha Registro");
        Lbl14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Lbl14.setToolTipText("");

        Lbl15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl15.setText("Hora");
        Lbl15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        Lbl16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl16.setText("ID Paciente");
        Lbl16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        TxtIdPaciente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TxtIdPaciente.setEnabled(false);

        Lbl17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl17.setText("Especialidad");
        Lbl17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        ComboEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Medico General", "Odontologo", "Pediatra", "Dermatologo", "Psiquiatra", "Nutricionista" }));

        Lbl18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl18.setText("Fecha Cita");
        Lbl18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Lbl18.setToolTipText("");

        ComboFechaRegistro.setEnabled(false);

        BtnUpdate.setText("Actualizar");
        BtnUpdate.setBackground(new java.awt.Color(51, 51, 255));
        BtnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnUpdate.setForeground(new java.awt.Color(255, 255, 255));

        BtnX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/circulo-marca-x.png"))); // NOI18N
        BtnX.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(202, 383, Short.MAX_VALUE)
                        .addComponent(BtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Lbl13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TxtIdCita, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(ComboFechaCita, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(Lbl18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(ComboEspecialidad, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Lbl17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                                .addGap(68, 68, 68)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BtnX, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Lbl14, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ComboFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lbl15, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(ComboHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lbl16, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtIdPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl13)
                    .addComponent(Lbl15)
                    .addComponent(Lbl16)
                    .addComponent(Lbl18))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtIdCita)
                    .addComponent(ComboFechaCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ComboHora, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(TxtIdPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
                .addGap(75, 75, 75)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl17)
                    .addComponent(Lbl14))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ComboFechaRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(ComboEspecialidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 324, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnX, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 720));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable AppointmentTable;
    public javax.swing.JButton BtnDelete;
    public javax.swing.JButton BtnEdit;
    public javax.swing.JButton BtnPDF;
    public javax.swing.JButton BtnUpdate;
    public javax.swing.JButton BtnX;
    public javax.swing.JComboBox<String> ComboEspecialidad;
    public com.toedter.calendar.JDateChooser ComboFechaCita;
    public com.toedter.calendar.JDateChooser ComboFechaRegistro;
    public javax.swing.JComboBox<String> ComboFilter;
    public com.github.lgooddatepicker.components.TimePicker ComboHora;
    public com.toedter.calendar.JDateChooser ComboSearch;
    public javax.swing.JLabel Lbl13;
    public javax.swing.JLabel Lbl14;
    public javax.swing.JLabel Lbl15;
    public javax.swing.JLabel Lbl16;
    public javax.swing.JLabel Lbl17;
    public javax.swing.JLabel Lbl18;
    public javax.swing.JTextField TxtIdCita;
    public javax.swing.JTextField TxtIdPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTabbedPane jTabbedPane1;
    private Mvc.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
