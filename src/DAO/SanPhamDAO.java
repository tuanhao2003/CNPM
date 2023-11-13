/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.SanPhamDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class SanPhamDAO {
    private sqlConnect SQLCon = new sqlConnect();
    private Connection conn = SQLCon.getConnection();
//    private Connection conn;
    
    public boolean openConnection() {
        try {
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databasename=QLCH;"
                    + "user=sa;password=12345;encrypt=true;trustServerCertificate=true";
            conn = DriverManager.getConnection(connectionUrl);
            System.out.println("Connected to database successfully.");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    
//    public void closeConnection(){
//        try {
//            if(conn!=null)
//                conn.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//    
    
    public ArrayList<SanPhamDTO> getListSanphamWithDiscount() {
        ArrayList<SanPhamDTO> list = new ArrayList<SanPhamDTO>();
        String sql = "SELECT SanPham.*, ChuongTrinhKhuyenMai.MucGiamGia " +
                     "FROM SanPham " +
                     "LEFT JOIN ChuongTrinhKhuyenMai ON SanPham.Hang = ChuongTrinhKhuyenMai.LoaiSanPhamDuocApDung";
        if (openConnection()) {
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    SanPhamDTO s = new SanPhamDTO();
                    s.setMaSP(rs.getString("MaSP"));
                    s.setTenSP(rs.getString("TenSP"));
                    s.setHang(rs.getString("Hang"));
                    s.setDungLuong(rs.getString("DungLuong"));
                    s.setSoLuong(rs.getInt("SoLuong"));
                    s.setDonGia(rs.getLong("DonGia"));
                    s.setHinhAnh(rs.getString("HinhAnh"));

                    // Lấy mức giảm giá từ cột MucGiamGia trong ChuongTrinhKhuyenMai
                    long mucGiamGia = rs.getInt("MucGiamGia");

                    // Tính giá sau giảm
                    long giaGoc = s.getDonGia();
                    long giaSauGiam = giaGoc - (giaGoc * mucGiamGia / 100);

                    s.setMucGiamGia(mucGiamGia);
                    s.setGiaSauGiam(giaSauGiam);

                    list.add(s);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return list;
    }
    public ArrayList<SanPhamDTO> getListSanpham(){
        ArrayList<SanPhamDTO> list = new ArrayList<SanPhamDTO>();
        String sql = "SELECT * FROM SanPham";
        
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while(rs.next()){

                    SanPhamDTO s = new SanPhamDTO();
                    s.setMaSP(rs.getString("MaSP"));
                    s.setTenSP(rs.getString("TenSP"));
                    s.setHang(rs.getString("Hang"));
                    s.setDungLuong(rs.getString("DungLuong"));
                    s.setSoLuong(rs.getInt("SoLuong"));
                    s.setDonGia(rs.getInt("DonGia"));
                    s.setHinhAnh(rs.getString("HinhAnh"));

                    list.add(s);
                }
              } catch (Exception e) {
                    System.out.println(e);
            
            }
            
        
        return list;
    }
    
    public boolean addSP(SanPhamDTO sp){
       boolean result= false;
        
            try {
                String sql = "Insert into SanPham values(?,?,?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, sp.getMaSP());
                ps.setString(2, sp.getTenSP());
                ps.setString(3, sp.getHang());
                ps.setString(4, sp.getDungLuong());
                ps.setInt(6, sp.getSoLuong());
                ps.setLong(5, sp.getDonGia());
                ps.setString(7, sp.getHinhAnh());
                if(ps.executeUpdate()>=1)
                    result=true;
            } catch (Exception e) {
                System.out.println(e);
            }
//            finally{
//                closeConnection();
//            }
            
        
        return result;
    }
    
    public boolean DelSP(String id){
    boolean result = false;
        
            try {
                String sql = "Delete from SanPham where MaSP=?";
                PreparedStatement pc = conn.prepareCall(sql);
                pc.setString(1, id);
                if(pc.executeUpdate()>=1)
                    result = true;
            } catch (Exception e) {
//            }finally{
//                closeConnection();
            }
        
        return result;
    }
    
    public boolean UpdateDS(String MaSP, String TenSP, String Hang, String DungLuong, int SoLuong, int DonGia, String HinhAnh) {
    boolean result = false;
    
        try {
            String sql = "UPDATE SanPham SET TenSP=?, Hang=?, DungLuong=?, SoLuong=?, DonGia=?, HinhAnh=? WHERE MaSP=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, TenSP);
            ps.setString(2, Hang);
            ps.setString(3, DungLuong);
            ps.setInt(4, SoLuong);
            ps.setInt(5, DonGia);
            ps.setString(6, HinhAnh);
            ps.setString(7, MaSP);
            if (ps.executeUpdate() >= 1) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
    }
    
        return result;
    }
    
    public boolean hasSanPhamID(String id){
        boolean result=false;
        
            try {
                String sql = "Select * from SanPham where MaSP="+id;
                Statement stmt = conn.createStatement();
                ResultSet rs= stmt.executeQuery(sql);
                result = rs.next();
            } catch (Exception e) {
                System.out.println(e);
            }
        
        return result;
    }
}
