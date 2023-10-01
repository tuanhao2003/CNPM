package GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainGUI extends javax.swing.JFrame {  
    private int working=-1;
   
    public mainGUI() {
        initComponents();
//thêm nút vào thanh công cụ và set màn hình được hiển thị khi nhấn nút
        addComponent("Phiếu Nhập", new phieuNhapGUI(), "pn.png");
        //lưu file trong thư mục Comp xong ghi tên file vào đây → → → → ↓
        addComponent("Phiếu Xuất", new phieuNhapGUI(), "ctpn.png");
        addComponent("Khuyến Mãi", new khuyenMaiGUI(), "logo.png");
        addComponent("Thống Kê", new thongKeGUI(), "logo.png");
        
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
        if(path == null){
            btn.setIcon(null);
        }
        else{
            btn.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("Comp/"+path)).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
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
//tạo khung mã nhân viên (chỉnh sửa thêm mã tự động sau)
        this.labelMenu.setBackground(new Color(0, 200, 0));
        this.labelMenu.setForeground(Color.RED);
        UIManager.put("Button.disabledText", Color.white);
        this.labelMenu.setFont(new Font(labelMenu.getFont().getName(), Font.BOLD, 14));
        this.labelMenu.setText("Menu Quản Lý");
        
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
            }
        });
        
//xử lý hoạt ảnh đang hoạt động của thanh công cụ
        for(int i=0; i<this.toolsPanel.getComponentCount(); i++){
            int tmp = i;
            this.toolsPanel.getComponent(i).addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if(working>=0){
                        ((JButton) toolsPanel.getComponent(working)).setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
                    }
                    working=tmp;
                    ((JButton) toolsPanel.getComponent(tmp)).setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.green));
                }

                @Override
                public void focusLost(FocusEvent e) {
                   //pass
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
        labelMenu = new javax.swing.JButton();
        scrollBar = new javax.swing.JScrollPane();
        toolsPanel = new javax.swing.JPanel();
        mainDisplay = new javax.swing.JPanel();
        navBar = new javax.swing.JPanel();
        logOut = new javax.swing.JButton();
        labelManv = new javax.swing.JLabel();
        title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý cửa hàng bán điện thoại");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setResizable(false);

        logoContainer.setBackground(new java.awt.Color(200, 200, 200));
        logoContainer.setMaximumSize(new java.awt.Dimension(200, 100));
        logoContainer.setMinimumSize(new java.awt.Dimension(200, 100));
        logoContainer.setPreferredSize(new java.awt.Dimension(200, 100));
        logoContainer.setLayout(new java.awt.BorderLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Comp/logo.png"))); // NOI18N
        logo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logo.setIconTextGap(0);
        logoContainer.add(logo, java.awt.BorderLayout.CENTER);

        labelMenu.setForeground(new java.awt.Color(255, 255, 255));
        labelMenu.setBorderPainted(false);
        labelMenu.setEnabled(false);
        labelMenu.setFocusPainted(false);
        labelMenu.setPreferredSize(new java.awt.Dimension(200, 20));
        logoContainer.add(labelMenu, java.awt.BorderLayout.PAGE_END);

        scrollBar.setBackground(new java.awt.Color(200, 200, 200));
        scrollBar.setBorder(null);
        scrollBar.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollBar.setPreferredSize(new java.awt.Dimension(200, 600));
        JScrollBar scb = new JScrollBar(JScrollBar.VERTICAL);
        scb.setPreferredSize(new Dimension(0,0));
        scrollBar.setVerticalScrollBar(scb);

        toolsPanel.setBackground(new java.awt.Color(80, 130, 100));
        toolsPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        toolsPanel.setPreferredSize(new java.awt.Dimension(0, 0));
        toolsPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        scrollBar.setViewportView(toolsPanel);

        mainDisplay.setBackground(new java.awt.Color(255, 255, 255));
        mainDisplay.setMaximumSize(new java.awt.Dimension(1000, 700));
        mainDisplay.setMinimumSize(new java.awt.Dimension(1000, 10));
        mainDisplay.setPreferredSize(new java.awt.Dimension(1000, 650));
        mainDisplay.setLayout(new java.awt.BorderLayout());

        navBar.setBackground(new java.awt.Color(200, 200, 200));
        navBar.setPreferredSize(new java.awt.Dimension(1000, 50));

        logOut.setBackground(new java.awt.Color(200, 200, 200));
        logOut.setBorderPainted(false);
        logOut.setPreferredSize(new java.awt.Dimension(50, 50));

        labelManv.setText("Mã nhân viên: ");

        logOut.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("Comp/logout.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));

        javax.swing.GroupLayout navBarLayout = new javax.swing.GroupLayout(navBar);
        navBar.setLayout(navBarLayout);
        navBarLayout.setHorizontalGroup(
            navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navBarLayout.createSequentialGroup()
                .addGap(383, 383, 383)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 483, Short.MAX_VALUE)
                .addComponent(labelManv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        navBarLayout.setVerticalGroup(
            navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navBarLayout.createSequentialGroup()
                .addComponent(logOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(navBarLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelManv)
                    .addComponent(title))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(logoContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(navBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
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
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelManv;
    private javax.swing.JButton labelMenu;
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
