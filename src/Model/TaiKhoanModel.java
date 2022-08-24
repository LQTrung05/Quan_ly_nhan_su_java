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
public class TaiKhoanModel implements Serializable{
    private int accountID;
    private String username;
    private String password;
    private String ten;
    
    public TaiKhoanModel() {}

    public TaiKhoanModel(int accountID, String username, String password, String ten) {
        this.accountID = accountID;
        this.username = username;
        this.password = password;
        this.ten = ten;
    }

    public TaiKhoanModel(TaiKhoanModel tk) {
        this.accountID = tk.accountID;
        this.username = tk.username;
        this.password = tk.password;
        this.ten = tk.ten;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
