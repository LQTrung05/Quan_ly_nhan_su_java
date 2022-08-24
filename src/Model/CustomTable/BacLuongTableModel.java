/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.CustomTable;

import Model.BacLuongModel;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author asus
 */
public class BacLuongTableModel extends AbstractTableModel{
    private String name[] = {"Bậc lương", "Hệ số"};
    private Class classes[] = {String.class, String.class};
    ArrayList<BacLuongModel> ds;
    
    public BacLuongTableModel() {
    }
    
    public BacLuongTableModel(ArrayList<BacLuongModel> ls) {
        ds = new ArrayList<>(ls);
    }

    @Override
    public int getRowCount() {
        return ds.size();
    }

    @Override
    public int getColumnCount() {
        return classes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return String.valueOf(ds.get(rowIndex).getBacLuong());
            case 1: return String.valueOf(ds.get(rowIndex).getHeSoLuong());
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
