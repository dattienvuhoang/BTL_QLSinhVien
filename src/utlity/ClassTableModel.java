/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utlity;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.GiangVien;
import models.LopHoc;
import models.SinhVien;


/**
 *
 * @author Dat
 */
public class ClassTableModel {
    public DefaultTableModel setTableSinhVien(List<SinhVien> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 7 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        SinhVien sinhVien = null;
        for (int i = 0; i < num; i++) {
            sinhVien = listItem.get(i);
            obj = new Object[columns];
            obj[0] = sinhVien.getMaSV();
            obj[1] = sinhVien.getHoTen();
            obj[2] = sinhVien.getNgaySinh();
            obj[3] = sinhVien.isGioiTinh() == true ?"Nam" : "Nữ";
            obj[4] = sinhVien.getSoDT();
            obj[5] = sinhVien.getQueQuan();
            obj[6] = sinhVien.getMaLop();
            dtm.addRow(obj);
        }
        return dtm;
    }
    public DefaultTableModel setTableLopHoc(List<LopHoc> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 7 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        LopHoc lopHoc = null;
        for (int i = 0; i < num; i++) {
            lopHoc = listItem.get(i);
            obj = new Object[columns];
            obj[0] = lopHoc.getMaLop();
            obj[1] = lopHoc.getTenLopHoc();
            obj[2] = lopHoc.getMaGiangVien();
            dtm.addRow(obj);
        }
        return dtm;
    }
    public DefaultTableModel setTableGiangVien(List<GiangVien> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 7 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        GiangVien giangVien = null;
        for (int i = 0; i < num; i++) {
            giangVien = listItem.get(i);
            obj = new Object[columns];
            obj[0] = giangVien.getMaGiangVien();
            obj[1] = giangVien.getTenGV();
            obj[2] = giangVien.getNgaySinh();
            obj[3] = giangVien.getQueQuan();
            dtm.addRow(obj);
        }
        return dtm;
    }
}
