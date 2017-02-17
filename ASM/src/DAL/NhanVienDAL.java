package DAL;

import DTO.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                + "email, luongnv, hinhanh, ghichu)\n" +
"values ('"+nv.getHoTen()+"', STR_TO_DATE('"+nv.getNgaySinh()+"','%d/%m/%Y'), '"+nv.getSdt()+"', '"+nv.getDiaChi()+"',"
                + " '"+nv.getChucVu()+"', b'"+nv.isGioiTinh()+"', STR_TO_DATE('"+nv.getNgayVaoLam()+"','%d/%m/%Y'),"
                + " '"+nv.getCmnd()+"', STR_TO_DATE('"+nv.getNgayCap()+"','%d/%m/%Y'), '', '', '"+nv.getEmail()+"',"
                + " '"+nv.getLuongNV()+"', '"+nv.getHinhAnh()+"', '"+nv.getGhiChu()+"');";
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
        System.out.println(cauTruyVan);
    }

    /*
    Hàm truy vấn sửa nhân viên trong DB
    Tham số truyền vào là đối tượng nhân viên - @NhanVienDTO
     */
    public static void SuaNhanVien(NhanVien nv) {
        String cauTruyVan = "set dateformat dmy Update NhanVien\n"
                + "  set TenNhanVien = N'" + nv.getTenNhanVien() + "', GioiTinh = " + nv.getGioiTinh() + ", "
                + "NgaySinh = '" + nv.getNgaySinh() + "', DiaChi = N'" + nv.getDiaChi() + "', "
                + "SoDienThoai = '" + nv.getSDT() + "', NgayVaoLam = '" + nv.getNgayVaoLam() + "', TenDangNhap = '" + nv.getTenDangNhap() + "', "
                + "MatKhau = '" + nv.getMatKhau() + "', GhiChu = N'" + nv.getGhiChu()
                + "', Quyen = " + nv.getQuyen() + ", HinhAnh = '" + nv.getHinhAnh() + "' \n"
                + "  where IDNhanVien = " + nv.getMaNhanVien();
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
        System.out.println(cauTruyVan);
    }


    /*
    Hàm truy vấn xóa nhân viên trong DB
    Tham số truyền vào là id của nhân viên - @idNhanVien
     */
    public static void XoaNhanVien(String idNhanVien) {
        String cauTruyVan = "Delete NhanVien where IDNhanVien = " + idNhanVien;
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
                nv.setMaNhanVien(rs.getInt("IDNhanVien"));
                nv.setTenNhanVien(rs.getString("TenNhanVien"));
                nv.setTenDangNhap(rs.getString("TenDangNhap"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setSDT(rs.getString("SoDienThoai"));
                nv.setNgaySinh(rs.getString("NgaySinh"));
                nv.setNgayVaoLam(rs.getString("NgayVaoLam"));
                nv.setQuyen(rs.getInt("Quyen"));
                nv.setHinhAnh(rs.getString("HinhAnh"));
                nv.setGioiTinh(rs.getInt("GioiTinh"));
                nv.setGhiChu(rs.getString("GhiChu"));
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
    public static ResultSet LayThongTinNhanVien(){
        ResultSet rs;
        String CTV="select * from nhanvien";
        rs=ConnectionDB.ExecuteQueryGetTable(CTV);
        return rs;
    }
    public static ResultSet LayTenQuyen(int maquyen){
       
        String cauTruyVan="select tenchucvu from chucvu where idchucvu = "+maquyen;
        ResultSet rs=ConnectionDB.ExecuteQueryGetTable(cauTruyVan);
        return rs;
    }
    public static ResultSet LayDuLieuQuyen(){ 
        String CTV="select * from chucvu";
        ResultSet rs=ConnectionDB.ExecuteQueryGetTable(CTV);
        return rs;
        
    }
}
