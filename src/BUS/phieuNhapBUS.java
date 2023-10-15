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
    
    public void sort(ArrayList<phieuNhapDTO> list, String type, String way){
        list = this.dtoLst;
        if(way.equals("Tăng Dần")){
            if(type.equals("Mã Phiếu")){
                for(int i = 0; i<list.size()-1; i++){
                    for (int j = i+1; j< list.size(); j++){
                        if(list.get(i).getmaPn().compareTo(list.get(j).getmaPn())>0){
                            phieuNhapDTO tmp = list.get(i);
                            list.set(i, list.get(j));
                            list.set(j, tmp);
                        }
                    }
                }
            }
            
            if(type.equals("Mã Kho")){
                for(int i = 0; i<list.size()-1; i++){
                    for (int j = i+1; j< list.size(); j++){
                        if(list.get(i).getmaKho().compareTo(list.get(j).getmaKho())>0){
                            phieuNhapDTO tmp = list.get(i);
                            list.set(i, list.get(j));
                            list.set(j, tmp);
                        }
                    }
                }
            }
            
            if(type.equals("Ngày Nhập")){
                for(int i = 0; i<list.size()-1; i++){
                    for (int j = i+1; j< list.size(); j++){
                        if(Integer.parseInt(list.get(i).getngayNhap().split("/")[2])>Integer.parseInt(list.get(j).getngayNhap().split("/")[2])){
                            phieuNhapDTO tmp = list.get(i);
                            list.set(i, list.get(j));
                            list.set(j, tmp);
                        }
                    }
                }
                for(int i = 0; i<list.size()-1; i++){
                    for (int j = i+1; j< list.size(); j++){
                        if(Integer.parseInt(list.get(i).getngayNhap().split("/")[1])>Integer.parseInt(list.get(j).getngayNhap().split("/")[1])){
                            phieuNhapDTO tmp = list.get(i);
                            list.set(i, list.get(j));
                            list.set(j, tmp);
                        }
                    }
                }
                for(int i = 0; i<list.size()-1; i++){
                    for (int j = i+1; j< list.size(); j++){
                        if(Integer.parseInt(list.get(i).getngayNhap().split("/")[0])>Integer.parseInt(list.get(j).getngayNhap().split("/")[0])){
                            phieuNhapDTO tmp = list.get(i);
                            list.set(i, list.get(j));
                            list.set(j, tmp);
                        }
                    }
                }
            }
        }
        else{
            if(type.equals("Mã Phiếu")){
                for(int i = 0; i<list.size()-1; i++){
                    for (int j = i+1; j< list.size(); j++){
                        if(list.get(i).getmaPn().compareTo(list.get(j).getmaPn())<0){
                            phieuNhapDTO tmp = list.get(i);
                            list.set(i, list.get(j));
                            list.set(j, tmp);
                        }
                    }
                }
            }
            
            if(type.equals("Mã Kho")){
                for(int i = 0; i<list.size()-1; i++){
                    for (int j = i+1; j< list.size(); j++){
                        if(list.get(i).getmaKho().compareTo(list.get(j).getmaKho())<0){
                            phieuNhapDTO tmp = list.get(i);
                            list.set(i, list.get(j));
                            list.set(j, tmp);
                        }
                    }
                }
            }
            
            if(type.equals("Ngày Nhập")){
                for(int i = 0; i<list.size()-1; i++){
                    for (int j = i+1; j< list.size(); j++){
                        if(Integer.parseInt(list.get(i).getngayNhap().split("/")[2])<Integer.parseInt(list.get(j).getngayNhap().split("/")[2])){
                            phieuNhapDTO tmp = list.get(i);
                            list.set(i, list.get(j));
                            list.set(j, tmp);
                        }
                    }
                }
                for(int i = 0; i<list.size()-1; i++){
                    for (int j = i+1; j< list.size(); j++){
                        if(Integer.parseInt(list.get(i).getngayNhap().split("/")[1])<Integer.parseInt(list.get(j).getngayNhap().split("/")[1])){
                            phieuNhapDTO tmp = list.get(i);
                            list.set(i, list.get(j));
                            list.set(j, tmp);
                        }
                    }
                }
                for(int i = 0; i<list.size()-1; i++){
                    for (int j = i+1; j< list.size(); j++){
                        if(Integer.parseInt(list.get(i).getngayNhap().split("/")[0])<Integer.parseInt(list.get(j).getngayNhap().split("/")[0])){
                            phieuNhapDTO tmp = list.get(i);
                            list.set(i, list.get(j));
                            list.set(j, tmp);
                        }
                    }
                }
            }
        }
        this.dtoLst=list;
    }
    
    public ArrayList<phieuNhapDTO> showByDays(String dayStart, String dayEnd){
        ArrayList<Integer> parsedDay = new ArrayList<>();
        for(String i : dayStart.split("/")){
            parsedDay.add(Integer.parseInt(i));
        }
        for(String i : dayEnd.split("/")){
            parsedDay.add(Integer.parseInt(i));
        }
        
        return this.daoPn.getByDays(parsedDay);
    }
}
