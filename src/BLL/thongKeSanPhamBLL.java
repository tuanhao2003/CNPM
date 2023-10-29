package BLL;

import DAO.thongKeSanPhamDAO;
import java.sql.ResultSet;
import java.util.List;

public class thongKeSanPhamBLL {
    private thongKeSanPhamDAO thongKeSanPhamDAO;
    
    public thongKeSanPhamBLL() {
        thongKeSanPhamDAO = new thongKeSanPhamDAO();
    }
    
    // Phương thức để lấy số lượng sản phẩm của từng hãng trong ngày hiện tại
    public int getSanPhamCountByHang(String hang) {
        return thongKeSanPhamDAO.getSanPhamCountByHang(hang);
    }
    
    public int getSanPhamCountByHangForWeek(String hang) {
        return thongKeSanPhamDAO.getSanPhamCountByHangForWeek(hang);
    }
    
    public int getSanPhamCountByHangForMonth(String hang) {
        return thongKeSanPhamDAO.getSanPhamCountByHangForMonth(hang);
    }

    public List<String[]> getSalesDataForWeek() {
        return thongKeSanPhamDAO.getSalesDataForWeek();
    }
}
