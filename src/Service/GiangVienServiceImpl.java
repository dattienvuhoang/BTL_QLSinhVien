/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Database.GiangVienDAO;
import Database.GiangVienDAOImpl;
import java.util.List;
import models.GiangVien;

/**
 *
 * @author Dat
 */
public class GiangVienServiceImpl {
    private GiangVienDAO giangVienDAO = null ;

    public GiangVienServiceImpl() {
        giangVienDAO = new GiangVienDAOImpl();
    }
    public List<GiangVien> getList(){
        return giangVienDAO.getList();
    }
    public static void main(String[] args) {
        GiangVienServiceImpl lopHoc = new GiangVienServiceImpl();
        System.out.println(lopHoc.getList());
    }
}
