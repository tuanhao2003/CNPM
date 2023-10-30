/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class SanPhamBLL {
    SanPhamDAO spDAO =new SanPhamDAO();
    
    public ArrayList<SanPhamDTO> getListSanPham(){
        return spDAO.getListSanpham();
    }
    
    public String addSP(SanPhamDTO d){
        if(spDAO.hasSanPhamID(d.getMaSP()))
            return "Mã đã tồn tại";
        if(spDAO.addSP(d))
            return "Thêm thành công";
        return "Thêm thất bại";
    }
    
    public String delSP(String id){
        if(spDAO.DelSP(id))
            return "Xoá thành công";
        else 
            return "Xóa thất bại";
    }
    
    public String UpSP(String MaSP, String TenSP, String Hang, String DungLuong, int SoLuong, int DonGia, String HinhAnh) {
    if (spDAO.UpdateDS(MaSP, TenSP, Hang, DungLuong, SoLuong, DonGia, HinhAnh)) {
        return "Cập nhật thành công";
    } else {
        return "Cập nhật thất bại";
    }
}

}
