package BLL;

import static BLL.ThongBao_ChuyenDoi.*;
import DAL.NhanVienDAL;
import DTO.CaLamViecDTO;
import DTO.ChucVuDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import DTO.NhanVien;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;

/**
 *
 * @author MinhNguyen 23/08/2016
 */
public class NhanVienBLL {

    /*
    Hàm kiểm tra tất cả thông tin nhân viên
    Sau đó trả về True - False
     */
    public static boolean KiemTraThongTin(NhanVien nv) {
        boolean ketQua = true, kTDT = true, kTCMND = true, kTLuong = true;
        if (nv.getHoTen().trim().equals("")) {
            ThongBao("Vui lòng nhập tên nhân viên !", "Thông báo", 1);
            return false;
//        } 
//        else if (!KiemTraChu(nv.getHoTen())) {
//            ThongBao("Tên chỉ chứa chữ !", "Thông báo", 1);
//            return false;
        } else if (nv.getNgaySinh().trim().equals("")) {
            ThongBao("Vui lòng chọn ngày sinh !", "Thông báo", 1);
            return false;
        } else if (nv.getDiaChi().trim().equals("")) {
            ThongBao("Vui lòng nhập địa chỉ !", "Thông báo", 1);
            return false;
        } else if (nv.getSdt().trim().equals("")) {
            ThongBao("Vui lòng nhập số điện thoại !", "Thông báo", 1);
            return false;
        } else if (nv.getSdt().length() > 11 || nv.getSdt().length() < 10) {
            ThongBao("Số điện thoại chỉ từ 10 - 11 kí tự số !", "Thông báo", 1);
            return false;
        } else if (nv.getSdt().length() < 12) {
            String tbSDT = "";
            for (int i = 0; i < nv.getSdt().length(); i++) {
                if (!KiemTraSo(nv.getSdt().charAt(i) + "")) {
                    tbSDT = "Số điện thoại phải là số !";
                    ketQua = false;
                    kTDT = false;
                }
            }
            if (!tbSDT.equals("")) {
                ThongBao(tbSDT, "Thông báo", 1);
            }
        }
        if (kTDT) {
            if (nv.getNgayVaoLam().trim().equals("")) {
                ThongBao("Vui lòng chọn ngày vào làm !", "Thông báo", 1);
                return false;
            } else if (nv.getEmail().trim().equals("")) {
                ThongBao("Vui lòng nhập email !", "Thông báo", 1);
                return false;
            } else if (!CheckEmail(nv.getEmail())) {
                ThongBao("Email không hợp lệ. Ex: abc@xyz.kj !", "Thông báo", 1);
                return false;
            } else if (nv.getCmnd().trim().equals("")) {
                ThongBao("Vui lòng nhập chứng minh nhân dân !", "Thông báo", 1);
                return false;
            } else if (nv.getCmnd().length() != 9) {
                ThongBao("CMND chỉ có 9 kí tự số !", "Thông báo", 1);
                return false;
            } else if (nv.getCmnd().length() == 9) {
                String tbCMND = "";
                for (int i = 0; i < nv.getCmnd().length(); i++) {
                    if (!KiemTraSo(nv.getCmnd().charAt(i) + "")) {
                        tbCMND = "CMND phải là kí tự số !";
                        ketQua = false;
                        kTCMND = false;
                    }
                }
                if (!tbCMND.equals("")) {
                    ThongBao(tbCMND, "Thông báo", 1);
                }
            }
        }
        if (kTCMND && kTDT) {
            if (nv.getNgayCap().trim().equals("")) {
                ThongBao("Vui lòng chọn ngày cấp cmnd !", "Thông báo", 1);
                return false;
            } else if (nv.getNoicap().trim().equals("")) {
                ThongBao("Vui lòng nhập nơi cấp cmnd !", "Thông báo", 1);
                return false;
            } else if (nv.getLuongNV().trim().equals("")) {
                ThongBao("Vui lòng nhập lương nhân viên !", "Thông báo", 1);
                return false;
            } else if (!nv.getLuongNV().trim().equals("")) {
                String tbLuong = "";
                for (int i = 0; i < nv.getLuongNV().length(); i++) {
                    if (!KiemTraSo(nv.getLuongNV().charAt(i) + "")) {
                        tbLuong = "Lương phải là kí tự số !";
                        ketQua = false;
                    }
                }
                if (!tbLuong.equals("")) {
                    ThongBao(tbLuong, "Thông báo", 1);
                }
            }
        }
        if (ketQua) {
            ThongBao("Thành công !", "Thông báo", 1);
        }

        return ketQua;
    }

    /*
    Hàm thêm nhân viên
    Đầu vào là đối tượng Nhân viên - @nv
    Thực hiện thêm dữ liệu vào trong DB
     */
    public static void ThemNhanVien(NhanVien nv) {
        //Thực hiện nếu kiểm tra đầy đủ sẽ sửa nhân viên
        if (KiemTraThongTin(nv)) {
            //Gọi hàm để thêm dữ liệu
//            NhanVienDAL.ThemNhanVien(nv);
        }
    }

    /*
    Hàm sửa nhân viên
    Đầu vào là đối tượng Nhân viên - @nv
    Thực hiện sửa trong DB
     */
    public static void SuaNhanVien(NhanVien nv) {
        //Thực hiện nếu kiểm tra đầy đủ sẽ sửa nhân viên
        if (KiemTraThongTin(nv)) {
            //Gọi hàm để sửa dữ liệu
            NhanVienDAL.SuaNhanVien(nv);
        }
    }

    /*
    Hàm xóa nhân viên
    Thực hiện xóa các bản ghi được chọn
     */
    public static void XoaNhanVien(JTable table) {
        //Mảng index lưu các hàng được chọn trong table
        int[] mangIndex = table.getSelectedRows();

        //Kiểm tra nếu độ dài mảng = 0, thông báo cho người dùng biết
        if (mangIndex.length == 0) {
            ThongBao("Bạn chưa chọn bản ghi nào để xóa.", "Thông báo", 1);
            //Ngược lại sẽ thực hiện gọi hàm XoaNhanVien từ DAL để xóa trong CSDL
        } else {
            //Hàm này để lưu mã của những nhân viên bị xóa
            String dem = "";

            //Dùng vòng lặp xét các vị trí trong mảng trên
            for (int i = 0; i < mangIndex.length; i++) {
                //Tạo ra mã nhân viên từ vị trí trong mảng
                String maNV = table.getValueAt(mangIndex[i], 1).toString();

                //Gọi hàm xóa nhân viên với mã nhân viên - @maNV trên
                NhanVienDAL.XoaNhanVien(maNV);

                dem += maNV + ", ";
            }
            //Hàm xử lý chuỗi mã các nhân viên bị xóa trên - @dem
            String strChuoiMa = dem.substring(0, dem.length() - 2);

            //Cuối cùng thông báo các nhân viên bị xóa
            ThongBao(mangIndex.length + " bản ghi đã được xóa." + "\nMã nhân viên gồm : " + strChuoiMa + ".",
                    "Thông báo", 1);
        }
    }

    /*
    Hàm trả về tất cả dữ liệu nhân viên có trong DB
     */
    public static ResultSet LayThongTinNhanVien() {
        ResultSet rs;
        rs = NhanVienDAL.LayTatCaThongTinNhanVien();

        return rs;
    }
      public static ResultSet LayThongTinChucVu() {
        ResultSet rs;
        rs = NhanVienDAL.LayDuLieuChucVu();

        return rs;
    }

    /*
    Hàm đổ dữ liệu vào bảng
    Tạo 1 bảng mẫu sau đó đổ dữ liệu vào
     */
    public static void DoDuLieuNhanVien(ResultSet rs, JTable table) {
        Object[] objs = new Object[]{"STT", "ID nhân viên", "Tên nhân viên", "Giới tính",
            "Ngày sinh", "Địa chỉ", "Số điện thoại", "Ngày vào làm", "Ghi chú", "Quyền"};
        DefaultTableModel tableModel = new DefaultTableModel(objs, 0);
        table.setModel(tableModel);

        try {
            while (rs.next()) {
                Object[] item = new Object[11];
                item[0] = table.getRowCount() + 1;
                item[1] = rs.getInt("IDNhanVien");
                item[2] = rs.getString("TenNhanVien");
                item[3] = GioiTinhText(rs.getInt("GioiTinh"));
                item[4] = DinhDangNgay(rs.getDate("NgaySinh"));
                item[5] = rs.getString("DiaChi");
                item[6] = rs.getString("SoDienThoai");
                item[7] = DinhDangNgay(rs.getDate("NgayVaoLam"));
                item[8] = rs.getString("GhiChu");
                item[9] = LayTenQuyen(rs.getInt("Quyen"));
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    /*
    Hàm tìm kiếm nhân viên
    Trả về dữ liệu vừa tìm kiếm
     */
    public static ResultSet TimKiemNhanVien(String tuKhoa) {
        ResultSet rs = NhanVienDAL.LayDuLieuTimKiem(tuKhoa);
        return rs;
    }

    public static String LayAnh(String maNV) {
        String fileAnh = NhanVienDAL.LayAnhNhanVien(maNV);

        return fileAnh;
    }

    /*
    Hàm kiểm tra trùng lặp tên đăng nhập
     */
    public static boolean TrungLapTenDangNhap(String tenDN) {
        boolean ketQua = NhanVienDAL.TrungLapTenDangNhap(tenDN);

        return ketQua;
    }

    //Hàm trả về đối tượng là tất cả thông tin của nhân viên  theo mã truyền vào
    public static NhanVien LayThongTinTheoID(String maNV) {
        NhanVien nv = NhanVienDAL.LayThongTinTheoID(maNV);
        return nv;
    }

    //Hàm kiểm tra đăng nhập trả về kết quả true false
    public static boolean KiemTraDangNhap(String tenDN, String mK) {
        boolean ketQua = NhanVienDAL.KiemTraDN(tenDN, mK);
        return ketQua;
    }

    //Hàm trả về tên nhân viên theo ID truyền vào
    public static String LayTenNhanVienTheoID(int idNV) {
        String tenNV = NhanVienDAL.LayTenNhanVienTheoID(idNV);

        return tenNV;
    }

    /*
    Hàm đổ dữ liệu vào bảng quản lý tài khoản
    Tạo 1 bảng mẫu sau đó đổ dữ liệu vào
     */
    public static void DoDuLieuVaoQLTaiKhoan(ResultSet rs, JTable table) {
        Object[] objs = new Object[]{"STT", "Mã người dùng", "Tên người dùng", "Tên đăng nhập", "Mật khẩu", "Quyền"};

        DefaultTableModel tableModel = new DefaultTableModel(objs, 0);
        table.setModel(tableModel);

        try {
            while (rs.next()) {
                Object[] item = new Object[6];
                item[0] = table.getRowCount() + 1;
                item[1] = rs.getInt("IDNhanVien");
                item[2] = rs.getString("TenNhanVien");
                item[3] = rs.getString("TenDangNhap");
                item[4] = rs.getString("MatKhau");
                item[5] = LayTenQuyen(rs.getInt("Quyen"));

                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public static void SuaTaiKhoanNguoiDung(String tenDN, String matKhau, int Quyen, int maND) {
        NhanVienDAL.SuaTaiKhoanNguoiDung(tenDN, matKhau, Quyen, maND);
        ThongBao("Thành công !", "Thông báo", 1);
    }

    //To van Tu
    public static ResultSet LayNhanVien() {
        ResultSet rs = NhanVienDAL.LayThongTinNhanVien();
        return rs;
    }

    public static void DoDuLieu(ResultSet rs, JTable table) {
        Object[] obj = new Object[]{"STT", "IDNV", "HoTen", "NgaySinh", "DienThoai", "DiaChi", "ChucVu", "GioiTinh", "NgayVaoLam", "CMND", "NgayCap", "Email", "Luong", "NoiCap", "GhiChu"};
        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
        table.setModel(tableModel);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            while (rs.next()) {
                Object[] item = new Object[15];
                item[0] = table.getRowCount() + 1;
                item[1] = rs.getInt("idnhanvien");
                item[2] = rs.getString("hoten");
                item[3] = sdf.format(rs.getDate("ngaysinh"));
                item[4] = rs.getString("sdt");
                item[5] = rs.getString("diachi");
                item[6] = LayTenQuyen(rs.getInt("chucvu"));
                String gioitinh = "Nữ";
                if (rs.getInt("GIOITINH") == 1) {
                    gioitinh = "Nam";
                }
                item[7] = gioitinh;
                item[8] = sdf.format(rs.getDate("ngayvaolam"));
                item[9] = rs.getString("cmnd");
                item[10] = sdf.format(rs.getDate("ngaycap"));

                item[11] = rs.getString("email");
                item[12] = rs.getString("luongnv");
                item[13] = rs.getString("noicap");
                item[14] = rs.getString("ghichu");
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public static String LayTenQuyen(int maquyen) {
        String tenquyen = "";
        ResultSet rs = NhanVienDAL.LayTenQuyen(maquyen);
        try {
            while (rs.next()) {
                tenquyen = rs.getString("tenchucvu");
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return tenquyen;
    }

    public static ResultSet LayQuyen() {
        ResultSet rs = NhanVienDAL.LayDuLieuQuyen();
        return rs;
    }

    public static void SuaChucVu(ChucVuDTO cv) {
        NhanVienDAL.SuaChucVu(cv);
        ThongBao("Thành công !", "Thông báo", 1);

    }

    public static void ThemChucVu(ChucVuDTO cv) {
        NhanVienDAL.ThemChucVu(cv);
        ThongBao("Thành công !", "Thông báo", 1);
    }

    public static void ThemCaLamViec(CaLamViecDTO clv) {
        NhanVienDAL.ThemCaLamViec(clv);
        ThongBao("Thành công !", "Thông báo", 1);
    }

    public static void SuaCaLamViec(CaLamViecDTO clv) {
        NhanVienDAL.SuaCaLamViec(clv);
        ThongBao("Thành công !", "Thông báo", 1);
    }

    public static void XoaCaLamViec(String id) {
        NhanVienDAL.XoaCaLamViec(id);
        ThongBao("Thành công !", "Thông báo", 1);
    }

    public static ResultSet LayTatCaDuLieuChucVu() {
        ResultSet rs;
        rs = NhanVienDAL.LayDuLieuChucVu();
        return rs;
    }
    
    public static ResultSet LayTatCaDuLieuCaLamViec() {
        ResultSet rs;
        rs = NhanVienDAL.LayDuLieuCaLamViec();
        return rs;
    }

    public static void DoDuLieuChucVu(ResultSet rs, JTable table) {
        Object[] objs = new Object[]{"Id Chức Vụ", "Tên Chức Vụ", "Mô Tả",};
        DefaultTableModel tableModel = new DefaultTableModel(objs, 0);
        table.setModel(tableModel);

        try {
            while (rs.next()) {
                Object[] item = new Object[4];
                item[0] = table.getRowCount() + 1;
                item[1] = rs.getInt("idchucvu");
                item[2] = rs.getString("tenchucvu");
                item[3] = rs.getString("mota");
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public static void DoDuLieuCaLamViec(ResultSet rs, JTable table) {
        Object[] objs = new Object[]{"STT","ID Ca Làm Việc", "Mã Ca", "Tên Ca", "Giờ Bắt Đầu", "Giờ Kết Thúc", "Ghi Chú"};
        DefaultTableModel tableModel = new DefaultTableModel(objs, 0);
        table.setModel(tableModel);

        try {
            while (rs.next()) {
                Object[] item = new Object[7];
                item[0] = table.getRowCount() + 1;
                item[1] = rs.getInt("idcalamviec");
                item[2] = rs.getString("maca");
                item[3] = rs.getString("tenca");
                item[4] = rs.getString("giobatdau");
                item[5] = rs.getString("gioketthuc");
                item[6] = rs.getString("ghichu");
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
