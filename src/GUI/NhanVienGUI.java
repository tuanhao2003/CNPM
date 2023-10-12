/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import BUS.NhanVienBLL;
import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JLabel;


/**
 *
 * @author HAO KIET
 */
public class NhanVienGUI extends javax.swing.JPanel {
    NhanVienBLL nvBLL=new NhanVienBLL();
    
    ArrayList<NhanVienDTO> arrNhanVien=new ArrayList<NhanVienDTO>();
    
    DefaultTableModel modelNV = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // không cho phép chỉnh sửa giá trị các ô trong bảng
        }
    };
    /**
     * Creates new form NhanVienGUI
     */
    public NhanVienGUI() {
        initComponents();
        
        jTable_NhanVien.setModel(modelNV);
        
        modelNV.addColumn("STT");
        modelNV.addColumn("Mã Nhân Viên");
        modelNV.addColumn("Tên Nhân Viên");
        modelNV.addColumn("Giới Tính");
        modelNV.addColumn("Địa Chỉ");
        modelNV.addColumn("Số Điện Thoại");
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
        jLabel5 = new javax.swing.JLabel();
        jTextField_DiaChi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField_SDT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField_Ten = new javax.swing.JTextField();
        jComboBox_Gender = new javax.swing.JComboBox<>();
        jButton_Them = new javax.swing.JButton();
        jButton_Sua = new javax.swing.JButton();
        jButton_Xoa = new javax.swing.JButton();
        jComboBox_SearchType = new javax.swing.JComboBox<>();
        jTextField_Search = new javax.swing.JTextField();
        jButton_Search = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_NhanVien = new javax.swing.JTable();
        jButton_Huy = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1000, 650));
        setMinimumSize(new java.awt.Dimension(1000, 650));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 51)));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Giới Tính");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Địa Chỉ");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Số Điện Thoại");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Tên Nhân Viên");

        jComboBox_Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam","Nữ" }));
        jComboBox_Gender.setToolTipText("");
        jComboBox_Gender.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox_Gender.setPreferredSize(new java.awt.Dimension(100, 30));
        jComboBox_Gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_GenderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField_Ten)
                    .addComponent(jTextField_SDT, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
                .addGap(146, 146, 146)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox_Gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_Ten))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_SDT)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox_Gender, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)))
                .addGap(28, 28, 28))
        );

        jButton_Them.setText("Thêm");
        jButton_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThemActionPerformed(evt);
            }
        });

        jButton_Sua.setText("Sửa");
        jButton_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SuaActionPerformed(evt);
            }
        });

        jButton_Xoa.setText("Xóa");
        jButton_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XoaActionPerformed(evt);
            }
        });

        jComboBox_SearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã Nhân Viên","Tên Nhân Viên" }));
        jComboBox_SearchType.setPreferredSize(new java.awt.Dimension(100, 30));
        jComboBox_SearchType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_SearchTypeActionPerformed(evt);
            }
        });

        jButton_Search.setText("Tìm Kiếm");
        jButton_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SearchActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));

        jTable_NhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_NhanVien);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
        );

        jButton_Huy.setText("Hủy");
        jButton_Huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_HuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(237, 237, 237)
                                .addComponent(jComboBox_SearchType, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(jButton_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(133, 133, 133)
                                .addComponent(jButton_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(145, 145, 145)
                                .addComponent(jButton_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(123, 123, 123)
                                .addComponent(jButton_Huy, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Them)
                    .addComponent(jButton_Sua)
                    .addComponent(jButton_Xoa)
                    .addComponent(jButton_Huy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_Search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox_SearchType, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jTextField_Search))
                .addGap(8, 8, 8)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_GenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_GenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_GenderActionPerformed

    private void jComboBox_SearchTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_SearchTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_SearchTypeActionPerformed

    private void jButton_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThemActionPerformed
        // TODO add your handling code here:
        // Lấy dữ liệu từ jTextField
        String ten = jTextField_Ten.getText();
        String sdt = jTextField_SDT.getText();
        String diachi = jTextField_DiaChi.getText();
        String gioitinh = jComboBox_Gender.getSelectedItem().toString();
        try{
    // Kiểm tra nếu cả hai trường không rỗng
            if (!ten.isEmpty() && !gioitinh.isEmpty() && !sdt.isEmpty() && !diachi.isEmpty()) 
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin");
            else{
                NhanVienDTO nv=new NhanVienDTO();
                if(arrNhanVien.size()==0){
                    nv.setMaNV("NV001");
                }
                else {
                    NhanVienDTO NV = arrNhanVien.get(arrNhanVien.size()-1);
	                int id = Integer.parseInt(NV.getMaNV().substring(3));
	                
	                if(id<=9)
	                    nv.setMaNV("NCC00"+(id+1));
	                else if(id>=10 && id<=99)
	                    nv.setMaNV("NCC0"+(id+1));
	                else
	                    nv.setMaNV("NCC"+(id+1));
                }
                nv.setTenNV(jTextField_Ten.getText());
                nv.setGioiTinh(jComboBox_Gender.getSelectedItem().toString());
                nv.setDiaChi(jTextField_DiaChi.getText());
                nv.setSDT(jTextField_SDT.getText());
                
                nvBLL.addNV(nv);
                loadNVlist();
            }
        
        }   
        catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Thông tin không hợp lệ");
        }
        // Thêm dữ liệu mới vào mô hình
        
    
        
        
    }//GEN-LAST:event_jButton_ThemActionPerformed

    private void jButton_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SuaActionPerformed
            // TODO add your handling code here:
        int i = jTable_NhanVien.getSelectedRow();
        String id = modelNV.getValueAt(i, 1).toString();
        String name = jTextField_Ten.getText();
        String diachi = jTextField_DiaChi.getText();
        String sdt = jTextField_SDT.getText();
        String gender = jComboBox_Gender.getSelectedItem().toString();
        
        
        nvBLL.UpNV(id,name,gender,diachi,sdt);
        	
        
        loadNVlist();
            
    }//GEN-LAST:event_jButton_SuaActionPerformed

    private void jButton_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XoaActionPerformed
        // TODO add your handling code here:
        int i= jTable_NhanVien.getSelectedRow();
        if(i>=0){
            nvBLL.delNV(modelNV.getValueAt(i,1).toString());
            loadNVlist();
        }
         
    }//GEN-LAST:event_jButton_XoaActionPerformed

    private void jButton_HuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HuyActionPerformed
        // TODO add your handling code here:
        jTextField_Ten.setText("");
        jTextField_DiaChi.setText("");
        jTextField_SDT.setText("");
        
    }//GEN-LAST:event_jButton_HuyActionPerformed

    private void jButton_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SearchActionPerformed
        // TODO add your handling code here:
        String selectedValue = jComboBox_SearchType.getSelectedItem().toString();

        // Lấy giá trị từ jTextField
        String searchText = jTextField_Search.getText().trim();
        
        if ("Mã Nhân Viên".equals(selectedValue)) {
            // Tìm kiếm theo ID trong jTable
            searchByID(searchText);
        } else if ("Tên Nhân Viên".equals(selectedValue)) {
            // Tìm kiếm theo Name trong jTable
            searchByName(searchText);
        } else {
            // Hiển thị thông báo hoặc xử lý lỗi nếu giá trị không hợp lệ
            JOptionPane.showMessageDialog(this, "Giá trị không hợp lệ.");
        }
    }//GEN-LAST:event_jButton_SearchActionPerformed

    private void searchByID(String id) {
    // Thực hiện tìm kiếm theo ID trong jTable và cập nhật kết quả lên jTable
        
        modelNV.setRowCount(0); // Xóa tất cả dữ liệu hiện có trong jTable
        int stt=1;
        for (int i = 0; i < modelNV.getRowCount(); i++) {
            String rowData = modelNV.getValueAt(i, 1).toString(); // Cột ID là cột 0
            if (rowData.equals(id)) {
                // Nếu tìm thấy ID, thêm hàng tương ứng vào jTable
                
                Object[] row = new Object[]{stt,modelNV.getValueAt(i, 1), modelNV.getValueAt(i, 2),modelNV.getValueAt(i, 3),modelNV.getValueAt(i, 4),modelNV.getValueAt(i, 5)};
                modelNV.addRow(row);
                stt++;
                
            }
        }
    }

    private void searchByName(String name) {
        // Thực hiện tìm kiếm theo Name trong jTable và cập nhật kết quả lên jTable
        
        modelNV.setRowCount(0); // Xóa tất cả dữ liệu hiện có trong jTable
        int stt=1;
        for (int i = 0; i < modelNV.getRowCount(); i++) {
            String rowData = modelNV.getValueAt(i, 2).toString(); // Cột Name là cột 1
            if (rowData.equalsIgnoreCase(name)) {
                // Nếu tìm thấy Name, thêm hàng tương ứng vào jTable
                Object[] row = new Object[]{modelNV.getValueAt(i, 1), modelNV.getValueAt(i, 2),modelNV.getValueAt(i, 3),modelNV.getValueAt(i, 4),modelNV.getValueAt(i, 5)};
                modelNV.addRow(row);
                stt++;
            }
        }
    }
    public void loadNVlist(){
        arrNhanVien = nvBLL.getListNhanVien();
//        int a = arrNCC.size();
//        System.out.print(rootPaneCheckingEnabled);
        for(int i = modelNV.getRowCount()-1;i>=0;i--)
            modelNV.removeRow(i);
        for(int i = 0; i<arrNhanVien.size();i++){
            NhanVienDTO em= arrNhanVien.get(i);
            int stt= i+1;
            String id= em.getMaNV();
            String name = em.getTenNV();
            String gender = em.getGioiTinh();
            String address = em.getDiaChi();
            String sdt = em.getSDT();
            
            Object[] row = {stt,id,name,gender,address,sdt};
            modelNV.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Huy;
    private javax.swing.JButton jButton_Search;
    private javax.swing.JButton jButton_Sua;
    private javax.swing.JButton jButton_Them;
    private javax.swing.JButton jButton_Xoa;
    private javax.swing.JComboBox<String> jComboBox_Gender;
    private javax.swing.JComboBox<String> jComboBox_SearchType;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_NhanVien;
    private javax.swing.JTextField jTextField_DiaChi;
    private javax.swing.JTextField jTextField_SDT;
    private javax.swing.JTextField jTextField_Search;
    private javax.swing.JTextField jTextField_Ten;
    // End of variables declaration//GEN-END:variables
}
