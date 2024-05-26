/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.DBConnect;
import Interface.AddGiangVienJFame;
import Interface.GiangVienJFrame;
import Interface.GiangVienJPanel;
import Interface.SinhVienJPanel;
import Service.GiangVienServiceImpl;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import models.GiangVien;
import utlity.ClassTableModel;

/**
 *
 * @author Dat
 */
public class QuanLyGiangVien {
    private JPanel jpnView ;
    private JPanel jpnRoot ;
    private JButton btnSave ; 
    private JButton btnDel ;
    private JTextField jtfSearch ; 
    private String type ;
    public GiangVienServiceImpl giangVienServiceImpl = null ;
    private String[] listColumn = {"Mã giảng viên","Tên giảng viên","Ngày sinh","Quê quán"};
    private TableRowSorter<TableModel> rowSorter = null ;

    public QuanLyGiangVien(JPanel jpnView, JPanel jpnRoot, JButton btnSave, JButton btnDel, JTextField jtfSearch, String type) {
        this.jpnView = jpnView;
        this.jpnRoot = jpnRoot;
        this.btnSave = btnSave;
        this.btnDel = btnDel;
        this.jtfSearch = jtfSearch;
        this.type = type;
    }

    
    
   public void setDataTable(){
       giangVienServiceImpl = new GiangVienServiceImpl();
       List<GiangVien> listItem = giangVienServiceImpl.getList();
       DefaultTableModel model = new ClassTableModel().setTableGiangVien(listItem, listColumn);
       JTable table = new JTable(model);
       
       rowSorter = new TableRowSorter<>(table.getModel());
       table.setRowSorter(rowSorter);
       
       jtfSearch.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
       });
       table.addMouseListener(new MouseAdapter(){
           @Override
           public void mouseClicked(MouseEvent e) {
               if (e.getClickCount()==2&&table.getSelectedRow()!=-1)
               {
                   DefaultTableModel model = (DefaultTableModel) table.getModel();
                   int index = table.getSelectedRow();
                   index = table.convertRowIndexToModel(index);
                   
                   GiangVien giangVien = new GiangVien();
                   giangVien.setMaGiangVien(model.getValueAt(index, 0).toString());
                   giangVien.setTenGV(model.getValueAt(index, 1).toString());
                   giangVien.setNgaySinh((Date) model.getValueAt(index, 2));
                   giangVien.setQueQuan(model.getValueAt(index, 3).toString());
                   
                   GiangVienJFrame frame = new GiangVienJFrame(giangVien, type);
                   frame.setTitle("Thông tin giảng viên");
                   frame.setResizable(false);
                   frame.setLocationRelativeTo(null);
                   frame.setVisible(true);
                   frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
                   frame.addWindowListener(new WindowAdapter(){
                       @Override
                       public void windowClosed(WindowEvent e) {
                           GiangVienJPanel gv = new GiangVienJPanel(type);
                            jpnRoot.removeAll();
                            jpnRoot.setLayout(new BorderLayout());
                            jpnRoot.add(gv);
                            jpnRoot.validate();
                            jpnRoot.repaint();
                       }
                   });
               }
               
           }
       });
       btnDel.addMouseListener(new MouseAdapter(){
                       @Override
                       public void mouseClicked(MouseEvent e) {
                           DefaultTableModel model = (DefaultTableModel) table.getModel();
                           int selectedIndex = table.getSelectedRow();
                           selectedIndex = table.convertRowIndexToModel(selectedIndex);
                           Connection conn = DBConnect.getConnection();
                           Statement sta = null ;
                           int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa thông tin giảng viên này vào cơ sở dữ liệu không?", "Xác nhận xóa giảng viên", JOptionPane.YES_NO_OPTION);

                            if (result == JOptionPane.YES_OPTION) {
                                try {
                                    sta = conn.createStatement();
                                    String maGV = model.getValueAt(selectedIndex, 0).toString() ;
                                    String sql  = "Delete from giangvien where maGiangVien = '" + maGV+ "'";
                                    int row = sta.executeUpdate(sql);
                                    if (row > 0) {
                                        JOptionPane.showMessageDialog(jpnView, "Xóa thành công");
                                        jpnRoot.removeAll();
                                        jpnRoot.setLayout(new BorderLayout());
                                        GiangVienJPanel gv = new GiangVienJPanel(type);
                                        jpnRoot.add(gv);
                                        jpnRoot.validate();
                                        jpnRoot.repaint();
                                     }
                                } catch (SQLException ex) {
                                    Logger.getLogger(QuanLyGiangVien.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } 
                           
                       }
                       
                   });
       btnSave.addMouseListener(new MouseAdapter(){
           @Override
           public void mouseClicked(MouseEvent e) {
                AddGiangVienJFame add = new AddGiangVienJFame();
                add.setTitle("Thêm thông tin giảng viên");
                add.setResizable(false);
                add.setLocationRelativeTo(null);
                add.setVisible(true);
                add.setDefaultCloseOperation(add.DISPOSE_ON_CLOSE);
                add.addWindowListener(new WindowAdapter(){
                    @Override
                    public void windowClosed(WindowEvent e) {
                        GiangVienJPanel gv = new GiangVienJPanel(type);
                        jpnRoot.removeAll();
                        jpnRoot.setLayout(new BorderLayout());
                        jpnRoot.add(gv);
                        jpnRoot.validate();
                        jpnRoot.repaint();
                    }
                    
                });
           }
           
       });
       table.getTableHeader().setFont(new Font("Time New Roman", Font.BOLD,14));
       table.getTableHeader().setPreferredSize(new Dimension(100,50));
       table.setRowHeight(50);
       table.validate();
       table.repaint();
       
       JScrollPane scrollPane = new JScrollPane();
       scrollPane.getViewport().add(table);
       scrollPane.setPreferredSize(new Dimension(1300,400));
       jpnView.removeAll();
       jpnView.setLayout(new BorderLayout());
       jpnView.add(scrollPane);
       jpnView.validate();
       jpnView.repaint();
   } 
}
