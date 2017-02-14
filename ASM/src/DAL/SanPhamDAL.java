package DAL;

import DTO.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MinhNguyen 23/08/2016
 */
public class SanPhamDAL {

    /*
    Hàm thêm dữ liệu vào bảng sản phẩm
    @sp - tham số đầu vào là đối tượng sản phẩm (từ DTO)
    sau đó gọi hàm thực thi câu lệnh
     */
    public static void ThemSanPham(SanPham sp) {
        String cauTruyVan = "Insert SanPham(IDSanPham, TenSanPham, GiaBan, GiaNhap, DonViTinh, SoLuong, LoaiSanPham, GiamGia, MoTa)\n"
                + "  values('" + sp.getIdSP() + "', N'" + sp.getTenSP() + "', " + sp.getGiaBan() + ", " + sp.getGiaNhap() + ","
                + " N'" + sp.getDonViTinh() + "', " + sp.getSoLuong() + ", " + sp.getLoaiSanPham() + ", " + sp.getGiamGia() + ", N'" + sp.getMota() + "')";
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
    }

    /*
    Hàm sửa dữ liệu vào bảng sản phẩm
    @sp - tham số đầu vào là đối tượng sản phẩm (từ DTO)
    sau đó gọi hàm thực thi câu lệnh
     */
    public static void SuaSanPham(SanPham sp) {
        String cauTruyVan = "Update SanPham set IDSanPham = '" + sp.getIdSP() + "', TenSanPham = N'" + sp.getTenSP() + "', "
                + "GiaBan = " + sp.getGiaBan() + ", GiaNhap = " + sp.getGiaNhap() + ", "
                + "DonViTinh = N'" + sp.getDonViTinh() + "', SoLuong = " + sp.getSoLuong() + ", "
                + "LoaiSanPham = " + sp.getLoaiSanPham() + ", GiamGia = " + sp.getGiamGia() + ", MoTa = N'" + sp.getMota() + "'\n"
                + "  where MaSP = " + sp.getMaSP();
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
    }

    /*
    Hàm xóa dữ liệu vào bảng sản phẩm
    @maSP - tham số đầu vào là mã sản phẩm cần xóa sản phẩm
    sau đó gọi hàm thực thi câu lệnh
     */
    public static void XoaSanPham(String maSP) {
        String cauTruyVan = "Delete SanPham where MaSP = " + maSP;
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
    }

    /*
   Hàm lấy tất cả thông tin sản phẩm trong bảng
   Trả về tất cả dữ liệu sản phẩm
     */
    public static ResultSet LayTatCaThongTinSanPham() {
        ResultSet rs;
        String cauTruyVan = "Select * from SanPham";

        rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);

        return rs;
    }

    /*
    Hàm lấy dữ liệu sản phẩm được tìm kiếm
   Trả về dữ liệu được tìm kiếm
     */
    public static ResultSet TimSanPham(String tuKhoa) {
        ResultSet rs;
        String cauTruyVanSQL = "Select * from SanPham "
                + "where TenSanPham like N'%" + tuKhoa + "%' "
                + "or MoTa like N'%" + tuKhoa + "%'";

        rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVanSQL);

        return rs;
    }

    //Hàm lấy tất cả thông tin của từng sản phẩm theo mã sản phẩm truyền vào
    public static SanPham LayDuLieuTheoIDSanPham(String idSP) {
        ResultSet rs;
        String cauTruyvan = "Select * from SanPham where IDSanPham = '" + idSP + "'";
        rs = ConnectionDB.ExecuteQueryGetTable(cauTruyvan);
        SanPham sp = new SanPham();
        try {
            while (rs.next()) {
                sp.setMaSP(rs.getInt("MaSP"));
                sp.setIdSP(rs.getString("IDSanPham"));
                sp.setTenSP(rs.getString("TenSanPham"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setDonViTinh(rs.getString("DonViTinh"));
                sp.setGiaBan(rs.getDouble("GiaBan"));
                sp.setGiaNhap(rs.getDouble("GiaNhap"));
                sp.setMota(rs.getString("MoTa"));
                sp.setLoaiSanPham(rs.getInt("LoaiSanPham"));
                sp.setGiamGia(rs.getInt("GiamGia"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return sp;
    }
    
//    
    public static void SuaSoLuongSP(int tongSoLuong, int maSP){
        String cauTruyVan = "Update SanPham set SoLuong = "+tongSoLuong+" where MaSP = "+maSP;
        ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
    }
    
    public static boolean KiemTraTrungIDSanPham(String idSanPham){
        boolean ketQua = true;
        String cauTruyVan = "Select * from SanPham where IDSanPham = '"+idSanPham+"'";
        ResultSet rs = ConnectionDB.ExecuteQueryGetTable(cauTruyVan);
        try {
            if(!rs.next()){
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return ketQua;
    }
    
    //Hàm lấy tất cả thông tin của từng sản phẩm theo mã sản phẩm truyền vào
    public static SanPham LayDuLieuTheoMaSP(int maSP) {
        ResultSet rs;
        String cauTruyvan = "Select * from SanPham where MaSP = " + maSP;
        rs = ConnectionDB.ExecuteQueryGetTable(cauTruyvan);
        SanPham sp = new SanPham();
        try {
            while (rs.next()) {
                sp.setMaSP(rs.getInt("MaSP"));
                sp.setIdSP(rs.getString("IDSanPham"));
                sp.setTenSP(rs.getString("TenSanPham"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setDonViTinh(rs.getString("DonViTinh"));
                sp.setGiaBan(rs.getDouble("GiaBan"));
                sp.setGiaNhap(rs.getDouble("GiaNhap"));
                sp.setMota(rs.getString("MoTa"));
                sp.setLoaiSanPham(rs.getInt("LoaiSanPham"));
                sp.setGiamGia(rs.getInt("GiamGia"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return sp;
    }
}
