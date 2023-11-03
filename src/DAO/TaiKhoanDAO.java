/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;

import DTO.TaiKhoanDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement; 
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author toica
 */
public class TaiKhoanDAO {
    private sqlConnect sqlConn;
    int row;
    public TaiKhoanDAO(){
         this.sqlConn = new sqlConnect();
    }
    public ArrayList<TaiKhoanDTO> getListall(){
        ArrayList<TaiKhoanDTO> resultList = new ArrayList<>();
        ResultSet rs = null;
        String query="select * from TaiKhoan";
        try {
            rs = this.sqlConn.getSta().executeQuery(query);
            while(rs.next()){
                resultList.add(new TaiKhoanDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (Exception e) {
            System.out.println("Loi lay danh sach tai khoan(r:24,DAO): "+e);
        }
        row = resultList.size();
        return resultList;
    }
    public boolean addTk(TaiKhoanDTO tk){
       try{
            String query = "INSERT INTO TaiKhoan (MaTK, TenDangNhap, MatKhau, TrangThai) VALUES (?, ?, ?, ?)";
            Connection connection = sqlConn.getConnection();

            if(connection != null){                               
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1,tk.getMaTK());
                ps.setString(2,tk.getTenDangNhap());
                ps.setString(3,tk.getMatKhau());
                ps.setInt(4,tk.getTrangThai());                
                int rowInserted = ps.executeUpdate();
                ps.close();
                connection.commit();    
                return rowInserted> 0;
            }else{
                System.out.println("Không thể kết nối cơ sở dữ liệu");
                return false;                
            }
       }catch(SQLException e){
           System.out.println("Lỗi truy vấn cơ sở dữ liệu" + e);
           return false;
       }              
     }
    public boolean hasTaiKhoanID(String id){
        boolean result=false;
        Connection connection = sqlConn.getConnection();
        if(connection != null){
            try {
                String sql = "Select * from TaiKhoan where MaTK="+id;
                Statement stmt = connection.createStatement();
                ResultSet rs= stmt.executeQuery(sql);
                result = rs.next();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
    public boolean delTK(String id){
        boolean result = false;
        Connection connection = sqlConn.getConnection();
        if(connection != null){
            try {
                String sql = "Delete from TaiKhoan where MaTK=?";
                PreparedStatement stmt = connection.prepareCall(sql);
                stmt.setString(1, id);
                if(stmt.executeUpdate()>=1)
                    result = true;
            } catch (Exception e) {
            }
        }
        return result;
    }
    public boolean UpTK( String username, String password, int trangthai){
        boolean result =false;
        Connection connection = sqlConn.getConnection();
        if(connection != null){
            try {
                String sql = "Update TaiKhoan set TenDangNhap=?, MatKhau=?, TrangThai=? where MaTK=?";
                PreparedStatement stmt = connection.prepareCall(sql);                
                stmt.setString(1, username);
                stmt.setString(2, password);
                stmt.setInt(3, trangthai);
                
                if(stmt.executeUpdate()>=1)
                    result=true;
            } catch (Exception e) {
            }
        }
        return result;
    }   
    
}
