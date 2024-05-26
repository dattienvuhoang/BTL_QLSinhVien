/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.swing.JButton;
import javax.swing.JTextField;
import models.LopHoc;

/**
 *
 * @author Dat
 */
public class LopHocController {
    private JTextField jtfMaLop ; 
    private JTextField jtfTenLop ; 
    private JTextField jtfMaGV ;
    private JButton btnSave ;
    private JButton btnCancel ;

    public LopHocController(JTextField jtfMaLop, JTextField jtfTenLop, JTextField jtfMaGV, JButton btnSave, JButton btnCancel) {
        this.jtfMaLop = jtfMaLop;
        this.jtfTenLop = jtfTenLop;
        this.jtfMaGV = jtfMaGV;
        this.btnSave = btnSave;
        this.btnCancel = btnCancel;
    }
    public void setView(LopHoc lopHoc)
    {
        jtfMaLop.setText(lopHoc.getMaLop());
        jtfMaLop.setEnabled(false);
        jtfTenLop.setText(lopHoc.getTenLopHoc());
        jtfMaGV.setText(lopHoc.getMaGiangVien());
    }
}
