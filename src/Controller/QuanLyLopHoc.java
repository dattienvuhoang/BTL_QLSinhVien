/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.DBConnect;
import Interface.AddLopHocJFame;
import Interface.LopHocJFrame;
import Interface.LopHocJPanel;
import Service.LopHocServiceImpl;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
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
import models.LopHoc;
import utlity.ClassTableModel;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Dat
 */
public class QuanLyLopHoc {
    private JPanel jpnView ;
    private JPanel jpnRoot ;
    private JButton btnAdd ; 
    private JButton btnDel ;
    private JTextField jtfSearch ; 
    private String type;
    public LopHocServiceImpl lopHocServiceImpl = null ;
    private String[] listColumn = {"Mã lớp","Tên lớp","Mã giảng viên"};
    private TableRowSorter<TableModel> rowSorter = null ;

    public QuanLyLopHoc(JPanel jpnView, JPanel jpnRoot, JButton btnAdd, JButton btnDel, JTextField jtfSearch, String type) {
        this.jpnView = jpnView;
        this.jpnRoot = jpnRoot;
        this.btnAdd = btnAdd;
        this.btnDel = btnDel;
        this.jtfSearch = jtfSearch;
        this.type = type;
    }

    
   
   public void setDataTable(){
       lopHocServiceImpl = new LopHocServiceImpl();
       List<LopHoc> listItem = lopHocServiceImpl.getList();
       DefaultTableModel model = new ClassTableModel().setTableLopHoc(listItem, listColumn);
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
               if (e.getClickCount()==2&& table.getSelectedRow()!=-1)
               {
                   DefaultTableModel model = (DefaultTableModel) table.getModel();
                   int index = table.getSelectedRow();
                   index = table.convertRowIndexToModel(index);
                   
                   LopHoc lopHoc = new LopHoc();
                   lopHoc.setMaLop(model.getValueAt(index, 0).toString());
                   lopHoc.setTenLopHoc(model.getValueAt(index, 1).toString());
                   lopHoc.setMaGiangVien(model.getValueAt(index, 2).toString());
                   
                   LopHocJFrame frame = new LopHocJFrame(lopHoc,type);
                   frame.setTitle("Thông tin lớp học");
                   frame.setResizable(false);
                   frame.setLocationRelativeTo(null);
                   frame.setVisible(true);
                   frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
                   frame.addWindowListener(new WindowAdapter(){
                       @Override
                       public void windowClosed(WindowEvent e) { 
                           LopHocJPanel lopHoc = new LopHocJPanel(type);
                            jpnRoot.removeAll();
                            jpnRoot.setLayout(new BorderLayout());
                            jpnRoot.add(lopHoc);
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
                           int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa thông tin lớp học này vào cơ sở dữ liệu không?", "Xác nhận xóa lớp học", JOptionPane.YES_NO_OPTION);

                           if (result == JOptionPane.YES_OPTION) {
                                try {
                               sta = conn.createStatement();
                               String maLop = model.getValueAt(selectedIndex, 0).toString();
                               String sql = "Delete from lophoc where maLop = '" + maLop+ "'";
                               int row = sta.executeUpdate(sql);
                               if (row > 0) {
                                   JOptionPane.showMessageDialog(jpnView, "Xóa thành công");
                                   jpnRoot.removeAll();
                                   jpnRoot.setLayout(new BorderLayout());
                                   LopHocJPanel sv = new LopHocJPanel(type);
                                   jpnRoot.add(sv);
                                   jpnRoot.validate();
                                   jpnRoot.repaint();
                                }
                           } catch (SQLException ex) {    
                               ex.printStackTrace();
                           }
                           }
                       } 
                   });
       btnAdd.addMouseListener(new MouseAdapter(){
           @Override
           public void mouseClicked(MouseEvent e) {
               AddLopHocJFame addLopHocJFame = new AddLopHocJFame();
                addLopHocJFame.setTitle("Thêm thông tin lớp học");
                addLopHocJFame.setResizable(false);
                addLopHocJFame.setLocationRelativeTo(null);
                addLopHocJFame.setVisible(true);
                addLopHocJFame.setDefaultCloseOperation(addLopHocJFame.DISPOSE_ON_CLOSE);
                addLopHocJFame.addWindowListener(new WindowAdapter(){
                    @Override
                    public void windowClosed(WindowEvent e) {
                        LopHocJPanel lopHoc = new LopHocJPanel(type);
                        jpnRoot.removeAll();
                        jpnRoot.setLayout(new BorderLayout());
                        jpnRoot.add(lopHoc);
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
