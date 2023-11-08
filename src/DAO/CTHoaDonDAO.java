/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CTHoaDonDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HAO KIET
 */
public class CTHoaDonDAO {
    private sqlConnect SQLCon = new sqlConnect();
    private Connection conn = SQLCon.getConnection();
    
    public ArrayList<CTHoaDonDTO> getListCTHoaDon() {
        ArrayList<CTHoaDonDTO> list = new ArrayList<CTHoaDonDTO>();
        String sql = "SELECT * FROM CTHoaDon";
        try {

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CTHoaDonDTO nv = new CTHoaDonDTO();
                String maHD = rs.getString("MaHoaDon");
                if (!maHD.startsWith("HD")) {
                    continue; // Chuyển sang bản ghi tiếp theo nếu MaNCC không bắt đầu bằng "NCC"
                }
                nv.setMaHD(maHD);
                nv.setMaSP(rs.getString("MaSP"));
                nv.setTenSP(rs.getString("TenSP"));
                nv.setSoLuong(rs.getInt("SoLuong"));
                nv.setDonGia(rs.getInt("GiaTien"));
                
                list.add(nv);
            }
        } catch (Exception e) {
            System.out.println(e);
        
        }
        return list;
    }
}
