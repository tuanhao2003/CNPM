package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class thongKeSanPhamDAO {
    private sqlConnect sqlConn;
    
    public thongKeSanPhamDAO() {
        sqlConn = new sqlConnect();
    }
    
    // Phương thức để lấy số lượng sản phẩm của một hãng cụ thể trong ngày hiện tại
    public int getSanPhamCountByHang(String hang) {
        int tongSoLuong = 0;
        try {
            String query = "SELECT SUM(CTH.SoLuong) AS TongSoLuong " +
                           "FROM HoaDon H " +
                           "INNER JOIN CTHoaDon CTH ON H.MaHoaDon = CTH.MaHoaDon " +
                           "INNER JOIN SanPham SP ON CTH.MaSP = SP.MaSP " +
                           "WHERE SP.Hang = ? " +
                           "AND CONVERT(DATE, H.NgayLap) = CONVERT(DATE, GETDATE())";
            Connection connection = sqlConn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, hang);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                tongSoLuong = resultSet.getInt("TongSoLuong");
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn cơ sở dữ liệu: " + e);
        }
        return tongSoLuong;
    }
    public int getSanPhamCountByHangForWeek(String hang) {
        int tongSoLuong = 0;
        try {
            // Đổi truy vấn SQL để lấy số lượng theo tuần
            String query = "SELECT SUM(CTH.SoLuong) AS TongSoLuong " +
                           "FROM HoaDon H " +
                           "INNER JOIN CTHoaDon CTH ON H.MaHoaDon = CTH.MaHoaDon " +
                           "INNER JOIN SanPham SP ON CTH.MaSP = SP.MaSP " +
                           "WHERE SP.Hang = ? " +
                           "AND YEAR(H.NgayLap) = YEAR(GETDATE()) " +
                           "AND DATEPART(WEEK, H.NgayLap) = DATEPART(WEEK, GETDATE())";
            Connection connection = sqlConn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, hang);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                tongSoLuong = resultSet.getInt("TongSoLuong");
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn cơ sở dữ liệu: " + e);
        }
        return tongSoLuong;
    }

    public int getSanPhamCountByHangForMonth(String hang) {
        int tongSoLuong = 0;
        try {
            // Đổi truy vấn SQL để lấy số lượng theo tháng
            String query = "SELECT SUM(CTH.SoLuong) AS TongSoLuong " +
                           "FROM HoaDon H " +
                           "INNER JOIN CTHoaDon CTH ON H.MaHoaDon = CTH.MaHoaDon " +
                           "INNER JOIN SanPham SP ON CTH.MaSP = SP.MaSP " +
                           "WHERE SP.Hang = ? " +
                           "AND YEAR(H.NgayLap) = YEAR(GETDATE()) " +
                           "AND DATEPART(MONTH, H.NgayLap) = DATEPART(MONTH, GETDATE())";
            Connection connection = sqlConn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, hang);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                tongSoLuong = resultSet.getInt("TongSoLuong");
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn cơ sở dữ liệu: " + e);
        }
        return tongSoLuong;
    }
    
    public List<String[]> getSalesDataForWeek() {
        List<String[]> salesData = new ArrayList<>();
        try {
            // Đoạn truy vấn bạn đã cung cấp
            String query = "WITH AllDaysOfWeek AS (" +
            "SELECT 1 AS Weekday, 'Chu nhat' AS NgayTrongTuan " +
            "UNION SELECT 2, 'Thu 2' " +
            "UNION SELECT 3, 'Thu 3' " +
            "UNION SELECT 4, 'Thu 4' " +
            "UNION SELECT 5, 'Thu 5' " +
            "UNION SELECT 6, 'Thu 6' " +
            "UNION SELECT 7, 'Thu 7' " +
            ") " +
            "SELECT " +
            "CASE " +
            "WHEN D.Weekday = DATEPART(WEEKDAY, GETDATE()) THEN 'Hôm nay' " +
            "ELSE D.NgayTrongTuan " +
            "END AS NgayTrongTuan, " +
            "ISNULL(SUM(CTH.SoLuong), 0) AS TongSoLuong " +
            "FROM " +
            "AllDaysOfWeek D " +
            "LEFT JOIN " +
            "HoaDon H ON DATEPART(WEEKDAY, H.NgayLap) = D.Weekday " +
            "LEFT JOIN " +
            "CTHoaDon CTH ON H.MaHoaDon = CTH.MaHoaDon " +
            "AND YEAR(H.NgayLap) = YEAR(GETDATE()) " +
            "AND DATEPART(WEEK, H.NgayLap) = DATEPART(WEEK, GETDATE()) " +
            "GROUP BY " +
            "CASE " +
            "WHEN D.Weekday = DATEPART(WEEKDAY, GETDATE()) THEN 'Hôm nay' " +
            "ELSE D.NgayTrongTuan " +
            "END";

            Connection connection = sqlConn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String ngayTrongTuan = resultSet.getString("NgayTrongTuan");
                int tongSoLuong = resultSet.getInt("TongSoLuong");
                salesData.add(new String[]{ngayTrongTuan, String.valueOf(tongSoLuong)});
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn cơ sở dữ liệu: " + e);
        }
        return salesData;
    }

}
