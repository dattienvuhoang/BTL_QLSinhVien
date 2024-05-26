/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Bean.DanhMuc;
import Interface.GiangVienJPanel;
import Interface.LopHocJPanel;
import Interface.TrangChuJPanel;
import Interface.SinhVienJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.w3c.dom.events.MouseEvent;

/**
 *
 * @author Dat
 */
public class ChuyenManHinhController {
    private final JPanel root ;
    private String kindSelected = "";
    private List<DanhMuc> listItem = null ;
    private String type ;
    public ChuyenManHinhController(JPanel root, String type) {
        this.root = root;
        this.type = type;
    }
    public void setView(JPanel jpnItem, JLabel jlbItem)
    {
        kindSelected = "Trang Chủ";
        jpnItem.setBackground(new Color(96,100,191));
        jlbItem.setBackground(new Color(96,100,191));
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuJPanel()); 
        root.validate();
        root.repaint();
    }
    public void setEvent(List<DanhMuc> listItem)
    {
        this.listItem = listItem;
        
        for (DanhMuc item : listItem)
        {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(),item.getJpn(),item.getJlb()));
        }
    }
    class LabelEvent implements MouseListener{
        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            switch(kind)
            {
                case "TrangChu":
                    node = new TrangChuJPanel();
                    break;
                case "SinhVien":
                    node = new SinhVienJPanel(type);
                    break;
                case "LopHoc":
                    node = new LopHocJPanel(type);
                    break;
                case "GiangVien":
                    node = new GiangVienJPanel(type);
                    break;
                default:
                    node = new TrangChuJPanel();
                    break;
                
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            kindSelected = kind; 
            jlbItem.setBackground(new Color(96,100,191));
            jpnItem.setBackground(new Color(96,100,191));
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            jlbItem.setBackground(new Color(96,100,191));
            jpnItem.setBackground(new Color(96,100,191));   
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind))
            {
                jpnItem.setBackground(new Color(38,123,229));
                jlbItem.setBackground(new Color(38,123,229));
            }
        }
        
    }
    private void setChangeBackground(String kind){
        for (DanhMuc item : listItem)
        {
            if (item.getKind().equalsIgnoreCase(kind))
            {
                item.getJpn().setBackground(new Color(96,100,191));
                item.getJlb().setBackground(new Color(96,100,191));
            }
            else{
                item.getJpn().setBackground(new Color(38,123,229));
                item.getJpn().setBackground(new Color(38,123,229));

            }
        }
    }
}

