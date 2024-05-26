/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Database.SinhVienDAO;
import Database.SinhVienDAOImpl;
import Service.SinhVienService;
import java.util.List;
import models.SinhVien;

/**
 *
 * @author Dat
 */
public class SinhVienServiceImpl implements SinhVienService{
    private SinhVienDAO sinhVienDao = null ;

    public SinhVienServiceImpl() {
        sinhVienDao = new SinhVienDAOImpl();
    }
    public List<SinhVien> getList(){
    return sinhVienDao.getList();
}
    public static void main(String[] args) {
        SinhVienServiceImpl lopHoc = new SinhVienServiceImpl();
        System.out.println(lopHoc.getList());
    }
}
