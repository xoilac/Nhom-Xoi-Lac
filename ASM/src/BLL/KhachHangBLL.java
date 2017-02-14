package BLL;

import static BLL.ThongBao_ChuyenDoi.*;
import DAL.KhachHangDAL;
import DAL.NhanVienDAL;
import DTO.KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MinhNguyen
 */
public class KhachHangBLL {

    /*
    Hàm kiểm tra thông tin nhập
    Trả về True - false
    */
    public static boolean KiemTra(KhachHang kh) {
        boolean ketQua = true;
        if (kh.getTenKH().equals("")) {
            ThongBao("Vui lòng nhập tên !", "Thông báo", 1);
            return false;
        } else if (!KiemTraChu(kh.getTenKH())) {
            ThongBao("Tên chỉ chứa chữ !", "Thông báo", 1);
            return false;
        } else if (kh.getNgaySinh().equals("")) {
            ThongBao("Vui lòng nhập ngày sinh !", "Thông báo", 1);
            return false;
        } else if (kh.getSDT().equals("")) {
            ThongBao("Vui lòng nhập số điện thoại !", "Thông báo", 1);
            return false;
        } else if (!kh.getSDT().matches(".*[0.9].*")) {
            ThongBao("Số điện thoại chỉ chứa số !", "Thông báo", 1);
            return false;
        } else if (kh.getSDT().length() < 10 || kh.getSDT().length() > 11) {
            ThongBao("Điện thoại có độ dài 11 hoặc 10 số !", "Thông báo", 1);
            return false;
        } else if (kh.getDiaChi().equals("")) {
            ThongBao("Vui lòng nhập địa chỉ !", "Thông báo", 1);
            return false;
        }

        return ketQua;
    }

    /*
    Hàm thêm khách hàng
    Đầu vào là đối tượng khách hàng - @kh
    Thực hiện thêm dữ liệu vào trong DB
     */
    public static void ThemKhachHang(KhachHang kh) {
        if (KiemTra(kh)) {
            KhachHangDAL.ThemKhachHang(kh);
            ThongBao("Thêm thành công !", "Thong báo", 1);
        }
    }

    /*
    Hàm xóa khách hàng
    Thực hiện xóa các bản ghi được chọn
     */
    public static void XoaKhachHang(JTable table) {
        //Mảng index lưu các hàng được chọn trong table
        int[] mangIndex = table.getSelectedRows();

        //Kiểm tra nếu độ dài mảng = 0, thông báo cho người dùng biết
        if (mangIndex.length == 0) {
            ThongBao("Bạn chưa chọn bản ghi nào để xóa.", "Thông báo", 1);
            //Ngược lại sẽ thực hiện gọi hàm XoaKhachHang từ DAL để xóa trong CSDL
        } else {
            //Hàm này để lưu mã bị xóa
            String dem = "";

            //Dùng vòng lặp xét các vị trí trong mảng trên
            for (int i = 0; i < mangIndex.length; i++) {
                //Tạo ra mã khách hàng từ vị trí trong mảng
                String maKH = table.getValueAt(mangIndex[i], 1).toString();

                //Gọi hàm xóa khách hàng với mã khách hàng - @maKH trên
                KhachHangDAL.XoaKhachHang(maKH);

                dem += maKH + ", ";
            }
            //Hàm xử lý chuỗi mã các khách hàng bị xóa trên - @dem
            String strChuoiMa = dem.substring(0, dem.length() - 2);

            //Cuối cùng thông báo các khách hàng bị xóa
            ThongBao(mangIndex.length + " bản ghi đã được xóa." + "\nMã khách hàng gồm : " + strChuoiMa + ".",
                    "Thông báo", 1);
        }
    }
    
    /*
    Hàm sửa khách hàng
    Đầu vào là đối tượng khách hàng - @kh
    Thực hiện sửa dữ liệu vào trong DB
     */
    public static void SuaKhachHang(KhachHang kh) {
        if (KiemTra(kh)) {
            KhachHangDAL.SuaKhachHang(kh);
            ThongBao("Sửa thành công !", "Thông báo", 1);
        }
    }

    /*
    Hàm lấy dữ liệu từ bên ngoài rồi đổ vào bảng tạm
    Trả về bảng là dữ liệu được truyền vào
    */
    public static void DoDuLieu(ResultSet rs, JTable table) {
        Object[] objs = new Object[]{"STT", "Mã KH", "Tên KH", "Địa chỉ", "Giới tính", "Số điện thoại", "Ngày sinh", "Loại khách hàng", "Ghi chú"};
        DefaultTableModel tableModel = new DefaultTableModel(objs, 0);
        table.setModel(tableModel);

        try {
            while (rs.next()) {
                Object[] item = new Object[9];
                item[0] = table.getRowCount() + 1;
                item[1] = rs.getInt("MaKH");
                item[2] = rs.getString("TenKhachHang");
                item[3] = rs.getString("DiaChi");
                item[4] = GioiTinhText(rs.getInt("GioiTinh"));
                item[5] = rs.getString("sodienthoai");
                item[6] = DinhDangNgay(rs.getDate("NgaySinh"));
                item[7] = rs.getString("LoaiKhachHang");
                item[8] = rs.getString("GhiChu");

                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    /*
    Hàm trả về  tất cả dữ liệu khách hàng
    */
    public static ResultSet LayTatCaDuLieu() {
        ResultSet rs;
        rs = KhachHangDAL.LayTatCaThongTinKhachHang();
        return rs;
    }

    /*
    Hàm trả về dữ liệu khách hàng được tìm kiếm theo từ khóa 
    */
    public static ResultSet LayDuLieuTimKiem(String tuKhoa) {
        ResultSet rs = KhachHangDAL.TimKiemKhachHang(tuKhoa);
        return rs;
    }
    
    /*
    Hàm trả về thông tin của khách hàng theo mã được truyền vào
    */
    public static KhachHang LayThongTinKhachHangTheoMa(String MaKH){
        KhachHang kh = KhachHangDAL.LayThongTinKhachHangTheoMaKH(MaKH);
        return kh;
    }
    
    //Hàm trả về tên khách hàng theo mã truyền vào
    public static String LayTenKhachHangTheoMa(int maKH) {
        String tenKH = KhachHangDAL.LayTenKhachHangTheoMa(maKH);

        return tenKH;
    }
}
