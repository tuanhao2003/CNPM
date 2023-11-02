package DTO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class khuyenMaiDTO {
    private String maKhuyenMai;
    private String tenKhuyenMai;
    private String loaiKhuyenMai;
    private int mucGiamGia;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private String maSanPham;

    public khuyenMaiDTO(String maKhuyenMai, String tenKhuyenMai, int mucGiamGia, String loaiKhuyenMai, Date ngayBatDau, Date ngayKetThuc, String maSanPham) {
        this.maKhuyenMai = maKhuyenMai;
        this.tenKhuyenMai = tenKhuyenMai;
        this.mucGiamGia = mucGiamGia;
        this.loaiKhuyenMai = loaiKhuyenMai;       
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.maSanPham = maSanPham;
    }


    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public String getLoaiKhuyenMai() {
        return loaiKhuyenMai;
    }

    public void setLoaiKhuyenMai(String loaiKhuyenMai) {
        this.loaiKhuyenMai = loaiKhuyenMai;
    }

    public int getMucGiamGia() {
        return mucGiamGia;
    }

    public void setMucGiamGia(int mucGiamGia) {
        this.mucGiamGia = mucGiamGia;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
    
    public String getmaSanPham() {
        return maSanPham;
    }

    public void setmaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

}
