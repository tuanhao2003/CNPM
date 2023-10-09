package BUS;

import DAO.phieuNhapDAO;
import DTO.phieuNhapDTO;
import java.util.*;

public class phieuNhapBUS {
    private phieuNhapDAO daoPn;
    private ArrayList<phieuNhapDTO> dtoLst;

    public phieuNhapBUS() {
        daoPn = new phieuNhapDAO();
        dtoLst = new ArrayList<>();
    }
    
    public ArrayList<phieuNhapDTO> getAll(){
        this.dtoLst = this.daoPn.getListall();
        return this.dtoLst;
    }
}
