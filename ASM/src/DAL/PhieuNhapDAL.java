package DAL;

import DTO.PhieuNhap;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MinhNguyen 23/08/2016
 */
public class PhieuNhapDAL {

    public static void ThemPhieuNhap(PhieuNhap pn) {
        String cauTruyVan = "set dateformat dmy Insert PhieuNhap(SoPhieuNhap, NhaCungCap, NhanVienTao, NhanVienNhap, NgayTao, TongTien, TrangThai, GhiChu)\n"
                + "  values('" + pn.getSoPhieuNhap()+ "'," + pn.getNhaCungCap() + ", " 
                + pn.getNhanVienTao() + "," + pn.getNhanVienNhap()+ ", '" + pn.getNgayTao() + "', " 
                + pn.getTongTien() + ", N'"+pn.getTrangThai()+"', N'" + pn.getGhiChu() + "')";
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
    }

    public static void SuaPhieuNhap(PhieuNhap pn) {
        String cauTruyVan = "set dateformat dmy Update PhieuNhap set NhaCungCap = " + pn.getNhaCungCap() + ","
                + " GhiChu = N'" + pn.getGhiChu() + "', TrangThai = N'"+pn.getTrangThai()+"', NhanVienNhap = "
                + ""+pn.getNhanVienNhap()+", TongTien = "+pn.getTongTien()+" "
                + "where MaPhieuNhap = " + pn.getMaPhieuNhap();
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
    }

    public static void XoaPhieuNhap(int idPhieuNhap) {
        String cauTruyVan = "Delete PhieuNhap where MaPhieuNhap =" + idPhieuNhap;
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
    }

    public static ResultSet LayTatCaThongTinPhieuNhap() {
        ResultSet rs;
        String cauTruyVan = "Select * from PhieuNhap";

        rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);

        return rs;
    }

    //Hàm lấy mã phiếu nhập theo số phiếu nhập truyền vào
    public static int LayMaPhieuNhap(String soPhieuNhap) {
        ResultSet rs;
        int maPN = 0;
        String SQLSelect = "select * from PhieuNhap where SoPhieuNhap = '" + soPhieuNhap + "'";
        rs = ConnectionDB.ExecuteQueryGetTable(SQLSelect);
        try {
            while (rs.next()) {
                maPN = rs.getInt("MaPhieuNhap");
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return maPN;
    }
    
    //Hàm kiểm tra trùng lặp theo số phiếu nhập
    public static boolean TrungLapPhieuNhap(String soPhieuNhap) {
        ResultSet rs;
        boolean ketQua = false;
        String cauTruyVan = "Select SoPhieuNhap from PhieuNhap where SoPhieuNhap = '" + soPhieuNhap + "'";
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
}
