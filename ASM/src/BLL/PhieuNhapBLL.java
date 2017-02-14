/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import static BLL.ThongBao_ChuyenDoi.*;
import DAL.PhieuNhapDAL;
import DTO.PhieuNhap;
import DTO.SanPham;
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
 * @author MinhNguyen
 */
public class PhieuNhapBLL {

    //Hàm tạo số phiếu nhập
    public static String CreateSoPhieuNhap() {
        Date CurrentDate = new Date();

        String dateCode = new SimpleDateFormat("ddMMyyhhmmss").format(CurrentDate);
        String soPhieuNhap = "PN" + dateCode;
        return soPhieuNhap;
    }

    //Hàm tạo bảng nhập số lượng sản phẩm vào trong chi tiết phiếu nhập
    public static String[] InputDialogSoLuongSanPham(String tieuDe, String maSP) {
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

    public static boolean KiemTraNhapSanPham(String[] info) {
        boolean ketQua = true;
        try {
            if (info[1].equals("")) {
                ThongBao("Bạn chưa nhập số lượng !",
                        "Thông báo", 1);
                return false;
            } else if (Integer.parseInt(info[1]) <= 0) {
                ThongBao("Số lượng phải lớn hơn 0 ", "Thông báo", 1);
                return false;
            }
        } catch (NumberFormatException e) {
            ThongBao("Số lượng phải là số !", "Thông báo", 1);
            return false;
        } catch (NullPointerException e) {
            ThongBao("Đã hủy ! ", "Thông báo ", 0);
            return false;
        }
        return ketQua;
    }
    
    //Hàm thêm đổ dữ liệu vào bảng chi tiết phiếu nhập
    public static void ThemSanPhamVaoCTPN(SanPham sp, JTable tableCTPN, int SoLuong, String ghiChu) {
        double ThanhTien = SoLuong * sp.getGiaNhap();

        DefaultTableModel tableModel = (DefaultTableModel) tableCTPN.getModel();

        Object[] item = new Object[8];

        item[0] = tableCTPN.getRowCount() + 1;
        item[1] = sp.getTenSP();
        item[2] = sp.getDonViTinh();
        item[3] = TienVietNam(sp.getGiaNhap());
        item[4] = SoLuong;
        item[5] = TienVietNam(ThanhTien);
        item[6] = ghiChu;
        item[7] = sp.getIdSP();

        tableModel.addRow(item);
    }
    
    //Hàm tạo bảng nhập để sửa bản ghi trong bảng chi tiết hóa đơn
    public static String[] InputDialogChiTietPhieuNhap(String tieuDe, String sTT,
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
    
    //Hàm sửa chi tiết hóa đơn theo vị trí tương ứng
    public static void SuaCTPN(JTable table, int viTriSua, int SoLuong, String ghiChu) {

        table.setValueAt(SoLuong, viTriSua, 4);

        String cotDonGia = DoiDeThem(table.getValueAt(viTriSua, 3).toString());
        double donGia = Double.parseDouble(cotDonGia);
        double thanhTien = donGia * SoLuong;

        table.setValueAt(TienVietNam(thanhTien), viTriSua, 5);

        table.setValueAt(ghiChu, viTriSua, 6);
    }
    
    //Hàm thực hiện lấy mã phiếu nhập theo số phiếu nhập
    public static int LayMaPhieuNhap(String soPhieuNhap) {
        int maPN = PhieuNhapDAL.LayMaPhieuNhap(soPhieuNhap);

        return maPN;
    }
    
    //Hàm thực hiện thêm phiếu nhập
    public static void ThemPhieuNhap(PhieuNhap pn) {
        PhieuNhapDAL.ThemPhieuNhap(pn);
        ThongBao("Thanh toán thành công !", "Thông báo", 1);
    }
    
    //Hàm thực hiện sửa phiếu nhập
    public static void SuaPhieuNhap(PhieuNhap pn) {
        PhieuNhapDAL.SuaPhieuNhap(pn);
    }
    
    //Hàm kiểm tra trùng lặp
    public static boolean TrungLapPhieuNhap(String soPhieuNhap) {
        boolean ketQua = PhieuNhapDAL.TrungLapPhieuNhap(soPhieuNhap);

        return ketQua;
    }
}
