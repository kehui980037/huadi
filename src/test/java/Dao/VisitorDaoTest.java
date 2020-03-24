package Dao;

import Bean.VisitorBean;
import JDBCUtils.JDBCUtils;
import com.alibaba.fastjson.JSONReader;
import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VisitorDaoTest {

    private Connection connection;

    @Test
    @Before
    public void getConnection(){
        connection = JDBCUtils.getConnection();
    }

    @Test
    public void getAllVisitor() {
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
        printList(list);
    }

    @Test
    public void getVisitorByBuildId() {
        int buildNumber = 1;
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
        printList(list);
    }

    @Test
    public void getVisitorByDate() {
        String date = "2014-04-05";
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
        printList(list);
    }

    @Test
    public void getVisitorByBuildIdAndDate() {
        //int buildNumber = 1;
        int buildNumber = 3;
        String date = "2012-02-03";
        //String date = "2014-04-05";
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
            System.out.println("wrong");
        }
        printList(list);
    }

    @Test
    public void addVistor() {
        int buildNumber = 1;
        String visitorName = "Test";
        String visitorDate = "2014-4-5";
        String phone = "123456";
        String reason = "rer";
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
        }

    }

    private void printList(List<VisitorBean> list){
        list.forEach(visitorBean -> {
            System.out.println(
                    visitorBean.getId() + " "
                    + visitorBean.getBuildNumber() + " "
                    + visitorBean.getVisitorName() + " "
                    + visitorBean.getVisitorDate() + " "
                    + visitorBean.getPhone() + " "
                    + visitorBean.getReason()
            );
        });
    }


    String jsonString = "{\"array\":[1,2,3],\"arraylist\":[{\"a\":\"b\",\"c\":\"d\",\"e\":\"f\"},{\"a\":\"b\",\"c\":\"d\",\"e\":\"f\"},{\"a\":\"b\",\"c\":\"d\",\"e\":\"f\"}],\"object\":{\"a\":\"b\",\"c\":\"d\",\"e\":\"f\"},\"string\":\"HelloWorld\"}";


    @Test
    public void testJSON(){
        JSONReader reader = new JSONReader(new StringReader(jsonString));
        reader.startObject();
        System.out.println("start fastjson");
        while (reader.hasNext())
        {
            String key = reader.readString();
            System.out.println("key " + key);
            if (key.equals("array"))
            {
                reader.startArray();
                System.out.println("start " + key);
                while (reader.hasNext())
                {
                    String item = reader.readString();
                    System.out.println(item);
                }
                reader.endArray();
                System.out.println("end " + key);
            }
            else if (key.equals("arraylist"))
            {
                reader.startArray();
                System.out.println("start " + key);
                while (reader.hasNext())
                {
                    reader.startObject();
                    System.out.println("start arraylist item");
                    while (reader.hasNext())
                    {
                        String arrayListItemKey = reader.readString();
                        String arrayListItemValue = reader.readObject().toString();
                        System.out.println("key " + arrayListItemKey);
                        System.out.println("value " + arrayListItemValue);
                    }
                    reader.endObject();
                    System.out.println("end arraylist item");
                }
                reader.endArray();
                System.out.println("end " + key);
            }
            else if (key.equals("object"))
            {
                reader.startObject();
                System.out.println("start object item");
                while (reader.hasNext())
                {
                    String objectKey = reader.readString();
                    String objectValue = reader.readObject().toString();
                    System.out.println("key " + objectKey);
                    System.out.println("value " + objectValue);
                }
                reader.endObject();
                System.out.println("end object item");
            }
            else if (key.equals("string"))
            {
                System.out.println("start string");
                String value = reader.readObject().toString();
                System.out.println("value " + value);
                System.out.println("end string");
            }
        }
        reader.endObject();
        System.out.println("start fastjson");
    }

    @Test
    public void deleteVisitor(){
        int id = 5;
        String sql = "delete from VisitorTable where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            if (preparedStatement.execute()){
                System.out.println("ok");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("wrong");
        }
        //System.out.println("false");
    }

}