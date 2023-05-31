/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

/**
 *
 * @author PC PRAKTIKUM
 */
public interface CRUD {
    public String[][] Tampil() ;
    public void Tambah(String judul, String alur, String penokohan, String akting, double nilai );
    public void Hapus(String judul);
    public void Update(String judul, String alur, String penokohan, String akting);
}
