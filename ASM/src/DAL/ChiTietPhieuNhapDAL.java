package DAL;
import DTO.ChiTietPhieuNhap;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MinhNguyen
 * 23/08/2016
 */
public class ChiTietPhieuNhapDAL {
    public static void ThemCTPN(ChiTietPhieuNhap ctpn){
       String cauTruyVan = "Insert ChiTietPhieuNhap(MaPhieuNhap, MaSanPham, SoLuong, ThanhTien, GhiChu)\n" +
"  values("+ctpn.getMaPhieuNhap()+", "+ctpn.getMaSP()+", "+ctpn.getSoLuong()+", "+ctpn.getThanhTien()+", N'"+ctpn.getGhiChu()+"')";
       ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
   } 
   
   public static void SuaCTPN(ChiTietPhieuNhap ctpn){
       String cauTruyVan = "update ChiTietPhieuNhap set MaSanPham = "+ctpn.getMaSP()+","
               + " SoLuong = "+ctpn.getSoLuong()+", GhiChu = N'"+ctpn.getGhiChu()+"', ThanhTien = "+ctpn.getThanhTien()+" "
               + "where MaCTPN = "+ctpn.getMCTPhieuNhap();
       ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
   } 
   
   public static void XoaCTPN(int idCTPN){
       String cauTruyVan = "Delete ChiTietPhieuNhap where MaCTPN = "+idCTPN;
       ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
   } 
   
   public static ResultSet LayTatCaThongTinCTPN(){
       ResultSet rs;
       String cauTruyVan = "Select * from ChiTietPhieuNhap";
       
       rs =ConnectionDB.ExecuteQueryGetTable(cauTruyVan);
       
       return rs;
   }
   
   //Hàm xóa chi tiết phiếu nhập theo mã phiếu nhập và id sản phẩm
    public static void XoaCTPNTheoIDSanPhamVaMaPN(int maPN, int maSP) {
        String cauTruyVan = "Delete ChiTietPhieuNhap where MaPhieuNhap = " + maPN + " and MaSanPham = " + maSP;
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
    }
    
    /*
    Hàm kiểm tra trùng lặp trong DB
     */
    public static boolean TrungCTPN(int maSP, int maPN) {
        ResultSet rs;
        boolean ketQua = false;
        String cauTruyVan = "Select * from ChiTietPhieuNhap where MaPhieuNhap = " + maPN + " and MaSanPham = " + maSP;
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
    
    //Hàm lấy mã chi tiết hóa đơn theo mã phiếu nhập và id sản phẩm
    public static int LayMaCTPN(int maPN, int idSP) {
        String cauTruyVan = "Select * from ChiTietPhieuNhap where MaPhieuNhap = " + maPN + " and  MaSanPham = " + idSP;
        int maCTHD = 0;
        ResultSet rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);
        try {
            while (rs.next()) {
                maCTHD = rs.getInt("MaCTPN");
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return maCTHD;
    }
}
