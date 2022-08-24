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
public class BacLuongModel implements Serializable{
    private Integer bacLuong;
    private double heSoLuong;
    
    public BacLuongModel() {}

    public BacLuongModel(int bacLuong, double heSoLuong) {
        this.bacLuong = bacLuong;
        this.heSoLuong = heSoLuong;
    }

    public int getBacLuong() {
        return bacLuong;
    }

    public void setBacLuong(int bacLuong) {
        this.bacLuong = bacLuong;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BacLuongModel e)
            return this.bacLuong.equals(e.bacLuong);
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.bacLuong);
        return hash;
    }
}
