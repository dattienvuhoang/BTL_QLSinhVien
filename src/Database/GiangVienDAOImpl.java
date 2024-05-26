/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.util.List;
import models.GiangVien;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Dat
 */
public class GiangVienDAOImpl implements GiangVienDAO{
    @Override
    public List<GiangVien> getList() {
        Connection cons = DBConnect.getConnection();
        System.out.println(cons);
        String sql = "SELECT * FROM `giangvien`";
        List<GiangVien> list = new ArrayList<>();
        ResultSet rs = null ;
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
             rs = ps.executeQuery();
            while (rs.next()) {
               GiangVien giangVien = new GiangVien();
               giangVien.setMaGiangVien(rs.getString("maGiangVien"));
               giangVien.setTenGV(rs.getString("tenGV"));
               giangVien.setNgaySinh(rs.getDate("ngaySinh"));
               giangVien.setQueQuan(rs.getString("queQuan"));
               list.add(giangVien);
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
        GiangVienDAOImpl lopHoc =  new GiangVienDAOImpl();
        System.out.println(lopHoc.getList());
    }
}