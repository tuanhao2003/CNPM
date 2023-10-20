package GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainGUI extends javax.swing.JFrame {  
    private int working=-1;
    private String manvLogined;
    private phieuNhapGUI pnGUI;
   
    public mainGUI() {
        initComponents();
        this.pnGUI = new phieuNhapGUI();
        
//thêm nút vào thanh công cụ và set màn hình được hiển thị khi nhấn nút
        addComponent("Nhập Hàng", this.pnGUI, "import.png");
        //lưu file trong thư mục Comp xong ghi tên file vào đây → → → → ↓
//        addComponent("Khuyến Mãi", new khuyenMaiGUI(), "empty.png");
        addComponent("Tài Khoản", new TaiKhoanGUI(),"empty.png");
        addComponent("Khách Hàng", new KhachHangGUI(),"empty.png");
        addComponent("Thống Kê", new thongKeGUI(), "empty.png");
        addComponent("Nhân Viên",new NhanVienGUI(),"empty.png");
        addComponent("Hóa Đơn", new HoaDonGUI(), "empty.png");        
        solveEvent();
    }
    
//hàm thêm phần tử
    private void addComponent(String buttonName, JPanel panelName, String path){
        int compQuantity = this.toolsPanel.getComponentCount();
        this.toolsPanel.setPreferredSize(new Dimension(this.toolsPanel.getWidth(), 50*(compQuantity+1)));
        JButton btn = new JButton(buttonName);
        btn.setPreferredSize(new Dimension(200,50));
        btn.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        btn.setBackground(new Color(80,130,100));
        btn.setForeground(Color.white);
        btn.setFont(new Font(btn.getFont().getName(), Font.BOLD, 14));
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setIconTextGap(30);
        if(path == null){
            btn.setIcon(null);
        }
        else{
            btn.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("Comp/"+path)).getImage().getScaledInstance(40,40 , Image.SCALE_SMOOTH)));
        }
        
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainDisplay.removeAll();
                mainDisplay.add(panelName);
                mainDisplay.repaint();
                mainDisplay.revalidate();
                title.setText("Quản Lý "+buttonName);
            }
        });
        this.toolsPanel.add(btn);
        this.logo.requestFocusInWindow();
    }
    private void addComponent(String buttonName, JPanel panelName){
        addComponent(buttonName, panelName, null);
    }
    
    
    
    
//xử lý sự kiện
    private void solveEvent(){
//Lấy mã nv đã đăng nhập và thêm vào màn hình chính
        this.manvLogined= "nv001";//đổi thành phương thức get mã nhân viên
        this.labelManv.setText(this.labelManv.getText()+this.manvLogined);
        
//sửa nút logOut
        logOut.setPreferredSize(new Dimension(50,50));
        logOut.setForeground(Color.white);
        logOut.setFont(new Font(logOut.getFont().getName(), Font.BOLD, 14));
        logOut.setFocusPainted(false);
        logOut.setContentAreaFilled(false);
        
        logOut.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                SwingUtilities.windowForComponent(logoContainer).dispose();
                Login lg = new Login();
                lg.setLocationRelativeTo(null); // Đặt JFrame ra giữa màn hình
                lg.setVisible(true);
            }
        });
        
//xử lý hoạt ảnh đang hoạt động của thanh công cụ
        for(int i=0; i<this.toolsPanel.getComponentCount(); i++){
            int tmp = i;
            this.toolsPanel.getComponent(i).addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if(working>=0){
                        ((JButton) toolsPanel.getComponent(working)).setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
                    }
                    working=tmp;
                    ((JButton) toolsPanel.getComponent(tmp)).setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.green));
                }
            });
        }

    }
    
    
    
    
    
    public static void main(String[] args) {
        mainGUI display = new mainGUI();
        display.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoContainer = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        scrollBar = new javax.swing.JScrollPane();
        toolsPanel = new javax.swing.JPanel();
        mainDisplay = new javax.swing.JPanel();
        navBar = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        logOut = new javax.swing.JButton();
        labelManv = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý cửa hàng bán điện thoại");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setResizable(false);

        logoContainer.setBackground(new java.awt.Color(200, 200, 200));
        logoContainer.setMaximumSize(new java.awt.Dimension(200, 100));
        logoContainer.setMinimumSize(new java.awt.Dimension(200, 100));
        logoContainer.setPreferredSize(new java.awt.Dimension(200, 50));
        logoContainer.setLayout(new java.awt.CardLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Comp/logo.jpg")));
        logo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logo.setIconTextGap(0);
        logoContainer.add(logo, "card2");

        scrollBar.setBackground(new java.awt.Color(200, 200, 200));
        scrollBar.setBorder(null);
        scrollBar.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollBar.setPreferredSize(new java.awt.Dimension(200, 650));
        JScrollBar scb = new JScrollBar(JScrollBar.VERTICAL);
        scb.setPreferredSize(new Dimension(0,0));
        scrollBar.setVerticalScrollBar(scb);

        toolsPanel.setBackground(new java.awt.Color(100, 150, 120));
        toolsPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        toolsPanel.setPreferredSize(new java.awt.Dimension(0, 0));
        toolsPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        scrollBar.setViewportView(toolsPanel);

        mainDisplay.setBackground(new java.awt.Color(255, 255, 255));
        mainDisplay.setMaximumSize(new java.awt.Dimension(1000, 700));
        mainDisplay.setMinimumSize(new java.awt.Dimension(1000, 10));
        mainDisplay.setPreferredSize(new java.awt.Dimension(1000, 650));
        mainDisplay.setLayout(new java.awt.BorderLayout());

        navBar.setBackground(new java.awt.Color(153, 153, 153));
        navBar.setPreferredSize(new java.awt.Dimension(1000, 50));

        title.setBounds(navBar.getWidth()/2, this.title.getHeight()/2, this.title.getPreferredSize().width, this.title.getPreferredSize().height);
        title.setFont(new java.awt.Font("Verdana", 2, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Quản Lý Cửa Hàng Bán ĐiệnThoại");
        title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        title.setPreferredSize(new java.awt.Dimension(300, 50));

        logOut.setBackground(new java.awt.Color(204, 204, 204));
        logOut.setBorderPainted(false);
        logOut.setPreferredSize(new java.awt.Dimension(50, 50));

        labelManv.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelManv.setForeground(new java.awt.Color(255, 255, 255));
        labelManv.setText("Nhân Viên: ");
        labelManv.setPreferredSize(new java.awt.Dimension(100, 50));

        logOut.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("Comp/logout.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));

        javax.swing.GroupLayout navBarLayout = new javax.swing.GroupLayout(navBar);
        navBar.setLayout(navBarLayout);
        navBarLayout.setHorizontalGroup(
            navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(labelManv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        navBarLayout.setVerticalGroup(
            navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(navBarLayout.createSequentialGroup()
                .addGroup(navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelManv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(logoContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(navBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(navBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(mainDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logoContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(scrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelManv;
    private javax.swing.JButton logOut;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel logoContainer;
    private javax.swing.JPanel mainDisplay;
    private javax.swing.JPanel navBar;
    private javax.swing.JScrollPane scrollBar;
    private javax.swing.JLabel title;
    private javax.swing.JPanel toolsPanel;
    // End of variables declaration//GEN-END:variables
}
