/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dat
 */
public class DBConnect {
    public static  Connection getConnection() 
    {
        try{
                Connection conn = null;
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien","root","");
                return conn;
        } catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
}
