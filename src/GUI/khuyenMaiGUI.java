package GUI;
import javax.swing.table.DefaultTableModel;
import DAO.khuyenMaiDAO;
import BLL.KhuyenMaiBLL;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import DTO.khuyenMaiDTO;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class khuyenMaiGUI extends javax.swing.JPanel {
    private khuyenMaiDAO khuyenMaiDAO;
    private KhuyenMaiBLL KhuyenMaiBLL;

    public khuyenMaiGUI() {
        initComponents();
        khuyenMaiDAO = new khuyenMaiDAO();
        KhuyenMaiBLL = new KhuyenMaiBLL();
        showALL();
        formtf.setVisible(false);
        totf.setVisible(false);       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        buttonGroup = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        searchkmtf = new javax.swing.JTextField();
        searchkmbtn = new javax.swing.JButton();
        createbtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        formtf = new javax.swing.JTextField();
        totf = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        Xuatbtn = new javax.swing.JButton();

        jDialog1.setMinimumSize(new java.awt.Dimension(630, 400));

        jLabel1.setText("Loại:");

        jLabel2.setText("Mã khuyến mãi:");

        jLabel3.setText("Tên khuyến mãi:");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(153, 153, 153));
        jTextField1.setText("00001(5 số)");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Iphone", "Samsung", "Xiaomi", "Oppo", "Nokia" }));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel4.setText("TẠO KHUYẾN MÃI");

        jButton1.setText("LÀM MỚI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("TẠO ");

        jLabel5.setText("Mức giảm giá:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10%", "20%", "30%", "40%", "50%", "60%", "70%", "80%", "90%" }));

        jLabel6.setText("Thời gian áp dụng:");

        jDateChooser1.setToolTipText("");
        jDateChooser1.setDateFormatString("dd/MM/yyyy");

        jDateChooser2.setDateFormatString("dd/MM/yyyy");

        jLabel10.setText("Mã sản phẩm:");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDialog1Layout.createSequentialGroup()
                                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jDialog1Layout.createSequentialGroup()
                                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(48, 48, 48))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialog1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDialog1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3))
                        .addGap(93, 93, 93))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                        .addGap(0, 5, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(182, 182, 182))))
        );

        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        buttonGroup.add(jRadioButton3);

        buttonGroup1.add(jRadioButton4);
        buttonGroup1.add(jRadioButton5);
        buttonGroup1.add(jRadioButton6);

        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setPreferredSize(new java.awt.Dimension(1000, 700));

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        searchkmtf.setForeground(new java.awt.Color(153, 153, 153));
        searchkmtf.setText("Tìm kiếm khuyến mãi");
        searchkmtf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchkmtfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchkmtfFocusLost(evt);
            }
        });

        searchkmbtn.setText("Tìm kiếm");

        createbtn.setText("+ Khuyến mãi");

        deletebtn.setText("Xóa khuyến mãi");

        formtf.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        formtf.setForeground(new java.awt.Color(153, 153, 153));
        formtf.setText("Từ ngày");
        formtf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formtfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formtfFocusLost(evt);
            }
        });

        totf.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        totf.setForeground(new java.awt.Color(153, 153, 153));
        totf.setText("Đến ngày");
        totf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                totfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                totfFocusLost(evt);
            }
        });

        jScrollPane1.setEnabled(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã CTKM", "Tên CTKM", "Mức giảm giá", "Loại sản phẩm", "Thời gian bắt đầu", "Thời gian kết thúc", "Thời gian tạo", "Mã sản phẩm"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        }
    );
    jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jScrollPane1.setViewportView(jTable1);

    jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
    jLabel7.setText("KHUYẾN MÃI");

    jPanel2.setBackground(new java.awt.Color(255, 255, 255));
    jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

    jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jLabel8.setText("Trạng thái");

    jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
    jRadioButton1.setText("Tất cả");

    jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
    jRadioButton2.setText("Hết hiệu lực");

    jRadioButton3.setBackground(new java.awt.Color(255, 255, 255));
    jRadioButton3.setText("Còn hiệu lực");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jRadioButton1)
                .addComponent(jRadioButton2)
                .addComponent(jRadioButton3))
            .addContainerGap(67, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jRadioButton1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jRadioButton3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jRadioButton2)
            .addContainerGap(21, Short.MAX_VALUE))
    );

    jPanel3.setBackground(new java.awt.Color(255, 255, 255));
    jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

    jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jLabel9.setText("Áp dụng");

    jRadioButton4.setBackground(new java.awt.Color(255, 255, 255));
    jRadioButton4.setText("Tất cả");

    jRadioButton5.setBackground(new java.awt.Color(255, 255, 255));
    jRadioButton5.setText("Điện thoại");

    jRadioButton6.setBackground(new java.awt.Color(255, 255, 255));
    jRadioButton6.setText("Phụ kiện");

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jRadioButton4)
                .addComponent(jRadioButton5)
                .addComponent(jRadioButton6))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jRadioButton4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jRadioButton6)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jRadioButton5)
            .addContainerGap(24, Short.MAX_VALUE))
    );

    Xuatbtn.setText("Xuất Excel");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(formtf, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(totf, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(searchkmtf, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(searchkmbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(createbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(Xuatbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(72, 72, 72)))))
            .addContainerGap(32, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(searchkmtf, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(searchkmbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(createbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(23, 23, 23)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(33, 33, 33)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(formtf, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(totf, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Xuatbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(25, 25, 25)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(30, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(41, Short.MAX_VALUE))
    );
    }// </editor-fold>//GEN-END:initComponents

    private void searchkmtfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchkmtfFocusGained
        if (searchkmtf.getText().equals("Tìm kiếm khuyến mãi")) {
            searchkmtf.setText("");
            searchkmtf.setForeground(Color.BLACK); // Đổi màu về đen khi tập trung
        }
    }//GEN-LAST:event_searchkmtfFocusGained

    private void searchkmtfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchkmtfFocusLost
        if (searchkmtf.getText().isEmpty()) {
            searchkmtf.setForeground(Color.GRAY); // Đổi màu về màu placeholder
            searchkmtf.setText("Tìm kiếm khuyến mãi"); // Đặt văn bản placeholder
        }
    }//GEN-LAST:event_searchkmtfFocusLost

    private void formtfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formtfFocusGained
        if (formtf.getText().equals("Từ ngày")) {
            formtf.setText("");
            formtf.setForeground(Color.BLACK); // Đổi màu về đen khi tập trung
        }
    }//GEN-LAST:event_formtfFocusGained

    private void formtfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formtfFocusLost
        if (formtf.getText().isEmpty()) {
            formtf.setForeground(Color.GRAY); // Đổi màu về màu placeholder
            formtf.setText("Từ ngày"); // Đặt văn bản placeholder
        }
    }//GEN-LAST:event_formtfFocusLost

    private void totfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_totfFocusGained
        if (totf.getText().equals("Đến ngày")) {
            totf.setText("");
            totf.setForeground(Color.BLACK); // Đổi màu về đen khi tập trung
        }
    }//GEN-LAST:event_totfFocusGained

    private void totfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_totfFocusLost
        if (totf.getText().isEmpty()) {
            totf.setForeground(Color.GRAY); // Đổi màu về màu placeholder
            totf.setText("Đến ngày"); // Đặt văn bản placeholder
        }
    }//GEN-LAST:event_totfFocusLost

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        if (jTextField1.getText().equals("00001(5 số)")) {
            jTextField1.setText("");
            jTextField1.setForeground(Color.BLACK); // Đổi màu về đen khi tập trung
        }
    }//GEN-LAST:event_jTextField1FocusGained

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        if (jTextField1.getText().isEmpty()) {
            jTextField1.setForeground(Color.GRAY); // Đổi màu về màu placeholder
            jTextField1.setText("00001(5 số)"); // Đặt văn bản placeholder
        }
    }//GEN-LAST:event_jTextField1FocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTextField1.setText(null);
        if (jTextField1.getText().isEmpty()) {
            jTextField1.setForeground(Color.GRAY); // Đổi màu về màu placeholder
            jTextField1.setText("00001(5 số)"); // Đặt văn bản placeholder
        }
        jTextField2.setText(null);
        jTextField3.setText(null);
        jComboBox1.setSelectedItem("Iphone");
        jComboBox2.setSelectedItem("10%");   
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
    }//GEN-LAST:event_jButton1ActionPerformed
       
    
   
    
    private void taokhuyemai() {
        createbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // Đặt jDialog1 thành cửa sổ modal
                jDialog1.setModal(true);

                // Đặt vị trí của JDialog ở giữa màn hình
                jDialog1.setLocationRelativeTo(null);

                // Hiển thị jDialog1
                jDialog1.setVisible(true);
            }
        });
    }
    
    private void tao() {
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // Lấy dữ liệu từ các trường nhập liệu và tạo đối tượng DTO
                String maKhuyenMai = jTextField1.getText();
                String tenKhuyenMai = jTextField2.getText();
                int mucGiamGia = Integer.parseInt(jComboBox2.getSelectedItem().toString().replace("%", ""));
                String loaiKhuyenMai = jComboBox1.getSelectedItem().toString();
                Date ngayBatDau = jDateChooser1.getDate();
                Date ngayKetThuc = jDateChooser2.getDate();
                String maSanPham = jTextField3.getText();
                khuyenMaiDTO khuyenMai = new khuyenMaiDTO(maKhuyenMai, tenKhuyenMai, mucGiamGia, loaiKhuyenMai, ngayBatDau, ngayKetThuc, maSanPham);

                // Gọi phương thức DAO để thêm dữ liệu vào cơ sở dữ liệu
                boolean themThanhCong = KhuyenMaiBLL.themKhuyenMai(khuyenMai);

                if (themThanhCong) {
                    JOptionPane.showMessageDialog(khuyenMaiGUI.this, "Đã tạo khuyến mãi: " + khuyenMai.getTenKhuyenMai(), "Thông báo", JOptionPane.INFORMATION_MESSAGE);

                    // Xóa dữ liệu sau khi thêm thành công (nếu cần)
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jComboBox1.setSelectedIndex(0);
                    jComboBox2.setSelectedIndex(0);
                    jDateChooser1.setDate(null);
                    jDateChooser2.setDate(null);
                    jTextField3.setText("");
                    KhuyenMaiBLL.loadKhuyenMaiData(jTable1);
                }else {
                    JOptionPane.showMessageDialog(khuyenMaiGUI.this, "Vui lòng nhập lại thông tin", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    
    private void xoa() {
        deletebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String maKhuyenMaiCanXoa = searchkmtf.getText(); // Lấy mã khuyến mãi cần xóa từ giao diện

                // Hiển thị hộp thoại xác nhận
                int option = JOptionPane.showConfirmDialog(khuyenMaiGUI.this, "Bạn có chắc chắn muốn xóa khuyến mãi có mã: " + maKhuyenMaiCanXoa + "?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                    // Gọi phương thức DAO để xóa khuyến mãi
                    boolean xoaThanhCong = KhuyenMaiBLL.xoaKhuyenMai(maKhuyenMaiCanXoa);

                    if (xoaThanhCong) {
                        JOptionPane.showMessageDialog(khuyenMaiGUI.this, "Đã xóa khuyến mãi có mã: " + maKhuyenMaiCanXoa, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        // Cập nhật giao diện hoặc làm bất kỳ điều gì cần thiết sau khi xóa thành công
                        KhuyenMaiBLL.loadKhuyenMaiData(jTable1);
                    } else {
                        JOptionPane.showMessageDialog(khuyenMaiGUI.this, "Lỗi khi xóa khuyến mãi", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    private void timkiem() {
        searchkmbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String timkiem = searchkmtf.getText();
                KhuyenMaiBLL.searchKhuyenMai(jTable1, timkiem); 
            }
        });
    }
    
    private void chon(){
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = jTable1.getSelectedRow();
                    if (selectedRow != -1) {
                        // Lấy giá trị "Mã CTKM" từ dòng được chọn
                        Object maCTKM = jTable1.getValueAt(selectedRow, 0);
                        // Đặt giá trị "Mã CTKM" vào JTextField
                        searchkmtf.setText(maCTKM.toString());
                        searchkmtf.setForeground(Color.BLACK); // Đổi màu về màu placeholder
                    } else {
                        // Nếu không có dòng nào được chọn, làm mới JTextField
                        searchkmtf.setText("");
                        searchkmtf.setForeground(Color.GRAY); // Đổi màu về màu placeholder
                    }
                }
            }
        });
    }
    
    private void trangthai(){
        jRadioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KhuyenMaiBLL.loadKhuyenMaiData(jTable1);
            }
        });

        jRadioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hiển thị khuyến mãi còn hạn
                KhuyenMaiBLL.loadExpiredData(jTable1);
            }
        });

        jRadioButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hiển thị khuyến mãi đã hết hạn
                KhuyenMaiBLL.loadValidData(jTable1);
            }
        });
    }
    
    private void apdung(){

    }
    
    private void showALL(){
        KhuyenMaiBLL.loadKhuyenMaiData(jTable1);
        taokhuyemai();
        tao();
        xoa();
        timkiem();
        chon();
        trangthai();
    }







    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Xuatbtn;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton createbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JTextField formtf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton searchkmbtn;
    private javax.swing.JTextField searchkmtf;
    private javax.swing.JTextField totf;
    // End of variables declaration//GEN-END:variables
}
