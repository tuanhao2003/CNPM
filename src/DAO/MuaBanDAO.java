/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.SanPhamDTO;
import DAO.SanPhamDAO;
import DAO.khuyenMaiDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author PC
 */
public class MuaBanDAO {
    private Connection conn;
    
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

    
    
}
