package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 *23-08-2016
 * Lớp tạo và kết nối csdl
 */
public class ConnectionDB {
    
    String hostName = "localhost",
            dbName = "ql_nhanvien",
            userName = "root",
            password ="123456";

    String url = "jdbc:mysql://"+hostName+":3306/"+dbName+"?useSSL=false";
    static Connection conn;

    public ConnectionDB() {
        try {
//            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            conn = DriverManager.getConnection(url, userName, password);
            if (conn != null) {
                System.out.println("Kết nối thành công");
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    /*
    hàm thực thi câu lệnh select
    ĐẦU VÀO: @CAUTRUYVANSQL - CÂU TRUY VẤN SELECT 
    ĐẦU RA: ResultSet - BẢNG DỮ LIỆU, VÌ CÂU SELECT TRẢ VỀ BẢNG DỮ LIỆU
     */
    public static ResultSet ExecuteQueryGetTable(String CauTruyVanSQL) {
        try {
            ResultSet rs;
            Statement stm = conn.createStatement();
            rs = stm.executeQuery(CauTruyVanSQL);
            return rs;

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return null;

    }

    /*
    hàm thực thi delete update insert
    đầu vào: @câu try vấn sql
    đầu ra: thực thi và cập nhật vào csdl
     */
    public static void ExecuteQueryUpdateTable(String CauTruyVanSQL) {
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(CauTruyVanSQL);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
