package BLL;

import static BLL.ThongBao_ChuyenDoi.*;
import DAL.NhaCungCapDAL;
import DTO.NhaCungCap;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MinhNguyen 25/08/2016
 */
public class NhaCungCapBLL {

    /*
    Hàm kiểm tra thông tin trả về true - false
     */
    public static boolean KiemTra(NhaCungCap ncc) {
        boolean ketQua = true;
        if (ncc.getTenNhaCungCap().equals("")) {
            ThongBao("Vui lòng nhập tên !", "Thông báo", 1);
            return false;
        } else if (!KiemTraChu(ncc.getTenNhaCungCap())) {
            ThongBao("Tên chỉ chứa chữ !", "Thông báo", 1);
            return false;
        } else if (ncc.getSDT().equals("")) {
            ThongBao("Vui lòng nhập số điện thoại !", "Thông báo", 1);
            return false;
        } else if (ncc.getSDT().length() < 10 || ncc.getSDT().length() > 11) {
            ThongBao("Điện thoại có độ dài 11 hoặc 10 số !", "Thông báo", 1);
            return false;
        } else if (!ncc.getSDT().matches(".*[0-9].*")) {
            ThongBao("Số điện thoại chỉ chứa số !", "Thông báo", 1);
            return false;
        } else if (ncc.getDiaChi().equals("")) {
            ThongBao("Vui lòng nhập địa chỉ !", "Thông báo", 1);
            return false;
        } else if (ncc.getThanhPho().equals("")) {
            ThongBao("Vui lòng nhập thành phố !", "Thông báo", 1);
            return false;
        }

        return ketQua;
    }

    /*
    Hàm thực hiện thêm nhà cung cấp vào DB
     */
    public static void ThemNhaCungCap(NhaCungCap ncc) {
        if (KiemTra(ncc)) {
            NhaCungCapDAL.ThemNhaCungCap(ncc);
            ThongBao("Thêm thành công !", "Thong báo", 1);
        }
    }

    /*
    Hàm xóa nhà cung cấp
    Thực hiện xóa các bản ghi được chọn
     */
    public static void XoaNhaCungCap(JTable table) {
        //Mảng index lưu các hàng được chọn trong table
        int[] mangIndex = table.getSelectedRows();

        //Kiểm tra nếu độ dài mảng = 0, thông báo cho người dùng biết
        if (mangIndex.length == 0) {
            ThongBao("Bạn chưa chọn bản ghi nào để xóa.", "Thông báo", 1);
            //Ngược lại sẽ thực hiện gọi hàm XoaNhaCungCap từ DAL để xóa trong CSDL
        } else {
            //Hàm này để lưu mã bị xóa
            String dem = "";

            //Dùng vòng lặp xét các vị trí trong mảng trên
            for (int i = 0; i < mangIndex.length; i++) {
                //Tạo ra các mã từ vị trí trong mảng
                String maXoa = table.getValueAt(mangIndex[i], 1).toString();

                //Gọi hàm xóa nhà cung cấp với mã nhà cung cấp - @maXoa trên
                NhaCungCapDAL.XoaNhaCungCap(maXoa);

                dem += maXoa + ", ";
            }
            //Hàm xử lý chuỗi mã bị xóa trên - @dem
            String strChuoiMa = dem.substring(0, dem.length() - 2);

            //Cuối cùng thông báo các nhà cung cấp bị xóa
            ThongBao(mangIndex.length + " bản ghi đã được xóa." + "\nMã nhà cung cấp gồm : " + strChuoiMa + ".",
                    "Thông báo", 1);
        }
    }

    //Hàm thực hiện sửa dữ liệu trong DB
    public static void SuaNhaCungCap(NhaCungCap ncc) {
        if (KiemTra(ncc)) {
            NhaCungCapDAL.SuaNhaCungCap(ncc);
            ThongBao("Sửa thành công !", "Thông báo", 1);
        }
    }

    //Hàm đổ dữ liệu từ rs --> bảng tạm @table
    public static void DoDuLieu(ResultSet rs, JTable table) {
        Object[] objs = new Object[]{"STT", "Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ",
            "Số điện thoại", "Thành phố", "Ghi chú"};
        DefaultTableModel tableModel = new DefaultTableModel(objs, 0);
        table.setModel(tableModel);

        try {
            while (rs.next()) {
                Object[] item = new Object[7];
                item[0] = table.getRowCount() + 1;
                item[1] = rs.getInt("MaNhaCungCap");
                item[2] = rs.getString("TenNhaCungCap");
                item[3] = rs.getString("DiaChi");
                item[4] = rs.getString("sodienthoai");
                item[5] = rs.getString("ThanhPho");
                item[6] = rs.getString("GhiChu");

                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    //Hàm trả về tất cả dữ liệu nhà cung cấp trong DB
    public static ResultSet LayTatCaDuLieu() {
        ResultSet rs;
        rs = NhaCungCapDAL.LayTatCaThongTinNhaCungCap();
        return rs;
    }

    //Hàm trả về dữ liệu tìm kiếm theo từ khóa
    public static ResultSet LayDuLieuTimKiem(String tuKhoa) {
        ResultSet rs = NhaCungCapDAL.TimKiemThongTin(tuKhoa);
        return rs;
    }

    /*
    Hàm trả về thông tin của khách hàng theo mã được truyền vào
     */
    public static NhaCungCap LayThongTinNhaCungCapTheoMa(String MaKH) {
        NhaCungCap ncc = NhaCungCapDAL.LayThongTinKhachHangTheoMaKH(MaKH);
        return ncc;
    }
}
