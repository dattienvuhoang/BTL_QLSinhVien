/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Dat
 */
public class LopHoc {
    private String maLop;
    private String tenLopHoc;
    private String maGiangVien;

    public LopHoc() {
    }

    public LopHoc(String maLop, String tenLopHoc, String maGiangVien) {
        this.maLop = maLop;
        this.tenLopHoc = tenLopHoc;
        this.maGiangVien = maGiangVien;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLopHoc() {
        return tenLopHoc;
    }

    public void setTenLopHoc(String tenLopHoc) {
        this.tenLopHoc = tenLopHoc;
    }

    public String getMaGiangVien() {
        return maGiangVien;
    }

    public void setMaGiangVien(String maGiangVien) {
        this.maGiangVien = maGiangVien;
    }
    public  String toString()
    {
        return maLop+" "+tenLopHoc+" "+maGiangVien;
    }
}
