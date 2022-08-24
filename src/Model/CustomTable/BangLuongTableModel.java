/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.CustomTable;

import Model.BacLuongModel;
import Model.BangLuongModel;
import Model.ChucVuModel;
import Model.NhanSuModel;
import Model.ThongTinTinhLuong;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author asus
 */
public class BangLuongTableModel extends AbstractTableModel{
    
    private String name[] = {"Mã nhân sự", "Họ tên", "Năm công tác", "Chức vụ", "Lương cơ bản", "Hệ số lương", "Thưởng thâm niên", "Phụ cấp", "Bảo hiểm", "Thực lĩnh"};
    private Class classes[] = {String.class, String.class, String.class, String.class, String.class, String.class, String.class,String.class, String.class, String.class};
    ArrayList<NhanSuModel> ds = new ArrayList<>();
    ArrayList<ChucVuModel> dscv = new ArrayList<>();
    ArrayList<BacLuongModel> dsbl = new ArrayList<>();
    ArrayList<BangLuongModel> dsBangLuong = new ArrayList<>();
    int rowCount=0;
    NumberFormat nf = NumberFormat.getInstance(Locale.US);
    String file_ts = "src/SourceFile/thongsotinhluong.txt";
    String file_cv = "src/SourceFile/chucvumodel.txt";
    String file_bl = "src/SourceFile/bacluongmodel.txt";
    ThongTinTinhLuong ts = new ThongTinTinhLuong();
    
    public BangLuongTableModel() {}
    
    public BangLuongTableModel(ArrayList<NhanSuModel> ls) {
        getSetting();
        ds = new ArrayList<>(ls);
        prepare();
    }
    
    public void getSetting() {
        // Đọc file thông số tính lương
        try {
            FileInputStream fi=new FileInputStream(file_ts);
            ObjectInputStream ois=new ObjectInputStream(fi);
            ts = (ThongTinTinhLuong) ois.readObject();
            fi.close();
            ois.close();
        } catch (Exception ex) {
             System.out.println("Lỗi đọc file thông số tính lương");
        }
        
        // Đọc file chức vụ
        try {
            FileInputStream fi=new FileInputStream(file_cv);
            ObjectInputStream ois=new ObjectInputStream(fi);
            ChucVuModel cv;
            while(fi.available() > 0) {
                cv = (ChucVuModel)ois.readObject();
                dscv.add(cv);
            }
            fi.close();
            ois.close();
        } catch (Exception ex) {
             System.out.println("Lỗi đọc file chức vụ");
        }
        
        // Đọc file bậc lương
        try {
            FileInputStream fi=new FileInputStream(file_bl);
            ObjectInputStream ois=new ObjectInputStream(fi);
            BacLuongModel bl;
            while(fi.available() > 0) {
                bl = (BacLuongModel)ois.readObject();
                dsbl.add(bl);
            }
            fi.close();
            ois.close();
        } catch (Exception ex) {
             System.out.println("Lỗi đọc file bậc lương");
        }
    }
    
    private void prepare(){
        // Đọc file thông số tính lương, chức vụ và bậc lương
        // ds = new ArrayList<>(ls); ds là danh sách nhân viên
        for(NhanSuModel s : ds){
            BangLuongModel a = new BangLuongModel();
            a.setMaNS(s.getMaNS());
            a.setHoTen(s.getHoTen());
            a.setNamCongTac(TinhNamCongTac(s.getNgayThamGia()));
            ChucVuModel job = new ChucVuModel();
            BacLuongModel bac = new BacLuongModel();
            for(ChucVuModel cv : dscv) {
                if(cv.getMaCV().equals(s.getMaCV())) {
                    a.setChucVu(cv.getTenCV());
                    job = cv;
                    for(BacLuongModel bl : dsbl)
                        if(cv.getBacLuong() == bl.getBacLuong())
                            bac = bl;
                }
                    
            }
            if(a.getChucVu()!=null){
                rowCount++;
                a.setHeSoLuong(bac.getHeSoLuong());
                a.setThuongThamNien(TinhLuongThamNien(a.getNamCongTac(), a.getHeSoLuong()));
                a.setPhuCap(job.getPhuCap());
                a.setThucLinh(ts.getLuongCB()*a.getHeSoLuong()+a.getThuongThamNien()+a.getPhuCap()-ts.getBaoHiem());
                dsBangLuong.add(a);
            }
        }
    }
    
    private double TinhNamCongTac(String ngay){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dateToday = new Date();
        LocalDate d1 = LocalDate.parse(ngay, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate d2 = LocalDate.parse((String)formatter.format(dateToday), DateTimeFormatter.ISO_LOCAL_DATE);
        Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
        long diffDays = diff.toDays();
        return Double.valueOf(diffDays/365);
    }
    
    private double TinhLuongThamNien(double ngay, double hsl){
        double thuong = 0;
        int nam = (int)(ngay - ts.getNamThamNiem());
        if(nam>0){
            thuong += (ts.getLuongCB()*hsl)*((ts.getThuongCB()+nam*ts.getThuongThem())/100);
        }
        return thuong;
            
    }
    
    @Override
    public int getRowCount() {
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return classes.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return dsBangLuong.get(rowIndex).getMaNS();
            case 1: return dsBangLuong.get(rowIndex).getHoTen();
            case 2: return String.valueOf(nf.format(dsBangLuong.get(rowIndex).getNamCongTac()));
            case 3: return dsBangLuong.get(rowIndex).getChucVu();
            case 4: return String.valueOf(nf.format(ts.getLuongCB()));
            case 5: return String.valueOf(nf.format(dsBangLuong.get(rowIndex).getHeSoLuong()));
            case 6: return String.valueOf(nf.format(dsBangLuong.get(rowIndex).getThuongThamNien()));
            case 7: return String.valueOf(nf.format(dsBangLuong.get(rowIndex).getPhuCap()));
            case 8: return String.valueOf(nf.format(ts.getBaoHiem()));
            case 9: return String.valueOf(nf.format(dsBangLuong.get(rowIndex).getThucLinh()));
            default: return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return name[column];
    }
}
