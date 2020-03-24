package Dao;

import Bean.PropertyBean;
import JDBCUtils.JDBCUtils;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PropertyDaoTest {

    private Connection connection;
    @Test
    @Before
    public void getConnection(){
        connection = JDBCUtils.getConnection();
    }

    @Test
    public void getAllPropertyList() {
        String sql = "select * from PropertyTable";
        List<PropertyBean> list = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                PropertyBean property=new PropertyBean();
                property.setId(resultSet.getInt(1));
                property.setBuildNumber(resultSet.getInt(2));
                property.setGoodName(resultSet.getString(3));
                property.setPrice(resultSet.getFloat(4));
                list.add(property);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        printProperty(list);
    }

    @Test
    public void addPropertyInfo() {
        int buildNumber = 2;
        String goodName = "iPhone";
        float price = 134.5F;
        try{
            String sql = "insert into PropertyTable(buildNumber,goodName,price) values (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,buildNumber);
            statement.setString(2,goodName);
            statement.setFloat(3,price);
            statement.execute();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetPropertyInfoByBuildId(){
        int buildNumber = 2;
        List<PropertyBean> list=new ArrayList<>();
        //String sql="select * from PropertyTable where buildNumber=?";
        String sql = "select * from PropertyTable where buildNumber=?";
        try{
            PreparedStatement statement= connection.prepareStatement(sql);
            statement.setInt(1, buildNumber);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next())
            {
                PropertyBean property=new PropertyBean();
                property.setId(resultSet.getInt(1));
                property.setBuildNumber(resultSet.getInt(2));
                property.setGoodName(resultSet.getString(3));
                property.setPrice(resultSet.getFloat(4));
                list.add(property);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        printProperty(list);
    }

    @Test
    public void testUpdatePropertyInfo(){
        PropertyBean property = new PropertyBean(
                1,
                1,
                "PXP",
                4443.4F
        );
        try{
            String sql="update PropertyTable set buildNumber=(?),goodName=(?),price=(?) where id=(?)";
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1, property.getBuildNumber());
            statement.setString(2,property.getGoodName());
            statement.setFloat(3,property.getPrice());
            statement.setInt(4, property.getId());
            statement.execute();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delete(){
        int propertyID = 5;
        String sql = "delete from PropertyTable where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,propertyID);
            if (preparedStatement.execute()){
                System.out.println("ok");
            }else {
                System.out.println("no");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void printProperty(List<PropertyBean> list){
        list.forEach(propertyBean -> {
            System.out.println(
                    propertyBean.getId() + " "
                    + propertyBean.getBuildNumber() + " "
                    + propertyBean.getGoodName() + " "
                    + propertyBean.getPrice()
             );
        });
    }
}