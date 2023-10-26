/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;

/**
 *
 * @author Trung Hiếu
 */
public class TaiKhoanBLL {
    TaiKhoanDAO tkDao = new TaiKhoanDAO();
    
    public ArrayList<TaiKhoanDTO> getListTaiKhoan(){
        return tkDao.getListall();
    }
    public String AddTaiKhoan(String MaTK, String TenDangNhap, String MatKhau, int TrangThai){
        if(tkDao.themTk(MaTK, TenDangNhap, MatKhau, TrangThai))
            return "Thêm thành công";
        else 
            return "Thêm thất bại";
    }
}
