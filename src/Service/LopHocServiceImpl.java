/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Database.LopHocDAO;
import Database.LopHocDAOImpl;
import java.util.List;
import models.LopHoc;

/**
 *
 * @author Dat
 */
public class LopHocServiceImpl {
    private LopHocDAO lopHocDAO = null ;

    public LopHocServiceImpl() {
        lopHocDAO = new LopHocDAOImpl();
    }
    public List<LopHoc> getList(){
        return lopHocDAO.getList();
    }
}
