 package BLL;

import DAO.phieuNhapDAO;
import DTO.ctphieuNhapDTO;
import DTO.phieuNhapDTO;
import java.util.*;

public class phieuNhapBLL {
    private phieuNhapDAO daoPn;

    public phieuNhapBLL() {
        daoPn = new phieuNhapDAO();
    }
    
    public ArrayList<phieuNhapDTO> showAll(){
        return this.daoPn.getListall();
    }
    
    public ArrayList<phieuNhapDTO> showSort(ArrayList<phieuNhapDTO> list, String type, String way){
        ArrayList<phieuNhapDTO> tmpList = list;
        if(way.equals("Tăng Dần")){
            if(type.equals("Mã Phiếu")){
                for(int i = 0; i<tmpList.size()-1; i++){
                    for (int j = i+1; j< tmpList.size(); j++){
                        if(tmpList.get(i).getmaPn().compareTo(tmpList.get(j).getmaPn())>0){
                            phieuNhapDTO tmp = tmpList.get(i);
                            tmpList.set(i, tmpList.get(j));
                            tmpList.set(j, tmp);
                        }
                    }
                }
            }

            if(type.equals("Mã Kho")){
                for(int i = 0; i<tmpList.size()-1; i++){
                    for (int j = i+1; j< tmpList.size(); j++){
                        if(tmpList.get(i).getmaKho().compareTo(tmpList.get(j).getmaKho())>0){
                            phieuNhapDTO tmp = tmpList.get(i);
                            tmpList.set(i, tmpList.get(j));
                            tmpList.set(j, tmp);
                        }
                    }
                }
            }

            if(type.equals("Ngày Nhập")){
                for(int i = 0; i<tmpList.size()-1; i++){
                    for (int j = i+1; j< tmpList.size(); j++){
                        if(Integer.parseInt(tmpList.get(i).getngayNhap().replace(" ", "").split("/")[2])>Integer.parseInt(tmpList.get(j).getngayNhap().replace(" ", "").split("/")[2])){
                            phieuNhapDTO tmp = tmpList.get(i);
                            tmpList.set(i, tmpList.get(j));
                            tmpList.set(j, tmp);
                        }
                    }
                }
                for(int i = 0; i<tmpList.size()-1; i++){
                    for (int j = i+1; j< tmpList.size(); j++){
                        if(Integer.parseInt(tmpList.get(i).getngayNhap().replace(" ", "").split("/")[2])==Integer.parseInt(tmpList.get(j).getngayNhap().replace(" ", "").split("/")[2]) && Integer.parseInt(tmpList.get(i).getngayNhap().split("/")[1])>Integer.parseInt(tmpList.get(j).getngayNhap().split("/")[1])){
                            phieuNhapDTO tmp = tmpList.get(i);
                            tmpList.set(i, tmpList.get(j));
                            tmpList.set(j, tmp);
                        }
                    }
                }
                for(int i = 0; i<tmpList.size()-1; i++){
                    for (int j = i+1; j< tmpList.size(); j++){
                        if(Integer.parseInt(tmpList.get(i).getngayNhap().replace(" ", "").split("/")[2])==Integer.parseInt(tmpList.get(j).getngayNhap().replace(" ", "").split("/")[2]) &&  Integer.parseInt(tmpList.get(i).getngayNhap().split("/")[1])==Integer.parseInt(tmpList.get(j).getngayNhap().split("/")[1]) && Integer.parseInt(tmpList.get(i).getngayNhap().split("/")[0])>Integer.parseInt(tmpList.get(j).getngayNhap().split("/")[0])){
                            phieuNhapDTO tmp = tmpList.get(i);
                            tmpList.set(i, tmpList.get(j));
                            tmpList.set(j, tmp);
                        }
                    }
                }
            }
        }
        else{
            if(type.equals("Mã Phiếu")){
                for(int i = 0; i<tmpList.size()-1; i++){
                    for (int j = i+1; j< tmpList.size(); j++){
                        if(tmpList.get(i).getmaPn().compareTo(tmpList.get(j).getmaPn())<0){
                            phieuNhapDTO tmp = tmpList.get(i);
                            tmpList.set(i, tmpList.get(j));
                            tmpList.set(j, tmp);
                        }
                    }
                }
            }

            if(type.equals("Mã Kho")){
                for(int i = 0; i<tmpList.size()-1; i++){
                    for (int j = i+1; j< tmpList.size(); j++){
                        if(tmpList.get(i).getmaKho().compareTo(tmpList.get(j).getmaKho())<0){
                            phieuNhapDTO tmp = tmpList.get(i);
                            tmpList.set(i, tmpList.get(j));
                            tmpList.set(j, tmp);
                        }
                    }
                }
            }

            if(type.equals("Ngày Nhập")){
                for(int i = 0; i<tmpList.size()-1; i++){
                    for (int j = i+1; j< tmpList.size(); j++){
                        if(Integer.parseInt(tmpList.get(i).getngayNhap().replace(" ", "").split("/")[2])<Integer.parseInt(tmpList.get(j).getngayNhap().replace(" ", "").split("/")[2])){
                            phieuNhapDTO tmp = tmpList.get(i);
                            tmpList.set(i, tmpList.get(j));
                            tmpList.set(j, tmp);
                        }
                    }
                }
                for(int i = 0; i<tmpList.size()-1; i++){
                    for (int j = i+1; j< tmpList.size(); j++){
                        if(Integer.parseInt(tmpList.get(i).getngayNhap().replace(" ", "").split("/")[2])==Integer.parseInt(tmpList.get(j).getngayNhap().replace(" ", "").split("/")[2]) && Integer.parseInt(tmpList.get(i).getngayNhap().split("/")[1])<Integer.parseInt(tmpList.get(j).getngayNhap().split("/")[1])){
                            phieuNhapDTO tmp = tmpList.get(i);
                            tmpList.set(i, tmpList.get(j));
                            tmpList.set(j, tmp);
                        }
                    }
                }
                for(int i = 0; i<tmpList.size()-1; i++){
                    for (int j = i+1; j< tmpList.size(); j++){
                        if(Integer.parseInt(tmpList.get(i).getngayNhap().replace(" ", "").split("/")[2])==Integer.parseInt(tmpList.get(j).getngayNhap().replace(" ", "").split("/")[2]) &&  Integer.parseInt(tmpList.get(i).getngayNhap().split("/")[1])==Integer.parseInt(tmpList.get(j).getngayNhap().split("/")[1]) && Integer.parseInt(tmpList.get(i).getngayNhap().split("/")[0])<Integer.parseInt(tmpList.get(j).getngayNhap().split("/")[0])){
                            phieuNhapDTO tmp = tmpList.get(i);
                            tmpList.set(i, tmpList.get(j));
                            tmpList.set(j, tmp);
                        }
                    }
                }
            }
        }
        return tmpList;
    }
    
    public ArrayList<phieuNhapDTO> showByDays(String dayStart,String monthStart,String yearStart, String dayEnd, String monthEnd, String yearEnd){
        ArrayList<Integer> parsedDay = new ArrayList<>();
        parsedDay.add(Integer.parseInt(dayStart.split(" ")[1]));
        parsedDay.add(Integer.parseInt(monthStart.split(" ")[1]));
        parsedDay.add(Integer.parseInt(yearStart.split(" ")[1]));
        
        parsedDay.add(Integer.parseInt(dayEnd.split(" ")[1]));
        parsedDay.add(Integer.parseInt(monthEnd.split(" ")[1]));
        parsedDay.add(Integer.parseInt(yearEnd.split(" ")[1]));
        
        return this.daoPn.getByDays(parsedDay);
    }
    
    public ArrayList<phieuNhapDTO> showSearch(String data, String type){
        return this.daoPn.getSearch(data, type);
    }
    
    public ArrayList<ctphieuNhapDTO> showCtpn(String id){
        return this.daoPn.getListCt(id);
    } 
}
