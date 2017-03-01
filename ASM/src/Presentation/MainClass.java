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

<<<<<<< HEAD
        frmChucVu dn = new frmChucVu();
=======
        frmLuong dn = new frmLuong();
>>>>>>> f0aa9878e4606a7f522c402efbb8d351e5e4ec97
        dn.show();               

    }

}
