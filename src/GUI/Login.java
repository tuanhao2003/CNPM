/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.spi.DirStateFactory;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 *
 * @author toica
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */

    public Login() {
        initComponents();
    }
 private Connection con;
    public boolean openConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "localhost";
            String DatabaseName="QLCH" ;
            String TenDangNhap = "sa"; 
            String MatKhau= "123";
            String url = "jdbc:sqlserver://" +dbUrl + ":1433;DatabaseName=" + DatabaseName + ";username="+TenDangNhap+";password="+MatKhau+";encrypt=true;trustServerCertificate=true;";
            con=DriverManager.getConnection(url);         
            return true;
        }catch (Exception ex){
            System.out.println(ex);
            return false;
        }
    }
    public void closeConection(){
        try {
            if (con != null)
                con.close();
        } catch (SQLException ex) {
            System.out.println(ex); }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtTenDangNhap = new javax.swing.JTextField();
        Loginbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtMatKhau = new javax.swing.JPasswordField();
        btnDangKy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("ĐĂNG NHẬP");
        jLabel1.setToolTipText("");

        Loginbtn.setText("Đăng nhập");
        Loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginbtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Quên mật khẩu?");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setText("Tên đăng nhập:");

        jLabel4.setText("Mật khẩu:");

        TxtMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtMatKhauActionPerformed(evt);
            }
        });

        btnDangKy.setText("Đăng ký");
        btnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(TxtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TxtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(Loginbtn)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel2))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jLabel1)))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Loginbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnDangKy))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        Loginbtn.getAccessibleContext().setAccessibleDescription("JLoginbtn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtMatKhauActionPerformed

    private void LoginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginbtnActionPerformed
        // TODO add your handling code here:
        String TenDangNhap = TxtTenDangNhap.getText();
        String MatKhau = String.valueOf(TxtMatKhau.getPassword());
        boolean confirms = true;

        if (TenDangNhap.equals("")) {
            confirms = false;
            JOptionPane.showMessageDialog(this, "Tên đăng nhập không được để trống");
        } else if (MatKhau.equals("")) {
            confirms = false;
            JOptionPane.showMessageDialog(this, "Mật khẩu không được để trống");
        }

        if (confirms) {
            if (openConnection()) {
                try {
                    String sql = "SELECT tk.MaTK, q.PhanQuyen " +
                                 "FROM TaiKhoan tk " +
                                 "INNER JOIN Quyen q ON tk.MaTK = q.MaTK " +
                                 "WHERE tk.TenDangNhap = ? AND tk.MatKhau = ?";
                    PreparedStatement ps = con.prepareCall(sql);
                    ps.setString(1, TenDangNhap);
                    ps.setString(2, MatKhau);
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        int phanQuyen = rs.getInt("PhanQuyen");

                        if (phanQuyen == 1) {
                            // Hiển thị trang Admin
                            mainGUI ad = new mainGUI();
                            ad.setVisible(true);
                            JOptionPane.showMessageDialog(ad, "Chào mừng bạn đến với trang Admin.");

                        } else if (phanQuyen == 0) {
                            JOptionPane.showMessageDialog(this, "Tài khoản đã bị khóa");
                        } else if (phanQuyen == 2) {
                            // Hiển thị trang Nhân Viên
                            StaffGUI st = new StaffGUI();
                            st.setVisible(true);
                            JOptionPane.showMessageDialog(st, "Chào mừng bạn đến với trang Nhân viên.");
                        } else if (phanQuyen == 3) {
                            // Hiển thị trang mua hàng
                            JOptionPane.showMessageDialog(this, "Chào mừng bạn đến với trang mua hàng.");
                        }
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Sai tên đăng nhập hoặc mật khẩu");
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
}

    }//GEN-LAST:event_LoginbtnActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MousePressed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Vui lòng liên hệ trantrunghieu20122002@gmail.com để lấy lại mật khẩu");
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKyActionPerformed
        // TODO add your handling code here:
        RegisterGUI rg = new RegisterGUI();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                rg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                rg.setLocationRelativeTo(null); // Đặt vị trí của frame giữa màn hình
                rg.setVisible(true);
            }
        });
    }//GEN-LAST:event_btnDangKyActionPerformed
   
    
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login login = new Login();
            login.setLocationRelativeTo(null); // Đặt JFrame ra giữa màn hình
            login.setVisible(true);
                
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Loginbtn;
    private javax.swing.JPasswordField TxtMatKhau;
    private javax.swing.JTextField TxtTenDangNhap;
    private javax.swing.JButton btnDangKy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    
}
