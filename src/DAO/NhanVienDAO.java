/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhanVienDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author HAO KIET
 */
public class NhanVienDAO {
    private Connection conn;
    
    public boolean openConnection() {
        try {
            String connectionUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=QLCH;"
                    + "user=sa;password=123;encrypt=true;trustServerCertificate=true";
            conn = DriverManager.getConnection(connectionUrl);
            System.out.println("Connected to database successfully.");
            return true;
        } catch (Exception e) {
            System.out.println("Ket noi that bai :"+e);
            return false;
        }
    }
    public ArrayList<NhanVienDTO> getListNhanVien() {
        ArrayList<NhanVienDTO> list = new ArrayList<NhanVienDTO>();
        String sql = "SELECT * FROM NhanVien";
        try {
            if (conn == null) {
                openConnection();
            }
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienDTO nv = new NhanVienDTO();
                String maNV = rs.getString("MaNV");
                if (!maNV.startsWith("NV")) {
                    continue; // Chuyển sang bản ghi tiếp theo nếu MaNCC không bắt đầu bằng "NV"
                }
                nv.setMaNV(rs.getString("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setDiaChi(rs.getString("DiaChiNV"));
                nv.setSDT(rs.getString("SDTNV"));
                
                list.add(nv);
            }
        } catch (Exception e) {
            System.out.println(e);
        
        }
        return list;
    } 
    public boolean hasNhanVienID(String id){
        boolean result=false;
        if(openConnection()){
            try {
                String sql = "Select * from NhanVien where MaNV="+id;
                Statement stmt = conn.createStatement();
                ResultSet rs= stmt.executeQuery(sql);
                result = rs.next();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
    public boolean addNV(NhanVienDTO emp){
        boolean result= false;
        if(openConnection()){
            try {
                String sql = "Insert into NhanVien values(?,?,?,?,?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, emp.getMaNV());
                stmt.setString(2, emp.getTenNV());
                stmt.setString(3, emp.getGioiTinh());
                stmt.setString(4, emp.getDiaChi());
                stmt.setString(5, emp.getSDT());
                if(stmt.executeUpdate()>=1)
                    result=true;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }
    public boolean delNV(String id){
        boolean result = false;
        if(openConnection()){
            try {
                String sql = "Delete from NhanVien where MaNV=?";
                PreparedStatement stmt = conn.prepareCall(sql);
                stmt.setString(1, id);
                if(stmt.executeUpdate()>=1)
                    result = true;
            } catch (Exception e) {
            }
        }
        return result;
    }
    public boolean UpNV(String id,String name,String sdt,String gioiTinh,String diachi){
        boolean result =false;
        if(openConnection()){
            try {
                String sql = "Update NhanVien set TenNV=?, GioiTinh=?, DiaChi=?, SDT=?  where MaNV=?";
                PreparedStatement stmt = conn.prepareCall(sql);
                stmt.setString(1, name);
                stmt.setString(4, sdt);
                stmt.setString(2, gioiTinh);
                stmt.setString(3, diachi);
                stmt.setString(5, id);
                if(stmt.executeUpdate()>=1)
                    result=true;
            } catch (Exception e) {
            }
        }
        return result;
    }
     
}
