package Dao;

import Bean.DormBean;
import JDBCUtils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DormDao {

    private static Connection connection;
    static {
        if (null == connection) {
            connection = JDBCUtils.getConnection();
        }
    }
    public DormDao(){
        if (null == connection) {
            connection = JDBCUtils.getConnection();
        }
    }

    /**
     * @return return the all dorm list
     */
    public static List<DormBean> getDormList(){
        String sql = "select * from DormTable";
        List<DormBean> list = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                DormBean dormBean = new DormBean();
                dormBean.setId(resultSet.getInt(1));
                dormBean.setBuildNumber(resultSet.getInt(2));
                dormBean.setFloorNumber(resultSet.getInt(3));
                dormBean.setDormNumber(resultSet.getInt(4));
                dormBean.setPeopleCount(resultSet.getInt(5));
                list.add(dormBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * get Dorm list by build Id
     * @param buildNumber buildId
     * @return the list of this build
     */
    public static List<DormBean> getDormList(int buildNumber){
        String sql = "select * from DormTable where buildNumber=(?)";
        List<DormBean> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,buildNumber);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                DormBean dormBean = new DormBean();
                dormBean.setId(set.getInt(1));
                dormBean.setBuildNumber(set.getInt(2));
                dormBean.setFloorNumber(set.getInt(3));
                dormBean.setDormNumber(set.getInt(4));
                dormBean.setPeopleCount(set.getInt(5));
                list.add(dormBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<DormBean> getDormList(int buildNumber,int floorNumber){
        List<DormBean> list = new ArrayList<>();
        String sql = "select * from DormTable where buildNumber=? and floorNumber=?";
        try {
//            Connection.prepareStatement(String sql)throws SQLException创建一个 PreparedStatement
// 对象来将参数化的 SQL 语句发送到数据库。
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,buildNumber);
            statement.setInt(2,floorNumber);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                DormBean dormBean = new DormBean();
                dormBean.setId(set.getInt(1));
                dormBean.setBuildNumber(set.getInt(2));
                dormBean.setFloorNumber(set.getInt(3));
                dormBean.setDormNumber(set.getInt(4));
                dormBean.setPeopleCount(set.getInt(5));
                list.add(dormBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * @param dormId just dormID, it's unique
     * @return return the dorm people number lived if return 5, this room is wrong.
     */
    public static int getDormPeopleNumber(int dormId){
        String sql = "select * from DormTable where id=(?)";
        int numeber = 5;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,dormId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                numeber = resultSet.getInt(5);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numeber;
    }

    /**
     * add one people to a dorm
     * @param dormId this form's id
     * @return true: add success, false: add failed
     */
    public static boolean addPeopleToDorm(int dormId){
        String sql = "select peopleCount from DormTable where id=(?)";
        String sqlAdd = "update DormTable set peopleCount=(?) where id=(?)";
        int number = 5;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,dormId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                number = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (number < 4){
            number++;
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(sqlAdd);
                preparedStatement.setInt(1,number);
                preparedStatement.setInt(2,dormId);
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }else {
            return false;
        }
        return true;
    }

    /**
     * change a dorm's information
     * @param dormBean new dorm bean
     * @return true: change successful, false change failed
     */
    public static boolean updateDormInfo(DormBean dormBean){
        String sql = "update DormTable set buildNumber=(?),floorNumber=(?),dormNumber=(?),peopleCount=(?) where id=(?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,dormBean.getBuildNumber());
            statement.setInt(2,dormBean.getFloorNumber());
            statement.setInt(3,dormBean.getDormNumber());
            statement.setInt(4,dormBean.getPeopleCount());
            statement.setInt(5,dormBean.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
