/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.HoaDonDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HAO KIET
 */
public class HoaDonDAO {
    private Connection conn;
    
    public boolean openConnection() {
        try {
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databasename=Sellphones;"
                    + "user=sa;password=123;encrypt=true;trustServerCertificate=true";
            conn = DriverManager.getConnection(connectionUrl);
            System.out.println("Connected to database successfully.");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public ArrayList<HoaDonDTO> getListHoaDon() {
        ArrayList<HoaDonDTO> list = new ArrayList<HoaDonDTO>();
        String sql = "SELECT * FROM HoaDon";
        try {
            if (conn == null) {
                openConnection();
            }
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonDTO nv = new HoaDonDTO();
                String maHD = rs.getString("MaHD");
                if (!maHD.startsWith("HD")) {
                    continue; // Chuyển sang bản ghi tiếp theo nếu MaNCC không bắt đầu bằng "NCC"
                }
                nv.setMaHD(maHD);
                nv.setMaKH(rs.getString("MaKH"));
                nv.setMaNV(rs.getString("MaNV"));
                nv.setNgayLap(rs.getString("NgayLap"));
                nv.setNgayGiao(rs.getString("NgayXuat"));
                nv.setTongTienGoc(rs.getInt("TongTienGoc"));
                nv.setTongTienSauGiam(rs.getInt("TongTienSauGiam"));
                
                list.add(nv);
            }
        } catch (Exception e) {
            System.out.println(e);
        
        }
        return list;
    } 
    public boolean AddNgayGiao(String id, String NgayGiao) {
        boolean result = false;
        if (openConnection()) {
            try {
                String sql = "UPDATE HoaDon SET NgayXuat = ? WHERE MaHoaDon = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, NgayGiao);
                ps.setString(2, id);

                if (ps.executeUpdate() >= 1) {
                    result = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            } 
//            finally {
//                closeConnection();
//            }
        }
        return result;
    }
    public boolean DelSL(String id, int soluong) {
    boolean result = false;
    if (openConnection()) {
        try {
            // Lấy số lượng hiện tại của sản phẩm với mã id
            String selectQuery = "SELECT SoLuong FROM SanPham WHERE MaSP = ?";
            PreparedStatement selectStatement = conn.prepareStatement(selectQuery);
            selectStatement.setString(1, id);
            ResultSet resultSet = selectStatement.executeQuery();

            int currentQuantity = 0;

            if (resultSet.next()) {
                currentQuantity = resultSet.getInt("SoLuong");
            }

            // Kiểm tra xem có đủ số lượng để trừ không
            if (currentQuantity >= soluong) {
                // Thực hiện phép trừ và cập nhật vào cơ sở dữ liệu
                int newQuantity = currentQuantity - soluong;
                String updateQuery = "UPDATE SanPham SET SoLuong = ? WHERE MaSP = ?";
                PreparedStatement updateStatement = conn.prepareStatement(updateQuery);
                updateStatement.setInt(1, newQuantity);
                updateStatement.setString(2, id);

                if (updateStatement.executeUpdate() >= 1) {
                    result = true;
                }
            } else {
                System.out.println("Số lượng không đủ để trừ.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    return result;
    }
    public boolean DelHD(String id){
        boolean result = false;
        if(openConnection()){
            try {
                String sql1 = "Delete from CTHoaDon where MaHoaDon=?";
                PreparedStatement pc1 = conn.prepareCall(sql1);
                pc1.setString(1, id);
                pc1.executeUpdate();
                
                String sql2 = "Delete from HoaDon where MaHoaDon=?";
                PreparedStatement pc2 = conn.prepareCall(sql2);
                pc2.setString(1, id);
                if(pc2.executeUpdate()>=1) {
                    result = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }
        return result;
    }
}
