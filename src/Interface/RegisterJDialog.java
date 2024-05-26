/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Interface;

import Database.DBConnect;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dat
 */
public class RegisterJDialog extends javax.swing.JDialog {

    /**
     * Creates new form RegisterJDialog
     */
    public RegisterJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jcbRole.removeAllItems();
        jcbRole.addItem("Sinh Viên");
        jcbRole.addItem("Giảng Viên");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfUser = new javax.swing.JTextField();
        jpfPass = new javax.swing.JPasswordField();
        jpfRePass = new javax.swing.JPasswordField();
        jbtnRegister = new javax.swing.JButton();
        jbtnExit = new javax.swing.JButton();
        jcbRole = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("ĐĂNG KÝ");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Nhập tài khoản:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Nhập mật khẩu:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Nhập lại mật khẩu");

        jtfUser.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jpfPass.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jpfRePass.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jbtnRegister.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbtnRegister.setText("Đăng ký");
        jbtnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRegisterActionPerformed(evt);
            }
        });

        jbtnExit.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbtnExit.setText("Quay lại");
        jbtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExitActionPerformed(evt);
            }
        });

        jcbRole.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jcbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Chọn loại tài khoản:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jbtnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfUser)
                            .addComponent(jpfRePass)
                            .addComponent(jpfPass)
                            .addComponent(jcbRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jpfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jpfRePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnRegister)
                    .addComponent(jbtnExit))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRegisterActionPerformed
        String username = jtfUser.getText();
        char[] pass = jpfPass.getPassword();
        char[] repass = jpfRePass.getPassword();
        String password = new String(pass);
        String repassword = new String(repass);
        String usertype = jcbRole.getSelectedItem().toString();

        // Kiểm tra dữ liệu hợp lệ
        if (username.isEmpty() || password.isEmpty() || repassword.isEmpty() || usertype.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.");
            return;
        }
        if (password.length()<8)
        {
            JOptionPane.showMessageDialog(this, "Mật khẩu phải có ít nhất 8 kí tự.");
            return;     
        }
        // Kiểm tra mật khẩu khớp nhau
        if (!password.equals(repassword)) {
            JOptionPane.showMessageDialog(this, "Mật khẩu không khớp nhau.");
            return;
        }
        if (usertype.equals("Sinh Viên")) {
        String sql = "SELECT maSV FROM sinhvien WHERE maSV = '" + username + "'";
        Connection conn = DBConnect.getConnection();
        Statement sta = null ; 
            try {
                sta = conn.createStatement();
                ResultSet rs = sta.executeQuery(sql);
                if (rs.next()) {
                    sql = "Select user_name from users where user_name = '"+username+"'";
                    ResultSet rS = sta.executeQuery(sql);
                    if (rS.next())
                    {
                        JOptionPane.showMessageDialog(this, "User đã tồn tại.");
                    }
                    else {
                        sql = "INSERT INTO `users` (`user_name`, `pass`, `user_type`) VALUES ('"+username+"','"+password+"','Student')";
                        sta.executeUpdate(sql);
                        JOptionPane.showMessageDialog(this, "Đăng ký thành công.");
                        return;
                    }
                    
                }
                else {
                     JOptionPane.showMessageDialog(this, "Mã sinh viên không tồn tại.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegisterJDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        

        
        }
        else {
            String sql = "SELECT maGiangVien FROM giangvien WHERE maGiangVien = '" + username + "'";
            Connection conn = DBConnect.getConnection();
            Statement sta = null ; 
                try {
                    sta = conn.createStatement();
                    ResultSet rs = sta.executeQuery(sql);
                    if (rs.next()) {
                        sql = "Select user_name from users where user_name = '"+username+"'";
                        ResultSet rS = sta.executeQuery(sql);
                        if (rS.next())
                        {
                            JOptionPane.showMessageDialog(this, "User đã tồn tại.");
                        }
                        else {
                            sql = "INSERT INTO `users` (`user_name`, `pass`, `user_type`) VALUES ('"+username+"','"+password+"','Teacher')";
                            sta.executeUpdate(sql);
                            JOptionPane.showMessageDialog(this, "Đăng ký thành công.");
                            return;
                        }
                    }
                    else {
                         JOptionPane.showMessageDialog(this, "Mã giảng viên không tồn tại.");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(RegisterJDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }//GEN-LAST:event_jbtnRegisterActionPerformed

    private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExitActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnExitActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegisterJDialog dialog = new RegisterJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtnExit;
    private javax.swing.JButton jbtnRegister;
    private javax.swing.JComboBox<String> jcbRole;
    private javax.swing.JPasswordField jpfPass;
    private javax.swing.JPasswordField jpfRePass;
    private javax.swing.JTextField jtfUser;
    // End of variables declaration//GEN-END:variables
}
