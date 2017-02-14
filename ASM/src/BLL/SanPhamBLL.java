package BLL;

import static BLL.ThongBao_ChuyenDoi.*;
import DAL.SanPhamDAL;
import static DAL.SanPhamDAL.KiemTraTrungIDSanPham;
import DTO.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MinhNguyen 25/08/2016
 */
public class SanPhamBLL {

    /*
    Hàm kiểm tra tất cả thông tin nhập
    Sau đó trả về True - False
     */
    public static boolean KiemTraSanPham(String txtIDSP, String txtTenSP, String txtGiaNhap,
            String txtGiaBan, String txtDonVi, String soLuong) {
        boolean ketQua = true;

        if (txtIDSP.equals("")) {
            ThongBao("Vui lòng nhập id sản phẩm !", "Thông báo", 1);
            return false;
        }else if(KiemTraTrungIDSanPham(txtIDSP)){
            ThongBao("ID này đã tồn tại !", "Thông báo", 0);
            return false;
        } else if (txtTenSP.equals("")) {
            ThongBao("Vui lòng nhập tên sản phẩm !", "Thông báo", 1);
            return false;
        } else if (txtGiaNhap.equals("")) {
            ThongBao("Vui lòng nhập giá nhập !", "Thông báo", 1);
            return false;
        } else if (!KiemTraSo(txtGiaNhap)) {
            ThongBao("Giá nhập là 1 con số !", "Thông báo", 1);
            return false;
        } else if (Double.parseDouble(txtGiaNhap) <= 0) {
            ThongBao("Giá nhập phải lớn hơn 0 !", "Thông báo", 1);
            return false;
        }else if (soLuong.equals("")) {
            ThongBao("Vui lòng nhập số lượng !", "Thông báo", 1);
            return false;
        }else if(!KiemTraSo(soLuong)){
            ThongBao("Số lượng phải là 1 con số !", "Thông báo", 1);
            return false;
        } else if (txtGiaBan.equals("")) {
            ThongBao("Vui lòng nhập giá bán !", "Thông báo", 1);
            return false;
        } else if (!KiemTraSo(txtGiaBan)) {
            ThongBao("Giá bán là 1 con số !", "Thông báo", 1);
            return false;
        } else if (Double.parseDouble(txtGiaBan) <= 0) {
            ThongBao("Giá bán phải lớn hơn 0 !", "Thông báo", 1);
            return false;
        } else if (Double.parseDouble(txtGiaBan) <= Double.parseDouble(txtGiaNhap)) {
            ThongBao("Giá bán phải lớn hơn giá nhập !", "Thông báo", 1);
            return false;
        } else if (txtDonVi.equals("")) {
            ThongBao("Vui lòng nhập đơn vị tính !", "Thông báo", 1);
            return false;
        }else if(!KiemTraChu(txtDonVi)){
            ThongBao("Đơn vị tính chỉ chứa chữ !", "Thông báo", 1);
            return false;
        }
        return ketQua;
    }

    /*
    Hàm thêm sản phẩm
    Đầu vào là đối tượng sản phẩm - @sp
    Thực hiện thêm dữ liệu vào trong DB
     */
    public static void ThemSanPham(SanPham sp) {
        SanPhamDAL.ThemSanPham(sp);
        ThongBao("Thêm thành công !", "Thong báo", 1);
    }

    /*
    Hàm sửa sản phẩm
    Đầu vào là đối tượng sản phẩm - @sp
    Thực hiện sửa trong DB
     */
    public static void SuaSanPham(SanPham sp) {
        SanPhamDAL.SuaSanPham(sp);
        ThongBao("Sửa thành công !", "Thong báo", 1);
    }

    /*
    Hàm xóa sản phẩm
    Thực hiện xóa các bản ghi được chọn
     */
    public static void XoaSanPham(JTable table) {
        //Mảng index lưu các hàng được chọn trong table
        int[] mangIndex = table.getSelectedRows();

        //Kiểm tra nếu độ dài mảng = 0, thông báo cho người dùng biết
        if (mangIndex.length == 0) {
            ThongBao("Bạn chưa chọn bản ghi nào để xóa.", "Thông báo", 1);
            //Ngược lại sẽ thực hiện gọi hàm XoaSanPham từ DAL để xóa trong CSDL
        } else {
            //Hàm này để lưu mã của những sản phẩm bị xóa
            String dem = "";

            //Dùng vòng lặp xét các vị trí trong mảng trên
            for (int i = 0; i < mangIndex.length; i++) {
                //Tạo ra mã nhân viên từ vị trí trong mảng
                String maXoa = table.getValueAt(mangIndex[i], 1).toString();

                //Gọi hàm xóa sản phẩm với mã sản phẩm - @maXoa trên
                SanPhamDAL.XoaSanPham(maXoa);

                dem += maXoa + ", ";
            }
            //Hàm xử lý chuỗi mã các sản phẩm bị xóa trên - @dem
            String strChuoiMa = dem.substring(0, dem.length() - 2);

            //Cuối cùng thông báo các mã bị xóa
            ThongBao(mangIndex.length + " bản ghi đã được xóa." + "\nMã sản phẩm gồm : " + strChuoiMa + ".",
                    "Thông báo", 1);
        }
    }

    /*
     * Hàm lấy dữ liệu từ ResultSet -> đổ vào Jtable
     *
     * @param rs
     * @param tableTam
     */
    public static void DoDuLieuVaoJTableSanPhamHoaDon(ResultSet rs, JTable tableTam) {
        Object[] objs = new Object[]{"ID", "Tên sản phẩm", "Giảm", "Giá bán", "Số lượng",};
        DefaultTableModel tableModel = new DefaultTableModel(objs, 0);
        tableTam.setModel(tableModel);

        try {
            while (rs.next()) {
                Object[] item = new Object[5];
                item[0] = rs.getString("IDSanPham");
                item[1] = rs.getString("TenSanPham");
                item[2] = rs.getInt("GiamGia");
                item[3] = TienVietNam(rs.getDouble("GiaBan"));
                item[4] = rs.getInt("SoLuong");

                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    /*
    Hàm trả về dữ liệu của bảng sản phẩm
     */
    public static ResultSet LayTatCaSanPham() {
        ResultSet rs;
        rs = SanPhamDAL.LayTatCaThongTinSanPham();
        return rs;
    }

    public static void DoDuLieu(ResultSet rs, JTable table) {
        Object[] objs = new Object[]{"STT", "Mã sản phẩm", "ID sản phẩm", "Tên sản phẩm",
            "Giá nhập", "Giá bán", "Giảm giá", "Số lượng", "Đơn vị tính", "Loại sản phẩm", "Mô tả"};
        DefaultTableModel tableModel = new DefaultTableModel(objs, 0);
        table.setModel(tableModel);

        try {
            while (rs.next()) {
                Object[] item = new Object[11];
                item[0] = table.getRowCount() + 1;
                item[1] = rs.getInt("MaSP");
                item[2] = rs.getString("IDSanPham");
                item[3] = rs.getString("TenSanPham");
                item[4] = TienVietNam(rs.getDouble("GiaNhap"));
                item[5] = TienVietNam(rs.getDouble("GiaBan"));
                item[6] = rs.getInt("GiamGia");
                item[7] = rs.getInt("SoLuong");
                item[8] = rs.getString("DonViTinh");
                item[9] = LoaiSanPhamBLL.LayTenLoai(rs.getInt("LoaiSanPham"));
                item[10] = rs.getString("MoTa");
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    /*
    Hàm trả về dữ liệu sản phẩm được tìm kiếm
    Đầu vào là từ khóa
    Đầu ra trả về dữ liệu vừa tìm kiếm
     */
    public static ResultSet TimKiemSanPham(String tuKhoa) {
        ResultSet rs;
        rs = SanPhamDAL.TimSanPham(tuKhoa);

        return rs;
    }

    /*
    Hàm lấy thông tin của từng sản phẩm theo mã tương ứng
    Kiểm tra trước khi cho chạy hàm
     */
    public static SanPham LaySanPhamTheoMa(String maSP) {
        SanPham sp = new SanPham();
        if (!maSP.equals("")) {
            sp = SanPhamDAL.LayDuLieuTheoIDSanPham(maSP);
        } else {
            ThongBao("Chưa chọn sản phẩm !", "Thông báo ", 0);
        }

        return sp;
    }

    public static void TruSoLuongSanPham(int soLuongCu, int soLuongMoi, int maSP) {
        int tongSoLuong = soLuongCu - soLuongMoi;

        SanPhamDAL.SuaSoLuongSP(tongSoLuong, maSP);
    }
//    
    /*
     * Hàm lấy dữ liệu từ ResultSet -> đổ vào Jtable
     *
     * @param rs
     * @param tableTam
     */
    public static void DoDuLieuVaoJTableSanPhamPhieuNhap(ResultSet rs, JTable tableTam) {
        Object[] objs = new Object[]{"ID", "Tên sản phẩm", "Đơn giá"};
        DefaultTableModel tableModel = new DefaultTableModel(objs, 0);
        tableTam.setModel(tableModel);

        try {
            while (rs.next()) {
                Object[] item = new Object[3];
                item[0] = rs.getString("IDSanPham");
                item[1] = rs.getString("TenSanPham");
//                item[2] = rs.getInt("GiamGia");
                item[2] = TienVietNam(rs.getDouble("GiaNhap"));
//                item[4] = rs.getInt("SoLuong");

                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
