/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import Interface.DangNhapJDialog;
import Interface.Form_Home;

/**
 *
 * @author Dat
 */
public class Main extends javax.swing.JFrame{
    public static void main(String[] args) {
//        Form_Home fh = new Form_Home();
//        fh.setVisible(true);
        DangNhapJDialog dangNhap = new DangNhapJDialog(null, true);
        dangNhap.setTitle("Đăng nhập vào hệ thống");
        dangNhap.setResizable(false);
        dangNhap.setLocationRelativeTo(null);
        dangNhap.setVisible(true);
                
    }
}
