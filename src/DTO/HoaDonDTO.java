/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author HAO KIET
 */
public class HoaDonDTO {
    private String MaHD;
    private String MaKH;
    private String MaNV;
    private String NgayLap;
    private String NgayGiao;
    private int TongTien;
    
    public HoaDonDTO(){
        MaHD=null;
        MaKH=null;
        MaNV=null;
        NgayLap=null;
        NgayGiao=null;
        TongTien=0;
    }

    public HoaDonDTO(String MaHD, String MaKH, String MaNV, String NgayLap, String NgayGiao, int TongTien) {
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        this.MaNV = MaNV;
        this.NgayLap = NgayLap;
        this.NgayGiao = NgayGiao;
        this.TongTien = TongTien;
    }

    public String getMaHD() {
        return MaHD;
    }

    public String getMaKH() {
        return MaKH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public String getNgayGiao() {
        return NgayGiao;
    }

    public String getNgayLap() {
        return NgayLap;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setNgayGiao(String NgayGiao) {
        this.NgayGiao = NgayGiao;
    }

    public void setNgayLap(String NgayLap) {
        this.NgayLap = NgayLap;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }
    
    
}
