package DAL;

import DTO.LoaiSanPham;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MinhNguyen 23/08/2016
 */
public class LoaiSanPhamDAL {

    public static void ThemLoaiSanPham(LoaiSanPham lsp) {
        String cauTruyVan = "insert into LoaiSanPham(TenLoai, GhiChu) values(N'" + lsp.getTenLoaiSP() + "',N'" + lsp.getGhiChu() + "')";
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
    }

    public static void SuaLoaiSanPham(LoaiSanPham lsp) {
        String cauTruyVan = "update LoaiSanPham set TenLoai=N'" + lsp.getTenLoaiSP() + "', GhiChu=N'" + lsp.getGhiChu() + "' "
                + "where MaLoai=" + lsp.getMaLoaiSP();
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
    }

    public static void XoaLoaiSanPham(String maLoai) {
        String cauTruyVan = "Delete LoaiSanPham where MaLoai =" + maLoai;
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
    }

    /*
    Hàm trả về tất cả thông tin loại sản phẩm
    */
    public static ResultSet LayTatCaThongTinLoaiSanPham() {
        ResultSet rs;
        String cauTruyVan = "Select * from LoaiSanPham";

        rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);

        return rs;
    }
    /*
    Hàm trả về dữ liệu loại sản phẩm được tìm kiếm theo từ khóa
    */
    public static ResultSet TimKiemDuLieu(String tuKhoa){
        ResultSet rs;
        String cauTruyVan = "Select * from LoaiSanPham where TenLoai like N'%"+tuKhoa+"%' or GhiChu like N'%"+tuKhoa+"%'";

        rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);

        return rs;
    }

    /*
    hàm lấy tên loại dựa vào mã loại truyền vào
    */
    public static String LayTenLoai(int maLoai) {
        String tenLoai = "";
        ResultSet rs;
        String cauTruyVan = "Select * from LoaiSanPham where MaLoai = " + maLoai;
        rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);
        try {
            if (rs.next()) {
                tenLoai = rs.getString("TenLoai");
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return tenLoai;
    }
}
