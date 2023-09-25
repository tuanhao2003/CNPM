package DTO;
import java.util.*;

public class ctphieuNhapDTO {
    private String maPn;
    private String maNcc;
    private int soLuong;
    private int donGia;
    private int tamTinh;

    public ctphieuNhapDTO(){
        this.maPn=null;
        this.maNcc=null;
        this.soLuong=0;
        this.donGia=0;
        this.tamTinh=0;
    }

    public ctphieuNhapDTO(String ticketID,String providerID, int quantity ,int pricePeritem){
        this.maPn=ticketID;
        this.maNcc=providerID;
        this.soLuong=quantity;
        this.donGia=pricePeritem;
        this.tamTinh=pricePeritem*quantity;
    }

    public String getmaPn(){
        return this.maPn;
    }

    public String getmaSp(){
        return this.maNcc;
    }

   public int getsoLuong(){
       return this.soLuong;
   }

    public int getdonGia(){
        return this.donGia;
    }

    public int gettamTinh(){
        return this.tamTinh;
    }



    public void setmaPn(String id){
        this.maPn=id;
    }

    public void setmaSp(String id){
        this.maNcc=id;
    }

    public void setsoLuong(int quantity){
        this.soLuong=quantity;
    }

    public void setdonGia(int tmpPrice){
        this.donGia=tmpPrice;
    }

    public void settamTinh(){
        this.tamTinh=this.donGia*this.soLuong;
    }

    public void setctphieuNhap(String ticketID,String providerID, int quantity ,int pricePeritem){
        this.maPn=ticketID;
        this.maNcc=providerID;
        this.soLuong=quantity;
        this.donGia=pricePeritem;
        this.tamTinh=pricePeritem*quantity;
    }
   
}
