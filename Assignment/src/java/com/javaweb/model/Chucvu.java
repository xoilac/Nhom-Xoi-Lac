package com.javaweb.model;
// Generated Feb 13, 2017 8:24:56 AM by Hibernate Tools 4.3.1



/**
 * Chucvu generated by hbm2java
 */
public class Chucvu  implements java.io.Serializable {


     private Integer idchucvu;
     private String tenchucvu;
     private String mota;

    public Chucvu() {
    }

	
    public Chucvu(String tenchucvu) {
        this.tenchucvu = tenchucvu;
    }
    public Chucvu(String tenchucvu, String mota) {
       this.tenchucvu = tenchucvu;
       this.mota = mota;
    }
   
    public Integer getIdchucvu() {
        return this.idchucvu;
    }
    
    public void setIdchucvu(Integer idchucvu) {
        this.idchucvu = idchucvu;
    }
    public String getTenchucvu() {
        return this.tenchucvu;
    }
    
    public void setTenchucvu(String tenchucvu) {
        this.tenchucvu = tenchucvu;
    }
    public String getMota() {
        return this.mota;
    }
    
    public void setMota(String mota) {
        this.mota = mota;
    }




}

