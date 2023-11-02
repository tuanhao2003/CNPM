/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Dao Khanh
 */
public class SanPhamNCCDTO {
    private String MaNCC;
    private String MaSP;
    private int SoLuong;
    private int DonGia;

    public SanPhamNCCDTO(String MaNCC, String MaSP, int SoLuong, int DonGia) {
        this.MaNCC = MaNCC;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
    }

    public SanPhamNCCDTO(){
        MaNCC=null;
        MaSP=null; 
        SoLuong=0;
        DonGia=0;
    }
    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }
    
    
}
