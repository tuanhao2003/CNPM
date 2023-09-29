package GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainGUI extends javax.swing.JFrame {

    public mainGUI() {
        initComponents();
        addComponent("Phiếu Nhập", new phieuNhapGUI());
        addComponent("Phiếu xuất", new phieuNhapGUI());
        
    }
    
    private void addComponent(String buttonName, JPanel panelName){
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
        
        btn.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                btn.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.green));
            }

            @Override
            public void focusLost(FocusEvent e) {
                btn.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
            }
        });
        
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý cửa hàng bán điện thoại");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1200, 700));
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setPreferredSize(new java.awt.Dimension(1200, 700));
        setResizable(false);

        logoContainer.setBackground(new java.awt.Color(200, 200, 200));
        logoContainer.setMaximumSize(new java.awt.Dimension(200, 100));
        logoContainer.setMinimumSize(new java.awt.Dimension(200, 100));
        logoContainer.setPreferredSize(new java.awt.Dimension(200, 100));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/logo.png"))); // NOI18N
        logo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logo.setIconTextGap(0);

        javax.swing.GroupLayout logoContainerLayout = new javax.swing.GroupLayout(logoContainer);
        logoContainer.setLayout(logoContainerLayout);
        logoContainerLayout.setHorizontalGroup(
            logoContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoContainerLayout.createSequentialGroup()
                .addComponent(logo)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        logoContainerLayout.setVerticalGroup(
            logoContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoContainerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(logo))
        );

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logoContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)))
                .addComponent(mainDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(logoContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(scrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(mainDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel logo;
    private javax.swing.JPanel logoContainer;
    private javax.swing.JPanel mainDisplay;
    private javax.swing.JScrollPane scrollBar;
    private javax.swing.JPanel toolsPanel;
    // End of variables declaration//GEN-END:variables
}
