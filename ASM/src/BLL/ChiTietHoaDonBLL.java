package BLL;

import DAL.ChiTietHoaDonDAL;
import static DAL.SanPhamDAL.LayDuLieuTheoMaSP;
import DTO.ChiTietHoaDon;
import DTO.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fpoly
 */
public class ChiTietHoaDonBLL {

    //Hàm thêm chi tiết hóa đơn 
    public static void ThemCTHD(ChiTietHoaDon cthd) {
        ChiTietHoaDonDAL.ThemCTHD(cthd);
    }

    //Hàm kiểm tra trùng lặp chi tiết hóa đơn
    public static boolean TrungLapCTHD(int idSP, int maHD) {
        boolean ketQua = ChiTietHoaDonDAL.TrungCTHD(idSP, maHD);

        return ketQua;
    }

    /*
    Hàm sửa chi tiết hóa đơn
     */
    public static void SuaCTHD(ChiTietHoaDon cthd) {
        ChiTietHoaDonDAL.SuaCTHD(cthd);
    }

    //Hàm xóa chi tiết hóa đơn theo mã hóa đơn và id sản phẩm
    public static void XoaCoDieuKienCTHD(int maHD, int idSP) {
        ChiTietHoaDonDAL.XoaCTHDTheoIDSanPhamVaMaHD(maHD, idSP);
    }

    //Hàm lấy mã của chi tiết hóa đơn theo mã hóa đơn và id sản phẩm
    public static int LayMaCTHD(int maHD, int idSP) {
        int maCTHD = ChiTietHoaDonDAL.LayMaCTHD(maHD, idSP);

        return maCTHD;
    }

    //Hàm trả về tất cả dữ liệu của chi tiết hóa đơn trong DB
    public static ResultSet LayTatCaThongTinCTHD() {
        ResultSet rs = ChiTietHoaDonDAL.LayTatCaThongTinCTHD();
        return rs;
    }

    //Hàm đổ dữ liệu từ rs --> bảng tạm @table
    public static void DoDuLieu(ResultSet rs, JTable table) {
        SanPham sp;
        Object[] objs = new Object[]{"STT", "Mã chi tiết hóa đơn", "Mã hóa đơn", "Tên sản phẩm",
            "Đơn vị tính", "Đơn giá", "Số lượng", "Thành tiền", "Ghi chú"};
        DefaultTableModel tableModel = new DefaultTableModel(objs, 0);
        table.setModel(tableModel);

        try {
            while (rs.next()) {
                sp = LayDuLieuTheoMaSP(rs.getInt("MaSP"));
                Object[] item = new Object[9];
                item[0] = table.getRowCount() + 1;
                item[1] = rs.getInt("MaChiTietHD");
                item[2] = rs.getInt("MaHD");
                item[3] = sp.getTenSP();
                item[4] = sp.getDonViTinh();
                item[4] = sp.getGiaBan();
                item[6] = rs.getInt("SoLuong");
                item[7] = rs.getString("ThanhTien");
                item[8] = rs.getString("GhiChu");

                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    //Hàm tìm kiếm theo mã hóa đơn
    public static ResultSet TimKiemTheoMaHD(int maHD) {
        ResultSet rs = ChiTietHoaDonDAL.TimKiemTheoMaHD(maHD);
        return rs;
    }
}
