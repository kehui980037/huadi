package Dao;

import JDBCUtils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class ManagerDaoTest {

    @Test
    public void isExistThisManager() {
        Connection connection = JDBCUtils.getConnection();
        String username = "roont";
        String password = "16321632";
        String sql = "select * from ManagerTable where username=? and password=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()){
                System.out.println("right");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("wrong");
            return;
        }
        System.out.println("Wrong!");
    }
}