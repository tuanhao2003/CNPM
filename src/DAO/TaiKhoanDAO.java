/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.PhanQuyenDTO;
import java.sql.Connection;

import DTO.TaiKhoanDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement; 
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

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
                String sql = "Delete from TaiKhoan where MaTK=?"
                        + "Delete from Quyen where MaTK = ?";
                PreparedStatement stmt = connection.prepareCall(sql);
                stmt.setString(1, id);
                stmt.setString(2,id);
                if(stmt.executeUpdate()>=1)
                    result = true;
            } catch (Exception e) {
                 e.printStackTrace();
                System.out.println("xóa thất bại DAO.TaiKhoanDAO.delTK()");
            }
        }
        return result;
    }
    public boolean UpTK(TaiKhoanDTO t, PhanQuyenDTO p){
        boolean result =false;
        Connection connection = sqlConn.getConnection();
        if(connection != null){
            try {
                String sql = "Update TaiKhoan set TenDangNhap=?, MatKhau=?, TrangThai=? where MaTK=?"
                        + "Update Quyen set PhanQuyen =? where MaTK=?";
                PreparedStatement stmt = connection.prepareCall(sql);                
                stmt.setString(1, t.getTenDangNhap());
                stmt.setString(2, t.getMatKhau());
                stmt.setInt(3, t.getTrangThai());
                stmt.setString(4, t.getMaTK());
                stmt.setString(5, String.valueOf(p.getQuyen()));
                stmt.setString(6, t.getMaTK());
                if(stmt.executeUpdate()>=1)
                    result=true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }   
    
}
