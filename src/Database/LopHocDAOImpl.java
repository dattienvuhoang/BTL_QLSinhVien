/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
import java.sql.* ;
import java.util.ArrayList;
import java.util.List;
import models.LopHoc;

/**
 *
 * @author Dat
 */
public class LopHocDAOImpl implements LopHocDAO{
    @Override
    public List<LopHoc> getList() {
        Connection cons = DBConnect.getConnection();
        System.out.println(cons);
        String sql = "SELECT * FROM `lophoc`";
        List<LopHoc> list = new ArrayList<>();
        ResultSet rs = null ;
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
             rs = ps.executeQuery();
            while (rs.next()) {
               LopHoc lopHoc = new LopHoc();
               lopHoc.setMaLop(rs.getString("maLop"));
               lopHoc.setTenLopHoc(rs.getString("tenLopHoc"));
               lopHoc.setMaGiangVien(rs.getString("maGiangVien"));
               list.add(lopHoc);
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
        LopHocDAOImpl lopHoc =  new LopHocDAOImpl();
        System.out.println(lopHoc.getList());
    }
}