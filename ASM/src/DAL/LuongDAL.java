/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.LuongNVDTO;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class LuongDAL {
    public static ResultSet LayThongTinLuong(){
        ResultSet rs;
        String CTV="select * from luongnv";
        rs=ConnectionDB.ExecuteQueryGetTable(CTV);
        return rs;
    }
    public static ResultSet LayTenQuyen(int maquyen){
       
        String cauTruyVan="select tenchucvu from chucvu where idchucvu = "+maquyen;
        ResultSet rs=ConnectionDB.ExecuteQueryGetTable(cauTruyVan);
        return rs;
    }
   public static boolean KiemTraTrungLuong(int chucvu){
        boolean ketQua = false;
        String cauTruyVan = "select * from Luongnv where chucvu = '"+chucvu+"'";
        ResultSet rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);
        try {
            if(rs.next()){
                
                return true;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return ketQua;
    }
    public static ResultSet LayDuLieuQuyen(){ 
        String CTV="select * from chucvu";
        ResultSet rs=ConnectionDB.ExecuteQueryGetTable(CTV);
        return rs;
        
    }
    public static void SuaLuong(LuongNVDTO l) {
        String cauTruyVan = "Update luongnv set chucvu = '"+l.getChucVu()+"', luongcoban = '"+l.getLuongCoBan()+"',"
                + " donvi = '"+l.getDonvi()+"',ghichu='"+l.getGhiChu()+"' where idluongnv='"+l.getIdLuongNV()+"'";
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
        System.out.println(cauTruyVan);
    }
}
