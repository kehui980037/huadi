package Dao;

import Bean.VisitorBean;
import JDBCUtils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VisitorDao {

    private static Connection connection;
    static {
        if (null == connection) {
            connection = (Connection) JDBCUtils.getConnection();
        }
    }
    public VisitorDao(){
        if (null == connection) {
            connection = (Connection) JDBCUtils.getConnection();
        }
    }

    /**
     * 从数据库中获取所有的访客数据
     * @return all visitor
     */
    public static List<VisitorBean> getAllVisitor() {
        List<VisitorBean> list=new ArrayList<>();
        try{
            String sql="select * from VisitorTable";
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while(resultSet.next())
            {
                VisitorBean visitor=new VisitorBean();
                visitor.setId(resultSet.getInt(1));
                visitor.setBuildNumber(resultSet.getInt(2));
                visitor.setVisitorName(resultSet.getString(3));
                visitor.setVisitorDate(resultSet.getString(4));
                visitor.setPhone(resultSet.getString(5));
                visitor.setReason(resultSet.getString(6));
                list.add(visitor);

            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 通过楼号查询访客数据
     * @param buildNumber build number
     * @return the list of this build's visitor
     */
    public static List<VisitorBean> getVisitorByBuildId(int buildNumber) {
        List<VisitorBean> list=new ArrayList<>();
        String sql="select * from VisitorTable where buildNumber=(?)";
        try{
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1, buildNumber);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()) {
                VisitorBean visitor=new VisitorBean();
                visitor.setId(resultSet.getInt(1));
                visitor.setBuildNumber(resultSet.getInt(2));
                visitor.setVisitorName(resultSet.getString(3));
                visitor.setVisitorDate(resultSet.getString(4));
                visitor.setPhone(resultSet.getString(5));
                visitor.setReason(resultSet.getString(6));
                list.add(visitor);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 通过日期查询访客数据
     * @param date the date
     * @return This day's all visitor information
     */
    public static List<VisitorBean> getVisitorByDate(String date) {
        List<VisitorBean> list=new ArrayList<>();
        String sql="select * from VisitorTable where visitorDate=(?)";
        try{
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1, date);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()) {
                VisitorBean visitor=new VisitorBean();
                visitor.setId(resultSet.getInt(1));
                visitor.setBuildNumber(resultSet.getInt(2));
                visitor.setVisitorName(resultSet.getString(3));
                visitor.setVisitorDate(resultSet.getString(4));
                visitor.setPhone(resultSet.getString(5));
                visitor.setReason(resultSet.getString(6));
                list.add(visitor);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 通过楼号和日期查询所有的数据
     * @param buildNumber build number
     * @param date date
     * @return this building and this's days all visitor list
     */
    public static List<VisitorBean> getVisitorByBuildIdAndDate(int buildNumber,String date) {
        String sql="select * from VisitorTable where buildNumber=(?) and visitorDate=(?)";
        List<VisitorBean> list=new ArrayList<>();
        try{
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1, buildNumber);
            statement.setString(2,date);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()) {
                VisitorBean visitor=new VisitorBean();
                visitor.setId(resultSet.getInt(1));
                visitor.setBuildNumber(resultSet.getInt(2));
                visitor.setVisitorName(resultSet.getString(3));
                visitor.setVisitorDate(resultSet.getString(4));
                visitor.setPhone(resultSet.getString(5));
                visitor.setReason(resultSet.getString(6));
                list.add(visitor);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 添加访客数据
     * @param buildNumber build number
     * @param visitorName visitor number
     * @param visitorDate visit date
     * @param phone visitor's phone number
     * @param reason the reason
     * @return boolean: if success return true,else false
     */
    public static boolean addVistor(int buildNumber,String visitorName,String visitorDate,String phone,String reason) {
        String sql="insert into VisitorTable(buildNumber,visitorName,visitorDate,phone,reason) values(?,?,?,?,?)";
        try{
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1,buildNumber);
            statement.setString(2,visitorName);
            statement.setString(3,visitorDate);
            statement.setString(4,phone);
            statement.setString(5, reason);
            statement.execute();
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 通过id删除访客数据
     * @param id
     * @return
     */
    public static boolean deleteVisitor(int id){
        String sql = "delete from VisitorTable where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            if (preparedStatement.execute()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
