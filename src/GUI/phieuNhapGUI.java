package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import BUS.phieuNhapBUS;
import DTO.phieuNhapDTO;

public class phieuNhapGUI extends javax.swing.JPanel {
    private phieuNhapBUS bus;
    private ArrayList<phieuNhapDTO> dto;
    
    public phieuNhapGUI() {
        this.bus = new phieuNhapBUS();
        this.dto = new ArrayList<>();
        initComponents();
        solveEvent();
        showAll();
    }
    
    private void solveEvent(){
        this.searchBtn.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e){
                searchBtn.setBackground(Color.LIGHT_GRAY);
            }
            @Override
            public void focusLost(FocusEvent e){
                searchBtn.setBackground(Color.WHITE);
            }
        });
    }
    
    public void showAll(){
        this.dto = this.bus.getAll();
        for(phieuNhapDTO i : this.dto){
            Object[] data = {"1",i.getmaPn(),i.getmaKho(), i.getngayNhap(), i.getthue(), i.gettongTien()};
            DefaultTableModel model = (DefaultTableModel) this.tablePhieunhap.getModel();
            model.addRow(data);
        }
        
        this.tablePhieunhap.updateUI();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchBar = new javax.swing.JPanel();
        searchInp = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        panelPhieunhap = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePhieunhap = new javax.swing.JTable();
        panelChitiet = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableChitiet = new javax.swing.JTable();
        sortFilter = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setPreferredSize(new java.awt.Dimension(1000, 700));

        searchBar.setPreferredSize(new java.awt.Dimension(350, 30));
        searchBar.setLayout(new java.awt.GridBagLayout());

        searchInp.setText("Tìm kiếm phiếu nhập");
        searchInp.setToolTipText("");
        searchInp.setPreferredSize(new java.awt.Dimension(300, 30));
        searchBar.add(searchInp, new java.awt.GridBagConstraints());

        searchBtn.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("Comp/search.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        searchBtn.setBorderPainted(false);
        searchBtn.setContentAreaFilled(false);
        searchBtn.setFocusPainted(false);
        searchBtn.setMargin(new java.awt.Insets(2, 2, 2, 2));
        searchBtn.setMaximumSize(new java.awt.Dimension(200, 200));
        searchBtn.setPreferredSize(new java.awt.Dimension(50, 30));
        searchBar.add(searchBtn, new java.awt.GridBagConstraints());

        panelPhieunhap.setPreferredSize(new java.awt.Dimension(450, 600));
        panelPhieunhap.setLayout(new java.awt.BorderLayout());

        tablePhieunhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String [] {
                "STT","Mã Phiếu", "Mã Kho", "Ngày Nhập", "Thuế", "Tổng Tiền", "Xóa"
            }
        ));
        jScrollPane1.setViewportView(tablePhieunhap);

        panelPhieunhap.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelChitiet.setPreferredSize(new java.awt.Dimension(450, 600));
        panelChitiet.setLayout(new java.awt.BorderLayout());

        tableChitiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "STT", "Mã NCC", "Đơn Giá", "Số Lượng", "Tạm Tính"
            }
        ));
        jScrollPane2.setViewportView(tableChitiet);

        panelChitiet.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        sortFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        sortFilter.setName(""); // NOI18N
        sortFilter.setPreferredSize(new java.awt.Dimension(200, 30));

        jPanel2.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel2.setLayout(new java.awt.GridLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(jComboBox1);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(jComboBox2);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(jComboBox3);

        jPanel1.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel1.setLayout(new java.awt.GridLayout());

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox4);

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox5);

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox6);

        jLabel1.setText("Từ ngày:");

        jLabel2.setText("Đến ngày:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPhieunhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sortFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelChitiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sortFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPhieunhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelChitiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 1, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelChitiet;
    private javax.swing.JPanel panelPhieunhap;
    private javax.swing.JPanel searchBar;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchInp;
    private javax.swing.JComboBox<String> sortFilter;
    private javax.swing.JTable tableChitiet;
    private javax.swing.JTable tablePhieunhap;
    // End of variables declaration//GEN-END:variables
}
