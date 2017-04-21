/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


/**
 *
 * @author Arrival
 */
public class koneksiDB {
    public static Connection setKoneksi() {
        String konString = "jdbc:mysql://localhost:3306/UAS";
        Connection koneksi = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(konString,"root","");
        } catch (ClassNotFoundException ex) {
            
            System.out.println("Koneksi Gagal");
        } catch (SQLException ex) {
           
        }
        return koneksi;
    }
    
    public static int execute(String SQL) {
        int status = 0;
        Connection koneksi = setKoneksi();
        try {
            Statement st = koneksi.createStatement();
            status = st.executeUpdate(SQL);
        } catch (SQLException ex) {
            
        }
        return status;
    }
    
    public static ResultSet executeQuery(String SQL) {
        ResultSet rs = null;
        Connection koneksi = setKoneksi();
        try {
            Statement st = koneksi.createStatement();
            rs = st.executeQuery(SQL);
        } catch (SQLException ex) {
            
        }
        return rs;
    }
  
    }
    
