package Dao;

import Bean.PropertyBean;
import JDBCUtils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropertyDao {
    private static Connection connection;

    static {
        if (null == connection){
            connection = JDBCUtils.getConnection();
        }
    }
    public PropertyDao(){
        if (null == connection) {
            connection = (Connection) JDBCUtils.getConnection();
        }
    }

    /**
     * get all property list
     * @return all property list
     */
    public static List<PropertyBean> getAllPropertyList(){
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
        return list;
    }

    /**
     * get this build's property
     * @param buildNumber one build's number
     * @return this build's all property information
     */
    public static List<PropertyBean> getBuildProperty(int buildNumber){
        List<PropertyBean> list=new ArrayList<>();
        String sql="select * from PropertyTable where buildNumber=?";
        try{
            PreparedStatement statement= connection.prepareStatement(sql);
            statement.setInt(1, buildNumber);
            ResultSet resultSet=statement.executeQuery(sql);
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
        return list;
    }

    /**
     * change a property information
     * @param property propertyBean
     * @return boolean: update success return true,else false
     */
    public static boolean updatePropertyInfo(PropertyBean property){
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
            return false;
        }
        return true;
    }

    /**
     * add a property to PropertyTable
     * @param buildNumber property's build number
     * @param goodName property's goodName
     * @param price property's price
     * @return boolean: insert success true, failed false
     */
    public static boolean addPropertyInfo(int buildNumber,String goodName,float price) {
        try{
            String sql = "insert into PropertyTable(buildNumber,goodName,price) values (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,buildNumber);
            statement.setString(2,goodName);
            statement.setFloat(3,price);
            statement.execute();
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean deletePropertyByID(int propertyID){
        String sql = "delete from PropertyTable where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,propertyID);
            if (preparedStatement.execute()){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
