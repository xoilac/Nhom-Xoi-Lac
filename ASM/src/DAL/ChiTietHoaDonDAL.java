package DAL;

import DTO.ChiTietHoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MinhNguyen
 * 23/08/2016
 */
public class ChiTietHoaDonDAL {
    //Hàm thêm dữ liệu vào DB
    public static void ThemCTHD(ChiTietHoaDon cthd){
       String cauTruyVan = "Insert ChiTietHoaDon(MaHD, MaSP, SoLuong, ThanhTien, GhiChu)\n" +
"  values("+cthd.getMaHD()+", "+cthd.getMaSP()+", "+cthd.getSoLuong()+", "+cthd.getThanhTien()+", N'"+cthd.getGhiChu()+"')";
       ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
   } 
   //Hàm sửa dữ liệu vào DB
   public static void SuaCTHD(ChiTietHoaDon cthd){
       String cauTruyVan = "Update ChiTietHoaDon set MaSP = "+cthd.getMaSP()+", SoLuong = "+cthd.getSoLuong()+","
               + " GhiChu = N'"+cthd.getGhiChu()+"', ThanhTien = "+cthd.getThanhTien()+" where MaChiTietHD = "+cthd.getMaChiTietHD();
       ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
   } 
   //Hàm xóa dữ liệu trong DB theo mã chi tiết hóa đơn truyền vào @idCTHD
   public static void XoaCTHD(int idCTHD){
       String cauTruyVan = "Delete ChiTietHoaDon where MaChiTietHD = "+idCTHD;
       ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
   } 
   
   //Hàm trả về tất cả thông tin chi tiết hóa đơn trong DB
   public static ResultSet LayTatCaThongTinCTHD(){
       ResultSet rs;
       String cauTruyVan = "Select * from ChiTietHoaDon";
       
       rs =ConnectionDB.ExecuteQueryGetTable(cauTruyVan);
       
       return rs;
   }
   
   /*
    Hàm kiểm tra trùng lặp trong DB
     */
    public static boolean TrungCTHD(int idSP, int maHD) {
        ResultSet rs;
        boolean ketQua = false;
        String cauTruyVan = "Select * from ChiTietHoaDon where MaHD = " + maHD + " and MaSP = " + idSP;
        rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);
        try {
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return ketQua;
    }

    //Hàm xóa chi tiết hóa đơn theo mã hóa đơn và id sản phẩm
    public static void XoaCTHDTheoIDSanPhamVaMaHD(int maHD, int idSP) {
        String cauTruyVan = "Delete ChiTietHoaDon where MaHD = " + maHD + " and MaSP = " + idSP;
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
    }

    //Hàm lấy mã chi tiết hóa đơn theo mã hóa đơn và id sản phẩm
    public static int LayMaCTHD(int maHD, int idSP) {
        String cauTruyVan = "Select * from ChiTietHoaDon where MaHD = " + maHD + " and MaSP = " + idSP;
        int maCTHD = 0;
        ResultSet rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);
        try {
            while (rs.next()) {
                maCTHD = rs.getInt("MaChiTietHD");
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return maCTHD;
    }
    
    //Hàm trả về dữ liệu được tìm kiếm
    public static ResultSet TimKiemTheoMaHD(int maHD){
        String cauTruyVan = "Select * from ChiTietHoaDon where MaHD = "+maHD;
        ResultSet rs= ConnectionDB.ExecuteQueryGetTable(cauTruyVan);
        
        return rs;
    }
}
