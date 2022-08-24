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
public class ChucVuModel implements Serializable{
    private String MaCV, tenCV;
    private double PhuCap;
    private int BacLuong;
    
    public ChucVuModel() {}

    public ChucVuModel(String MaCV, String tenCV, double PhuCap, int BacLuong) {
        this.MaCV = MaCV;
        this.tenCV = tenCV;
        this.PhuCap = PhuCap;
        this.BacLuong = BacLuong;
    }

    public String getMaCV() {
        return MaCV;
    }

    public void setMaCV(String MaCV) {
        this.MaCV = MaCV;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    public double getPhuCap() {
        return PhuCap;
    }

    public void setPhuCap(double PhuCap) {
        this.PhuCap = PhuCap;
    }

    public int getBacLuong() {
        return BacLuong;
    }

    public void setBacLuong(int BacLuong) {
        this.BacLuong = BacLuong;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ChucVuModel e)
            return this.MaCV.equals(e.MaCV);
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.MaCV);
        return hash;
    }
}
