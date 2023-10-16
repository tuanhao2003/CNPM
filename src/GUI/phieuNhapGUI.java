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
    private ArrayList<phieuNhapDTO> dspn;

    public phieuNhapGUI() {
        this.bus = new phieuNhapBLL();
        dspn = this.bus.showAll();
        initComponents();
        solveEvent();
    }

    private void solveEvent(){
        show(dspn);
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
                dspn=bus.showSearch(searchInp.getText(), searchType.getSelectedItem().toString());
                show(dspn);
            }
        });
        
        this.searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                dspn=bus.showSearch(searchInp.getText(), searchType.getSelectedItem().toString());
                show(dspn);
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
                    showCt(bus.showCtpn(tablePhieunhap.getModel().getValueAt(row, 1).toString()));
                    ctpnDialog.setVisible(true);
                }
            }
        });
    
//Sự kiện lọc danh sách phiếu nhập
        this.sortFilter.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                show(bus.showSort(dspn, sortFilter.getSelectedItem().toString(), sortType.getSelectedItem().toString()));
            }
        });
        
        this.sortType.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                show(bus.showSort(dspn, sortFilter.getSelectedItem().toString(), sortType.getSelectedItem().toString()));
            }
        });
        
//Sự kiện lọc theo ngày
        this.dayFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                dspn = bus.showByDays(dayS.getSelectedItem().toString(), monthS.getSelectedItem().toString(), yearS.getSelectedItem().toString(), dayE.getSelectedItem().toString(), monthE.getSelectedItem().toString(), yearE.getSelectedItem().toString());
                show(dspn);
            }
        });
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

        ctpnDialog = new javax.swing.JDialog();
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
        sortType = new javax.swing.JComboBox<>();
        dayFilter = new javax.swing.JButton();

        ctpnDialog.setLocationRelativeTo(panelPhieunhap);
        ctpnDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        ctpnDialog.setTitle("Chi Tiết Phiếu Nhập");
        ctpnDialog.setAlwaysOnTop(true);
        ctpnDialog.setLocationByPlatform(true);
        ctpnDialog.setMaximumSize(new java.awt.Dimension(500, 600));
        ctpnDialog.setMinimumSize(new java.awt.Dimension(500, 600));
        ctpnDialog.setName("Chi Tiết Phiếu Nhập"); // NOI18N
        ctpnDialog.setPreferredSize(new java.awt.Dimension(500, 600));

        tableChitiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "STT", "Mã Phiếu","Mã NCC", "Đơn Giá", "Số Lượng", "Tạm Tính"
            }
        ));
        tableChitiet.setEnabled(false);
        jScrollPane2.setViewportView(tableChitiet);

        ctpnDialog.getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        ctpnDialog.getAccessibleContext().setAccessibleParent(panelPhieunhap);

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

        yearS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Năm 1950", "Năm 1951", "Năm 1952", "Năm 1953", "Năm 1954", "Năm 1955", "Năm 1956", "Năm 1957", "Năm 1958", "Năm 1959", "Năm 1960", "Năm 1961", "Năm 1962", "Năm 1963", "Năm 1964", "Năm 1965", "Năm 1966", "Năm 1967", "Năm 1968", "Năm 1969", "Năm 1970", "Năm 1971", "Năm 1972", "Năm 1973", "Năm 1974", "Năm 1975", "Năm 1976", "Năm 1977", "Năm 1978", "Năm 1979", "Năm 1980", "Năm 1981", "Năm 1982", "Năm 1983", "Năm 1984", "Năm 1985", "Năm 1986", "Năm 1987", "Năm 1988", "Năm 1989", "Năm 1990", "Năm 1991", "Năm 1992", "Năm 1993", "Năm 1994", "Năm 1995", "Năm 1996", "Năm 1997", "Năm 1998", "Năm 1999", "Năm 2000", "Năm 2001", "Năm 2002", "Năm 2003", "Năm 2004", "Năm 2005", "Năm 2006", "Năm 2007", "Năm 2008", "Năm 2009", "Năm 2010", "Năm 2011", "Năm 2012", "Năm 2013", "Năm 2014", "Năm 2015", "Năm 2016", "Năm 2017", "Năm 2018", "Năm 2019", "Năm 2020", "Năm 2021", "Năm 2022", "Năm 2023" }));
        jPanel2.add(yearS);

        jPanel1.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        dayE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày 1", "Ngày 2", "Ngày 3", "Ngày 4", "Ngày 5", "Ngày 6", "Ngày 7", "Ngày 8", "Ngày 9", "Ngày 10", "Ngày 11", "Ngày 12", "Ngày 13", "Ngày 14", "Ngày 15", "Ngày 16", "Ngày 17", "Ngày 18", "Ngày 19", "Ngày 20", "Ngày 21", "Ngày 22", "Ngày 23", "Ngày 24", "Ngày 25", "Ngày 26", "Ngày 27", "Ngày 28", "Ngày 29", "Ngày 30", "Ngày 31" }));
        jPanel1.add(dayE);

        monthE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" }));
        jPanel1.add(monthE);

        yearE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Năm 2023", "Năm 2022", "Năm 2021", "Năm 2020", "Năm 2019", "Năm 2018", "Năm 2017", "Năm 2016", "Năm 2015", "Năm 2014", "Năm 2013", "Năm 2012", "Năm 2011", "Năm 2010", "Năm 2009", "Năm 2008", "Năm 2007", "Năm 2006", "Năm 2005", "Năm 2004", "Năm 2003", "Năm 2002", "Năm 2001", "Năm 2000", "Năm 1999", "Năm 1998", "Năm 1997", "Năm 1996", "Năm 1995", "Năm 1994", "Năm 1993", "Năm 1992", "Năm 1991", "Năm 1990", "Năm 1989", "Năm 1988", "Năm 1987", "Năm 1986", "Năm 1985", "Năm 1984", "Năm 1983", "Năm 1982", "Năm 1981", "Năm 1980", "Năm 1979", "Năm 1978", "Năm 1977", "Năm 1976", "Năm 1975", "Năm 1974", "Năm 1973", "Năm 1972", "Năm 1971", "Năm 1970", "Năm 1969", "Năm 1968", "Năm 1967", "Năm 1966", "Năm 1965", "Năm 1964", "Năm 1963", "Năm 1962", "Năm 1961", "Năm 1960", "Năm 1959", "Năm 1958", "Năm 1957", "Năm 1956", "Năm 1955", "Năm 1954", "Năm 1953", "Năm 1952", "Năm 1951", "Năm 1950"}));
        jPanel1.add(yearE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Lọc Từ Ngày:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Đến Ngày:");

        searchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm Theo", "Mã Phiếu", "Mã Kho", "Tổng Tiền" }));
        searchType.setPreferredSize(new java.awt.Dimension(80, 30));
        searchType.setSelectedIndex(0);

        sortType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tăng Dần", "Giảm Dần" }));
        sortType.setPreferredSize(new java.awt.Dimension(150, 30));

        dayFilter.setText("Lọc");
        dayFilter.setPreferredSize(new java.awt.Dimension(100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sortFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(sortType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dayFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
            .addComponent(panelPhieunhap, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sortFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sortType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(dayFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addComponent(panelPhieunhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog ctpnDialog;
    private javax.swing.JComboBox<String> dayE;
    private javax.swing.JButton dayFilter;
    private javax.swing.JComboBox<String> dayS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> monthE;
    private javax.swing.JComboBox<String> monthS;
    private javax.swing.JPanel panelPhieunhap;
    private javax.swing.JPanel searchBar;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchInp;
    private javax.swing.JComboBox<String> searchType;
    private javax.swing.JComboBox<String> sortFilter;
    private javax.swing.JComboBox<String> sortType;
    private javax.swing.JTable tableChitiet;
    private javax.swing.JTable tablePhieunhap;
    private javax.swing.JComboBox<String> yearE;
    private javax.swing.JComboBox<String> yearS;
    // End of variables declaration//GEN-END:variables
}
