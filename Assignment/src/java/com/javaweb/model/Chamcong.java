package com.javaweb.model;
// Generated Feb 13, 2017 8:24:56 AM by Hibernate Tools 4.3.1



/**
 * Chamcong generated by hbm2java
 */
public class Chamcong  implements java.io.Serializable {


     private Integer idchamcong;
     private int nhanvien;
     private double tongngaycong;
     private Double tonggiolamthem;
     private Double luongthuong;
     private Double thuclanh;
     private int thanglam;
     private String ghichu;

    public Chamcong() {
    }

	
    public Chamcong(int nhanvien, double tongngaycong, int thanglam) {
        this.nhanvien = nhanvien;
        this.tongngaycong = tongngaycong;
        this.thanglam = thanglam;
    }
    public Chamcong(int nhanvien, double tongngaycong, Double tonggiolamthem, Double luongthuong, Double thuclanh, int thanglam, String ghichu) {
       this.nhanvien = nhanvien;
       this.tongngaycong = tongngaycong;
       this.tonggiolamthem = tonggiolamthem;
       this.luongthuong = luongthuong;
       this.thuclanh = thuclanh;
       this.thanglam = thanglam;
       this.ghichu = ghichu;
    }
   
    public Integer getIdchamcong() {
        return this.idchamcong;
    }
    
    public void setIdchamcong(Integer idchamcong) {
        this.idchamcong = idchamcong;
    }
    public int getNhanvien() {
        return this.nhanvien;
    }
    
    public void setNhanvien(int nhanvien) {
        this.nhanvien = nhanvien;
    }
    public double getTongngaycong() {
        return this.tongngaycong;
    }
    
    public void setTongngaycong(double tongngaycong) {
        this.tongngaycong = tongngaycong;
    }
    public Double getTonggiolamthem() {
        return this.tonggiolamthem;
    }
    
    public void setTonggiolamthem(Double tonggiolamthem) {
        this.tonggiolamthem = tonggiolamthem;
    }
    public Double getLuongthuong() {
        return this.luongthuong;
    }
    
    public void setLuongthuong(Double luongthuong) {
        this.luongthuong = luongthuong;
    }
    public Double getThuclanh() {
        return this.thuclanh;
    }
    
    public void setThuclanh(Double thuclanh) {
        this.thuclanh = thuclanh;
    }
    public int getThanglam() {
        return this.thanglam;
    }
    
    public void setThanglam(int thanglam) {
        this.thanglam = thanglam;
    }
    public String getGhichu() {
        return this.ghichu;
    }
    
    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }




}

