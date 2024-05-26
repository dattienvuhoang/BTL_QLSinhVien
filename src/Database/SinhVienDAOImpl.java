/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.util.List;
import java.sql.* ;
import java.util.ArrayList;
import models.SinhVien;

/**
 *
 * @author Dat
 */
public class SinhVienDAOImpl implements SinhVienDAO{
    @Override
    public List<SinhVien> getList() {
        Connection cons = DBConnect.getConnection();
        System.out.println(cons);
        String sql = "SELECT * FROM `sinhvien`";
        List<SinhVien> list = new ArrayList<>();
        ResultSet rs = null ;
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
             rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sinhVien = new SinhVien();
                sinhVien.setMaSV(rs.getString("maSV"));
                sinhVien.setHoTen(rs.getString("hoTen"));
                sinhVien.setNgaySinh(rs.getDate("ngaySinh"));
                sinhVien.setGioiTinh(rs.getInt("gioiTinh"));
                sinhVien.setQueQuan(rs.getString("queQuan"));
                sinhVien.setSoDT(rs.getString("soDT"));
                sinhVien.setMaLop(rs.getString("maLop"));
                list.add(sinhVien);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
       
    }
    public static void main(String[] args) {
        SinhVienDAOImpl sv = new SinhVienDAOImpl();
        System.out.println(sv.getList());
    }
}
