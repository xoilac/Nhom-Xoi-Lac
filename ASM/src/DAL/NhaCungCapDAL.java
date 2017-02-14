package DAL;
import DTO.KhachHang;
import DTO.NhaCungCap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MinhNguyen
 * 23/08/2016
 */
public class NhaCungCapDAL {
    public static void ThemNhaCungCap(NhaCungCap ncc){
       String cauTruyVan = "Insert NhaCungCap(TenNhaCungCap, DiaChi, ThanhPho, SoDienThoai, GhiChu)\n" +
"  values(N'"+ncc.getTenNhaCungCap()+"', N'"+ncc.getDiaChi()+"', N'"+ncc.getThanhPho()+"', '"+ncc.getSDT()+"', N'"+ncc.getGhiChu()+"')";
       ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
   } 
   
   public static void SuaNhaCungCap(NhaCungCap ncc){
       String cauTruyVan = "Update NhaCungCap set TenNhaCungCap = N'"+ncc.getTenNhaCungCap()+"', "
               + "DiaChi = N'"+ncc.getDiaChi()+"',"
               + " ThanhPho = N'"+ncc.getThanhPho()+"', SoDienThoai= N'"+ncc.getSDT()+"', "
               + "GhiChu = N'"+ncc.getGhiChu()+"' where MaNhaCungCap = "+ncc.getMaNhaCungCap();
       ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
   } 
   
   public static void XoaNhaCungCap(String idNhaCungCap){
       String cauTruyVan = "Delete NhaCungCap where MaNhaCungCap = "+idNhaCungCap;
       ConnectionDB.ExecuteQueryUpdateTable(cauTruyVan);
   } 
   
   public static ResultSet LayTatCaThongTinNhaCungCap(){
       ResultSet rs;
       String cauTruyVan = "Select * from NhaCungCap";
       
       rs =ConnectionDB.ExecuteQueryGetTable(cauTruyVan);
       
       return rs;
   }
   
   public static ResultSet TimKiemThongTin(String tuKhoa){
       ResultSet rs;
       String cauTruyVan = "Select * from NhaCungCap where TenNhaCungCap like N'%"+tuKhoa+"%' "
               + "or DiaChi like N'%"+tuKhoa+"%' or ThanhPho like N'%"+tuKhoa+"%' or GhiChu like N'%"+tuKhoa+"%'";
       
       rs =ConnectionDB.ExecuteQueryGetTable(cauTruyVan);
       
       return rs;
   }
   
   public static NhaCungCap LayThongTinKhachHangTheoMaKH(String MaKH) {
        ResultSet rs;
        String SQLSelect = "select * from NhaCungCap where MaNhaCungCap = " + MaKH;
        rs = ConnectionDB.ExecuteQueryGetTable(SQLSelect);
        
        NhaCungCap ncc = new NhaCungCap();
        
        try {
            while (rs.next()) {
                
                ncc.setMaNhaCungCap(rs.getInt("MaNhaCungCap"));
                ncc.setTenNhaCungCap(rs.getString("TenNhaCungCap"));
                ncc.setDiaChi(rs.getString("DiaChi"));
                ncc.setThanhPho(rs.getString("ThanhPho"));
                ncc.setSDT(rs.getString("SoDienThoai"));
                ncc.setGhiChu(rs.getString("GhiChu"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ncc;
    }
}
