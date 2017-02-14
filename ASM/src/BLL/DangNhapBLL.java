package BLL;

import DAL.NhanVienDAL;

/**
 *
 * @author MinhNguyen
 */
public class DangNhapBLL {

    public static boolean KiemTraDangNhap(String tenDN, String mK) {
        boolean ketQua = true;
        if (tenDN.equals("") || mK.equals("")) {
            ThongBao_ChuyenDoi.ThongBao("Vui lòng nhập tài khoản và mật khẩu", "Thông báo", 1);
            return false;
        } else if (!NhanVienBLL.KiemTraDangNhap(tenDN, mK)) {
            ThongBao_ChuyenDoi.ThongBao("Tài khoản hoặc mật khẩu sai !", "Thông báo lỗi", 0);
            return false;
        } else {
            ThongBao_ChuyenDoi.ThongBao("Đăng nhập thành công !", "Thông báo", 1);
            if (NhanVienDAL.iQuyenND == 1) {
                ThongBao_ChuyenDoi.ThongBao("Bạn đã đăng nhập với quyền ADMIN !", "Thông báo", 1);
            } else {
                ThongBao_ChuyenDoi.ThongBao("Bạn đã đăng nhập với quyền Con gà !", "Thông báo", 1);
            }
            
        }

        return ketQua;
    }
}
