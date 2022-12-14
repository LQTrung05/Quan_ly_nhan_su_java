/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View;

import Model.ChucVuModel;
import Model.ComboItem;
import Model.NhanSuModel;
import Model.PhongBanModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author asus
 */
public class detailHoSo extends javax.swing.JDialog {

    /**
     * Creates new form detailHoSo
     */
    String file_ns = "src/SourceFile/nhansumodel.txt";
    String file_pb = "src/SourceFile/phongbanmodel.txt";
    String file_cv = "src/SourceFile/chucvumodel.txt";
    ArrayList<NhanSuModel> dsnv = new ArrayList<>();
    ArrayList<ChucVuModel> dscv = new ArrayList<>();
    ArrayList<PhongBanModel> dspb = new ArrayList<>();
    hosoPanel previousPanel;
    NhanSuModel acc;
    ButtonGroup btn_gioitinh = new ButtonGroup();
    ButtonGroup btn_congchuc = new ButtonGroup();
    
    public detailHoSo(hosoPanel pF, String MaNS, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        // Lấy danh sách nhân sự
        try {
            FileInputStream fi=new FileInputStream(file_ns);
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
        
        for(NhanSuModel ns : dsnv) {
            if(ns.getMaNS().equals(MaNS))
                acc= ns;
        }
        
        // Lay danh sach phong ban
        try {
            FileInputStream fi=new FileInputStream(file_pb);
            ObjectInputStream ois=new ObjectInputStream(fi);
            PhongBanModel pb;
            dspb = new ArrayList<>();
            while(fi.available() > 0)
            {
                pb = (PhongBanModel) ois.readObject();
                dspb.add(pb);
            }
            fi.close();
            ois.close();
        } catch (Exception ex) {
            System.out.println("Lỗi đọc file phong ban");
        }
        // Lay danh sach chuc vu
        try {
            FileInputStream fi=new FileInputStream(file_cv);
            ObjectInputStream ois=new ObjectInputStream(fi);
            ChucVuModel cv;
            dscv = new ArrayList<>();
            while(fi.available() > 0)
            {
                cv = (ChucVuModel) ois.readObject();
                dscv.add(cv);
            }
            fi.close();
            ois.close();
        } catch (Exception ex) {
            System.out.println("Lỗi đọc file chuc vu");
        }
        previousPanel = pF;
        prepare();
    }
    
    public void prepare() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        rdCongChuc.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    txt_DateEnd.getCalendarButton().setEnabled(false);
                }
                else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    txt_DateEnd.getCalendarButton().setEnabled(true);
                }
            }
        });
        btn_gioitinh.add(rdNam);
        btn_gioitinh.add(rdNu);
        btn_congchuc.add(rdCongChuc);
        btn_congchuc.add(rdHopDong);
        txt_ngaysinh.setDateFormatString("yyyy-MM-dd");
        txt_DateStart.setDateFormatString("yyyy-MM-dd");
        txt_DateEnd.setDateFormatString("yyyy-MM-dd");
        
        txt_id.setText(acc.getMaNS());
        txt_id.setEnabled(false);
        txt_major.setText(acc.getChuyenNganh());
        txt_nation.setText(acc.getDanToc());
        txt_name.setText(acc.getHoTen());
        txt_address.setText(acc.getQueQuan());
        txt_phone.setText(acc.getSoDienThoai());
        txt_qualify.setText(acc.getTrinhDoHocVan());
        if(acc.isGioiTinh())
            rdNam.setSelected(true);
        else
            rdNu.setSelected(true);
        if(acc.isCongChuc())
        {
            rdCongChuc.setSelected(true);
        }
        else
        {
            rdHopDong.setSelected(true);
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date date = formatter.parse(acc.getHanHopDong());
                txt_DateEnd.setDate(date);
            } catch (ParseException ex) {
                Logger.getLogger(detailHoSo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        cbo_department.addItem(new ComboItem("Không có",null));
        for(PhongBanModel s : dspb)
            cbo_department.addItem(new ComboItem(s.getTenPB(),s.getMaPB()));
        int i = 1;
        if(acc.getMaPB()==null){
            cbo_department.setSelectedIndex(0);
        }
        else{
            for(PhongBanModel pb : dspb)
            {
                if(pb.getMaPB().equals(acc.getMaPB()))
                    cbo_department.setSelectedIndex(i);
                i++;
            }
        }
        cbo_job.addItem(new ComboItem("Không có",null));
        for(ChucVuModel s : dscv)
            cbo_job.addItem(new ComboItem(s.getTenCV(),s.getMaCV()));
        i = 1;
        if(acc.getMaCV()==null){
            cbo_job.setSelectedIndex(0);
        }
        else{
            for(ChucVuModel cv : dscv)
            {
                if(cv.getMaCV().equals(acc.getMaCV()))
                    cbo_job.setSelectedIndex(i);
                i++;
            }
        }
        
        // DateTime
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = formatter.parse(acc.getNgaySinh());
            txt_ngaysinh.setDate(date);
            
            date = formatter.parse(acc.getNgayThamGia());
            txt_DateStart.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(detailHoSo.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        lb_id = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        lb_name = new javax.swing.JLabel();
        txt_address = new javax.swing.JTextField();
        lb_address = new javax.swing.JLabel();
        txt_nation = new javax.swing.JTextField();
        lb_nation = new javax.swing.JLabel();
        txt_ngaysinh = new com.toedter.calendar.JDateChooser();
        lb_birthday = new javax.swing.JLabel();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        lb_gender = new javax.swing.JLabel();
        lb_phone = new javax.swing.JLabel();
        txt_phone = new javax.swing.JTextField();
        lb_job = new javax.swing.JLabel();
        lb_department = new javax.swing.JLabel();
        cbo_department = new javax.swing.JComboBox<>();
        cbo_job = new javax.swing.JComboBox<>();
        txt_qualify = new javax.swing.JTextField();
        lb_qualify = new javax.swing.JLabel();
        txt_major = new javax.swing.JTextField();
        lb_major = new javax.swing.JLabel();
        lb_dateStart = new javax.swing.JLabel();
        lb_type = new javax.swing.JLabel();
        rdHopDong = new javax.swing.JRadioButton();
        rdCongChuc = new javax.swing.JRadioButton();
        lb_dateEnd = new javax.swing.JLabel();
        txt_DateEnd = new com.toedter.calendar.JDateChooser();
        btnCancel = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        txt_DateStart = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHI TIẾT NHÂN SỰ");

        lb_id.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_id.setText("Mã nhân sự");

        lb_name.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_name.setText("Họ và tên");

        lb_address.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_address.setText("Quê quán");

        lb_nation.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_nation.setText("Dân tộc");

        txt_ngaysinh.setBackground(new java.awt.Color(255, 255, 255, 0));
        txt_ngaysinh.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_ngaysinh.setOpaque(false);

        lb_birthday.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_birthday.setText("Ngày sinh");

        rdNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdNam.setText("Nam");

        rdNu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdNu.setText("Nữ");

        lb_gender.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_gender.setText("Giới tính");

        lb_phone.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_phone.setText("Số điện thoại");

        txt_phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_phoneKeyTyped(evt);
            }
        });

        lb_job.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_job.setText("Chức vụ");

        lb_department.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_department.setText("Phòng ban");

        lb_qualify.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_qualify.setText("Trình độ");

        lb_major.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_major.setText("Chuyên ngành");

        lb_dateStart.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_dateStart.setText("Ngày tham gia");

        lb_type.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_type.setText("Loại nhân sự");

        rdHopDong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdHopDong.setText("Hợp đồng");

        rdCongChuc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdCongChuc.setText("Công chức");

        lb_dateEnd.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lb_dateEnd.setText("Hạn hợp đồng");

        txt_DateEnd.setBackground(new java.awt.Color(255, 255, 255, 0));
        txt_DateEnd.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_DateEnd.setOpaque(false);

        btnCancel.setBackground(new java.awt.Color(255, 0, 0));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("HỦY BỎ");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btn_save.setBackground(new java.awt.Color(0, 255, 0));
        btn_save.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_save.setForeground(new java.awt.Color(255, 255, 255));
        btn_save.setText("LƯU");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        txt_DateStart.setBackground(new java.awt.Color(255, 255, 255, 0));
        txt_DateStart.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_DateStart.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lb_nation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_address, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_gender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_birthday, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nation, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(rdNam)
                                .addGap(37, 37, 37)
                                .addComponent(rdNu)
                                .addGap(48, 48, 48)))
                        .addComponent(txt_ngaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lb_dateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(txt_DateEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(45, 45, 45))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lb_dateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lb_department, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_qualify, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_major, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lb_job, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lb_type, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdCongChuc)
                                .addGap(18, 18, 18)
                                .addComponent(rdHopDong))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_DateStart, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbo_department, javax.swing.GroupLayout.Alignment.LEADING, 0, 180, Short.MAX_VALUE)
                                .addComponent(cbo_job, javax.swing.GroupLayout.Alignment.LEADING, 0, 180, Short.MAX_VALUE)
                                .addComponent(txt_qualify, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addComponent(txt_major, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
                        .addContainerGap(32, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lb_department, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_job, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_qualify, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lb_major, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_major, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbo_department, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbo_job, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_qualify, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_DateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_dateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_type, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdCongChuc)
                            .addComponent(rdHopDong))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_DateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_dateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lb_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lb_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lb_birthday, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_address, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdNam)
                            .addComponent(rdNu)
                            .addComponent(lb_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_nation, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nation, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        try{
            if(txt_name.getText().equals("")){
                txt_name.requestFocus();
                throw new Exception("Họ tên không được để trống!");
            }
            if(txt_ngaysinh.getDate()==null)
                throw new Exception("Ngày sinh không được để trống!");
            if(txt_address.getText().equals("")){
                txt_address.requestFocus();
                throw new Exception("Quê quán không được để trống!");
            }
            if(txt_nation.getText().equals("")){
                txt_nation.requestFocus();
                throw new Exception("Dân tộc không được để trống!");
            }
            if(txt_phone.getText().equals("")){
                txt_phone.requestFocus();
                throw new Exception("Số điện thoại không được để trống!");
            }
            if(!txt_phone.getText().matches("[0-9]+")){
                txt_phone.requestFocus();
                throw new Exception("Số điện thoại chỉ bao gồm số!");
            }
            if(txt_qualify.getText().equals("")){
                txt_qualify.requestFocus();
                throw new Exception("Trình độ không được để trống!");
            }
            if(txt_major.getText().equals("")){
                txt_major.requestFocus();
                throw new Exception("Chuyên ngành không được để trống!");
            }
            if(txt_DateStart.getDate()==null)
                throw new Exception("Ngày tham gia không được để trống!");
            if(rdHopDong.isSelected())
                if(txt_DateEnd.getDate()==null)
                throw new Exception("Hạn hợp đồng không được để trống!");
            
            String id = txt_id.getText().toUpperCase();
            String name = txt_name.getText();
            String birthday = ((JTextField)txt_ngaysinh.getDateEditor().getUiComponent()).getText();
            String address = txt_address.getText();
            String nation = txt_nation.getText();
            String phone = txt_phone.getText();
            String qualify = txt_qualify.getText();
            String major = txt_major.getText();
            String dateStart = ((JTextField)txt_DateStart.getDateEditor().getUiComponent()).getText();
            String pb = ((ComboItem)cbo_department.getSelectedItem()).getValue();
            String cv = ((ComboItem)cbo_job.getSelectedItem()).getValue();
            boolean gender = rdNam.isSelected()?true:false;
            boolean typeNV = rdCongChuc.isSelected() ? true : false;
            String dateEnd = rdHopDong.isSelected() ? ((JTextField)txt_DateEnd.getDateEditor().getUiComponent()).getText() : "1900-01-01";
            
            NhanSuModel newnv = new NhanSuModel(id, name, birthday, address, nation, phone, qualify, major, pb, cv, dateStart, dateEnd, gender, typeNV);
            int index = dsnv.indexOf(newnv);
            if(index != -1)
                dsnv.set(index, newnv);
            try {
                FileOutputStream fs=new FileOutputStream(file_ns);
                ObjectOutputStream os=new ObjectOutputStream(fs);
                for(NhanSuModel nv : dsnv)
                    os.writeObject(nv);
                fs.close();
                os.close();
                
                JOptionPane.showMessageDialog(this,"Sửa thành công!");
                previousPanel.LoadData();
                this.dispose();
            }
            catch(Exception ex) {
                System.out.println("Lỗi ghi file nhân sự");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Sửa thất bại!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void txt_phoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_phoneKeyTyped
        if(!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_phoneKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(detailHoSo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detailHoSo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detailHoSo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detailHoSo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                detailHoSo dialog = new detailHoSo(new hosoPanel(new java.awt.Frame()), null, new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btn_save;
    private javax.swing.JComboBox<ComboItem> cbo_department;
    private javax.swing.JComboBox<ComboItem> cbo_job;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_address;
    private javax.swing.JLabel lb_birthday;
    private javax.swing.JLabel lb_dateEnd;
    private javax.swing.JLabel lb_dateStart;
    private javax.swing.JLabel lb_department;
    private javax.swing.JLabel lb_gender;
    private javax.swing.JLabel lb_id;
    private javax.swing.JLabel lb_job;
    private javax.swing.JLabel lb_major;
    private javax.swing.JLabel lb_name;
    private javax.swing.JLabel lb_nation;
    private javax.swing.JLabel lb_phone;
    private javax.swing.JLabel lb_qualify;
    private javax.swing.JLabel lb_type;
    private javax.swing.JRadioButton rdCongChuc;
    private javax.swing.JRadioButton rdHopDong;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private com.toedter.calendar.JDateChooser txt_DateEnd;
    private com.toedter.calendar.JDateChooser txt_DateStart;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_major;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_nation;
    private com.toedter.calendar.JDateChooser txt_ngaysinh;
    private javax.swing.JTextField txt_phone;
    private javax.swing.JTextField txt_qualify;
    // End of variables declaration//GEN-END:variables
}
