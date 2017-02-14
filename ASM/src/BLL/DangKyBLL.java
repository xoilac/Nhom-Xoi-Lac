package BLL;

import static BLL.ThongBao_ChuyenDoi.*;

/**
 *
 * @author MinhNguyen
 */
public class DangKyBLL {
    public static boolean KiemTraDangKy(String tenDN, String matKhau, String nhacLaiMK){
        boolean ketQua = true;
        if(tenDN.equals("")){
            ThongBao("Vui lòng nhập tên đăng nhập !", "Thông báo", 1);
            return false;
        }else if(CheckSpecialCharacters(tenDN)){
            ThongBao("Tên đăng nhập không chứa ký tự đặc biệt !", "Thông báo", 1);
            return false;
        }else if(tenDN.length() < 7 || tenDN.length() >20){
            ThongBao("Tên đăng nhập phải trên 6 và dưới 20 kí tự !", "Thông báo", 1);
            return false;
        }else if(NhanVienBLL.TrungLapTenDangNhap(tenDN)){
            ThongBao("Tên đăng nhập đã có người sử dụng !", "Thông báo", 1);
            return false;
        }else if(matKhau.equals("")){
            ThongBao("Vui lòng nhập mật khẩu !", "Thông báo", 1);
            return false;
        }else if(!CheckLettersAndNumbers(matKhau)){
            ThongBao("Mật khẩu phải có chữ và số !", "Thông báo", 1);
            return false;
        }else if(matKhau.length() <7 || matKhau.length() > 20){
            ThongBao("Mật khẩu phải phải trên 6 và dưới 20 kí tự !", "Thông báo", 1);
            return false;
        }else if(!nhacLaiMK.equals(matKhau)){
            ThongBao("Nhập lại mật khẩu không trùng khớp !", "Thông báo", 1);
            return false;
        }
        return ketQua;
    }
}
