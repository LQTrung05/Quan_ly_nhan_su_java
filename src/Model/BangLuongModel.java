/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author asus
 */
public class BangLuongModel {
    String maNS, hoTen, chucVu;
    double  namCongTac, heSoLuong, phuCap, thucLinh, thuongThamNien;
    
    public BangLuongModel() {}

    public BangLuongModel(String maNS, String hoTen, String chucVu, double namCongTac, double heSoLuong, double phuCap, double thucLinh, double thuongThamNien) {
        this.maNS = maNS;
        this.hoTen = hoTen;
        this.chucVu = chucVu;
        this.namCongTac = namCongTac;
        this.heSoLuong = heSoLuong;
        this.phuCap = phuCap;
        this.thucLinh = thucLinh;
        this.thuongThamNien = thuongThamNien;
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

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public double getNamCongTac() {
        return namCongTac;
    }

    public void setNamCongTac(double namCongTac) {
        this.namCongTac = namCongTac;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public double getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(double phuCap) {
        this.phuCap = phuCap;
    }

    public double getThucLinh() {
        return thucLinh;
    }

    public void setThucLinh(double thucLinh) {
        this.thucLinh = thucLinh;
    }

    public double getThuongThamNien() {
        return thuongThamNien;
    }

    public void setThuongThamNien(double thuongThamNien) {
        this.thuongThamNien = thuongThamNien;
    }
    
    
}
