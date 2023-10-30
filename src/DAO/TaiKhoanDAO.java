/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;

import DTO.TaiKhoanDTO;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement; 
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author toica
 */
public class TaiKhoanDAO {
    private sqlConnect sqlConn;
    int row;
   
    public TaiKhoanDAO(){
         sqlConn = new sqlConnect();
    }
    public ArrayList<TaiKhoanDTO> getListall(){
        ArrayList<TaiKhoanDTO> arr = new ArrayList<TaiKhoanDTO>();
        ResultSet rs = null;
        String query = "Select * from TaiKhoan";
        
            try{
               rs = this.sqlConn.getSta().executeQuery(query);
               
            while(rs.next()){
                arr.add(new TaiKhoanDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
            }catch(SQLException ex){
                System.out.println(ex + "line 40");
            }
        
        return arr;
    }
    public boolean addTk(TaiKhoanDTO tk) {
    try {
        // Truy vấn số lượng tài khoản hiện có trong bảng TaiKhoan
        String countQuery = "SELECT COUNT(*) AS total FROM TaiKhoan";
        ResultSet rs = this.sqlConn.getSta().executeQuery(countQuery);
        
        int total = 0;
        if (rs.next()) {
            total = rs.getInt("total");
        }
        
        // Tạo MaTK mới dựa trên số lượng tài khoản
        String maTK;
        if (total < 9) {
            maTK = "TK00" + (total + 1);
        } else if (total < 99) {
            maTK = "TK0" + (total + 1);
        } else {
            maTK = "TK" + (total + 1);
        }
        
        // Thêm tài khoản mới với MaTK đã tạo
        String query = "INSERT INTO TaiKhoan (MaTK, TenDangNhap, MatKhau, TrangThai) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = this.sqlConn.getConnection().prepareStatement(query);
        ps.setString(1, maTK);
        ps.setString(2, tk.getTenDangNhap());
        ps.setString(3, tk.getMatKhau());
        ps.setInt(4, tk.getTrangThai());
        
        int rowInserted = ps.executeUpdate();
        ps.close();
        
        return rowInserted > 0;
    } catch (Exception e) {
        System.out.println("Lỗi thêm tài khoản: " + e);
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
        public boolean delTK(String id) {
        boolean result = false;
        Connection connection = sqlConn.getConnection();
        if (connection != null) {
            try {
                String deleteTaiKhoanSQL = "DELETE FROM TaiKhoan WHERE MaTK=?";
                PreparedStatement taiKhoanStmt = connection.prepareStatement(deleteTaiKhoanSQL);
                taiKhoanStmt.setString(1, id);
                int taiKhoanDeleted = taiKhoanStmt.executeUpdate();

                if (taiKhoanDeleted >= 1) {
                    result = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

      public boolean updateTK(String username, String password, int trangthai) {
        boolean result = false;
        Connection connection = sqlConn.getConnection();
        if (connection != null) {
            try {
                String updateTaiKhoanSQL = "UPDATE TaiKhoan SET TenDangNhap=?, MatKhau=?, TrangThai=? WHERE MaTK=?";
                PreparedStatement taiKhoanStmt = connection.prepareCall(updateTaiKhoanSQL);
                taiKhoanStmt.setString(1, username);
                taiKhoanStmt.setString(2, password);
                taiKhoanStmt.setInt(3, trangthai);                

                int taiKhoanUpdated = taiKhoanStmt.executeUpdate();

                if (taiKhoanUpdated >= 1) {
                    result = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }   
//    public void searchTK(String username){
//        boolean result = false;
//        Connection connection = sqlConn.getConnection();
//        try{
//            string query = "Select * from TaiKhoan where TenDangNhap ='"+username+"'";
//            
//        }
//    }
}
