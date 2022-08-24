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
public class PhongBanModel implements Serializable{
    private String maPB, tenPB, sdt;
    
    public PhongBanModel() {}

    public PhongBanModel(String maPB, String tenPB, String sdt) {
        this.maPB = maPB;
        this.tenPB = tenPB;
        this.sdt = sdt;
    }

    public String getMaPB() {
        return maPB;
    }

    public void setMaPB(String maPB) {
        this.maPB = maPB;
    }

    public String getTenPB() {
        return tenPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof PhongBanModel e)
            return this.maPB.equals(e.maPB);
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.maPB);
        return hash;
    }
}
