package DAO;
import DTO.phieuNhapDTO;
import java.sql.*;
import java.util.*;

public class phieuNhapDAO {
    private sqlConnect sql;
    
    public phieuNhapDAO(){
        this.sql=new sqlConnect();
    }
    
    public ArrayList<phieuNhapDTO> getListall(){
        ArrayList<phieuNhapDTO> resultList = new ArrayList<>();
        phieuNhapDTO phieuNhap = new phieuNhapDTO();
        ResultSet rs = null;
        String query="select * form PhieuNhapKho";
        try {
            rs = this.sql.getSta().executeQuery(query);
            while(rs.next()){
                resultList.add(new phieuNhapDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }
        } catch (Exception e) {
            System.out.println("Lỗi lấy danh sách phiếu nhập(r:25,DAO): "+e);
        }
        return resultList;
    }
    
    public void themPn(phieuNhapDTO pn){
        String query = "insert into PhieuNhapKho((MaPhieuNhap, MaKho,NgayNhap,TongTien,Thue) values('"+pn.getmaPn()+"','"+pn.getmaKho()+"','"+ pn.getngayNhap() +"',"+pn.gettongTien()+","+ pn.getthue()+");";
        try {
            this.sql.getSta().executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Lỗi thêm phiếu nhập(r:34,DAO): "+e);
        }
    }
    
    public void xoaPn(String id){
        try {
            this.sql.getSta().executeUpdate("delete form table PhieuNhapKho where MaPhieuNhap='"+id+"';");
        } catch (Exception e) {
            System.out.println("Lỗi xóa phiếu nhập(r:43,DAO): "+e);
        }
    }
}