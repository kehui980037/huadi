package Dao;

import Bean.DormBean;
import JDBCUtils.JDBCUtils;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DormDaoTest {

    private Connection connection;
    @Test
    @Before
    public void getConnection(){
         String Driver = "com.mysql.cj.jdbc.Driver";
         String username = "root";
         String password = "123456";
         String URL = "jdbc:mysql://localhost:3306/StuentDormManagerDB";
         try {
             Class.forName(Driver);
             connection = JDBCUtils.getConnection();
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
         //return connection;
    }

    @Test
    public void getDormList() {
        getConnection();
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
        list.forEach(dormBean -> {
            System.out.println(dormBean.getId()+" "+dormBean.getBuildNumber() + " " + dormBean.getFloorNumber() + " " + dormBean.getDormNumber()
            + " " + dormBean.getPeopleCount());
        });
    }

    @Test
    public void getDormLivedPeopleNumber(){
        getConnection();
        String sql = "select * from DormTable where id=(?)";
        int numeber = 5;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                numeber = resultSet.getInt(5);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(numeber);
    }

    @Test
    public void addPeopleToDorm() {
        int dormId = 2;
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
                System.out.println("full");
                e.printStackTrace();
            }
        }else {
            System.out.println("full");
        }
    }

    @Test
    public void updateDormInfo() {
        String sql = "update DormTable set buildNumber=(?),floorNumber=(?),dormNumber=(?),peopleCount=(?) where id=(?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,2);
            statement.setInt(2,3);
            statement.setInt(3,104);
            statement.setInt(4,1);
            statement.setInt(5,2);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getDormListByBuildId() {
        int buildNumber = 2;
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
        list.forEach(dormBean -> {
            System.out.println(dormBean.getId()+" " + dormBean.getBuildNumber() + " "+dormBean.getFloorNumber()+" "
            + dormBean.getDormNumber()+" "+dormBean.getPeopleCount());
        });
    }

    @Test
    public void getDormListByBuildIdAndFloorNumber(){
        int buildId = 2;
        int floorNumber = 3;
        List<DormBean> list = new ArrayList<>();
        String sql = "select * from DormTable where buildNumber=? and floorNumber=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,buildId);
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
        list.forEach(dormBean -> {
            System.out.println(dormBean.getId() + " " + dormBean.getBuildNumber() + " " + dormBean.getFloorNumber() + " " + dormBean.getDormNumber()
            + " " + dormBean.getPeopleCount());
        });
    }

    @Test
    public void initDorm(){
        String sql = "insert into DormTable(buildNumber, floorNumber, dormNumber, peopleCount) " +
                "values (?,?,?,?);";


        for(int buildNumber = 1; buildNumber <= 5; buildNumber++){
            for (int floorNumber = 1; floorNumber <= 5; floorNumber++){
                for (int dormNumber = 1; dormNumber <= 18; dormNumber++){
                    int r_dormNumebr = Integer.parseInt(floorNumber+"0"+dormNumber);
                    System.out.println("d: " + r_dormNumebr);
                    try {
                        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setInt(1,buildNumber);
                        preparedStatement.setInt(2,floorNumber);
                        preparedStatement.setInt(3,r_dormNumebr);
                        preparedStatement.setInt(4,0);
                        preparedStatement.execute();
                    } catch (SQLException e) {
                        System.out.println("wrong");
                        e.printStackTrace();
                    }

                }
            }
        }
    }
}