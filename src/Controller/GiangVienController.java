/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import models.GiangVien;

/**
 *
 * @author Dat
 */
public class GiangVienController {
    private JTextField jtfMaGV ; 
    private JTextField jtfHoTen ;
    private JTextArea jtfQueQuan ; 
    private JDateChooser jdcNgaySinh ; 

    public GiangVienController(JTextField jtfMaGV, JTextField jtfHoTen, JTextArea jtfQueQuan, JDateChooser jdcNgaySinh) {
        this.jtfMaGV = jtfMaGV;
        this.jtfHoTen = jtfHoTen;
        this.jtfQueQuan = jtfQueQuan;
        this.jdcNgaySinh = jdcNgaySinh;
    }
    public void setView(GiangVien giangVien)
    {
        jtfMaGV.setText(giangVien.getMaGiangVien());
        jtfMaGV.setEnabled(false);
        jtfHoTen.setText(giangVien.getTenGV());
        jtfQueQuan.setText(giangVien.getQueQuan());
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        jdcNgaySinh.setDate(giangVien.getNgaySinh());
                
    }
}
