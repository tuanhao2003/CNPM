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
                resultList.add(new TaiKhoanDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (Exception e) {
            System.out.println("Loi lay danh sach tai khoan(r:24,DAO): "+e);
        }
        return resultList;
    }
    public void themTk(TaiKhoanDTO tk){
       boolean result = false;
       if(openConnection()){
           try{
               String sql = "Insert into TaiKhoan values (?,?,?,?)";
               
           }
       }
    
}
