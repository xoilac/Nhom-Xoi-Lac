/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author admin
 */
public class ChamCongDTO {

    private int idChamCong;
    private int nhanVien;
    private double tongNgayCong;
    private double luongThuong;
    private double thucLanh;
    private int thangLam;
    private String ghiChu;

    public ChamCongDTO() {
    }

    public ChamCongDTO(int idChamCong, int nhanVien, double tongNgayCong, double luongThuong, double thucLanh, int thangLam, String ghiChu) {
        this.idChamCong = idChamCong;
        this.nhanVien = nhanVien;
        this.tongNgayCong = tongNgayCong;
        this.luongThuong = luongThuong;
        this.thucLanh = thucLanh;
        this.thangLam = thangLam;
        this.ghiChu = ghiChu;
    }

    /**
     * @return the idChamCong
     */
    public int getIdChamCong() {
        return idChamCong;
    }

    /**
     * @param idChamCong the idChamCong to set
     */
    public void setIdChamCong(int idChamCong) {
        this.idChamCong = idChamCong;
    }

    /**
     * @return the nhanVien
     */
    public int getNhanVien() {
        return nhanVien;
    }

    /**
     * @param nhanVien the nhanVien to set
     */
    public void setNhanVien(int nhanVien) {
        this.nhanVien = nhanVien;
    }

    /**
     * @return the tongNgayCong
     */
    public double getTongNgayCong() {
        return tongNgayCong;
    }

    /**
     * @param tongNgayCong the tongNgayCong to set
     */
    public void setTongNgayCong(double tongNgayCong) {
        this.tongNgayCong = tongNgayCong;
    }

    /**
     * @return the luongThuong
     */
    public double getLuongThuong() {
        return luongThuong;
    }

    /**
     * @param luongThuong the luongThuong to set
     */
    public void setLuongThuong(double luongThuong) {
        this.luongThuong = luongThuong;
    }

    /**
     * @return the thucLanh
     */
    public double getThucLanh() {
        return thucLanh;
    }

    /**
     * @param thucLanh the thucLanh to set
     */
    public void setThucLanh(double thucLanh) {
        this.thucLanh = thucLanh;
    }

    /**
     * @return the thangLam
     */
    public int getThangLam() {
        return thangLam;
    }

    /**
     * @param thangLam the thangLam to set
     */
    public void setThangLam(int thangLam) {
        this.thangLam = thangLam;
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
