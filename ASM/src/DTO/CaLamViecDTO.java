package DTO;

/**
 *
 * @author admin
 */
public class CaLamViecDTO {

    private int idCaLamViec;
    private String maCa;
    private String tenCa;
    private String gioBatDau;
    private String gioKetThuc;
    private String ghiChu;

    public CaLamViecDTO() {
    }

    public CaLamViecDTO(int idCaLamViec, String maCa, String tenCa, String gioBatDau, String gioKetThuc, String ghiChu) {
        this.idCaLamViec = idCaLamViec;
        this.maCa = maCa;
        this.tenCa = tenCa;
        this.gioBatDau = gioBatDau;
        this.gioKetThuc = gioKetThuc;
        this.ghiChu = ghiChu;
    }

    /**
     * @return the idCaLamViec
     */
    public int getIdCaLamViec() {
        return idCaLamViec;
    }

    /**
     * @param idCaLamViec the idCaLamViec to set
     */
    public void setIdCaLamViec(int idCaLamViec) {
        this.idCaLamViec = idCaLamViec;
    }

    /**
     * @return the maCa
     */
    public String getMaCa() {
        return maCa;
    }

    /**
     * @param maCa the maCa to set
     */
    public void setMaCa(String maCa) {
        this.maCa = maCa;
    }

    /**
     * @return the tenCa
     */
    public String getTenCa() {
        return tenCa;
    }

    /**
     * @param tenCa the tenCa to set
     */
    public void setTenCa(String tenCa) {
        this.tenCa = tenCa;
    }

    /**
     * @return the gioBatDau
     */
    public String getGioBatDau() {
        return gioBatDau;
    }

    /**
     * @param gioBatDau the gioBatDau to set
     */
    public void setGioBatDau(String gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    /**
     * @return the gioKetThuc
     */
    public String getGioKetThuc() {
        return gioKetThuc;
    }

    /**
     * @param gioKetThuc the gioKetThuc to set
     */
    public void setGioKetThuc(String gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
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
