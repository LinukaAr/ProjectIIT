
package iitmanegement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

public class AddMarks extends javax.swing.JFrame {
    
   
    private  String SUrl = "jdbc:mysql://localhost:3306/iitdatabase";
    private String SUser = "root";
    private String SPass = "";
    
    
    public AddMarks() {
        initComponents();
        loadItemNames();  
    
    
    sid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = sid.getSelectedItem().toString();
                // Query the database to get the item's price and description based on the selected item name.
                showItemDetails(selectedItem);
            }
        });
    }
                
    private void loadItemNames() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            String query = "SELECT Student_Id FROM student";
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            sid.removeAllItems();
            while (rs.next()) {
                String itemName = rs.getString("Student_Id");
                sid.addItem(itemName);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed (show error message, log, etc.)
        }
    }
        
    
    
    private void showItemDetails(String itemName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
            String query = "SELECT Student_Name, NIC FROM student WHERE Student_Id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, itemName);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
    String Sname = rs.getString("Student_Name");
    String NIC = rs.getString("NIC");
    
    sname.setText(Sname);
    nic.setText(NIC);
    ;
} else {
    // Handle the case when the student ID is not found in the database.
    sname.setText("");    
    nic.setText("");
    
}

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed (show error message, log, etc.)
        }
    }


   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCourses = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sname = new javax.swing.JTextField();
        nic = new javax.swing.JTextField();
        mod1 = new javax.swing.JTextField();
        mod3 = new javax.swing.JTextField();
        sid = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        mod2 = new javax.swing.JTextField();
        save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtCourses.setBackground(new java.awt.Color(255, 255, 255));
        txtCourses.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("                  Add Marks");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Student ID              :");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Student Name       :");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("NIC                        :");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Module 1");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Module 3");

        sname.setBackground(new java.awt.Color(204, 204, 204));
        sname.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        sname.setForeground(new java.awt.Color(0, 0, 0));

        nic.setBackground(new java.awt.Color(204, 204, 204));
        nic.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        nic.setForeground(new java.awt.Color(0, 0, 0));
        nic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicActionPerformed(evt);
            }
        });

        mod1.setBackground(new java.awt.Color(204, 204, 204));
        mod1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        mod1.setForeground(new java.awt.Color(0, 0, 0));
        mod1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mod1ActionPerformed(evt);
            }
        });

        mod3.setBackground(new java.awt.Color(204, 204, 204));
        mod3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        mod3.setForeground(new java.awt.Color(0, 0, 0));
        mod3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mod3ActionPerformed(evt);
            }
        });

        sid.setBackground(new java.awt.Color(255, 255, 255));
        sid.setForeground(new java.awt.Color(0, 0, 0));
        sid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        sid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sidActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Assignment Marks:");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Module 2");

        mod2.setBackground(new java.awt.Color(204, 204, 204));
        mod2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        mod2.setForeground(new java.awt.Color(0, 0, 0));
        mod2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mod2ActionPerformed(evt);
            }
        });

        save.setBackground(new java.awt.Color(204, 0, 0));
        save.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txtCoursesLayout = new javax.swing.GroupLayout(txtCourses);
        txtCourses.setLayout(txtCoursesLayout);
        txtCoursesLayout.setHorizontalGroup(
            txtCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtCoursesLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(txtCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(txtCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(txtCoursesLayout.createSequentialGroup()
                            .addGroup(txtCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(4, 4, 4)
                            .addGroup(txtCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(mod2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(mod1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nic, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                .addComponent(sname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                .addComponent(sid, javax.swing.GroupLayout.Alignment.LEADING, 0, 350, Short.MAX_VALUE)
                                .addComponent(mod3)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        txtCoursesLayout.setVerticalGroup(
            txtCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtCoursesLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addGroup(txtCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sid, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(txtCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sname, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(txtCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nic, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txtCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mod1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(txtCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mod2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txtCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mod3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(save)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(txtCourses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCourses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nicActionPerformed

    private void mod1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mod1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mod1ActionPerformed

    private void mod3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mod3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mod3ActionPerformed

    private void sidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sidActionPerformed

    private void mod2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mod2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mod2ActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        System.out.println("Save btn clicked");
        String Student_Id, Student_Name, NIC,MOD1,MOD2,MOD3,query;
        String SUrl,SUser,SPass;
        SUrl ="jdbc:mysql://localhost:3306/iitdatabase";
        SUser = "root";
        SPass = "";
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection(SUrl, SUser, SPass);
             Statement st =con.createStatement();
             if("".equals(sid.getSelectedItem().toString())){
                 JOptionPane.showMessageDialog(new JFrame(),    "Id is required", "Error",
                         JOptionPane.ERROR_MESSAGE);
             }else if("".equals(sname.getText())){
                 JOptionPane.showMessageDialog(new JFrame(),    "Name is required", "Error",
                         JOptionPane.ERROR_MESSAGE);
             }else if("".equals(nic.getText())){
                 JOptionPane.showMessageDialog(new JFrame(),    "Nic  is required", "Error",
                         JOptionPane.ERROR_MESSAGE);
             }else{
             Student_Id = sid.getSelectedItem().toString();
             Student_Name	 = sname.getText(); 
             NIC = nic.getText(); 
             MOD1 = mod1.getText();
             MOD2 = mod2.getText();
             MOD3 = mod3.getText();
             
            query = "INSERT INTO marks(Student_Id, Student_Name, NIC, MOD1, MOD2, MOD3) " +
                    "VALUES('"+Student_Id+"','"+Student_Name+"','"+NIC+"','"+MOD1+"','"+MOD2+"','"+MOD3+"')";
            
            st.execute(query);
            sid.setSelectedItem("");
            sname.setText("");
            nic.setText("");
            mod1.setText("");
            mod2.setText("");
            mod3.setText("");
            
            showMessageDialog(null, "Marks has been Saved successfully!");
            }
         }catch(Exception e){
             System.out.println("Error!=" + e.getMessage());
         
         }
                                           

    }//GEN-LAST:event_saveActionPerformed

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
            java.util.logging.Logger.getLogger(AddMarks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddMarks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddMarks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddMarks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddMarks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField mod1;
    private javax.swing.JTextField mod2;
    private javax.swing.JTextField mod3;
    private javax.swing.JTextField nic;
    private javax.swing.JButton save;
    private javax.swing.JComboBox<String> sid;
    private javax.swing.JTextField sname;
    private javax.swing.JPanel txtCourses;
    // End of variables declaration//GEN-END:variables
}
