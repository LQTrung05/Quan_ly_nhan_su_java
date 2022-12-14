/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Model.ComboItem;
import Model.NhanSuModel;
import Model.PhongBanModel;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class phongbanPanel extends javax.swing.JPanel {

    /**
     * Creates new form phongbanPanel
     */
    java.awt.Frame bb;
    ArrayList<PhongBanModel> ls = new ArrayList<>();
    ArrayList<NhanSuModel> dsnv = new ArrayList<>();
    String fileName = "src/SourceFile/phongbanmodel.txt";
    String file_nv = "src/SourceFile/nhansumodel.txt";
    
    public phongbanPanel(java.awt.Frame mainFrame) {
        initComponents();
        bb=mainFrame;
        loadData();
    }
    
    public void loadData() {
        btn_save.setVisible(false);
        btn_cancel.setVisible(false);
        try {
            FileInputStream fi=new FileInputStream(file_nv);
            ObjectInputStream ois=new ObjectInputStream(fi);
            NhanSuModel nv;
            dsnv = new ArrayList<>();
            while(fi.available() > 0)
            {
                nv = (NhanSuModel) ois.readObject();
                dsnv.add(nv);
            }
            fi.close();
            ois.close();
        } catch (Exception ex) {
            System.out.println("Lỗi đọc file nhân sự");
        }
        reLoad();
    }
    
    public void reLoad(){
        try {
            FileInputStream fi=new FileInputStream(fileName);
            ObjectInputStream ois=new ObjectInputStream(fi);
            PhongBanModel pb;
            ls = new ArrayList<>();
            while(fi.available() > 0)
            {
                pb = (PhongBanModel) ois.readObject();
                ls.add(pb);
            }
            fi.close();
            ois.close();
        } catch (Exception ex) {
            System.out.println("Lỗi đọc file phòng ban");
        }
        cbo_department.removeAllItems();
        for(PhongBanModel z: ls)
        {
            cbo_department.addItem(new ComboItem(z.getTenPB(),z.getMaPB()));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_phone = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_soluong = new javax.swing.JTextField();
        lb_soluongns = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbo_department = new javax.swing.JComboBox<>();
        btn_save = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Mã phòng ban");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 94, 150, 40));
        add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 95, 210, 40));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Tên phòng ban");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 147, 150, 40));
        add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 148, 210, 40));
        add(txt_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 201, 210, 40));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Số điện thoại");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 200, 150, 40));
        add(txt_soluong, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 254, 210, 40));

        lb_soluongns.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lb_soluongns.setText("Số lượng nhân sự");
        add(lb_soluongns, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 253, 150, 40));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Danh sách phòng");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 35, 150, 40));

        cbo_department.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_departmentItemStateChanged(evt);
            }
        });
        add(cbo_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 36, 210, 40));

        btn_save.setBackground(new java.awt.Color(0, 102, 102));
        btn_save.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_save.setForeground(new java.awt.Color(255, 255, 255));
        btn_save.setText("LƯU");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 85, 41));

        btn_cancel.setBackground(new java.awt.Color(0, 102, 102));
        btn_cancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_cancel.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancel.setText("HỦY");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 85, 41));

        btn_add.setBackground(new java.awt.Color(0, 102, 102));
        btn_add.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("THÊM");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, 85, 41));

        btn_update.setBackground(new java.awt.Color(0, 102, 102));
        btn_update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("SỬA");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 85, 41));

        btn_delete.setBackground(new java.awt.Color(0, 102, 102));
        btn_delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("XÓA");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 85, 41));
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 350));
    }// </editor-fold>//GEN-END:initComponents
    private void getStartAdd(){
        txt_id.setEnabled(true);
        btn_save.setVisible(true);
        btn_cancel.setVisible(true);
        btn_update.setEnabled(false);
        btn_delete.setEnabled(false);
        btn_add.setEnabled(false);
        cbo_department.setEnabled(false);
        cbo_department.setSelectedIndex(-1);
        txt_id.setText("");
        txt_name.setText("");
        txt_phone.setText("");
        txt_soluong.setText("0");
        txt_soluong.setEnabled(false);
    }
    
    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        getStartAdd();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        cbo_department.setEnabled(true);
        cbo_department.setSelectedIndex(-1);
        btn_save.setVisible(false);
        btn_cancel.setVisible(false);
        btn_update.setEnabled(true);
        btn_delete.setEnabled(true);
        btn_add.setEnabled(true);
        txt_id.setEnabled(false);
        txt_soluong.setEnabled(false);

    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        try{
            if(txt_id.getText().equals("")){
                txt_id.requestFocus();
                throw new Exception("Mã phòng ban không được để trống!");
            }
            if(txt_name.getText().equals("")){
                txt_name.requestFocus();
                throw new Exception("Tên phòng ban không được để trống!");
            }
            if(txt_phone.getText().equals("")){
                txt_phone.requestFocus();
                throw new Exception("Số điện thoại không được để trống!");
            }
            if(!txt_phone.getText().matches("[0-9]+")){
                txt_phone.requestFocus();
                throw new Exception("Số điện thoại chỉ bao gồm số!");
            }
            for(PhongBanModel pb : ls) {
                if(pb.getMaPB().equals(txt_id.getText())){
                    txt_id.requestFocus();
                    throw new Exception("Mã phòng ban này đã tồn tại!");
                }
            }
            
            String maPB = txt_id.getText();
            String tenPB = txt_name.getText();
            String sdt = txt_phone.getText();
            try {
                PhongBanModel newpb = new PhongBanModel(maPB, tenPB, sdt);
                ls.add(newpb);
                FileOutputStream fs=new FileOutputStream(fileName);
                ObjectOutputStream os=new ObjectOutputStream(fs);
                for(PhongBanModel pb : ls)
                    os.writeObject(pb);
                fs.close();
                os.close();
                
                reLoad();
                cbo_department.setEnabled(true);
                cbo_department.setSelectedIndex(0);
                btn_save.setVisible(false);
                btn_cancel.setVisible(false);
                btn_update.setEnabled(true);
                btn_delete.setEnabled(true);
                btn_add.setEnabled(true);
                txt_id.setEnabled(false);
                JOptionPane.showMessageDialog(background, "Thêm thành công!");
            }
            catch(Exception ex) {
                System.out.println("Lỗi ghi file");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(background, e.getMessage(), "Thêm thất bại!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void cbo_departmentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_departmentItemStateChanged
        if(cbo_department.getSelectedItem()!=null){
            String choose = ((ComboItem)cbo_department.getSelectedItem()).getValue();
            int count = 0;
            for(NhanSuModel nv : dsnv) {
                if(nv.getMaPB().equals(choose))
                    count++;
            }
            for(PhongBanModel z: ls)
                if(choose.equals(z.getMaPB())){
                    txt_id.setText(z.getMaPB());
                    txt_name.setText(z.getTenPB());
                    txt_phone.setText(String.valueOf(z.getSdt()));
                    txt_soluong.setText(String.valueOf(count));
                    txt_soluong.setEnabled(false);
                    
                }
        }
    }//GEN-LAST:event_cbo_departmentItemStateChanged

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        int choose = cbo_department.getSelectedIndex();
        try{
            if(txt_name.getText().equals("")){
                txt_name.requestFocus();
                throw new Exception("Tên phòng ban không được để trống!");
            }
            if(txt_phone.getText().equals("")){
                txt_phone.requestFocus();
                throw new Exception("Số điện thoại không được để trống!");
            }
            if(!txt_phone.getText().matches("[0-9]+")){
                txt_phone.requestFocus();
                throw new Exception("Số điện thoại chỉ bao gồm số!");
            }
            String maPB = txt_id.getText();
            String tenPB = txt_name.getText();
            String sdt = txt_phone.getText();
            
            PhongBanModel newpb = new PhongBanModel(maPB, tenPB, sdt);
            int index = ls.indexOf(newpb);
            if(index != -1)
                ls.set(index, newpb);
            try {
                FileOutputStream fs=new FileOutputStream(fileName);
                ObjectOutputStream os=new ObjectOutputStream(fs);
                for(PhongBanModel pb : ls)
                    os.writeObject(pb);
                fs.close();
                os.close();
                
                reLoad();
                cbo_department.setSelectedIndex(choose);
                JOptionPane.showMessageDialog(background, "Sửa thành công!");
            }
            catch(Exception ex) {
                System.out.println("Lỗi ghi file");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(background, e.getMessage(), "Sửa thất bại!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        if(JOptionPane.showConfirmDialog (null, "Bạn chắc chắn muốn xóa bản ghi này?","Bạn chắc chứ?",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            try{
                int choose = cbo_department.getSelectedIndex();
                String maPB = txt_id.getText();
                for(NhanSuModel ns : dsnv) {
                    if(ns.getMaPB().equals(maPB))
                        throw new Exception("Đang có nhân viên ở phòng ban này, vui lòng xem xét lại!");
                }
                String tenPB = txt_name.getText();
                String sdt = txt_phone.getText();
                PhongBanModel xoapb = new PhongBanModel(maPB, tenPB, sdt);
                int index = ls.indexOf(xoapb);
                if(index != -1) {
                    ls.remove(index);
                }
                try {
                    FileOutputStream fs=new FileOutputStream(fileName);
                    ObjectOutputStream os=new ObjectOutputStream(fs);
                    for(PhongBanModel pb : ls)
                        os.writeObject(pb);
                    fs.close();
                    os.close();
                    JOptionPane.showMessageDialog(background, "Xoá thành công!");
                    reLoad();
                }
                catch(Exception ex) {
                    System.out.println("Lỗi ghi file phòng ban");
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(background, e.getMessage(), "Xoá thất bại!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_deleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<ComboItem> cbo_department;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lb_soluongns;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_phone;
    private javax.swing.JTextField txt_soluong;
    // End of variables declaration//GEN-END:variables
}
