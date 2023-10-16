package DAO;

import DTO.ctphieuNhapDTO;
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
        ResultSet rs = null;
        String query="select * from PhieuNhapKho";
        try {
            rs = this.sql.getSta().executeQuery(query);
            while(rs.next()){
                resultList.add(new phieuNhapDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }
        } catch (Exception e) {
            System.out.println("Loi lay danh sach phieu nhap: "+e);
        }
        return resultList;
    }
    
    public void themPn(phieuNhapDTO pn){
        String query = "insert into PhieuNhapKho((MaPhieuNhap, MaKho,NgayNhap,TongTien,Thue) values('"+pn.getmaPn()+"','"+pn.getmaKho()+"','"+ pn.getngayNhap() +"',"+pn.gettongTien()+","+ pn.getthue()+");";
        try {
            this.sql.getSta().executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Loi them phieu nhap: "+e);
        }
    }
    
    public void xoaPn(String id){
        String query = "delete form table PhieuNhapKho where MaPhieuNhap='"+id+"';";
        try {
            this.sql.getSta().executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Loi xoa phieu nhap "+e);
        }
    }
    
    public void suaPn(String idPn, String id, String day, int total, int tax){
        String query="update PhieuNhapKho set MaKho='"+id+"', NgayNhap='"+day+"', TongTien="+total+",Thue="+tax+" where MaPhieuNhap='"+idPn+"';";
        try {
            this.sql.getSta().executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Loi sua phieu nhap: "+e);
        }
    }
    
    
//    CHI TIẾT PHIẾU NHẬP
    public ArrayList<ctphieuNhapDTO> getListCt(String idpn){
        ArrayList<ctphieuNhapDTO> resultList = new ArrayList<>();
        ResultSet rs = null;
        String query="select * from CTPhieuNhapKho where MaPhieuNhap='"+idpn+"';";
        try {
            rs = this.sql.getSta().executeQuery(query);
            while(rs.next()){
                resultList.add(new ctphieuNhapDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
            }
        } catch (Exception e) {
            System.out.println("Loi lay danh sach phieu nhap: "+e);
        }
        return resultList;
    }
    
    public void themCtpn(ctphieuNhapDTO pn){
        String query = "insert into CTPhieuNhapKho((MaPhieuNhap, MaNcc,SoLuong,DonGia,TamTinh) values('"+pn.getmaPn()+"','"+pn.getmaNcc()+"','"+ pn.getsoLuong() +"',"+pn.getdonGia()+","+ pn.gettamTinh()+");";
        try {
            this.sql.getSta().executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Loi them chi tiet phieu nhap: "+e);
        }
    }
    
    public void xoaCtpn(String id, String idncc){
        String query = "delete form table CTPhieuNhapKho where MaPhieuNhap='"+id+"' and MaNcc='"+idncc+"';";
        try {
            this.sql.getSta().executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Loi xoa phieu nhap: "+e);
        }
    }
    
    public void suaCtpn(String idPn, String idncc, int quantity, int pricePer, int tmpPrice){
        String query="update CTPhieuNhapKho set MaNcc='"+idncc+"', SoLuong='"+quantity+"', DonGia="+pricePer+",TamTinh="+tmpPrice+" where MaPhieuNhap='"+idPn+"';";
        try {
            this.sql.getSta().executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Loi sua phieu nhap: "+e);
        }
    }
    
    public ArrayList<phieuNhapDTO> getSearch(String data, String type){
        ResultSet rs = null;
        ArrayList<phieuNhapDTO> dspn = new ArrayList<>();
        String query = "select * from PhieuNhapKho where ";
        try{
            switch (type) {
                case "Mã Phiếu":
                    query += "MaPhieuNhap='"+data+"';";
                    break;
                case "Mã Kho":
                    query += "MaKho='"+data+"';";
                    break;
                case "Tổng Tiền":
                    query += "TongTien="+Integer.parseInt(data)+";";
                    break;
                default:
                    query += "MaPhieuNhap like '%"+data+"%' or MaKho like '%"+data+"%' or NgayNhap like '%"+data+"%';";
            }
            System.out.println(query);
            rs = this.sql.getSta().executeQuery(query);
            while(rs.next()){
                dspn.add(new phieuNhapDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }
        }catch(Exception e){
            System.out.println("Loi tim kiem phieu nhap: "+e);
        }
        return dspn;
    }
    
    public ArrayList<phieuNhapDTO> getByDays(ArrayList<Integer> days){
        ResultSet rs = null;
        ArrayList<phieuNhapDTO> dspn = new ArrayList<>();
        String  query = "select * form PhieuNhapKho where convert(DATE, NgayNhap, 103) between '"+days.get(0)+"-"+days.get(1)+"-"+days.get(2)+"' and '"+days.get(3)+"-"+days.get(4)+"-"+days.get(5)+"';";
        try {
            rs = this.sql.getSta().executeQuery(query);
            while (rs.next()) {
                dspn.add(new phieuNhapDTO(rs.getString(1), rs.getString(2), rs.getDate(3).toString(), rs.getInt(4), rs.getInt(5)));
            }
        }
        catch (Exception e) {
            System.out.println("Loi lay phieu nhap theo ngay: "+e);
        }
        return dspn;
    }
}