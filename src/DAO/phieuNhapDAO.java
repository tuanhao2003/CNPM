package DAO;
import DTO.phieuNhapDTO;
import java.sql.*;
import java.util.*;

public class phieuNhapDAO {
    private sqlConnect sql;
    
    public phieuNhapDAO(){
        this.sql=new sqlConnect();
    }
    
    public ArrayList<phieuNhapDTO> getListpn(){
        ArrayList<phieuNhapDTO> resultList = new ArrayList<>();
        ResultSet rs = null;
        String direct="select * form ";
        try {
            rs = this.sql.getSta().executeQuery(direct);
        } catch (Exception e) {
            System.out.println("Lỗi lấy danh sách phiếu nhập: "+e);
        }
        return resultList;
    }
}
