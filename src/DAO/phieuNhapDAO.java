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
        String query="select * from PhieuNhapKho";
        try {
            rs = this.sql.getSta().executeQuery(query);
            while(rs.next()){
                resultList.add(new phieuNhapDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }
        } catch (Exception e) {
            System.out.println("Loi lay danh sach phieu nhap(r:24,DAO): "+e);
        }
        return resultList;
    }
    
    public void themPn(phieuNhapDTO pn){
        String query = "insert into PhieuNhapKho((MaPhieuNhap, MaKho,NgayNhap,TongTien,Thue) values('"+pn.getmaPn()+"','"+pn.getmaKho()+"','"+ pn.getngayNhap() +"',"+pn.gettongTien()+","+ pn.getthue()+");";
        try {
            this.sql.getSta().executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Loi them phieu nhap(r:34,DAO): "+e);
        }
    }
    
    public void xoaPn(String id){
        String query = "delete form table PhieuNhapKho where MaPhieuNhap='"+id+"';";
        try {
            this.sql.getSta().executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Loi xoa phieu nhap(r:43,DAO): "+e);
        }
    }
    
    public void suaPn(String idPn, String id, String day, int total, int tax){
        String query="update PhieuNhapKho set MaKho='"+id+"', NgayNhap='"+day+"', TongTien="+total+",Thue="+tax+" where MaPhieuNhap='"+idPn+"';";
        try {
            this.sql.getSta().executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Loi sua phieu nhap(r52,DAO): "+e);
        }
    }
}