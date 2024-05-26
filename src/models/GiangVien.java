/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author Dat
 */
public class GiangVien {
    private String maGiangVien ;
    private String tenGV ;
    private Date ngaySinh ;
    private String queQuan ;

    public GiangVien() {
    }

    public GiangVien(String maGiangVien, String tenGV, Date ngaySinh, String queQuan) {
        this.maGiangVien = maGiangVien;
        this.tenGV = tenGV;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
    }

    public String getMaGiangVien() {
        return maGiangVien;
    }

    public void setMaGiangVien(String maGiangVien) {
        this.maGiangVien = maGiangVien;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }
    public String toString()
    {
        return maGiangVien + " " + tenGV + " " + ngaySinh + " " + queQuan;
    }
    
}
