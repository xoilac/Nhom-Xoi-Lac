package Presentation;

import DAL.ConnectionDB;

/**
 *
 * @author MinhNguyen
 */
public class MainClass {
     
    /*
    Tạo đối tượng kết nối CSDL từ DAL
    public để truy cập từ xa
    static để truy  cập nhanh
     */
    public static ConnectionDB conn = new ConnectionDB();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        frmChucVu dn = new frmChucVu();

        dn.show();               

    }

}
