/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.SanPhamNCCDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Dao Khanh
 */
public class SanPhamNCCDAO {
    private Connection conn;
    
    public boolean openConnection() {
        try {
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databasename=QLCH;"
                    + "user=sa;password=123;encrypt=true;trustServerCertificate=true";
            conn = DriverManager.getConnection(connectionUrl);
            System.out.println("Connected to database successfully.");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public ArrayList<SanPhamNCCDTO> getListSPNCC()
    {
        ArrayList<SanPhamNCCDTO> list = new ArrayList<SanPhamNCCDTO>();
        String sql = "SELECT * FROM SanPhamNCC";
        try {
            if (conn == null) {
                openConnection();
            }
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamNCCDTO spncc = new SanPhamNCCDTO();
                String maNCC = rs.getString("MaNCC");
                if (!maNCC.startsWith("NCC")) {
                    continue;
                }
                spncc.setMaNCC(rs.getString("MaNCC"));
                spncc.setMaSP(rs.getString("MaSP"));
                spncc.setSoLuong(rs.getInt("SoLuong"));
                spncc.setDonGia(rs.getInt("DonGia"));
//                ncc.setLoaiHang(rs.getString("loaiHang"));      
                list.add(spncc);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public boolean addSPNCC(SanPhamNCCDTO emp){
        boolean result= false;
        if(openConnection()){
            try {
                String sql = "Insert into Nha Cung cap values(?,?,?,?,?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, emp.getMaNCC());
                stmt.setString(2, emp.getMaSP());
                stmt.setInt(3, emp.getSoLuong());
                stmt.setInt(4, emp.getDonGia());
//                stmt.setString(4, emp.getLoaiHang());
                if(stmt.executeUpdate()>=1)
                    result=true;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
    
    public boolean hasSanPhamNCC(String id){
        boolean result = false;
        if(openConnection()){
            try {
                String sql = "Select * from SanPhamNCC where MaNCC=" +id;
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                result = rs.next();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
}
