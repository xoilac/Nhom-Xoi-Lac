package DTO;

/**
 *
 * @author admin
 */
public class LuongNVDTO {
    private int idLuongNV;
    private int chucVu;
    private String luongCoBan;
    private String ghiChu;

    private String donvi;
    public LuongNVDTO() {
    }

    public LuongNVDTO(int idLuongNV, int chucVu, String luongCoBan,String donvi, String ghiChu) {
        this.idLuongNV = idLuongNV;
        this.chucVu = chucVu;
        this.luongCoBan = luongCoBan;
        this.ghiChu = ghiChu;
    }
    
    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }
    /**
     * @return the idLuongNV
     */
    public int getIdLuongNV() {
        return idLuongNV;
    }

    /**
     * @param idLuongNV the idLuongNV to set
     */
    public void setIdLuongNV(int idLuongNV) {
        this.idLuongNV = idLuongNV;
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
     * @return the luongCoBan
     */
    public String getLuongCoBan() {
        return luongCoBan;
    }

    /**
     * @param luongCoBan the luongCoBan to set
     */
    public void setLuongCoBan(String luongCoBan) {
        this.luongCoBan = luongCoBan;
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
    
    
}
