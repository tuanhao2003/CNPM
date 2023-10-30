/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author toica
 */
public class PhanQuyenDTO {
    private String MaTK;
    private int Quyen;
    public PhanQuyenDTO(String matk, int quyen){
        this.MaTK = matk;
        this.Quyen = quyen;
    }

    public PhanQuyenDTO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getMaTK() {
        return MaTK;
    }

    public int getQuyen() {
        return Quyen;
    }

    public void setMaTK(String MaTK) {
        this.MaTK = MaTK;
    }

    public void setQuyen(int Quyen) {
        this.Quyen = Quyen;
    }
    
}
