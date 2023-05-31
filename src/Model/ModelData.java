/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author PC PRAKTIKUM
 */
public class ModelData extends Connector implements CRUD {

    @Override
    public String[][] Tampil() {
        String data[][] = new String[99][5];
        
        try {
            int total = 0 ;
            String query = "SELECT * FROM movie " ;
            stt = con.createStatement();
            ResultSet rs = stt.executeQuery(query) ;
            
            while(rs.next()){
                data[total][0] = rs.getString("judul") ;
                data[total][1] = rs.getString("alur") ;
                data[total][2] = rs.getString("penokohan") ;
                data[total][3] = rs.getString("akting") ;
                data[total][4] = rs.getString("nilai") ;
                total++ ;
            }
            
            stt.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error !" + e.getMessage());
        }finally{
            return data;
        }
    }
    
    @Override
    public void Tambah(String judul, String alur, String penokohan, String akting, double nilai ){
        try {
            String query="INSERT INTO movie VALUES ('"+judul+"','"+alur+"','"+penokohan+"','"+akting+"', '"+nilai+"')";
            stt=con.createStatement();
            stt.executeUpdate(query);
            stt.close();
            JOptionPane.showMessageDialog(null, "Tambah Data Berhasil!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error !"+e.getMessage());
        }
    }
    
    @Override
    public void Hapus(String judul) {
        try {
            String query = "DELETE FROM `movie` WHERE judul = '"+judul+"'";
            stt=con.createStatement();
            stt.executeUpdate(query);
            stt.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error !"+e.getMessage());
        }
    }
    
    @Override
    public void Update(String judul, String alur, String penokohan, String akting) {
        try {
            String query = "UPDATE `movie` SET alur = '"+alur+"', penokohan = '"+penokohan+"', akting = '"+akting+"'  WHERE judul = '"+judul+"' " ;
            stt=con.createStatement();
            stt.executeUpdate(query);
            stt.close();
            JOptionPane.showMessageDialog(null, "Ubah Data Berhasil!");
        }catch (Exception e) {
            System.out.println("UPDATE GAGAL " + e.getMessage());
        }
    }
}
