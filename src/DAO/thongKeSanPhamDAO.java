package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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


}
