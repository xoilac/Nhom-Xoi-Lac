/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import static BLL.ThongBao_ChuyenDoi.KiemTraSo;
import static BLL.ThongBao_ChuyenDoi.ThongBao;
import DAL.LuongDAL;
import static DAL.LuongDAL.KiemTraTrungLuong;
import DAL.NhanVienDAL;
import DTO.LuongNVDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class LuongBLL {

    public static ResultSet LayNhanVien() {
        ResultSet rs = LuongDAL.LayThongTinLuong();
        return rs;
    }

    public static void DoDuLieu(ResultSet rs, JTable table) {
        Object[] obj = new Object[]{"STT", "idluongnv", "chucvu", "luongcoban", "donvi", "ghichu"};
        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
        table.setModel(tableModel);

        try {
            while (rs.next()) {
                Object[] item = new Object[6];
                item[0] = table.getRowCount() + 1;
                item[1] = rs.getInt("idluongnv");
                item[2] = LayTenQuyen(rs.getInt("chucvu"));
                item[3] = rs.getString("luongcoban");
                item[4] = rs.getString("donvi");
                item[5] = rs.getString("ghichu");
                tableModel.addRow(item);

            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public static String LayTenQuyen(int maquyen) {
        String tenquyen = "";
        ResultSet rs = LuongDAL.LayTenQuyen(maquyen);
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
        ResultSet rs = LuongDAL.LayDuLieuQuyen();
        return rs;
    }

    public static void SuaNhanVien(LuongNVDTO luong) {
        //Thực hiện nếu kiểm tra đầy đủ sẽ sửa nhân viên
        if (KiemTraThongTin(luong)) {
            //Gọi hàm để sửa dữ liệu
            LuongDAL.SuaLuong(luong);
        }
    }

    public static boolean KiemTraLuong(int idluong) {
        boolean ketQua = true;

        if (KiemTraTrungLuong(idluong)) {
            ThongBao("Mức lương này đã được áp dụng cho nhân viên khác !", "Thông báo", 0);
            return false;
        }
        return ketQua;
    }

    public static boolean KiemTraThongTin(LuongNVDTO luong) {
        boolean ketQua = true, ktTL = true;
        if (luong.getLuongCoBan().trim().equals("")) {
            ThongBao("Vui lòng nhập tên nhân viên !", "Thông báo", 1);
            return false;
//        } 
//        else if (!KiemTraChu(nv.getHoTen())) {
//            ThongBao("Tên chỉ chứa chữ !", "Thông báo", 1);
//            return false;
        } else if (!luong.getLuongCoBan().trim().equals("")) {
            String tbLuong = "";
            for (int i = 0; i < luong.getLuongCoBan().length(); i++) {
                if (!KiemTraSo(luong.getLuongCoBan().charAt(i) + "")) {
                    tbLuong = "Lương phải là kí tự số !";
                    ketQua = false;
                    ktTL = false;
                }
            }
            if (!tbLuong.equals("")) {
                ThongBao(tbLuong, "Thông báo", 1);
            }
        }
        if (ktTL) {
            if (KiemTraTrungLuong(luong.getChucVu())) {
                ThongBao("Mức lương này đã được áp dụng cho nhân viên khác !", "Thông báo", 0);
                return false;
            }
        }

        if (ketQua) {
            ThongBao("Thành công !", "Thông báo", 1);
        }

        return ketQua;
    }
}
