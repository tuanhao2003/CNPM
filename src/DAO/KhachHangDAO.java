/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhachHangDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author toica
 */
public class KhachHangDAO {
    private sqlConnect sql;
    public KhachHangDAO(){
        this.sql = new sqlConnect();
    }
    public ArrayList<KhachHangDTO> resultList = new ArrayList<>();
    ResultSet rs = null;
    String query = "Select * from KhachHang";
//    try{
//    rs = this.sql.getSta().executeQuery(query);
//    while(rs.next()){
//        resultList.add(new KhachHangDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
//    } 
}
}
