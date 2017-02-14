/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.QuyenNhanVienDAL;
import java.sql.ResultSet;

/**
 *
 * @author MinhNguyen
 */
public class QuyenNhanVienBLL {
    public static ResultSet LayThongTinQuyen(){
        ResultSet rs = QuyenNhanVienDAL.LayTatCaThongTinQuyenNV();
        return rs;
    }
}
