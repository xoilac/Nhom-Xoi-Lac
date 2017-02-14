/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import static BLL.ThongBao_ChuyenDoi.ThongBao;
import DAL.LoaiSanPhamDAL;
import DTO.LoaiSanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MinhNguyen
 */
public class LoaiSanPhamBLL {
    /*
    Hàm kiểm tra thông tin trả về true - false
    */

    public static boolean KiemTra(LoaiSanPham lsp) {
        boolean ketQua = true;
        if (lsp.getTenLoaiSP().equals("")) {
            ThongBao("Vui lòng nhập tên loại !", "Thông báo", 1);
            return false;
        } else {
            ThongBao("Thành công", "Thông báo", 1);
        }
        return ketQua;
    }

    /*
    Hàm thêm dữ liệu trong DB
    Thực hiện kiểm tra sau đó thêm
    */
    public static void ThemDuLieu(LoaiSanPham lsp) {
        if (KiemTra(lsp)) {
            LoaiSanPhamDAL.ThemLoaiSanPham(lsp);
        }
    }

    /*
    Hàm sửa dữ liệu trong DB
    Thực hiện kiểm tra sau đó sửa
    */
    public static void SuaDuLieu(LoaiSanPham lsp) {
        if (KiemTra(lsp)) {
            LoaiSanPhamDAL.ThemLoaiSanPham(lsp);
        }
    }

    /*
    Hàm xóa loại sản phẩm
    Thực hiện xóa các bản ghi được chọn
     */
    public static void XoaDuLieu(JTable table) {
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

                //Gọi hàm xóa loại sản phẩm với mã nhà loại - @maXoa trên
                LoaiSanPhamDAL.XoaLoaiSanPham(maXoa);

                dem += maXoa + ", ";
            }
            //Hàm xử lý chuỗi mã bị xóa trên - @dem
            String strChuoiMa = dem.substring(0, dem.length() - 2);

            //Cuối cùng thông báo các loại bị xóa
            ThongBao(mangIndex.length + " bản ghi đã được xóa." + "\nMã loại gồm : " + strChuoiMa + ".",
                    "Thông báo", 1);
        }
    }

    /*
    Hàm thực hiện lấy tên loại sản phẩm dựa vào mã loại
     */
    public static String LayTenLoai(int maLoai) {
        String tenLoai = LoaiSanPhamDAL.LayTenLoai(maLoai);

        return tenLoai;
    }

    /*
    Hàm lấy tất cả dữ liệu đổ vào @rs
     */
    public static ResultSet LayTatCaDuLieu() {
        ResultSet rs = LoaiSanPhamDAL.LayTatCaThongTinLoaiSanPham();
        return rs;
    }
    
    /*
    Hàm trả về dữ liệu tìm kiếm theo từ khóa
    */
    public static ResultSet TimKiemDuLieu(String tuKhoa){
        ResultSet rs = LoaiSanPhamDAL.TimKiemDuLieu(tuKhoa);
        
        return rs;
    }

    /*
    Hàm đổ dữ liệu @rs vào bảng tạm @table
     */
    public static void DoDuLieu(ResultSet rs, JTable table) {
        Object[] objs = new Object[]{"STT", "Mã loại", "Tên loại", "Ghi chú"};
        DefaultTableModel tableModel = new DefaultTableModel(objs, 0);
        table.setModel(tableModel);

        try {
            while (rs.next()) {
                Object[] item = new Object[4];
                item[0] = table.getRowCount() + 1;
                item[1] = rs.getInt("MaLoai");
                item[2] = rs.getString("TenLoai");
                item[3] = rs.getString("GhiChu");

                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
