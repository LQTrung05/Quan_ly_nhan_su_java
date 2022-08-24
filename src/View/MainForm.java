/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class MainForm extends javax.swing.JFrame {
    
    MainForm thisForm;
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_hoso = new javax.swing.JButton();
        btn_luong = new javax.swing.JButton();
        btn_phongban = new javax.swing.JButton();
        btn_chucvu = new javax.swing.JButton();
        btn_taikhoan = new javax.swing.JButton();
        lb_hoso = new javax.swing.JLabel();
        lb_taikhoan = new javax.swing.JLabel();
        lb_luong = new javax.swing.JLabel();
        lb_chucvu = new javax.swing.JLabel();
        lb_phongban = new javax.swing.JLabel();
        MainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_hoso.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_hoso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bt_hoso2.png"))); // NOI18N
        btn_hoso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hosoActionPerformed(evt);
            }
        });

        btn_luong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bt_salary2png.png"))); // NOI18N
        btn_luong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luongActionPerformed(evt);
            }
        });

        btn_phongban.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_phongban.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bt_phongban2.png"))); // NOI18N
        btn_phongban.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_phongban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_phongbanActionPerformed(evt);
            }
        });

        btn_chucvu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bt_chucvu2.png"))); // NOI18N
        btn_chucvu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_chucvu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chucvuActionPerformed(evt);
            }
        });

        btn_taikhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bt_account.png"))); // NOI18N
        btn_taikhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taikhoanActionPerformed(evt);
            }
        });

        lb_hoso.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lb_hoso.setText("Hồ sơ");

        lb_taikhoan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lb_taikhoan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_taikhoan.setText("Đăng xuất");

        lb_luong.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lb_luong.setText("Lương");

        lb_chucvu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lb_chucvu.setText("Chức vụ");

        lb_phongban.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lb_phongban.setText("Phòng ban");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(lb_hoso, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_phongban, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_phongban, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lb_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_luong, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lb_luong, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(97, 97, 97)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_taikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_taikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(btn_hoso, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(555, Short.MAX_VALUE)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_chucvu, btn_hoso, btn_luong, btn_phongban, btn_taikhoan});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_chucvu))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_luong, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_luong))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_taikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_phongban, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_hoso)
                            .addComponent(lb_taikhoan)
                            .addComponent(lb_phongban))))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btn_hoso, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(41, Short.MAX_VALUE)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_chucvu, btn_hoso, btn_luong, btn_phongban, btn_taikhoan});

        MainPanel.setBackground(new java.awt.Color(153, 255, 204));
        MainPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_hosoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hosoActionPerformed
        MainPanel.removeAll();
        MainPanel.setLayout(new BorderLayout());
        MainPanel.add(new hosoPanel(thisForm));
        MainPanel.revalidate();
        MainPanel.repaint();
    }//GEN-LAST:event_btn_hosoActionPerformed

    private void btn_phongbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_phongbanActionPerformed
        MainPanel.removeAll();
        MainPanel.setLayout(new BorderLayout());
        MainPanel.add(new phongbanPanel(thisForm));
        MainPanel.revalidate();
        MainPanel.repaint();
    }//GEN-LAST:event_btn_phongbanActionPerformed

    private void btn_chucvuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chucvuActionPerformed
        MainPanel.removeAll();
        MainPanel.setLayout(new BorderLayout());
        MainPanel.add(new chucvuPanel(thisForm));
        MainPanel.revalidate();
        MainPanel.repaint();
    }//GEN-LAST:event_btn_chucvuActionPerformed

    private void btn_luongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luongActionPerformed
        MainPanel.removeAll();
        MainPanel.setLayout(new BorderLayout());
        MainPanel.add(new luongPanel(thisForm));
        MainPanel.revalidate();
        MainPanel.repaint();
    }//GEN-LAST:event_btn_luongActionPerformed

    private void btn_taikhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taikhoanActionPerformed
        int ret=JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn đăng xuất?", "Đăng xuất",
                JOptionPane.YES_NO_OPTION);
            
        if(ret==JOptionPane.YES_OPTION) {
            LoginForm lg = new LoginForm();
            lg.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            lg.setLocationRelativeTo(null);
            lg.setResizable(false);
            lg.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btn_taikhoanActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton btn_chucvu;
    private javax.swing.JButton btn_hoso;
    private javax.swing.JButton btn_luong;
    private javax.swing.JButton btn_phongban;
    private javax.swing.JButton btn_taikhoan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_chucvu;
    private javax.swing.JLabel lb_hoso;
    private javax.swing.JLabel lb_luong;
    private javax.swing.JLabel lb_phongban;
    private javax.swing.JLabel lb_taikhoan;
    // End of variables declaration//GEN-END:variables
}
