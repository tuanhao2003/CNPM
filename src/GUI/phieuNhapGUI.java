package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import BLL.phieuNhapBLL;
import DTO.phieuNhapDTO;
import DTO.ctphieuNhapDTO;

public class phieuNhapGUI extends javax.swing.JPanel {
    private phieuNhapBLL bus;

    public phieuNhapGUI() {
        this.bus = new phieuNhapBLL();
        initComponents();
        solveEvent();
        show(this.bus.showAll());
    }

    private void solveEvent(){
        this.searchBtn.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e){
                searchBtn.setBackground(Color.LIGHT_GRAY);
            }
            @Override
            public void focusLost(FocusEvent e){
                searchBtn.setBackground(Color.WHITE);
            }
        });
        
//sự kiện search
        this.searchInp.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(searchInp.getText().equals("Tìm kiếm phiếu nhập")){
                    searchInp.setText("");
                }
            }
        });
        
        this.searchInp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                show(bus.showSearch(searchInp.getText(), searchType.getSelectedItem().toString()));
            }
        });
        
// Hiện dialog chi tiết phiếu nhập
        this.tablePhieunhap.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent m){
        //lay dong va cot theo vi tri chuot
                int row = tablePhieunhap.rowAtPoint(m.getPoint());
                int col = tablePhieunhap.columnAtPoint(m.getPoint());
                if(col!=6){
                    showCt(tablePhieunhap.get);//get column from row
                    phieuNhapdialog.setLocationRelativeTo(panelPhieunhap);
                    phieuNhapdialog.setVisible(true);
                }
            }
        });
    
//Sự kiện lọc danh sách phiếu nhập
        
    }

    public void show(ArrayList<phieuNhapDTO> dto){
        int n = 0;
        DefaultTableModel model = (DefaultTableModel) this.tablePhieunhap.getModel();
        model.setRowCount(0);
        
        for(phieuNhapDTO i : dto){
            n++;
            Object[] data = {n, i.getmaPn(), i.getmaKho(), i.getngayNhap(), i.getthue(), i.gettongTien()};
            model.addRow(data);
        }
        this.tablePhieunhap.updateUI();
    }
    
    public void showCt(ArrayList<ctphieuNhapDTO> dto){
        int n = 0;
        DefaultTableModel model = (DefaultTableModel) this.tableChitiet.getModel();
        model.setRowCount(0);
        
        for(ctphieuNhapDTO i : dto){
            n++;
            Object[] data = {n, i.getmaPn(), i.getmaNcc(), i.getsoLuong(), i.getdonGia(), i.gettamTinh()};
            model.addRow(data);
        }
        this.tableChitiet.updateUI();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        phieuNhapdialog = new javax.swing.JDialog();
        panelChitiet = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableChitiet = new javax.swing.JTable();
        searchBar = new javax.swing.JPanel();
        searchInp = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        panelPhieunhap = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePhieunhap = new javax.swing.JTable();
        sortFilter = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        dayS = new javax.swing.JComboBox<>();
        monthS = new javax.swing.JComboBox<>();
        yearS = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        dayE = new javax.swing.JComboBox<>();
        monthE = new javax.swing.JComboBox<>();
        yearE = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchType = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();

        phieuNhapdialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        phieuNhapdialog.setTitle("Chi Tiết Phiếu Nhập");
        phieuNhapdialog.setLocationByPlatform(true);
        phieuNhapdialog.setName("Chi Tiết Phiếu Nhập"); // NOI18N
        phieuNhapdialog.setPreferredSize(new java.awt.Dimension(500, 600));

        panelChitiet.setPreferredSize(new java.awt.Dimension(450, 600));
        panelChitiet.setLayout(new java.awt.BorderLayout());

        tableChitiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "STT", "Mã NCC", "Đơn Giá", "Số Lượng", "Tạm Tính"
            }
        ));
        tableChitiet.setEnabled(false);
        jScrollPane2.setViewportView(tableChitiet);

        panelChitiet.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        phieuNhapdialog.getContentPane().add(panelChitiet, java.awt.BorderLayout.CENTER);

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
        tablePhieunhap.setEnabled(false);
        jScrollPane1.setViewportView(tablePhieunhap);

        panelPhieunhap.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        sortFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã Phiếu", "Mã Kho", "Ngày Nhập" }));
        sortFilter.setName(""); // NOI18N
        sortFilter.setPreferredSize(new java.awt.Dimension(150, 30));

        jPanel2.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        dayS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày 1", "Ngày 2", "Ngày 3", "Ngày 4", "Ngày 5", "Ngày 6", "Ngày 7", "Ngày 8", "Ngày 9", "Ngày 10", "Ngày 11", "Ngày 12", "Ngày 13", "Ngày 14", "Ngày 15", "Ngày 16", "Ngày 17", "Ngày 18", "Ngày 19", "Ngày 20", "Ngày 21", "Ngày 22", "Ngày 23", "Ngày 24", "Ngày 25", "Ngày 26", "Ngày 27", "Ngày 28", "Ngày 29", "Ngày 30", "Ngày 31"}));
        jPanel2.add(dayS);

        monthS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" }));
        jPanel2.add(monthS);

        yearS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Năm 2000", "Năm 2001", "Năm 2002", "Năm 2003", "Năm 2004", "Năm 2005", "Năm 2006", "Năm 2007", "Năm 2008", "Năm 2009", "Năm 2010", "Năm 2011", "Năm 2012", "Năm 2013", "Năm 2014", "Năm 2015", "Năm 2016", "Năm 2017", "Năm 2018", "Năm 2019", "Năm 2020", "Năm 2021", "Năm 2022", "Năm 2023" }));
        jPanel2.add(yearS);

        jPanel1.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        dayE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày 1", "Ngày 2", "Ngày 3", "Ngày 4", "Ngày 5", "Ngày 6", "Ngày 7", "Ngày 8", "Ngày 9", "Ngày 10", "Ngày 11", "Ngày 12", "Ngày 13", "Ngày 14", "Ngày 15", "Ngày 16", "Ngày 17", "Ngày 18", "Ngày 19", "Ngày 20", "Ngày 21", "Ngày 22", "Ngày 23", "Ngày 24", "Ngày 25", "Ngày 26", "Ngày 27", "Ngày 28", "Ngày 29", "Ngày 30", "Ngày 31" }));
        jPanel1.add(dayE);

        monthE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" }));
        jPanel1.add(monthE);

        yearE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Năm 2000", "Năm 2001", "Năm 2002", "Năm 2003", "Năm 2004", "Năm 2005", "Năm 2006", "Năm 2007", "Năm 2008", "Năm 2009", "Năm 2010", "Năm 2011", "Năm 2012", "Năm 2013", "Năm 2014", "Năm 2015", "Năm 2016", "Năm 2017", "Năm 2018", "Năm 2019", "Năm 2020", "Năm 2021", "Năm 2022", "Năm 2023" }));
        jPanel1.add(yearE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Lọc Từ Ngày:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Đến Ngày:");

        searchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm Theo", "Mã Phiếu", "Mã Kho", "Tổng Tiền" }));
        searchType.setPreferredSize(new java.awt.Dimension(80, 30));
        searchType.setSelectedIndex(0);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tăng Dần", "Giảm Dần" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(150, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(searchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sortFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 168, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(panelPhieunhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sortFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(panelPhieunhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> dayE;
    private javax.swing.JComboBox<String> dayS;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> monthE;
    private javax.swing.JComboBox<String> monthS;
    private javax.swing.JPanel panelChitiet;
    private javax.swing.JPanel panelPhieunhap;
    private javax.swing.JDialog phieuNhapdialog;
    private javax.swing.JPanel searchBar;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchInp;
    private javax.swing.JComboBox<String> searchType;
    private javax.swing.JComboBox<String> sortFilter;
    private javax.swing.JTable tableChitiet;
    private javax.swing.JTable tablePhieunhap;
    private javax.swing.JComboBox<String> yearE;
    private javax.swing.JComboBox<String> yearS;
    // End of variables declaration//GEN-END:variables
}
