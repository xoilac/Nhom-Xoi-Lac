package DAL;

import DTO.HoaDon;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MinhNguyen 23/08/2016
 */
public class HoaDonDAL {

    //Hàm thực hiện thêm dữ liệu vào DB
    public static void ThemHoaDon(HoaDon hd) {
        String cauTruyVan = "set dateformat dmy Insert HoaDon(SoHoaDon, NgayTaoHD, KhachHang, NhanVienTao, NhanVienBan, TongTien, TrangThai, GhiChu)\n"
                + "  values('" + hd.getSoHD() + "', '" + hd.getNgayTaoHD() + "', " + hd.getKhachHang() + ", " + hd.getNhanVienTao() + ", "
                + "" + hd.getNhanVienBan() + ", " + hd.getTongTien() + ", N'" + hd.getTrangThai() + "', N'" + hd.getGhiChu() + "')";
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
    }
    //Hàm thực hiện sửa dữ liệu vào DB

    public static void SuaHoaDon(HoaDon hd) {
        String cauTruyVan = "Update HoaDon set KhachHang = " + hd.getKhachHang() + ", NhanVienBan = " + hd.getNhanVienBan() + ","
                + " TrangThai = N'" + hd.getTrangThai() + "', GhiChu = N'" + hd.getGhiChu() + "', TongTien = " + hd.getTongTien() + " "
                + "where MaHoaDon = " + hd.getMaHD();
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
    }
    //Hàm thực hiện xóa dữ liệu theo id hóa đơn truyền vào

    public static void XoaHoaDon(String idHoaDon) {
        String cauTruyVan = "";
        cauTruyVan += "Delete ChiTietHoaDon where MaHD = " + idHoaDon;
        cauTruyVan += "Delete HoaDon where MaHoaDon = " + idHoaDon;
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
    }

    //Hàm trả về tất cả thông tin hóa đơn trong DB
    public static ResultSet LayTatCaThongTinHoaDon() {
        ResultSet rs;
        String cauTruyVan = "Select * from HoaDon";

        rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);

        return rs;
    }

    //Hàm lấy mã hóa đơn theo số hóa đơn truyền vào
    public static int LayMaHD(String soHoaDon) {
        ResultSet rs;
        int maHD = 0;
        String SQLSelect = "select * from HoaDon where SoHoaDon = '" + soHoaDon + "'";
        rs = ConnectionDB.ExecuteQueryGetTable(SQLSelect);
        try {
            while (rs.next()) {
                maHD = rs.getInt("MaHoaDon");
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return maHD;
    }

    //Hàm kiểm tra trùng lặp theo số hóa đơn 
    public static boolean TrungLapHoaDon(String soHoaDon) {
        boolean ketQua = false;
        String cauTruyVan = "Select SoHoaDon from HoaDon where SoHoaDon = '" + soHoaDon + "'";
        ResultSet rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);
        try {
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return ketQua;
    }

    //Hàm thực hiện lấy dữ liệu có điều kiện là khoảng thời gian
    public static ResultSet ThongKeTheoNgay(String ngayBatDau, String ngayKetThuc) {
        String cauTruyVan = "Select * from HoaDon where convert(varchar,NgayTaoHD,103) "
                + "between '" + ngayBatDau + "' and '" + ngayKetThuc + "' and TrangThai like N'%đã hoàn%'";
        ResultSet rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);
        return rs;
    }

    //Hàm thực hiện lấy dữ liệu hóa đơn có trạng thái đã hoàn thành
    public static ResultSet LayHoaDonDaHoanThanh() {
        String cauTruyVan = "Select * from HoaDon where TrangThai like N'%đã hoàn thành%'";
        ResultSet rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);

        return rs;
    }

    //Hàm lấy dữ liệu tìm kiếm theo từ khóa truyền vào
    public static ResultSet TimKiemDuLieu(String tuKhoa) {
        String cauTruyVan = "Select * from HoaDon where TrangThai like N'%" + tuKhoa + "%' or GhiChu like N'%" + tuKhoa + "%'";
        ResultSet rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);

        return rs;
    }
}
