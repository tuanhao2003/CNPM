/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhaCungCapDTO;
import DTO.NhanVienDTO;
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
public class NhaCungCapDAO {
    private Connection conn;
    
    public boolean openConnection() {
        try {
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databasename=QLCH;"
                    + "user=sa;password=123456;encrypt=true;trustServerCertificate=true";
            conn = DriverManager.getConnection(connectionUrl);
            System.out.println("Connected to database successfully.");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public ArrayList<NhaCungCapDTO> getListNCC()
    {
        ArrayList<NhaCungCapDTO> list = new ArrayList<NhaCungCapDTO>();
        String sql = "SELECT * FROM NhaCungCap";
        try {
            if (conn == null) {
                openConnection();
            }
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhaCungCapDTO ncc = new NhaCungCapDTO();
                String maNCC = rs.getString("MaNCC");
                if (!maNCC.startsWith("NCC")) {
                    continue;
                }
                ncc.setMaNCC(rs.getString("MaNCC"));
                ncc.setTenNCC(rs.getString("TenNCC"));
                ncc.setSDTNCC(rs.getString("SDTNCC"));
                ncc.setDiaChiNCC(rs.getString("DiaChiNCC"));
//                ncc.setLoaiHang(rs.getString("loaiHang"));      
                list.add(ncc);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public boolean addNCC(NhaCungCapDTO emp){
        boolean result= false;
        if(openConnection()){
            try {
                String sql = "Insert into NhaCungCap values(?,?,?,?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, emp.getMaNCC());
                stmt.setString(2, emp.getTenNCC());
                stmt.setString(3, emp.getSDTNCC());
                stmt.setString(4, emp.getDiaChiNCC());
//                stmt.setString(4, emp.getLoaiHang());
                if(stmt.executeUpdate()>=1)
                    result=true;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
    
    public boolean delNCC(String id){
        boolean result = false;
        if(openConnection()){
            try {
                String sql = "Delete from NhaCungCap where MaNCC=?";
                PreparedStatement stmt = conn.prepareCall(sql);
                stmt.setString(1, id);
                if(stmt.executeUpdate()>=1)
                    result = true;
            } catch (Exception e) {
            }
        }
        return result;
    }
    
    public boolean UpNCC(String id, String name, String sdt, String diachi){
        boolean result =false;
        if(openConnection()){
            try {
                String sql = "Update NhaCungCap set TenNCC=?, SDTNCC=?,  DiaChiNCC  where MaNCC=?";
                PreparedStatement stmt = conn.prepareCall(sql);
                stmt.setString(1, name);
                stmt.setString(2, sdt);
                stmt.setString(3, diachi);
                stmt.setString(5, id);
                if(stmt.executeUpdate()>=1)
                    result=true;
            } catch (Exception e) {
            }
        }
        return result;
    }
    
    public boolean hasNhaCungCapID(String id){
        boolean result=false;
        if(openConnection()){
            try {
                String sql = "Select * from NhaCungCap where MaNCC="+id;
                Statement stmt = conn.createStatement();
                ResultSet rs= stmt.executeQuery(sql);
                result = rs.next();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
    
    
}


