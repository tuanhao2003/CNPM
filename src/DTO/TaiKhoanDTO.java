/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author toica
 */
public class TaiKhoanDTO {
    private String MaTK;
    private String TenDangNhap;
    private String MatKhau;
    private int Quyen;
    private int TrangThai;
    public TaiKhoanDTO(String MaTK, String TenDangNhap, String MatKhau, int Quyen, int TrangThai){
        this.MaTK = MaTK;
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.TrangThai = TrangThai;
    }

    public TaiKhoanDTO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getMaTK() {
        return MaTK;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public int getQuyen() {
        return Quyen;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setMaTK(String MaTK) {
        this.MaTK = MaTK;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public void setQuyen(int Quyen) {
        this.Quyen = Quyen;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}