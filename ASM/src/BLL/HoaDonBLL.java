/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import static BLL.KhachHangBLL.LayTenKhachHangTheoMa;
import static BLL.NhanVienBLL.LayTenNhanVienTheoID;
import static BLL.ThongBao_ChuyenDoi.*;
import DAL.HoaDonDAL;
import DTO.HoaDon;
import DTO.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CuongNP
 */
public class HoaDonBLL {

    //Hàm thực hiện thêm hóa đơn
    public static void ThemHoaDon(HoaDon hd) {
        HoaDonDAL.ThemHoaDon(hd);
        ThongBao("Thanh toán thành công !", "Thông báo", 1);
    }

    //Hàm thực hiện sửa hóa đơn
    public static void SuaHoaDon(HoaDon hd) {
        HoaDonDAL.SuaHoaDon(hd);
    }

    //Hàm thực hiện lấy mã hóa đơn theo số hóa đơn 
    public static int LayMaHD(String soHoaDon) {
        int maHD = HoaDonDAL.LayMaHD(soHoaDon);

        return maHD;
    }

    //Hàm tạo số hóa đơn 
    public static String CreateSoHoaDon() {
        Date CurrentDate = new Date();

        String dateCode = new SimpleDateFormat("ddMMyyhhmmss").format(CurrentDate);
        String SoHoaDon = "HD" + dateCode;
        return SoHoaDon;
    }

    /*
    Hàm kiểm tra nhập trước thêm
    Trả về kết quả true - false
     */
    public static boolean KiemTraNhapSanPham(String[] info, int soLuongKho) {
        boolean ketQua = true;
        try {
            if (info[1].equals("")) {
                ThongBao("Bạn chưa nhập số lượng !",
                        "Thông báo", 1);
                return false;
                //Xét điều kiện giới hạn nhập
            } else if (Integer.parseInt(info[1]) > soLuongKho) {
                ThongBao("Bạn đã nhập vượt quá số lượng trong kho. \n Số lượng trong kho hiện tại là : " + soLuongKho, "Thông báo", 0);
                return false;
            } else if (Integer.parseInt(info[1]) <= 0) {
                ThongBao("Số lượng phải lớn hơn 0 ", "Thông báo", 1);
                return false;
            }
        } catch (NumberFormatException e) {
            ThongBao("Số lượng phải là số !", "Thông báo", 1);
            return false;
        } catch (NullPointerException e) {
            ThongBao("Đã hủy ! ", "Thông báo ", 1);
            return false;
        }
        return ketQua;
    }

    //Hàm tạo bảng nhập số lượng sản phẩm vào trong chi tiết hóa đơn
    public static String[] InputDialogSoLuongSanPham(String tieuDe, String maSP, int soLuongKho) {
        boolean ketQua = true;
        String[] info = new String[3];
        JLabel lblMaSP = new JLabel();
        lblMaSP.setText(maSP);
        JTextField txtSoLuong = new JTextField();
        txtSoLuong.setText("1");
        JTextField txtGhiChu = new JTextField();

        Object[] message = {
            "Mã sản phẩm:", lblMaSP,
            "Nhập số lượng:", txtSoLuong,
            "Nhập ghi chú:", txtGhiChu,};
        //Biến lưu frame nhập thông tin kiểu OK - Cancel
        int option = JOptionPane.showConfirmDialog(new JFrame(), message, tieuDe, JOptionPane.OK_CANCEL_OPTION);
        //Xét điều kiện 
        if (option == JOptionPane.OK_OPTION) {
            info[0] = lblMaSP.getText();
            info[1] = txtSoLuong.getText();
            info[2] = txtGhiChu.getText();
        } else {
            info = null;
        }
        return info;
    }

    //Hàm thêm đổ dữ liệu vào bảng chi tiết hóa đơn
    public static void ThemSanPhamVaoCTHD(SanPham sp, JTable tableCTHD, int SoLuong, String ghiChu) {
        double ThanhTien = SoLuong * sp.getGiaBan();

        DefaultTableModel tableModel = (DefaultTableModel) tableCTHD.getModel();

        Object[] item = new Object[8];

        item[0] = tableCTHD.getRowCount() + 1;
        item[1] = sp.getTenSP();
        item[2] = sp.getDonViTinh();
        item[3] = TienVietNam(sp.getGiaBan());
        item[4] = SoLuong;
        item[5] = TienVietNam(ThanhTien);
        item[6] = ghiChu;
        item[7] = sp.getIdSP();

        tableModel.addRow(item);
    }

    //Hàm tính tổng tiền dựa vào bảng và cột truyền vào
    //trả về tổng tiền vừa tính
    public static Double TinhTongTien(JTable tableCTHD, int chiSoCotThanhTien) {
        double tongTien = 0;
        for (int i = 0; i < tableCTHD.getRowCount(); i++) {
            tongTien += Double.parseDouble(DoiDeThem(tableCTHD.getValueAt(i, chiSoCotThanhTien).toString()));
        }

        return tongTien;
    }

    //Hàm xóa bản ghi theo điều kiện
    public static void RemoveRow(JTable table, int index) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.removeRow(index);
    }

    //Hàm xóa tất cả bản ghi trong bảng table
    public static void RemoveAllRow(int gioiHan, JTable table) {
        for (int i = gioiHan - 1; i >= 0; i--) {
            HoaDonBLL.RemoveRow(table, i);
        }
    }

    //Hàm tìm vị trí trùng lặp 
    //Trả về vị trí bị trùng 
    public static int TrungLapSanPham(JTable table, String maSP) {
        int viTriTrung = -1;
        for (int i = 0; i < table.getRowCount(); i++) {
            String IDSanPhamTable = table.getValueAt(i, 7).toString();

            if (IDSanPhamTable.equals(maSP)) {
                viTriTrung = i;
            }
        }
        return viTriTrung;
    }

    //Hàm thêm sản phẩm trùng lặp vào chi tiết hóa đơn
    public static void ThemSanPhamTrung(JTable table, int viTriTrung, int SoLuong) {
        int SoLuongHienTai = (int) table.getValueAt(viTriTrung, 4);

        int tongSoLuong = SoLuongHienTai + SoLuong;

        table.setValueAt(tongSoLuong, viTriTrung, 4);

        String strDonGia = DoiDeThem(table.getValueAt(viTriTrung, 3).toString());

        double donGia = Double.parseDouble(strDonGia);
        double thanhTien = donGia * tongSoLuong;

        String strThanhTien = TienVietNam(thanhTien);

        table.setValueAt(strThanhTien, viTriTrung, 5);
    }

    //Hàm kiểm tra trùng lặp hóa đơn dựa vào số hóa đơn truyền
    //Trả về kết quả true - false
    public static boolean TrungLapHoaDon(String soHoaDon) {
        boolean ketQua = HoaDonDAL.TrungLapHoaDon(soHoaDon);

        return ketQua;
    }

    //Hàm tạo bảng nhập để sửa bản ghi trong bảng chi tiết hóa đơn
    public static String[] InputDialogChiTietHoaDon(String tieuDe, String sTT,
            String soLuong, String ghiChu) {

        String[] info = new String[3];
        JLabel lblSTT = new JLabel();
        lblSTT.setText(sTT);
        JTextField txtSoLuong = new JTextField();
        txtSoLuong.setText(soLuong);

        JTextField txtGhiChu = new JTextField();
        txtGhiChu.setText(ghiChu);

        Object[] message = {
            "Số thứ tự:", lblSTT,
            "Nhập số lượng:", txtSoLuong,
            "Nhập ghi chú:", txtGhiChu,};

        int option = JOptionPane.showConfirmDialog(new JFrame(), message, tieuDe, JOptionPane.OK_CANCEL_OPTION);

        //Xét điều kiện rỗng
        if (option == JOptionPane.OK_OPTION) {

            info[0] = lblSTT.getText();
            info[1] = txtSoLuong.getText();
            info[2] = txtGhiChu.getText();
        } else {
            info = null;
        }

        return info;
    }

    /*
    Hàm sửa chi tiết hóa đơn theo vị trí tương ứng
    Các tham số đầu vào gồm bảng tạm @table
    vị trí cần sửa @viTriSua
    số lượng nhập vào @soLuong
    ghi chú nhập vào @ghiChu
     */
    public static void SuaCTHD(JTable table, int viTriSua, int SoLuong, String ghiChu) {

        table.setValueAt(SoLuong, viTriSua, 4);

        String cotDonGia = DoiDeThem(table.getValueAt(viTriSua, 3).toString());
        double donGia = Double.parseDouble(cotDonGia);
        double thanhTien = donGia * SoLuong;

        table.setValueAt(TienVietNam(thanhTien), viTriSua, 5);

        table.setValueAt(ghiChu, viTriSua, 6);
    }

    /*
    Hàm thống kê hóa đơn theo ngày truyền vào
     */
    public static ResultSet ThongKeTheoNgay(String ngayBatDau, String ngayKetThuc) {
        ResultSet rs = HoaDonDAL.ThongKeTheoNgay(ngayBatDau, ngayKetThuc);
        return rs;
    }

    /*
    Hàm đổ dữ liệu từ rs vào bảng tạm @table trong form thống kê
     */
    public static void DoDuLieuVaoBangThongKe(ResultSet rs, JTable table) {
        Object[] objs = new Object[]{"STT", "Mã hóa đơn", "Ngày tạo", "Tổng tiền", "Ghi chú", "Trạng thái"};
        DefaultTableModel tableModel = new DefaultTableModel(objs, 0);
        table.setModel(tableModel);

        try {
            while (rs.next()) {
                Object[] item = new Object[6];
                item[0] = table.getRowCount() + 1;
                item[1] = rs.getInt("MaHoaDon");
                item[2] = DinhDangNgay(rs.getDate("NgayTaoHD"));
                item[3] = TienVietNam(rs.getDouble("TongTien"));
                item[4] = rs.getString("GhiChu");
                item[5] = rs.getString("TrangThai");

                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    /*
    Hàm trả về tất cả dữ liệu hóa đơn trong DB
     */
    public static ResultSet LayTatCaThongTinHoaDon() {
        ResultSet rs = HoaDonDAL.LayTatCaThongTinHoaDon();
        return rs;
    }

    /*
    Hàm trả về dữ liệu các hóa đơn đã hoàn thành
     */
    public static ResultSet LayHoaDonDaHoanThanh() {
        ResultSet rs = HoaDonDAL.LayHoaDonDaHoanThanh();
        return rs;
    }

    //Hàm thực hiện tìm kiếm dữ liệu 
    //Trả về dữ liệu vừa tìm kiếm
    public static ResultSet TimKiemDuLieu(String tuKhoa) {
        ResultSet rs = HoaDonDAL.TimKiemDuLieu(tuKhoa);
        return rs;
    }

    /*
    Hàm đổ dữ liệu từ rs vào bảng tạm @table=
     */
    public static void DoDuLieu(ResultSet rs, JTable table) {
        Object[] objs = new Object[]{"STT", "Mã hóa đơn", "Số hóa đơn", "Ngày tạo", "Khách hàng",
            "Nhân viên tạo", "Nhân viên bán", "Tổng tiền", "Ghi chú", "Trạng thái"};
        DefaultTableModel tableModel = new DefaultTableModel(objs, 0);
        table.setModel(tableModel);

        try {
            while (rs.next()) {
                Object[] item = new Object[10];
                item[0] = table.getRowCount() + 1;
                item[1] = rs.getInt("MaHoaDon");
                item[2] = rs.getString("SoHoaDon");
                item[3] = rs.getDate("NgayTaoHD");
                item[4] = LayTenKhachHangTheoMa(rs.getInt("KhachHang"));
                item[5] = LayTenNhanVienTheoID(rs.getInt("NhanVienTao"));
                item[6] = LayTenNhanVienTheoID(rs.getInt("NhanVienBan"));
                item[7] = TienVietNam(rs.getDouble("TongTien"));
                item[8] = rs.getString("GhiChu");
                item[9] = rs.getString("TrangThai");

                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    /*
    Hàm xóa hóa đơn
    Thực hiện xóa các bản ghi được chọn
     */
    public static void XoaDuLieu(JTable table) {
        //Mảng index lưu các hàng được chọn trong table
        int[] mangIndex = table.getSelectedRows();

        //Kiểm tra nếu độ dài mảng = 0, thông báo cho người dùng biết
        if (mangIndex.length == 0) {
            ThongBao("Bạn chưa chọn bản ghi nào để xóa.", "Thông báo", 1);
            //Ngược lại sẽ thực hiện gọi hàm XoaHoaDon từ DAL để xóa trong CSDL
        } else {
            //Hàm này để lưu mã của những hóa đơn bị xóa
            String dem = "";
            int iCauHoi = JOptionPane.showConfirmDialog(null, "Có thể sẽ mất hết dữ liệu trong bảng chi tiết hóa đơn. "
                    + "Bạn có đồng ý không ?", "Confirm",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (iCauHoi == JOptionPane.YES_OPTION) {
                //Dùng vòng lặp xét các vị trí trong mảng trên
                for (int i = 0; i < mangIndex.length; i++) {
                    //Tạo ra mã hóa đơn từ vị trí trong mảng
                    String maXoa = table.getValueAt(mangIndex[i], 1).toString();

                    //Gọi hàm xóa hóa đơn với mã hóa đơn - @maXoa trên
                    HoaDonDAL.XoaHoaDon(maXoa);

                    dem += maXoa + ", ";
                }
                //Hàm xử lý chuỗi mã các hóa đơn bị xóa trên - @dem
                String strChuoiMa = dem.substring(0, dem.length() - 2);

                //Cuối cùng thông báo các nhân viên bị xóa
                ThongBao(mangIndex.length + " bản ghi đã được xóa." + "\nMã hóa đơn gồm : " + strChuoiMa + ".",
                        "Thông báo", 1);
            } else {
                ThongBao("Đã hủy", "Thông báo", 1);
            }
        }
    }

}
