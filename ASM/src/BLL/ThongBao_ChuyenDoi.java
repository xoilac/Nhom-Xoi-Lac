package BLL;

import Presentation.frmDangNhap;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author MinhNguyen
 */
public class ThongBao_ChuyenDoi {

    //Hàm chạy đồng hồ
    public static void DongHo(final JMenu mnuTime) {
        new Thread() {
            public void run() {

                while (true) {
                    String strTime = "";
                    Calendar Lich = Calendar.getInstance();
                    int iHour = Lich.get(Calendar.HOUR_OF_DAY);
                    int iMin = Lich.get(Calendar.MINUTE);
                    int iSec = Lich.get(Calendar.SECOND);
                    int iDay = Lich.get(Calendar.DAY_OF_MONTH);
                    int iMonth = Lich.get(Calendar.MONTH) + 1;
                    int iYear = Lich.get(Calendar.YEAR);

                    String strMin = DinhDangGio(iMin);
                    String strSec = DinhDangGio(iSec);
                    String strMonth = DinhDangGio(iMonth);
                    String strDay = DinhDangGio(iDay);

                    strTime = iHour + ":" + strMin + ":" + strSec + "  " + strDay + "/" + strMonth + "/" + iYear;

                    mnuTime.setText(strTime);
                    mnuTime.setForeground(Color.red);
                }
            }
        }.start();
    }

    //Hàm định dạng giờ 
    private static String DinhDangGio(int iGiaTriDoi) {

        String strKQua = "" + iGiaTriDoi;

        if (iGiaTriDoi < 10) {
            strKQua = "0" + iGiaTriDoi;
        }
        return strKQua;
    }

    //Hàm định dạng ngày theo kiểu ngày/tháng/năm
    public static String DinhDangNgay(Date ngayDoi) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dinhDang = sdf.format(ngayDoi);
        return dinhDang;
    }
    //Hàm lấy tên giới tính

    public static String GioiTinhText(int soDoi) {
        String ketQua = "Nữ";
        if (soDoi == 1) {
            ketQua = "Nam";
        }

        return ketQua;
    }

    //Hàm lấy số để thêm dựa vào radio button
    public static int GioiTinhBoolean(JRadioButton nam) {
        int ketQua = 0;
        if (nam.isSelected()) {
            ketQua = 1;
        }

        return ketQua;
    }

    //Hàm chọn radio button dựa vào giới tính Nam/Nữ
    public static void chonRadio(String gioiTinh, JRadioButton radNam, JRadioButton radNu) {
        if ("Nam".equals(gioiTinh)) {
            radNam.setSelected(true);
        } else {
            radNu.setSelected(true);
        }
    }

    //Hàm đổi JDateChooser sang dạng ô text
    public static JTextField DoiDateChooser(JDateChooser ngay) {
        return (JTextField) ngay.getDateEditor().getUiComponent();
    }

    //Hàm thông báo với đầu vào gồm : nội dung, tiêu đề, icon
    public static void ThongBao(String noidung, String tieude, int icon) {
        JOptionPane.showMessageDialog(null, noidung, tieude,icon);
    }

    /*
    Hàm kiểm tra chứa chữ trả về True - False
     */
    public static boolean KiemTraChu(String chuoiKTra) {
        boolean blnKetQua = false;
        Pattern mauKyTu = Pattern.compile("[a-zA-Z].*[a-zA-Z]");
        Matcher m = mauKyTu.matcher(chuoiKTra);

        blnKetQua = m.find();

        return blnKetQua;
    }

    /*
    Hàm kiểm tra chứa số trả về True - False
     */
    public static boolean KiemTraSo(String chuoiKTra) {
        boolean blnKetQua = false;
        Pattern mauKyTu = Pattern.compile(".*[0-9].*");
        Matcher m = mauKyTu.matcher(chuoiKTra);

        blnKetQua = m.find();

        return blnKetQua;
    }

    //Hàm ghi file ảnh với định dạng png
    public static void ghiFileAnh(RenderedImage duongDan, File noiLuu) {
        try {
            ImageIO.write(duongDan, "png", noiLuu);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    //Hàm đọc file ảnh với đầu vào là đường dẫn ảnh @duongDanANh
    public static BufferedImage DocFileAnh(File duongDanAnh) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(duongDanAnh);
        } catch (IOException e) {
        } catch (NullPointerException e) {
            System.out.println(e.toString());
        }

        return image;
    }

    /*
    Chuyển sang kiểu tiền tệ Việt Nam Đồng
     */
    public static String TienVietNam(double chuoi) {
        String chuyenDoi = "";
        Locale lc_vn = new Locale("vi", "VN");

        NumberFormat nf_cur_vn = NumberFormat.getCurrencyInstance(lc_vn);

        chuyenDoi = nf_cur_vn.format(chuoi);

        return chuyenDoi;
    }

    /*
    Xử lý chuỗi tiền để thêm vào CSDL
     */
    public static String DoiDeThem(String chuoi) {
        String ChuyenDoi = chuoi;
        if (chuoi != null) {
            ChuyenDoi = chuoi.substring(0, chuoi.indexOf(' ')).replace('.', ' ').replaceAll("\\s+", "");
        }

        return ChuyenDoi;
    }

    /*
    Hàm kiểm tra chứa kí tự đặc biệt trả về True - False
     */
    public static boolean CheckSpecialCharacters(String chuoi) {
        boolean blnKetQua = false;
        Pattern mauKyTu = Pattern.compile("[" + "-/@#!*$%^&.'_+={}()" + "]+");
        Matcher m = mauKyTu.matcher(chuoi);

        blnKetQua = m.find();

        return blnKetQua;
    }

    /*
    Hàm kiểm tra chứa chữ và số trả về True - False
     */
    public static boolean CheckLettersAndNumbers(String chuoi) {
        boolean blnKetQua = false;

        Pattern mauKyTuSo = Pattern.compile(".*[a-zA-Z][0-9].*");
        Pattern mauSoKyTu = Pattern.compile(".*[0-9][a-zA-Z].*");

        Matcher m = mauKyTuSo.matcher(chuoi);
        Matcher m2 = mauSoKyTu.matcher(chuoi);

        blnKetQua = m.find() | m2.find();

        return blnKetQua;
    }

    /*
    Hàm kiểm tra định dạng email trả về True - False
     */
    public static boolean CheckEmail(String chuoiCanKiemTra) {
        boolean blnKetQua = false;

        Pattern email = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher m = email.matcher(chuoiCanKiemTra);

        blnKetQua = m.find();

        return blnKetQua;
    }

    //Hàm tạo ra jframe câu hỏi
    public static void CauHoiThoat() {
        int iCauHoi = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn không ?. ", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (iCauHoi == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void PhanQuyen(JMenuItem mnuNhanVien, JMenuItem mnuQLTaiKhoan, JMenuItem mnuDangKy, int quyen) {
        if (quyen != 1) {
            mnuNhanVien.setEnabled(false);
            mnuQLTaiKhoan.setEnabled(false);
            mnuDangKy.setEnabled(false);
        }
    }

    //Câu hỏi trước khi thoát JFrame form
    public static void cauHoiThoatWindow(JFrame fr) {
        int iCauHoi = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát hắn không ?",
                "Confirm",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (iCauHoi == JOptionPane.YES_OPTION) {
            System.out.println("Yes");
            System.exit(0);
        } else if (iCauHoi == JOptionPane.CANCEL_OPTION) {
            System.out.println("Cancel");
            fr.setDefaultCloseOperation(0);
        } else {
            fr.dispose();
        }
    }
}
