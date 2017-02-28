package DAL;

import DTO.ChucVuDTO;
import DTO.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MinhNguyen 23/08/2016
 */
public class NhanVienDAL {

    public static int iQuyenND = 0;
    public static int maNguoiTao = 0;

    /*
    Hàm truy vấn thêm nhân viên trong DB
    Tham số truyền vào là đối tượng nhân viên - @NhanVienDTO
     */
    public static void ThemNhanVien(NhanVien nv) {
        String cauTruyVan = "insert into nhanvien(hoten, ngaysinh, sdt, diachi, "
                + "chucvu, gioitinh, ngayvaolam, cmnd, ngaycap, tendn, matkhau, "
                + "email, luongnv, hinhanh, ghichu)\n"
                + "values ('" + nv.getHoTen() + "', STR_TO_DATE('" + nv.getNgaySinh() + "','%d/%m/%Y'), '" + nv.getSdt() + "', '" + nv.getDiaChi() + "',"
                + " '" + nv.getChucVu() + "', b'" + nv.isGioiTinh() + "', STR_TO_DATE('" + nv.getNgayVaoLam() + "','%d/%m/%Y'),"
                + " '" + nv.getCmnd() + "', STR_TO_DATE('" + nv.getNgayCap() + "','%d/%m/%Y'), '', '', '" + nv.getEmail() + "',"
                + " '" + nv.getLuongNV() + "', '" + nv.getHinhAnh() + "', '" + nv.getGhiChu() + "');";
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
        System.out.println(cauTruyVan);
    }

    /*
    Hàm truy vấn sửa nhân viên trong DB
    Tham số truyền vào là đối tượng nhân viên - @NhanVienDTO
     */
    public static void SuaNhanVien(NhanVien nv) {
        String cauTruyVan = "Update nhanvien set hoten = '" + nv.getHoTen() + "', ngaysinh = STR_TO_DATE('" + nv.getNgaySinh() + "','%d/%m/%Y'),"
                + " sdt = '" + nv.getSdt() + "', diachi = N'" + nv.getDiaChi() + "', chucvu = '" + nv.getChucVu() + "', gioitinh = b'" + nv.isGioiTinh() + "',"
                + " ngayvaolam = STR_TO_DATE('" + nv.getNgayVaoLam() + "','%d/%m/%Y'),cmnd = '" + nv.getCmnd() + "',"
                + " ngaycap = STR_TO_DATE('" + nv.getNgayCap() + "','%d/%m/%Y'),  email = '" + nv.getEmail() + "', luongnv = '" + nv.getLuongNV() + "',"
                + " hinhanh = '" + nv.getHinhAnh() + "', ghichu = '" + nv.getGhiChu() + "',"
                + "noicap='" + nv.getNoicap() + "'  where idnhanvien = " + nv.getIdNhanVien() + "";
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
        System.out.println(cauTruyVan);
    }

    /*
    Hàm truy vấn xóa nhân viên trong DB
    Tham số truyền vào là id của nhân viên - @idNhanVien
     */
    public static void XoaNhanVien(String idNhanVien) {
        String cauTruyVan = " delete from NhanVien where idNhanVien = " + idNhanVien;
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
    }

    /*
    Hàm lấy tất cả thông tin của nhân viên
    Vì lấy hết nên không cần tham số đầu vào
    Trả về dữ liệu của nhân viên từ DB
     */
    public static ResultSet LayTatCaThongTinNhanVien() {
        ResultSet rs;
        String cauTruyVan = "Select * from NhanVien";
        rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);

        return rs;
    }

    /*
    Hàm lấy dữ liệu được tìm kiếm
    Tham số đầu vào là từ khóa tím kiếm
    Trả về dữ liệu được tìm kiếm
     */
    public static ResultSet LayDuLieuTimKiem(String tuKhoa) {
        ResultSet rs;
        String cauTruyVan = "Select * from NhanVien where TenNhanVien like N'%" + tuKhoa + "%' or "
                + "DiaChi like N'%" + tuKhoa + "%' or GhiChu like N'%" + tuKhoa + "%'";
        rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);

        return rs;
    }

    /*
    Hàm trả về file ảnh của nhân viên với tham số đầu vào là mã
     */
    public static String LayAnhNhanVien(String maNV) {
        String cauTruyVan = "Select * from NhanVien where IDNhanVien = " + maNV;
        ResultSet rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);
        String fileAnh = "";
        try {
            if (rs.next()) {
                fileAnh = rs.getString("HinhAnh");
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return fileAnh;
    }

    /*
    Hàm kiểm tra trùng lặp tên đăng nhập của nhân viên
    Trả về true nếu tên đăng nhập đã tồn tại
     */
    public static boolean TrungLapTenDangNhap(String tenDN) {
        boolean ketQua = false;
        String cauTruyVan = "Select * from NhanVien where TenDangNhap = '" + tenDN + "'";
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

    /*
    Hàm lấy tất cả thông tin của nhân viên có mã trùng với mã truyền vào
    Trả về đối tượng được gán các thông tin vừa được tìm
     */
    public static NhanVien LayThongTinTheoID(String maNV) {
        String cauTruyVan = "Select * from NhanVien where IDNhanVien = " + maNV;
        ResultSet rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);
        NhanVien nv = new NhanVien();
        try {
            while (rs.next()) {
                nv.setIdNhanVien(rs.getInt("idNhanVien"));
                nv.setHoTen(rs.getString("hoTen"));
                nv.setTenDN(rs.getString("tenDN"));
                nv.setMatKhau(rs.getString("matKhau"));
                nv.setDiaChi(rs.getString("diaChi"));
                nv.setSdt(rs.getString("sdt"));
                nv.setNgaySinh(rs.getString("ngaySinh"));
                nv.setNgayVaoLam(rs.getString("ngayVaoLam"));
                nv.setChucVu(rs.getInt("chucVu"));
                nv.setHinhAnh(rs.getString("HinhAnh"));
                nv.setGioiTinh(rs.getInt("gioiTinh"));
                nv.setGhiChu(rs.getString("ghiChu"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return nv;
    }

    /*
    Hàm kiểm tra đăng nhập dựa vào tên đăng nhập @tenDN và mật khẩu @mK
    Trả về true nếu tồn tại và ngược lại là false
     */
    public static boolean KiemTraDN(String tenDN, String mK) {
        boolean blnKetQua = false;

        String cauTruyVan = "Select * from NhanVien where tenDN = '" + tenDN + "' and matKhau = '" + mK + "' ";
        ResultSet rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);

        try {
            if (rs.next()) {
                maNguoiTao = rs.getInt("idNhanVien");
                //   iQuyenND = rs.getInt("Quyen");//
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return blnKetQua;
    }

    //Hàm trả về tên nhân viên theo id truyền vào
    public static String LayTenNhanVienTheoID(int idNV) {
        String tenNV = "";
        String cauTruyVan = "Select * from NhanVien where IDNhanVien = " + idNV;
        ResultSet rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);
        try {
            if (rs.next()) {
                tenNV = rs.getString("TenNhanVien");
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return tenNV;
    }

    /*
    Hàm sửa tài khoản theo tên đăng nhập, mật khẩu và tên người dùng
     */
    public static void SuaTaiKhoanNguoiDung(String tenDN, String matKhau, int Quyen, int maND) {
        String cauTruyVan = "Update NhanVien set TenDangNhap = '" + tenDN + "', MatKhau = '" + matKhau + "', Quyen = " + Quyen + ""
                + "where IDNhanVien = " + maND + "";
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
    }

    public static ResultSet LayThongTinNhanVien() {
        ResultSet rs;
        String CTV = "select * from nhanvien";
        rs = ConnectionDB.ExecuteQueryGetTable(CTV);
        return rs;
    }

    public static ResultSet LayTenQuyen(int maquyen) {

        String cauTruyVan = "select tenchucvu from chucvu where idchucvu = " + maquyen;
        ResultSet rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);
        return rs;
    }

    public static ResultSet LayDuLieuQuyen() {
        String CTV = "select * from chucvu";
        ResultSet rs = ConnectionDB.ExecuteQueryGetTable(CTV);
        return rs;

    }

    public static void SuaChucVu(ChucVuDTO cv) {
        String cauTruyVan = "Update chucvu set tenchucvu  = = '" + cv.getTenChucVu()+ "' , mota = '" + cv.getGhiChu()+  "' where idchucvu = "+cv.getIdChucVu();
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
        System.out.println(cauTruyVan);
    }
    
    public static void ThemChucVu(ChucVuDTO cv) {
        String cauTruyVan = "insert into chucvu(tenchucvu, mota) "
                 + "values ('" + cv.getTenChucVu()+ "', '" + cv.getGhiChu() + "');";
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
        System.out.println(cauTruyVan);
    }
  
    public static ResultSet LayDuLieuChucVu() {
        String CTV = "select * from chucvu";
        ResultSet rs = ConnectionDB.ExecuteQueryGetTable(CTV);
        return rs;
    }

}
