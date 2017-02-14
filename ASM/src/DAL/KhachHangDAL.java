package DAL;

import DTO.KhachHang;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MinhNguyen 23/08/2016
 */
public class KhachHangDAL {

    //Hàm thêm dữ liệu trong DB theo đối tượng truyền vào
    public static void ThemKhachHang(KhachHang kh) {
        String cauTruyVan = "set dateformat dmy "
                + "insert into KhachHang(TenKhachHang,DiaChi,GioiTinh,SoDienThoai,LoaiKhachHang,GhiChu, NgaySinh) "
                + "values(N'" + kh.getTenKH() + "',N'" + kh.getDiaChi() + "'," + kh.getGioiTinh() + ",'"
                + kh.getSDT() + "',N'" + kh.getLoaiKH() + "','" + kh.getGhiChu() + "', '" + kh.getNgaySinh() + "')";
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
    }

    //Hàm sửa dữ liệu trong DB theo đối tượng truyền vào
    public static void SuaKhachHang(KhachHang kh) {
        String cauTruyVan = "set dateformat dmy update KhachHang set TenKhachHang=N'" + kh.getTenKH()
                + "',DiaChi=N'" + kh.getDiaChi() + "',GioiTinh=" + kh.getGioiTinh() + ","
                + "SoDienThoai='" + kh.getSDT() + "',LoaiKhachHang=N'" + kh.getLoaiKH()
                + "',GhiChu=N'" + kh.getGhiChu() + "', NgaySinh = '" + kh.getNgaySinh() + "' where MaKH=" + kh.getMaKH();
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
    }

    //Hàm xóa dữ liệu trong DB theo id truyền vào
    public static void XoaKhachHang(String idKhachHang) {
        String cauTruyVan = "delete KhachHang where MaKH=" + idKhachHang;
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
    }
    
    //Hàm trả về tất cả thông tin khách hàng trong DB
    public static ResultSet LayTatCaThongTinKhachHang() {
        ResultSet rs;
        String cauTruyVan = "Select * from KhachHang";

        rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);

        return rs;
    }
    
    //Hàm trả về dữ liệu khách hàng được tìm kiếm theo từ khóa truyền vào
    public static ResultSet TimKiemKhachHang(String tuKhoa) {
        ResultSet rs;
        String cauTruyVan = "Select * from KhachHang where TenKhachHang like N'%" + tuKhoa + "%' "
                + "or DiaChi like N'%" + tuKhoa + "%' or GhiChu like N'%" + tuKhoa + "%'";
        rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);

        return rs;
    }

    /*
   Hàm thực hiện lấy tất cả thông tin của khách hàng theo mã truyền vào
   Trả về đối tượng khách hàng KhachHang là các thông tin đó
     */
    public static KhachHang LayThongTinKhachHangTheoMaKH(String MaKH) {
        ResultSet rs;
        String SQLSelect = "select * from KhachHang where MaKH = " + MaKH;
        rs = ConnectionDB.ExecuteQueryGetTable(SQLSelect);

        KhachHang kh = new KhachHang();

        try {
            while (rs.next()) {

                kh.setMaKH(rs.getInt("MaKH"));
                kh.setTenKH(rs.getString("TenKhachHang"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setGioiTinh(rs.getInt("GioiTinh"));
                kh.setSDT(rs.getString("SoDienThoai"));
                kh.setLoaiKH(rs.getString("LoaiKhachHang"));
                kh.setGhiChu(rs.getString("GhiChu"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return kh;
    }

    //Hàm trả về tên khách hàng theo mã truyền vào
    public static String LayTenKhachHangTheoMa(int maKH) {
        String tenNV = "";
        String cauTruyVan = "Select * from KhachHang where MaKH = " + maKH;
        ResultSet rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);
        try {
            if (rs.next()) {
                tenNV = rs.getString("TenKhachHang");
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return tenNV;
    }
}
