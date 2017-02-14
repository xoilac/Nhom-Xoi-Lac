package DTO;

/**
 *
 * @author admin
 */
public class ChucVuDTO {

    private int idChucVu;
    private String tenChucVu;
    private String ghiChu;

    public ChucVuDTO(int idChucVu, String tenChucVu, String ghiChu) {
        this.idChucVu = idChucVu;
        this.tenChucVu = tenChucVu;
        this.ghiChu = ghiChu;
    }

    public ChucVuDTO() {
    }

    /**
     * @return the idChucVu
     */
    public int getIdChucVu() {
        return idChucVu;
    }

    /**
     * @param idChucVu the idChucVu to set
     */
    public void setIdChucVu(int idChucVu) {
        this.idChucVu = idChucVu;
    }

    /**
     * @return the tenChucVu
     */
    public String getTenChucVu() {
        return tenChucVu;
    }

    /**
     * @param tenChucVu the tenChucVu to set
     */
    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
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
