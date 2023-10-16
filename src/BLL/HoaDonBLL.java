/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.HoaDonDAO;
import DTO.HoaDonDTO;
import java.util.ArrayList;

/**
 *
 * @author HAO KIET
 */
public class HoaDonBLL {
    HoaDonDAO hdDAO= new HoaDonDAO();
    
    public ArrayList<HoaDonDTO> getListHoaDon(){
        return hdDAO.getListHoaDon();
    }
    public String AddNgayGiao(String id,String ngaygiao){
         if(hdDAO.AddNgayGiao(id,ngaygiao))
            return "Thêm thành công";
        else 
            return "Thêm thất bại";
    }
    public String DelHD(String id){
         if(hdDAO.DelHD(id))
            return "Xóa thành công";
        else 
            return "Xóa thất bại";
    }
    public String DelSL(String id , int soluong){
         if(hdDAO.DelSL(id,soluong))
            return "Cập Nhật thành công";
        else 
            return "Cập Nhật thất bại";
    }
}
