package GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainGUI extends javax.swing.JFrame {  
    private int working=-1;
    
    public mainGUI() {
        initComponents();
//thêm nút vào thanh công cụ và set màn hình được hiển thị khi nhấn nút
        addComponent("Phiếu Nhập", new phieuNhapGUI());
        //lưu file trong thư mục Comp xong ghi tên file vào đây → → → → ↓
        addComponent("Phiếu Xuất", new phieuNhapGUI(), "logo.png");
        
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
            btn.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("Comp/logo.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        }
        
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainDisplay.removeAll();
                mainDisplay.add(panelName);
                mainDisplay.repaint();
                mainDisplay.revalidate();
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
        String Manv="nv001";
        this.labelManv.setBackground(new Color(0, 200, 0));
        this.labelManv.setForeground(Color.RED);
        UIManager.put("Button.disabledText", Color.white);
        this.labelManv.setFont(new Font(labelManv.getFont().getName(), Font.BOLD, 14));
        this.labelManv.setText("NV: "+Manv);
        
//thêm nút đăng xuất vào thanh công cụ
        JButton logOut = new JButton("Đăng xuất");
        logOut.setPreferredSize(new Dimension(200,50));
        logOut.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        logOut.setBackground(new Color(80,130,100));
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
        this.toolsPanel.add(logOut);
        
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
        labelManv = new javax.swing.JButton();
        scrollBar = new javax.swing.JScrollPane();
        toolsPanel = new javax.swing.JPanel();
        mainDisplay = new javax.swing.JPanel();

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

        labelManv.setForeground(new java.awt.Color(255, 255, 255));
        labelManv.setBorderPainted(false);
        labelManv.setEnabled(false);
        labelManv.setFocusPainted(false);
        labelManv.setPreferredSize(new java.awt.Dimension(200, 20));
        logoContainer.add(labelManv, java.awt.BorderLayout.PAGE_END);

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
        mainDisplay.setPreferredSize(new java.awt.Dimension(1000, 700));
        mainDisplay.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(mainDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(logoContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(mainDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton labelManv;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel logoContainer;
    private javax.swing.JPanel mainDisplay;
    private javax.swing.JScrollPane scrollBar;
    private javax.swing.JPanel toolsPanel;
    // End of variables declaration//GEN-END:variables
}
