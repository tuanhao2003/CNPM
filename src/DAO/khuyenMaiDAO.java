package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import GUI.khuyenMaiGUI;
import DTO.khuyenMaiDTO;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement; 

public class khuyenMaiDAO {
    private sqlConnect sqlConn;

    public khuyenMaiDAO() {
        sqlConn = new sqlConnect();
    }

    public void loadKhuyenMaiData(JTable jTable1) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Xóa hết dữ liệu trong jTable1

        try {
            String query = "SELECT MaCTKM, TenCTKM, MucGiamGia, LoaiSanPhamDuocApDung, ThoiGianBatDau, ThoiGianKetThuc, ThoiGianTaoKM, MaSP FROM ChuongTrinhKhuyenMai"; // Thay thế bằng tên bảng thực tế
            ResultSet resultSet = sqlConn.getSta().executeQuery(query);

            while (resultSet.next()) {
                String maCTKM = resultSet.getString("MaCTKM");
                String tenCTKM = resultSet.getString("TenCTKM");
                int mucGiamGia = resultSet.getInt("MucGiamGia");
                String loaiKhuyenMai = resultSet.getString("LoaiSanPhamDuocApDung");
                String ngayBatDau = resultSet.getString("ThoiGianBatDau");
                String ngayKetThuc = resultSet.getString("ThoiGianKetThuc");
                String thoiGianTao = resultSet.getString("ThoiGianTaoKM");
                String maSanPham = resultSet.getString("MaSP");
                // Thêm dữ liệu vào model của jTable1
                model.addRow(new Object[]{maCTKM, tenCTKM, mucGiamGia, loaiKhuyenMai, ngayBatDau, ngayKetThuc, thoiGianTao, maSanPham});
            }

            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn cơ sở dữ liệu: " + e);
        }
    }

    public void searchKhuyenMai(JTable jTable1, String keyword) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Xóa hết dữ liệu trong jTable1

        try {
            String query;
            if (keyword == null || keyword.isEmpty()) {
                // Nếu từ khóa là null hoặc trống, hiển thị toàn bộ dữ liệu
                query = "SELECT * FROM ChuongTrinhKhuyenMai"; // Lấy tất cả các cột
            } else {
                // Ngược lại, thực hiện tìm kiếm theo từ khóa
                query = "SELECT * FROM ChuongTrinhKhuyenMai WHERE MaCTKM LIKE ? OR TenCTKM LIKE ?";
            }
            Connection connection = sqlConn.getConnection(); // Lấy kết nối

            if (connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                if (!keyword.isEmpty()) {
                    preparedStatement.setString(1, "%" + keyword + "%"); // Tìm kiếm theo mã
                    preparedStatement.setString(2, "%" + keyword + "%"); // Tìm kiếm theo tên
                }
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String maCTKM = resultSet.getString("MaCTKM");
                    String tenCTKM = resultSet.getString("TenCTKM");
                    int mucGiamGia = resultSet.getInt("MucGiamGia");
                    String loaiKhuyenMai = resultSet.getString("LoaiSanPhamDuocApDung");
                    String ngayBatDau = resultSet.getString("ThoiGianBatDau");
                    String ngayKetThuc = resultSet.getString("ThoiGianKetThuc");
                    String thoiGianTao = resultSet.getString("ThoiGianTaoKM");
                    String maSanPham = resultSet.getString("MaSP");

                    // Thêm dòng mới vào model của jTable1
                    model.addRow(new Object[]{maCTKM, tenCTKM, mucGiamGia, loaiKhuyenMai, ngayBatDau, ngayKetThuc, thoiGianTao, maSanPham});
                }

                resultSet.close();
                preparedStatement.close();
            } else {
                System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn cơ sở dữ liệu: " + e);
        }
    }


    public boolean themKhuyenMai(khuyenMaiDTO khuyenMai) {
        try {
            if (khuyenMai.getNgayBatDau().after(khuyenMai.getNgayKetThuc()) || khuyenMai.getNgayBatDau().equals(khuyenMai.getNgayKetThuc())) {
                return false; // Thay vì hiển thị thông báo lỗi, chỉ cần trả về false.
            } else {
                if (maKhuyenMaiDaTonTai(khuyenMai.getMaKhuyenMai())) {
                    return false; // Mã khuyến mãi đã tồn tại trong cơ sở dữ liệu.
                }

                String query = "INSERT INTO ChuongTrinhKhuyenMai (MaCTKM, TenCTKM, MucGiamGia, LoaiSanPhamDuocApDung, ThoiGianBatDau, ThoiGianKetThuc, ThoiGianTaoKM, MaSP) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                Connection connection = sqlConn.getConnection();

                if (connection != null) {
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, khuyenMai.getMaKhuyenMai());
                    preparedStatement.setString(2, khuyenMai.getTenKhuyenMai());
                    preparedStatement.setInt(3, khuyenMai.getMucGiamGia());
                    preparedStatement.setString(4, khuyenMai.getLoaiKhuyenMai());
                    preparedStatement.setDate(5, new java.sql.Date(khuyenMai.getNgayBatDau().getTime()));
                    preparedStatement.setDate(6, new java.sql.Date(khuyenMai.getNgayKetThuc().getTime()));
                    preparedStatement.setDate(7, new java.sql.Date(System.currentTimeMillis()));
                    preparedStatement.setString(8, khuyenMai.getmaSanPham());
                    int rowsInserted = preparedStatement.executeUpdate();

                    preparedStatement.close();
                    return rowsInserted > 0;
                } else {
                    return false; // Không thể kết nối đến cơ sở dữ liệu.
                }
            }
        } catch (SQLException e) {
            return false; // Lỗi truy vấn cơ sở dữ liệu.
        }
    }
    

    private boolean maKhuyenMaiDaTonTai(String maKhuyenMai) {
        try {
            String query = "SELECT MaCTKM FROM ChuongTrinhKhuyenMai WHERE MaCTKM = ?";
            Connection connection = sqlConn.getConnection();

            if (connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, maKhuyenMai);
                ResultSet resultSet = preparedStatement.executeQuery();

                boolean tonTai = resultSet.next();

                resultSet.close();
                preparedStatement.close();

                return tonTai;
            } else {
                return false; // Không thể kết nối đến cơ sở dữ liệu.
            }
        } catch (SQLException e) {
            return false; // Lỗi truy vấn cơ sở dữ liệu.
        }
    }


    public boolean xoaKhuyenMai(String maKhuyenMai) {
        try {
            String query = "DELETE FROM ChuongTrinhKhuyenMai WHERE MaCTKM = ?";
            Connection connection = sqlConn.getConnection();

            if (connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, maKhuyenMai);

                int rowsDeleted = preparedStatement.executeUpdate();

                preparedStatement.close();
                return rowsDeleted > 0;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
    
    public void loadValidData(JTable jTable1) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Xóa hết dữ liệu trong jTable1

        try {
            String query = "SELECT MaCTKM, TenCTKM, MucGiamGia, LoaiSanPhamDuocApDung, ThoiGianBatDau, ThoiGianKetThuc, ThoiGianTaoKM, MaSP FROM ChuongTrinhKhuyenMai WHERE ThoiGianKetThuc >= ?";
            Connection connection = sqlConn.getConnection();

            if (connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setDate(1, new java.sql.Date(System.currentTimeMillis())); // Lấy ngày hiện tại

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String maCTKM = resultSet.getString("MaCTKM");
                    String tenCTKM = resultSet.getString("TenCTKM");
                    int mucGiamGia = resultSet.getInt("MucGiamGia");
                    String loaiKhuyenMai = resultSet.getString("LoaiSanPhamDuocApDung");
                    String ngayBatDau = resultSet.getString("ThoiGianBatDau");
                    String ngayKetThuc = resultSet.getString("ThoiGianKetThuc");
                    String ThoiGianTao = resultSet.getString("ThoiGianTaoKM");
                    String maSanPham = resultSet.getString("MaSP");

                    // Thêm dữ liệu vào model của jTable1
                    model.addRow(new Object[]{maCTKM, tenCTKM, mucGiamGia, loaiKhuyenMai, ngayBatDau, ngayKetThuc, ThoiGianTao, maSanPham});
                }

                resultSet.close();
                preparedStatement.close();
            } else {
                System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn cơ sở dữ liệu: " + e);
        }
    }

    public void loadExpiredData(JTable jTable1) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Xóa hết dữ liệu trong jTable1

        try {
            String query = "SELECT MaCTKM, TenCTKM, MucGiamGia, LoaiSanPhamDuocApDung, ThoiGianBatDau, ThoiGianKetThuc FROM ChuongTrinhKhuyenMai WHERE ThoiGianKetThuc < ?";
            Connection connection = sqlConn.getConnection();

            if (connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setDate(1, new java.sql.Date(System.currentTimeMillis())); // Lấy ngày hiện tại

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String maCTKM = resultSet.getString("MaCTKM");
                    String tenCTKM = resultSet.getString("TenCTKM");
                    int mucGiamGia = resultSet.getInt("MucGiamGia");
                    String loaiKhuyenMai = resultSet.getString("LoaiSanPhamDuocApDung");
                    String ngayBatDau = resultSet.getString("ThoiGianBatDau");
                    String ngayKetThuc = resultSet.getString("ThoiGianKetThuc");
                    String ThoiGianTao = resultSet.getString("ThoiGianTaoKM");
                    String maSanPham = resultSet.getString("MaSP");

                    // Thêm dữ liệu vào model của jTable1
                    model.addRow(new Object[]{maCTKM, tenCTKM, mucGiamGia, loaiKhuyenMai, ngayBatDau, ngayKetThuc, ThoiGianTao, maSanPham});
                }

                resultSet.close();
                preparedStatement.close();
            } else {
                System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn cơ sở dữ liệu: " + e);
        }
    }
   
}
