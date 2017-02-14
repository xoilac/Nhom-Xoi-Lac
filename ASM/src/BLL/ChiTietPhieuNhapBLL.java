package BLL;

import DAL.ChiTietPhieuNhapDAL;
import DTO.ChiTietPhieuNhap;

/**
 *
 * @author MinhNguyen
 */
public class ChiTietPhieuNhapBLL {
    //Hàm xóa chi tiết phiếu nhập theo mã phiếu nhập và id sản phẩm
    public static void XoaCoDieuKienCTPN(int maPN, int idSP) {
        ChiTietPhieuNhapDAL.XoaCTPNTheoIDSanPhamVaMaPN(maPN, idSP);
    }
    
    public static void ThemCTPN(ChiTietPhieuNhap ctpn){
        ChiTietPhieuNhapDAL.ThemCTPN(ctpn);
    }
    
    //Hàm kiểm tra trùng lặp chi tiết phiếu nhập
    public static boolean TrungLapCTPN(int maSP, int maPN) {
        boolean ketQua = ChiTietPhieuNhapDAL.TrungCTPN(maSP, maPN);

        return ketQua;
    }
    
    /*
    Hàm sửa chi tiết phiếu nhập
     */
    public static void SuaCTPN(ChiTietPhieuNhap ctpn) {
        ChiTietPhieuNhapDAL.SuaCTPN(ctpn);
    }
    
    //Hàm lấy mã của chi tiết hóa đơn theo mã phiếu nhập và mã sản phẩm
    public static int LayMaCTHD(int maPN, int maSP) {
        int maCTHD = ChiTietPhieuNhapDAL.LayMaCTPN(maPN, maSP);

        return maCTHD;
    }
}
