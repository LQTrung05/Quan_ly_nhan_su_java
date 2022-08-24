/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author asus
 */
public class NhanSuModel implements Serializable {
    private String maNS, hoTen, ngaySinh, queQuan, danToc, soDienThoai, trinhDoHocVan, ChuyenNganh, maPB, maCV, NgayThamGia, hanHopDong;
    private boolean gioiTinh, congChuc;

    public NhanSuModel() {}
    
    public NhanSuModel(String maNS, String maPB, String maCV) {
        this.maNS = maNS;
        this.maPB = maPB;
        this.maCV = maCV;
    }
    
    public NhanSuModel(String maNS, String hoTen, String ngaySinh, String queQuan, String danToc, String soDienThoai, String trinhDoHocVan, String ChuyenNganh, String maPB, String maCV, String NgayThamGia, String hanHopDong, boolean gioiTinh, boolean congChuc) {
        this.maNS = maNS;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
        this.danToc = danToc;
        this.soDienThoai = soDienThoai;
        this.trinhDoHocVan = trinhDoHocVan;
        this.ChuyenNganh = ChuyenNganh;
        this.maPB = maPB;
        this.maCV = maCV;
        this.NgayThamGia = NgayThamGia;
        this.hanHopDong = hanHopDong;
        this.gioiTinh = gioiTinh;
        this.congChuc = congChuc;
    }

    public String getMaNS() {
        return maNS;
    }

    public void setMaNS(String maNS) {
        this.maNS = maNS;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getTrinhDoHocVan() {
        return trinhDoHocVan;
    }

    public void setTrinhDoHocVan(String trinhDoHocVan) {
        this.trinhDoHocVan = trinhDoHocVan;
    }

    public String getChuyenNganh() {
        return ChuyenNganh;
    }

    public void setChuyenNganh(String ChuyenNganh) {
        this.ChuyenNganh = ChuyenNganh;
    }

    public String getMaPB() {
        return maPB;
    }

    public void setMaPB(String maPB) {
        this.maPB = maPB;
    }

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public String getNgayThamGia() {
        return NgayThamGia;
    }

    public void setNgayThamGia(String NgayThamGia) {
        this.NgayThamGia = NgayThamGia;
    }

    public String getHanHopDong() {
        return hanHopDong;
    }

    public void setHanHopDong(String hanHopDong) {
        this.hanHopDong = hanHopDong;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public boolean isCongChuc() {
        return congChuc;
    }

    public void setCongChuc(boolean congChuc) {
        this.congChuc = congChuc;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof NhanSuModel e)
            return this.maNS.equals(e.maNS);
        return false;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.maNS);
        return hash;
    }
}
