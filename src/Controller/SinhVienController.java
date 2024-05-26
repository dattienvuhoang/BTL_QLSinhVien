/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import models.SinhVien;

/**
 *
 * @author Dat
 */
public class SinhVienController {
    private JButton btnSave ; 
    private JTextField jtfMaSV ;
    private JTextField jtfHoTen ;
    private JTextField jtfSDT ;
    private JTextField jtfMaLop ;
    private JTextArea jtfQueQuan ;
    private JDateChooser jdcNgaySinh ;
    private JRadioButton rdNam ; 
    private JRadioButton rdNu ;
    private JButton btnDel ;

    public SinhVienController(JButton btnSave, JTextField jtfMaSV, JTextField jtfHoTen, JTextField jtfSDT, JTextField jtfMaLop, JTextArea jtfQueQuan, JDateChooser jdcNgaySinh, JRadioButton rdNam, JRadioButton rdNu) {
        this.btnSave = btnSave;
        this.jtfMaSV = jtfMaSV;
        this.jtfHoTen = jtfHoTen;
        this.jtfSDT = jtfSDT;
        this.jtfMaLop = jtfMaLop;
        this.jtfQueQuan = jtfQueQuan;
        this.jdcNgaySinh = jdcNgaySinh;
        this.rdNam = rdNam;
        this.rdNu = rdNu;
    }
    public  void setView(SinhVien sinhVien)
    {
        jtfMaSV.setText(sinhVien.getMaSV());
        jtfMaSV.setEnabled(false);
        jtfHoTen.setText(sinhVien.getHoTen());
        jtfSDT.setText(sinhVien.getSoDT());
        jtfMaLop.setText(sinhVien.getMaLop());
        if (sinhVien.isGioiTinh())
        {
            rdNam.setSelected(true);
        }
        else {
            rdNu.setSelected(true);
        }
        System.out.println(sinhVien.isGioiTinh());
        jtfQueQuan.setText(sinhVien.getQueQuan());
        jdcNgaySinh.setDate(sinhVien.getNgaySinh());
    }
    
}
