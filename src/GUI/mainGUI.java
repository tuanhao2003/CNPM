package GUI;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class mainGUI extends javax.swing.JFrame {

    public mainGUI() {
        initComponents();
        solveEvent();
        addComponent("Phiếu Nhập", new phieuNhapGUI());
        
    }
    
    private void addComponent(String buttonName, JPanel panelName){
        int compQuantity = this.toolsPanel.getComponentCount();
        this.toolsPanel.setPreferredSize(new Dimension(this.toolsPanel.getWidth(), 50*(compQuantity+1)));
        JButton btn = new JButton(buttonName);
        btn.setPreferredSize(new Dimension(200,50));
        
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(panelName);
                mainDisplay.removeAll();
                mainDisplay.add(panelName);
                mainDisplay.repaint();
                mainDisplay.revalidate();
            }
        });
        this.toolsPanel.add(btn);
    }
    
    private void solveEvent(){
        
    }
    
    public static void main(String[] args) {
        mainGUI display = new mainGUI();
        display.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navBar = new javax.swing.JPanel();
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

        navBar.setBackground(new java.awt.Color(0, 255, 0));
        navBar.setMaximumSize(new java.awt.Dimension(200, 100));
        navBar.setMinimumSize(new java.awt.Dimension(200, 100));
        navBar.setPreferredSize(new java.awt.Dimension(200, 100));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/logo.png"))); // NOI18N
        logo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logo.setIconTextGap(0);

        javax.swing.GroupLayout navBarLayout = new javax.swing.GroupLayout(navBar);
        navBar.setLayout(navBarLayout);
        navBarLayout.setHorizontalGroup(
            navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navBarLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(logo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        navBarLayout.setVerticalGroup(
            navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navBarLayout.createSequentialGroup()
                .addComponent(logo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scrollBar.setBackground(new java.awt.Color(200, 200, 200));
        scrollBar.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollBar.setPreferredSize(new java.awt.Dimension(200, 600));
        JScrollBar scb = new JScrollBar(JScrollBar.VERTICAL);
        scb.setPreferredSize(new Dimension(0,0));
        scrollBar.setVerticalScrollBar(scb);

        toolsPanel.setBackground(new java.awt.Color(255, 255, 255));
        toolsPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        toolsPanel.setPreferredSize(new java.awt.Dimension(0, 0));
        toolsPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        scrollBar.setViewportView(toolsPanel);

        mainDisplay.setBackground(new java.awt.Color(255, 255, 255));
        mainDisplay.setMaximumSize(new java.awt.Dimension(1000, 700));
        mainDisplay.setMinimumSize(new java.awt.Dimension(1000, 700));
        mainDisplay.setPreferredSize(new java.awt.Dimension(1000, 700));
        mainDisplay.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(navBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(mainDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(navBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(scrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mainDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel logo;
    private javax.swing.JPanel mainDisplay;
    private javax.swing.JPanel navBar;
    private javax.swing.JScrollPane scrollBar;
    private javax.swing.JPanel toolsPanel;
    // End of variables declaration//GEN-END:variables
}
