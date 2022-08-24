/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author asus
 */
public class ThongTinTinhLuong implements Serializable{
    private double  thuongCB, thuongThem;
    private int luongCB,  baoHiem, namThamNiem;
    
    public ThongTinTinhLuong() {}

    public ThongTinTinhLuong(double thuongCB, double thuongThem, int luongCB, int baoHiem, int namThamNiem) {
        this.thuongCB = thuongCB;
        this.thuongThem = thuongThem;
        this.luongCB = luongCB;
        this.baoHiem = baoHiem;
        this.namThamNiem = namThamNiem;
    }

    public double getThuongCB() {
        return thuongCB;
    }

    public void setThuongCB(double thuongCB) {
        this.thuongCB = thuongCB;
    }

    public double getThuongThem() {
        return thuongThem;
    }

    public void setThuongThem(double thuongThem) {
        this.thuongThem = thuongThem;
    }

    public int getLuongCB() {
        return luongCB;
    }

    public void setLuongCB(int luongCB) {
        this.luongCB = luongCB;
    }

    public int getBaoHiem() {
        return baoHiem;
    }

    public void setBaoHiem(int baoHiem) {
        this.baoHiem = baoHiem;
    }

    public int getNamThamNiem() {
        return namThamNiem;
    }

    public void setNamThamNiem(int namThamNiem) {
        this.namThamNiem = namThamNiem;
    }
}
