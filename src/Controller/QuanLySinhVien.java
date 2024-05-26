/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Bean.DanhMuc;
import Database.DBConnect;
import Interface.AddSinhVienJFame;
import Interface.SinhVienJPanel;
import Service.SinhVienService;
import Service.SinhVienServiceImpl;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
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
import models.SinhVien;
import utlity.ClassTableModel;
import Interface.SinhVienJfFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.sql.* ;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dat
 */
public class QuanLySinhVien {
    private JPanel jpnView ;
    private JPanel jpnRoot ;
    private JButton btnAdd ; 
    private JButton btnDel;
    private JTextField jtfSearch ; 
    private String type ;
    public SinhVienServiceImpl sinhVienSer = null ;
    private String[] listColumn = {"Mã sinh viên","Họ tên","Ngày sinh","Giới tính","Số điện thoại","Quê quán","Mã lớp"};
    private TableRowSorter<TableModel> rowSorter = null ;

    public QuanLySinhVien(JPanel jpnView, JPanel jpnRoot, JButton btnAdd, JButton btnDel, JTextField jtfSearch, String type) {
        this.jpnView = jpnView;
        this.jpnRoot = jpnRoot;
        this.btnAdd = btnAdd;
        this.btnDel = btnDel;
        this.jtfSearch = jtfSearch;
        this.type = type;
    }

    
    
   public void setDataTable(){
       sinhVienSer = new SinhVienServiceImpl();
       List<SinhVien> listItem = sinhVienSer.getList();
       DefaultTableModel model = new ClassTableModel().setTableSinhVien(listItem, listColumn);
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
       
       table.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               if (e.getClickCount()==2 && table.getSelectedRow()!=-1 )
               {
                   DefaultTableModel model = (DefaultTableModel) table.getModel();
                   int index = table.getSelectedRow();
                   index = table.convertRowIndexToModel(index);
                   
                   SinhVien sinhVien = new SinhVien();
                   sinhVien.setMaSV(model.getValueAt(index, 0).toString());
                   sinhVien.setHoTen(model.getValueAt(index, 1).toString());
                   sinhVien.setNgaySinh((Date)model.getValueAt(index, 2));
                   String GT = model.getValueAt(index, 3).toString();
                   if (GT.equalsIgnoreCase("Nam"))
                   {
                      sinhVien.setGioiTinh(1);
                   }
                   else{
                      sinhVien.setGioiTinh(2);
                   }
                   sinhVien.setSoDT(model.getValueAt(index, 4).toString());
                   sinhVien.setQueQuan(model.getValueAt(index, 5).toString());
                   sinhVien.setMaLop(model.getValueAt(index, 6).toString());
                   System.out.println(sinhVien.getMaSV() + " " + sinhVien.getHoTen() + " " + GT + " " +sinhVien.getSoDT() + 
                           " " + sinhVien.getQueQuan() + " " + sinhVien.getMaLop());
                   
                   SinhVienJfFrame frame = new SinhVienJfFrame(sinhVien,type);
                   frame.setTitle("Thông tin sinh viên");
                   frame.setResizable(false);
                   frame.setLocationRelativeTo(null);
                   frame.setVisible(true);
                   frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
                   frame.addWindowListener(new WindowAdapter(){
                       @Override
                       public void windowClosed(WindowEvent e) {
                           SinhVienJPanel sv = new SinhVienJPanel(type);
                            jpnRoot.removeAll();
                            jpnRoot.setLayout(new BorderLayout());
                            jpnRoot.add(sv);
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
                           int selectedIndex = table.getSelectedRow();
                           if (selectedIndex != -1)
                           {
                              
                               DefaultTableModel model = (DefaultTableModel) table.getModel();
                                selectedIndex = table.convertRowIndexToModel(selectedIndex);
                                Connection conn = DBConnect.getConnection();
                                Statement sta = null ;
                                int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa thông tin sinh viên này vào cơ sở dữ liệu không?", "Xác nhận xóa sinh viên", JOptionPane.YES_NO_OPTION);

                                 if (result == JOptionPane.YES_OPTION) {
                                    
                                     try {
                                    sta = conn.createStatement();
                                    String MaSV = model.getValueAt(selectedIndex, 0).toString();
                                    String sql = "Delete from sinhvien where maSV = '" + MaSV+ "'";
                                    int row = sta.executeUpdate(sql);
                                    if (row > 0) {
                                        JOptionPane.showMessageDialog(jpnView, "Xóa thành công");
                                        jpnRoot.removeAll();
                                        jpnRoot.setLayout(new BorderLayout());
                                        SinhVienJPanel sv = new SinhVienJPanel(type);
                                        jpnRoot.add(sv);
                                        jpnRoot.validate();
                                        jpnRoot.repaint();
                                        sta.close();
                                        conn.close();
                                     }
                                } catch (SQLException ex) {
                                    Logger.getLogger(QuanLySinhVien.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                }
                           }
                           
                            
                           
                       }
                      
                       
                   });
       btnAdd.addMouseListener(new MouseAdapter(){
           @Override
           public void mouseClicked(MouseEvent e) {
                AddSinhVienJFame addSinhVien = new AddSinhVienJFame();
                addSinhVien.setTitle("Thêm thông tin sinh viên");
                addSinhVien.setResizable(false);
                addSinhVien.setLocationRelativeTo(null);
                addSinhVien.setVisible(true);
                addSinhVien.setDefaultCloseOperation(addSinhVien.DISPOSE_ON_CLOSE);
                addSinhVien.addWindowListener(new WindowAdapter(){
                    @Override
                    public void windowClosed(WindowEvent e) {
                        SinhVienJPanel sv = new SinhVienJPanel(type);
                        jpnRoot.removeAll();
                        jpnRoot.setLayout(new BorderLayout());
                        jpnRoot.add(sv);
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
