package DAL;

import DTO.QuyenNV;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MinhNguyen 23/08/2016
 */
public class QuyenNhanVienDAL {

    //Hàm thực hiện thêm dữ liệu vào DB
    public static void ThemQuyenNV(QuyenNV qnv) {
        String cauTruyVan = "insert into QuyenNV(TenQuyen, GhiChu) values(N'" + qnv.getTenQuyen() + "',N'" + qnv.getGhiChu() + "')";
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
    }

    //Hàm thực hiện sửa dữ liệu vào DB
    public static void SuaQuyenNV(QuyenNV qnv) {
        String cauTruyVan = "update QuyenNV set TenQuyen=N'" + qnv.getTenQuyen() + "',"
                + "GhiChu=N'" + qnv.getGhiChu() + "' where MaQuyen=" + qnv.getMaQuyen();
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
    }

    //Hàm thực hiện xóa dữ liệu theo id quyền truyền vào
    public static void XoaQuyenNV(int idQuyenNV) {
        String cauTruyVan = "Delete QuyenNV where MaQuyen =" + idQuyenNV;
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
    }
    //Hàm trả về tất cả thông tin quyền trong DB

    public static ResultSet LayTatCaThongTinQuyenNV() {
        ResultSet rs;
        String cauTruyVan = "Select * from QuyenNV";

        rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);

        return rs;
    }

    //Hàm lấy tên quyền dựa vào mã quyền truyền vào
    public static String LayTenQuyen(int maQuyen) {
        ResultSet rs;
        String tenQuyen = "";
        String cauTruyVan = "Select * from QuyenNV where MaQuyen = " + maQuyen;
        rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);

        try {
            if (rs.next()) {
                tenQuyen = rs.getString("TenQuyen");
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return tenQuyen;
    }
}
