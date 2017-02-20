package DTO;

/**
 *
 * @author Administrator
 */
public class NhanVien {

    private int idNhanVien;
    private String hoTen;
    private String ngaySinh;
    private String sdt;
    private String diaChi;
    private int chucVu;
    private int gioiTinh;
    private String ngayVaoLam;
    private String cmnd;
    private String ngayCap;
    private String tenDN;
    private String matKhau;
    private String email;
    private String luongNV;
    private String ghiChu;
    private String hinhAnh;  
    private String noicap;
    public NhanVien() {
    }

    public NhanVien(int idNhanVien, String hoTen, String ngaySinh, String sdt, String diaChi, int chucVu, int gioiTinh, String ngayVaoLam, String cmnd, String ngayCap, String tenDN, String matKhau, String email, String luongNV, String ghiChu, String hinhAnh, String noicap) {
        this.idNhanVien = idNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.chucVu = chucVu;
        this.gioiTinh = gioiTinh;
        this.ngayVaoLam = ngayVaoLam;
        this.cmnd = cmnd;
        this.ngayCap = ngayCap;
        this.tenDN = tenDN;
        this.matKhau = matKhau;
        this.email = email;
        this.luongNV = luongNV;
        this.ghiChu = ghiChu;
        this.hinhAnh = hinhAnh;
        this.noicap = noicap;
    }

    public String getNoicap() {
        return noicap;
    }

    public void setNoicap(String noicap) {
        this.noicap = noicap;
    }

    

    /**
     * @return the idNhanVien
     */
    public int getIdNhanVien() {
        return idNhanVien;
    }

    /**
     * @param idNhanVien the idNhanVien to set
     */
    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    /**
     * @return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @return the ngaySinh
     */
    public String getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @return the sdt
     */
    public String getSdt() {
        return sdt;
    }

    /**
     * @param sdt the sdt to set
     */
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    /**
     * @return the diaChi
     */
    public String getDiaChi() {
        return diaChi;
    }

    /**
     * @param diaChi the diaChi to set
     */
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    /**
     * @return the chucVu
     */
    public int getChucVu() {
        return chucVu;
    }

    /**
     * @param chucVu the chucVu to set
     */
    public void setChucVu(int chucVu) {
        this.chucVu = chucVu;
    }

    /**
     * @return the gioiTinh
     */
    public int isGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the ngayVaoLam
     */
    public String getNgayVaoLam() {
        return ngayVaoLam;
    }

    /**
     * @param ngayVaoLam the ngayVaoLam to set
     */
    public void setNgayVaoLam(String ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    /**
     * @return the cmnd
     */
    public String getCmnd() {
        return cmnd;
    }

    /**
     * @param cmnd the cmnd to set
     */
    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    /**
     * @return the ngayCap
     */
    public String getNgayCap() {
        return ngayCap;
    }

    /**
     * @param ngayCap the ngayCap to set
     */
    public void setNgayCap(String ngayCap) {
        this.ngayCap = ngayCap;
    }

    /**
     * @return the tenDN
     */
    public String getTenDN() {
        return tenDN;
    }

    /**
     * @param tenDN the tenDN to set
     */
    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    /**
     * @return the matKhau
     */
    public String getMatKhau() {
        return matKhau;
    }

    /**
     * @param matKhau the matKhau to set
     */
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the luongNV
     */
    public String getLuongNV() {
        return luongNV;
    }

    /**
     * @param luongNV the luongNV to set
     */
    public void setLuongNV(String luongNV) {
        this.luongNV = luongNV;
    }

    /**
     * @return the ghiChu
     */
    public String getGhiChu() {
        return ghiChu;
    }

    /**
     * @param ghiChu the ghiChu to set
     */
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    /**
     * @return the hinhAnh
     */
    public String getHinhAnh() {
        return hinhAnh;
    }

    /**
     * @param hinhAnh the hinhAnh to set
     */
    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
