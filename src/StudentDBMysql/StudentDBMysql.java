package StudentDBMysql;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;



public class StudentDBMysql extends javax.swing.JFrame {
    
    private static final String username="root";
    private static final String password="Abhi@1289";
    private static final String dataConn ="jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";

    Connection sqlConn =null;
    PreparedStatement pst = null;
    ResultSet rs=null;
     int q, i, id, deleteItem;
    /**
     * Creates new form StudentDBMysql
     */
    public StudentDBMysql() {
        initComponents();
        updateDB();
    }

    @SuppressWarnings("unchecked")
    //===============================Function Declaration======================================
    
    public void updateDB()
    {
        //int q, i;
         try
        {
           
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            sqlConn = DriverManager.getConnection(dataConn,username,password);
            pst = sqlConn.prepareStatement("select * from studentdata");
            
            rs = pst.executeQuery();
            ResultSetMetaData StData = rs.getMetaData();
            
            q = StData.getColumnCount();
            
            DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
            RecordTable.setRowCount(0);
            while(rs.next()){
                
                Vector columnData = new Vector();
                
                for (i = 1; i <= q; i++)
                {
                    columnData.add(rs.getString("studentid"));
                    columnData.add(rs.getString("firstname"));
                    columnData.add(rs.getString("surname"));
                    columnData.add(rs.getString("address"));
                    columnData.add(rs.getString("gender"));
                    columnData.add(rs.getString("mobile"));
                    columnData.add(rs.getString("maths"));
                    columnData.add(rs.getString("games"));
                    columnData.add(rs.getString("datasci"));
                    columnData.add(rs.getString("analysis"));
                    columnData.add(rs.getString("graphic"));
                    columnData.add(rs.getString("database1"));
                    columnData.add(rs.getString("science"));
                    columnData.add(rs.getString("english"));
                }
                    RecordTable.addRow(columnData);
            }
         
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    void clearWhole(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            sqlConn = DriverManager.getConnection(dataConn,username,password);
            PreparedStatement pst = sqlConn.prepareStatement("delete from studentdata");
            pst.executeUpdate();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    private void clearTable() {
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.setRowCount(0);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFirstname = new javax.swing.JTextField();
        txtStudentID = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtSurname = new javax.swing.JTextField();
        txtMobile = new javax.swing.JTextField();
        cboGender = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cboGraphic = new javax.swing.JComboBox<>();
        cboDatabase = new javax.swing.JComboBox<>();
        cboScience = new javax.swing.JComboBox<>();
        cboEnglish = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cboMaths = new javax.swing.JComboBox<>();
        cboGames = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cboAnalysis = new javax.swing.JComboBox<>();
        cboDataSci = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        btnPrint = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnAddNew = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1360, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(95, 158, 160), 4));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel4.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setBackground(new java.awt.Color(0, 153, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        jLabel15.setText("Learning Management System");
        jLabel15.setToolTipText("");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1460, 100));

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel5.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Student ID", "Firstname", "Surname", "Address", "Gender", "Mobile", "Maths", "Games", "Data Sci", "Analysis", "Graphic", "Database", "Science", "English"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 410));

        jPanel5.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 980, -1));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Mobile");
        jPanel7.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Student ID");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Firstname");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Surname");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Address");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Gender");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        txtFirstname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel7.add(txtFirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 320, -1));

        txtStudentID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel7.add(txtStudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 320, -1));

        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel7.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 320, -1));

        txtSurname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel7.add(txtSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 320, -1));

        txtMobile.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel7.add(txtMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 120, -1));

        cboGender.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Female", "Male", "prefer not to say" }));
        cboGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGenderActionPerformed(evt);
            }
        });
        jPanel7.add(cboGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 120, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Graphic");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Database");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Science");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("English");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        cboGraphic.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboGraphic.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Yes", "Core Unit", "Complete" }));
        jPanel3.add(cboGraphic, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 90, 30));

        cboDatabase.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboDatabase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Yes", "Core Unit", "Complete" }));
        jPanel3.add(cboDatabase, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 90, 30));

        cboScience.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboScience.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Yes", "Core Unit", "Complete" }));
        jPanel3.add(cboScience, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 90, 30));

        cboEnglish.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboEnglish.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Yes", "Core Unit", "Complete" }));
        jPanel3.add(cboEnglish, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 90, 30));

        jPanel7.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 220, 170));

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel8.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Maths");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        cboMaths.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboMaths.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Yes", "Core Unit", "Complete" }));
        jPanel8.add(cboMaths, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 90, 30));

        cboGames.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboGames.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Yes", "Core Unit", "Complete" }));
        jPanel8.add(cboGames, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 90, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Games");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Data Sci");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Analysis");
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        cboAnalysis.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboAnalysis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Yes", "Core Unit", "Complete" }));
        jPanel8.add(cboAnalysis, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 90, 30));

        cboDataSci.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboDataSci.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Yes", "Core Unit", "Complete" }));
        jPanel8.add(cboDataSci, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 90, 30));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 200, 170));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 450, 410));

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPrint.setBackground(new java.awt.Color(0, 153, 255));
        btnPrint.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel6.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 212, 60));

        btnReset.setBackground(new java.awt.Color(0, 153, 255));
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel6.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 212, 60));

        btnDelete.setBackground(new java.awt.Color(0, 153, 255));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnDelete.setText("Delete Table");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel6.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 320, 60));

        btnExit.setBackground(new java.awt.Color(0, 153, 255));
        btnExit.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel6.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, 212, 60));

        btnAddNew.setBackground(new java.awt.Color(0, 153, 255));
        btnAddNew.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnAddNew.setText("Add New");
        btnAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewActionPerformed(evt);
            }
        });
        jPanel6.add(btnAddNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 10, 200, 60));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 1290, 80));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1460, 520));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1460, 620));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtStudentID.setText("");
            txtFirstname.setText("");
            txtSurname.setText("");
            txtAddress.setText("");
            cboGender.setSelectedIndex(0);
            txtMobile.setText("");
            cboMaths.setSelectedIndex(0);
            cboGames.setSelectedIndex(0);
            cboDataSci.setSelectedIndex(0);
            cboAnalysis.setSelectedIndex(0);
            cboGraphic.setSelectedIndex(0);
            cboDatabase.setSelectedIndex(0);
            cboScience.setSelectedIndex(0);
            cboEnglish.setSelectedIndex(0);
    }//GEN-LAST:event_btnResetActionPerformed
private JFrame frame;
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        
      frame = new JFrame("Exit");
      if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","Student Management Systems",
              JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
          System.exit(0);
      }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewActionPerformed
        
        try
        {
           
           Class.forName("com.mysql.cj.jdbc.Driver"); 
            sqlConn = DriverManager.getConnection(dataConn,username,password);
            pst = sqlConn.prepareStatement("insert into studentdata(studentid,firstname,surname,address,"
                    + "gender,mobile,maths,games,datasci,analysis,graphic,database1,science,english)values"
                    + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            pst.setString(1, txtStudentID.getText());
            pst.setString(2, txtFirstname.getText());
            pst.setString(3, txtSurname.getText());
            pst.setString(4, txtAddress.getText());
            pst.setString(5, (String) cboGender.getSelectedItem());
            pst.setString(6, txtMobile.getText());
            pst.setString(7, (String)cboMaths.getSelectedItem());
            pst.setString(8, (String)cboGames.getSelectedItem());
            pst.setString(9, (String)cboDataSci.getSelectedItem());
            pst.setString(10, (String)cboAnalysis.getSelectedItem());
            pst.setString(11, (String)cboGraphic.getSelectedItem());
            pst.setString(12, (String)cboDatabase.getSelectedItem());
            pst.setString(13, (String)cboScience.getSelectedItem());
            pst.setString(14, (String)cboEnglish.getSelectedItem());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"Student Record Added");
            clearTable();
            updateDB();
        }
        
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentDBMysql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
             //System.err.println(ex);
            java.util.logging.Logger.getLogger(StudentDBMysql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
   
        
    }//GEN-LAST:event_btnAddNewActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
        DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
        int SelectedRows = jTable1.getSelectedRow();
        
        txtStudentID.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
        txtFirstname.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
        txtSurname.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
        txtAddress.setText(RecordTable.getValueAt(SelectedRows, 4).toString());        
        cboGender.setSelectedItem(RecordTable.getValueAt(SelectedRows, 5).toString());        
        txtMobile.setText(RecordTable.getValueAt(SelectedRows, 6).toString());
        cboMaths.setSelectedItem(RecordTable.getValueAt(SelectedRows, 7).toString());
        cboGames.setSelectedItem(RecordTable.getValueAt(SelectedRows, 8).toString());
        cboDataSci.setSelectedItem(RecordTable.getValueAt(SelectedRows, 9).toString());
        cboAnalysis.setSelectedItem(RecordTable.getValueAt(SelectedRows, 10).toString());
        cboGraphic.setSelectedItem(RecordTable.getValueAt(SelectedRows, 11).toString());
        cboDatabase.setSelectedItem(RecordTable.getValueAt(SelectedRows, 12).toString());
        cboScience.setSelectedItem(RecordTable.getValueAt(SelectedRows, 13).toString());
        cboEnglish.setSelectedItem(RecordTable.getValueAt(SelectedRows, 14).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed

        
        MessageFormat header = new MessageFormat("Printing in progress");
        MessageFormat footer = new MessageFormat("Page {0, number, integer}");
        
        try
        {
            jTable1.print(JTable.PrintMode.NORMAL,header,footer);
        }
        
        catch(java.awt.print.PrinterException e)
        {
            System.err.format("No Printer found", e.getMessage());
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        
      DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
      int SelectedRows = jTable1.getSelectedRow();
      frame = new JFrame("delete");
      if (JOptionPane.showConfirmDialog(frame, "Confirm do you want to reset table","Student Management Systems",
              JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
       clearWhole();
       updateDB();
      }
 
 
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void cboGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboGenderActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(StudentDBMysql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentDBMysql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentDBMysql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentDBMysql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentDBMysql().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNew;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cboAnalysis;
    private javax.swing.JComboBox<String> cboDataSci;
    private javax.swing.JComboBox<String> cboDatabase;
    private javax.swing.JComboBox<String> cboEnglish;
    private javax.swing.JComboBox<String> cboGames;
    private javax.swing.JComboBox<String> cboGender;
    private javax.swing.JComboBox<String> cboGraphic;
    private javax.swing.JComboBox<String> cboMaths;
    private javax.swing.JComboBox<String> cboScience;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtStudentID;
    private javax.swing.JTextField txtSurname;
    // End of variables declaration//GEN-END:variables
}
