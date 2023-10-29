/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.PhanQuyenDAO;
import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Trung Hiếu
 */
public class TaiKhoanBLL {
    TaiKhoanDAO tkDao = new TaiKhoanDAO();
    PhanQuyenDAO pqDao = new PhanQuyenDAO();
    public ArrayList<TaiKhoanDTO> getListTaiKhoan(){
        return tkDao.getListall();
    }
    public String AddTK(TaiKhoanDTO t){
       if(tkDao.hasTaiKhoanID(t.getMaTK()))
           return "Mã tài khoản đã tồn tại";
       if(tkDao.addTk(t))
           return "Thêm thành công";
       return "Thêm thất bại";
    }
        public String delTK(String id){
        if(tkDao.delTK(id))
            return "Xoá thành công";
        else 
            return "Xóa thất bại";
    }
    
    public String UpTK( String id, String username, String password, int trangthai, int quyen){
       if(tkDao.updateTK(username,password,trangthai) )
            return "Cap nhat thanh cong";
        return "Cap nhat that bai";
    }
}
