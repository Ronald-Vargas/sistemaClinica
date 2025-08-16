
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
       BtnPDF.putClientProperty( "JButton.buttonType" , "roundRect" ); 
       BtnRegistrarPago.putClientProperty( "JButton.buttonType" , "roundRect" ); 
      
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

        ComboHora2 = new com.github.lgooddatepicker.components.TimePicker();
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
        BtnRegistrarPago = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ComboFilter = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        TxtSearchId = new javax.swing.JTextField();
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
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        Lbl19 = new javax.swing.JLabel();
        Lbl20 = new javax.swing.JLabel();
        Lbl21 = new javax.swing.JLabel();
        Lbl22 = new javax.swing.JLabel();
        Lbl23 = new javax.swing.JLabel();
        Lbl24 = new javax.swing.JLabel();
        Lbl25 = new javax.swing.JLabel();
        Lbl26 = new javax.swing.JLabel();
        panelRound2 = new Mvc.PanelRound();
        Lbl27 = new javax.swing.JLabel();
        Lbl28 = new javax.swing.JLabel();
        Lbl29 = new javax.swing.JLabel();
        TxtMonto = new javax.swing.JTextField();
        TxtIVA = new javax.swing.JTextField();
        TxtMontoFinal = new javax.swing.JTextField();
        BtnPagar = new javax.swing.JButton();
        BtnCancel = new javax.swing.JButton();
        Lbl31 = new javax.swing.JLabel();
        TxtNombre4 = new javax.swing.JLabel();
        TxtIdPaciente4 = new javax.swing.JLabel();
        TxtIdCita4 = new javax.swing.JLabel();
        TxtPrimerApellido4 = new javax.swing.JLabel();
        TxtSegundoApellido4 = new javax.swing.JLabel();
        ComboEspecialidad4 = new javax.swing.JLabel();
        ComboEstado4 = new javax.swing.JLabel();
        ComboHora4 = new javax.swing.JLabel();
        ComboFechaCita4 = new javax.swing.JLabel();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista de citas");
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
        AppointmentTable.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jScrollPane1.setViewportView(AppointmentTable);

        BtnEdit.setText("Editar");
        BtnEdit.setBackground(new java.awt.Color(255, 153, 51));
        BtnEdit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnEdit.setForeground(new java.awt.Color(255, 255, 255));

        BtnDelete.setText("Borrar");
        BtnDelete.setBackground(new java.awt.Color(255, 0, 0));
        BtnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnDelete.setForeground(new java.awt.Color(255, 255, 255));

        BtnPDF.setText("Comprobante");
        BtnPDF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        BtnPDF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnPDF.setForeground(new java.awt.Color(255, 0, 0));

        BtnRegistrarPago.setText("Registrar Pago");
        BtnRegistrarPago.setBackground(new java.awt.Color(0, 0, 255));
        BtnRegistrarPago.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnRegistrarPago.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(BtnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(55, 55, 55)
                        .addComponent(BtnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(179, 179, 179)
                        .addComponent(BtnPDF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(50, 50, 50)
                        .addComponent(BtnRegistrarPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(17, 17, 17))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnRegistrarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Identificación Paciente");
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        ComboFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Pendiente", "Atendida" }));
        ComboFilter.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Estado");
        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        TxtSearchId.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ComboSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(96, 96, 96)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ComboFilter, 0, 150, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(92, 92, 92)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtSearchId, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                .addGap(162, 162, 162))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(ComboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ComboFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TxtSearchId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel4))
                .addGap(34, 34, 34)
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        Lbl13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl13.setText("ID Cita");
        Lbl13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        TxtIdCita.setEnabled(false);
        TxtIdCita.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

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

        TxtIdPaciente.setEnabled(false);
        TxtIdPaciente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

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
                        .addGap(202, 395, Short.MAX_VALUE)
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
                            .addComponent(Lbl15, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        Lbl19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl19.setText("Nombre del paciente");
        Lbl19.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        Lbl20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl20.setText("Primer Apellido");
        Lbl20.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        Lbl21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl21.setText("Segundo Apellido");
        Lbl21.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        Lbl22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl22.setText("ID Cita");
        Lbl22.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        Lbl23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl23.setText("Especialidad");
        Lbl23.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        Lbl24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl24.setText("Estado");
        Lbl24.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        Lbl25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl25.setText("Fecha Cita");
        Lbl25.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Lbl25.setToolTipText("");

        Lbl26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl26.setText("Hora");
        Lbl26.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        panelRound2.setBackground(new java.awt.Color(248, 248, 248));
        panelRound2.setRoundBottomLeft(75);
        panelRound2.setRoundBottomRight(75);
        panelRound2.setRoundTopLeft(75);
        panelRound2.setRoundTopRight(75);

        Lbl27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl27.setText("Monto");
        Lbl27.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        Lbl28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl28.setText("IVA");
        Lbl28.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        Lbl29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl29.setText("Monto Final");
        Lbl29.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        TxtMonto.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TxtMonto.setEnabled(false);

        TxtIVA.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TxtIVA.setEnabled(false);

        TxtMontoFinal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        TxtMontoFinal.setEnabled(false);

        BtnPagar.setText("Pagar");
        BtnPagar.setBackground(new java.awt.Color(0, 204, 0));
        BtnPagar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnPagar.setForeground(new java.awt.Color(255, 255, 255));

        BtnCancel.setText("Cancelar");
        BtnCancel.setBackground(new java.awt.Color(204, 0, 0));
        BtnCancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnCancel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addComponent(BtnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lbl27)
                            .addComponent(Lbl28)
                            .addComponent(Lbl29))
                        .addGap(25, 25, 25)
                        .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtMontoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(124, 124, 124))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(Lbl27))
                    .addComponent(TxtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(Lbl28))
                    .addComponent(TxtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(Lbl29))
                    .addComponent(TxtMontoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        Lbl31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl31.setText("ID Paciente");
        Lbl31.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        TxtNombre4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtNombre4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        TxtIdPaciente4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtIdPaciente4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        TxtIdPaciente4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        TxtIdCita4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtIdCita4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        TxtIdCita4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        TxtPrimerApellido4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtPrimerApellido4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        TxtSegundoApellido4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtSegundoApellido4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        ComboEspecialidad4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ComboEspecialidad4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        ComboEstado4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ComboEstado4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        ComboHora4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ComboHora4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        ComboFechaCita4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ComboFechaCita4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lbl21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lbl19, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(TxtNombre4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lbl20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtPrimerApellido4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtSegundoApellido4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(109, 109, 109)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ComboEspecialidad4, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(Lbl23, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(Lbl31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(TxtIdCita4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lbl22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtIdPaciente4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(125, 125, 125)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ComboHora4, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(ComboEstado4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lbl24, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(Lbl26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lbl25, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(ComboFechaCita4, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addGap(96, 96, 96))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Lbl22)
                            .addComponent(Lbl25))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TxtIdCita4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboFechaCita4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Lbl19)
                        .addGap(18, 18, 18)
                        .addComponent(TxtNombre4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl20)
                    .addComponent(Lbl26)
                    .addComponent(Lbl31))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TxtIdPaciente4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtPrimerApellido4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboHora4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Lbl23)
                                .addGap(18, 18, 18)
                                .addComponent(ComboEspecialidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Lbl24)
                                .addGap(18, 18, 18)
                                .addComponent(ComboEstado4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Lbl21, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtSegundoApellido4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable AppointmentTable;
    public javax.swing.JButton BtnCancel;
    public javax.swing.JButton BtnDelete;
    public javax.swing.JButton BtnEdit;
    public javax.swing.JButton BtnPDF;
    public javax.swing.JButton BtnPagar;
    public javax.swing.JButton BtnRegistrarPago;
    public javax.swing.JButton BtnUpdate;
    public javax.swing.JButton BtnX;
    public javax.swing.JComboBox<String> ComboEspecialidad;
    public javax.swing.JLabel ComboEspecialidad4;
    public javax.swing.JLabel ComboEstado4;
    public com.toedter.calendar.JDateChooser ComboFechaCita;
    public javax.swing.JLabel ComboFechaCita4;
    public com.toedter.calendar.JDateChooser ComboFechaRegistro;
    public javax.swing.JComboBox<String> ComboFilter;
    public com.github.lgooddatepicker.components.TimePicker ComboHora;
    public com.github.lgooddatepicker.components.TimePicker ComboHora2;
    public javax.swing.JLabel ComboHora4;
    public com.toedter.calendar.JDateChooser ComboSearch;
    public javax.swing.JLabel Lbl13;
    public javax.swing.JLabel Lbl14;
    public javax.swing.JLabel Lbl15;
    public javax.swing.JLabel Lbl16;
    public javax.swing.JLabel Lbl17;
    public javax.swing.JLabel Lbl18;
    public javax.swing.JLabel Lbl19;
    public javax.swing.JLabel Lbl20;
    public javax.swing.JLabel Lbl21;
    public javax.swing.JLabel Lbl22;
    public javax.swing.JLabel Lbl23;
    public javax.swing.JLabel Lbl24;
    public javax.swing.JLabel Lbl25;
    public javax.swing.JLabel Lbl26;
    public javax.swing.JLabel Lbl27;
    public javax.swing.JLabel Lbl28;
    public javax.swing.JLabel Lbl29;
    public javax.swing.JLabel Lbl31;
    public javax.swing.JTextField TxtIVA;
    public javax.swing.JTextField TxtIdCita;
    public javax.swing.JLabel TxtIdCita4;
    public javax.swing.JTextField TxtIdPaciente;
    public javax.swing.JLabel TxtIdPaciente4;
    public javax.swing.JTextField TxtMonto;
    public javax.swing.JTextField TxtMontoFinal;
    public javax.swing.JLabel TxtNombre4;
    public javax.swing.JLabel TxtPrimerApellido4;
    public javax.swing.JTextField TxtSearchId;
    public javax.swing.JLabel TxtSegundoApellido4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTabbedPane jTabbedPane1;
    private Mvc.PanelRound panelRound1;
    private Mvc.PanelRound panelRound2;
    // End of variables declaration//GEN-END:variables
}
