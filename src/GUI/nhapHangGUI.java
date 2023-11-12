package GUI;

import DTO.NhaCungCapDTO;
import DTO.SanPhamNCCDTO;
import BLL.NhaCungCapBLL;
import DTO.SanPhamDTO;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class nhapHangGUI extends javax.swing.JPanel {
    private NhaCungCapBLL nccBLL = new NhaCungCapBLL();
    private ArrayList<SanPhamDTO> dsChon = new ArrayList<>();
    private ArrayList<SanPhamDTO> dsSpncc = new ArrayList<>();
    private ArrayList<SanPhamDTO> dsXoa = new ArrayList<>();
    private ArrayList<SanPhamDTO> dsReverse = new ArrayList<>();
    private ArrayList<NhaCungCapDTO> dsncc = new ArrayList<>();
    
    public nhapHangGUI() {
        initComponents();
        init();
        solveEvents();
    }

    public void init(){
        for(NhaCungCapDTO i : this.nccBLL.getListAll()){
            JCheckBox cb = new JCheckBox();
            cb.setText(i.getTenNCC());
            cb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(cb.isSelected()==true){
                        dsncc.add(i);
                    }
                    else{
                        dsncc.remove(i);
                    }
                }
            });
            this.dsNcc.add(cb);
        }
    }
        
    public void solveEvents(){
        this.btnXoads.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                for(SanPhamDTO i : dsChon){
                    dsXoa.add(i);
                }
                dsChon.removeAll(dsChon);
            }
        });
        
        this.btnTrashbin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dialogSanpham();
            }
        });
        
        this.reverseBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                for(SanPhamDTO i : dsReverse){
                    dsXoa.remove(i);
                    dsChon.add(i);
                    dsReverse.remove(i);
                }
                dsDaXoa.repaint();
                dsDaXoa.revalidate();
            }
        });
    }
    
    
    public void dialogSanpham(){
        for(SanPhamDTO i : dsXoa){            
            JPanel sp = new JPanel();
            sp.setLayout(new BoxLayout(sp, BoxLayout.Y_AXIS));
            
            JLabel masp = new JLabel(i.getMaSP());
            JLabel tenSp = new JLabel(i.getTenSP());
            JLabel hang = new JLabel(i.getHang());
            JLabel donGia = new JLabel(Long.toString(i.getDonGia()));
            JLabel hinhAnh = new JLabel();
            hinhAnh.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(i.getHinhAnh())).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
            sp.add(hinhAnh);
            sp.add(masp);
            sp.add(tenSp);
            sp.add(hang);
            sp.add(donGia);
            sp.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(!dsReverse.contains(i)){
                        dsReverse.add(i);
                    }
                }
            });
            dsDaXoa.add(sp);
        }
        binDialog.setVisible(true);
    }
    
    public JButton openQlpn(){
        return this.btnQuanlypn;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        binDialog = new javax.swing.JDialog();
        jScrollPane4 = new javax.swing.JScrollPane();
        dsDaXoa = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        reverseBtn = new javax.swing.JButton();
        reverseBtn1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dsNcc = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        dsSanphamncc = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        dsSanphamchon = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnNhaphang = new javax.swing.JButton();
        btnXoads = new javax.swing.JButton();
        btnQuanlypn = new javax.swing.JButton();
        btnTrashbin = new javax.swing.JButton();

        binDialog.setTitle("Thùng rác");
        binDialog.setLocationByPlatform(true);
        binDialog.setPreferredSize(new java.awt.Dimension(400, 500));
        binDialog.setResizable(false);
        binDialog.setSize(new java.awt.Dimension(400, 500));
        binDialog.setLocationRelativeTo(null);
        binDialog.getContentPane().setLayout(new javax.swing.BoxLayout(binDialog.getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setPreferredSize(new java.awt.Dimension(400, 400));
        JScrollBar scbDl = new JScrollBar(JScrollBar.VERTICAL);
        scbDl.setPreferredSize(new Dimension(0,0));
        jScrollPane4.setVerticalScrollBar(scbDl);

        dsDaXoa.setLayout(new javax.swing.BoxLayout(dsDaXoa, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane4.setViewportView(dsDaXoa);

        binDialog.getContentPane().add(jScrollPane4);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 50));

        reverseBtn.setText("Khôi phục");
        reverseBtn.setPreferredSize(new java.awt.Dimension(100, 30));

        reverseBtn1.setText("Khôi phục tất cả");
        reverseBtn1.setPreferredSize(new java.awt.Dimension(150, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(reverseBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(reverseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reverseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reverseBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        binDialog.getContentPane().add(jPanel1);

        setPreferredSize(new java.awt.Dimension(1000, 650));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(150, 600));

        dsNcc.setLayout(new javax.swing.BoxLayout(dsNcc, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(dsNcc);

        jButton1.setText("Danh sách NCC");
        jButton1.setToolTipText("");
        jButton1.setBorderPainted(false);
        jButton1.setEnabled(false);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(850, 250));

        dsSanphamncc.setLayout(new javax.swing.BoxLayout(dsSanphamncc, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane2.setViewportView(dsSanphamncc);

        jScrollPane3.setPreferredSize(new java.awt.Dimension(850, 200));

        dsSanphamchon.setLayout(new javax.swing.BoxLayout(dsSanphamchon, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane3.setViewportView(dsSanphamchon);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Danh Sách Sản Phẩm Nhà Cung Cấp");
        jLabel1.setPreferredSize(new java.awt.Dimension(850, 50));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Danh Sách Sản Phẩm Đã Chọn");
        jLabel2.setPreferredSize(new java.awt.Dimension(850, 50));

        btnNhaphang.setText("Nhập hàng");
        btnNhaphang.setPreferredSize(new java.awt.Dimension(150, 30));

        btnXoads.setText("Xóa đã chọn");
        btnXoads.setPreferredSize(new java.awt.Dimension(150, 30));

        btnQuanlypn.setText("Quản lí phiếu nhập");
        btnQuanlypn.setPreferredSize(new java.awt.Dimension(150, 30));

        btnTrashbin.setText("Sản phẩm vừa xóa");
        btnTrashbin.setPreferredSize(new java.awt.Dimension(150, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(btnQuanlypn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(btnXoads, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(btnTrashbin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(btnNhaphang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnQuanlypn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoads, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNhaphang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTrashbin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog binDialog;
    private javax.swing.JButton btnNhaphang;
    private javax.swing.JButton btnQuanlypn;
    private javax.swing.JButton btnTrashbin;
    private javax.swing.JButton btnXoads;
    private javax.swing.JPanel dsDaXoa;
    private javax.swing.JPanel dsNcc;
    private javax.swing.JPanel dsSanphamchon;
    private javax.swing.JPanel dsSanphamncc;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton reverseBtn;
    private javax.swing.JButton reverseBtn1;
    // End of variables declaration//GEN-END:variables
}
//hien ncc => duyet ds ncc, tao cbb theo ten ncc
//chon ncc => dsspncc = duyet list ncc, dsspncc add( get sp by ncc)
//xoa sp chon => dsxoa add sp, dschon remove sp
//xoa het => dsxoa = dschon, dschon removeall
