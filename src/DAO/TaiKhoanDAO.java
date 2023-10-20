/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TaiKhoanDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author toica
 */
public class TaiKhoanDAO {
    private sqlConnect sql;
    public TaiKhoanDAO(){
         this.sql=new sqlConnect();
    }
    public ArrayList<TaiKhoanDTO> getListall(){
        ArrayList<TaiKhoanDTO> resultList = new ArrayList<>();
        ResultSet rs = null;
        String query="select * from TaiKhoan";
        try {
            rs = this.sql.getSta().executeQuery(query);
            while(rs.next()){
                resultList.add(new TaiKhoanDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }
        } catch (Exception e) {
            System.out.println("Loi lay danh sach tai khoan(r:24,DAO): "+e);
        }
        return resultList;
    }
    public void themTk(TaiKhoanDTO tk){
        String query = "insert into TaiKhoan((MaTK, TenDangNhap, MatKhau, Quyen, TrangThai) values('"+tk.getMaTK()+"','"+tk.getTenDangNhap()+"','"+tk.getQuyen()+"','"+tk.getTrangThai()+");";
        try{
            this.sql.getSta().executeUpdate(query);  
        }catch(Exception e){
            System.out.println("Loi them tai khoan(DAO)" + e);
        }     
    }
    
}
