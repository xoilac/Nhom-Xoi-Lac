package BLL;

import static BLL.ThongBao_ChuyenDoi.*;

/**
 *
 * @author MinhNguyen
 */
public class DoiMatKhauBLL {

    /*
    Hàm kiểm tra mật khẩu với 4 tham số đầu vào
    @mkCu - mật khẩu cũ
    @mkMoi - mật khẩu mới
    @nhapLai - nhập lại mật khẩu mới
    @soSahMK - kết quả so sánh mật khẩu hiện tại và mật khẩu nhập vào
    */
    public static boolean KiemTraDoiMatKhau(String mkCu, String mkMoi, String nhapLai, boolean soSanhMK) {
        boolean ketQua = true;
        if (mkCu.equals("")) {
            ThongBao("Vui lòng nhập mật khẩu cũ !", "Thông báo", 1);
            return false;
        } else if (!soSanhMK) {
            ThongBao("Mật khẩu cũ không chính xác !", "Thông báo", 1);
            return false;
        }else if(mkMoi.equals("")){
            ThongBao("Vui lòng nhập mật khẩu mới !", "Thông báo", 1);
            return false;
        }else if(mkMoi.equals(mkCu)){
            ThongBao("Mật khẩu mới không được giống với mật khẩu hiện tại !", "Thông báo", 0);
            return false;
        } else if (!CheckLettersAndNumbers(mkMoi)) {
            ThongBao("Mật khẩu phải có chữ và số !", "Thông báo", 1);
            return false;
        } else if (mkMoi.length() < 7 || mkMoi.length() > 20) {
            ThongBao("Mật khẩu phải phải trên 6 và dưới 20 kí tự !", "Thông báo", 1);
            return false;
        } else if (!nhapLai.equals(mkMoi)) {
            ThongBao("Nhập lại không trùng khớp !", "Thông báo", 1);
            return false;
        }

        return ketQua;
    }
}
