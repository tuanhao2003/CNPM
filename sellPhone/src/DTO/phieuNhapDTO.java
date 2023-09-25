package DTO;
import java.util.*;

public class phieuNhapDTO {
    private String maPn;
    private String maKho;
    private String ngayNhap;
    private int tongTien;
    private int thue;
    private int phiVanchuyen;
    
    public phieuNhapDTO(){
        this.maPn=null;
        this.maKho = null;
        this.ngayNhap=null;
        this.tongTien=0;
        this.thue=0;
        this.phiVanchuyen=0;
    }
    
    public phieuNhapDTO(String ticketID, String storedID, String dateModifier, ArrayList<ctphieuNhapDTO> ctpnLst, int tax, int fee){
        this.maPn=ticketID;
        this.maKho=storedID;
        this.ngayNhap=dateModifier;
        this.tongTien=0;
        for(ctphieuNhapDTO ctpn : ctpnLst){
            this.tongTien+=ctpn.gettamTinh();
        }
        this.thue=tax;
        this.tongTien = this.tongTien - this.tongTien*this.thue;
        this.phiVanchuyen=fee;
    }
    
    public String getmaPn(){
        return this.maPn;
    }
    public void setmaPn(String ID){
        this.maPn=ID;
    }
    
    public String getngayNhap(){
        return this.ngayNhap;
    }
    public void setngayNhap(String date){
        this.ngayNhap=date;
    }
    
    public String getmaNcc(){
        return this.maKho;
    }
    public void setmaNcc(String ID){
        this.maKho=ID;
    }
    
    public int gettongTien(){
        return this.tongTien;
    }
    public void settongTien(ArrayList<ctphieuNhapDTO> ctpnLst){
        this.tongTien=0;
        for(ctphieuNhapDTO ctpn : ctpnLst){
            this.tongTien+=ctpn.gettamTinh();
        }
        this.tongTien = this.tongTien - this.tongTien*this.thue;
    }

    public int getthue(){
        return this.thue;
    }
    public void setthue(int tax){
        this.thue=tax;
    }
    
    public int getphiVanchuyen(){
        return this.phiVanchuyen;
    }
    public void setphiVanchuyen(int fee){
        this.phiVanchuyen=fee;
    }
    
    public void setphieuNhap(String ticketID, String storedID, String dateModifier, ArrayList<ctphieuNhapDTO> ctpnLst, int tax, int fee){
        this.maPn=ticketID;
        this.maKho=storedID;
        this.ngayNhap=dateModifier;
        this.tongTien=0;
        for(ctphieuNhapDTO ctpn : ctpnLst){
            this.tongTien+=ctpn.gettamTinh();
        }
        this.thue=tax;
        this.tongTien = this.tongTien - this.tongTien*this.thue;
        this.phiVanchuyen=fee;
    }

    @Override
    public String toString(){
        return this.maPn+this.maKho+this.ngayNhap+Integer.toString(this.tongTien)+Integer.toString(this.thue);
    }
}
