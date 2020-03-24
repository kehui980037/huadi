package JDBCUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {

    private static final String Driver = "com.mysql.cj.jdbc.Driver";
    private static final String username = "root";
    //private static final String password = "16321632";
    private static final String password = "123";
    //private static final String URL = "jdbc:mysql://106.15.199.8:1521/StuentDormManagerDB";
    private static final String URL = "jdbc:mysql://localhost:3306/StuentDormManagerDB?serverTimezone=UTC";
    private static Connection connection;


    public static Connection getConnection(){
        if (null == connection){
            try {
                Class.forName(Driver);
                connection = DriverManager.getConnection(URL,username,password);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void release(){
        if (null!=connection){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
