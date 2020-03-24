package Dao;

import Bean.ManagerBean;
import JDBCUtils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerDao {

    private static Connection connection;


    static {
        if (null == connection){
            connection = JDBCUtils.getConnection();
        }
    }
    public ManagerDao(){
        if (null == connection){
            connection = JDBCUtils.getConnection();
        }
    }

    public static boolean isExistThisManager(String username, String password){
        String sql = "select * from ManagerTable where username=? and password=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
