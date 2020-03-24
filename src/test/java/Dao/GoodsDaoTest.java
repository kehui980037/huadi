package Dao;

import Bean.GoodsBean;
import JDBCUtils.JDBCUtils;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GoodsDaoTest {

    private Connection connection;
    @Before
    @Test
    public void getConnection(){
        connection = JDBCUtils.getConnection();
    }

    @Test
    public void getAllGoodsList() {
        List<GoodsBean> list = new ArrayList<>();
        String sql = "select * from GoodsTable;";
        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(sql);
            while (set.next()){
                GoodsBean goodsBean = new GoodsBean();
                goodsBean.setId(set.getInt(1));
                goodsBean.setBuildNumber(set.getInt(2));
                goodsBean.setGoodsName(set.getString(3));
                goodsBean.setGoodsDate(set.getString(4));
                goodsBean.setGoodsDetail(set.getString(5));
                list.add(goodsBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        list.forEach(goodsBean -> {
            System.out.println(
                    goodsBean.getId() + " "
                    + goodsBean.getBuildNumber() + " "
                    + goodsBean.getGoodsName() + " "
                    + goodsBean.getGoodsDate() + " "
                    + goodsBean.getGoodsDetail());
        });
    }

    @Test
    public void insertGood() {
        int buildNumber = 2;
        String goodsName = "这几个";
        String goodsDate = "2015-3-3";
        String goodsDetail = "路好谈芭比娃娃";
        String sql = "insert into GoodsTable(buildNumber, goodsName, goodsDate, goodsDetail) " +
                "values(?,?,?,?);";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,buildNumber);
            statement.setString(2,goodsName);
            statement.setString(3,goodsDate);
            statement.setString(4,goodsDetail);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateGoodIndo(){
        GoodsBean goodsBean = new GoodsBean(
                4,
                4,
                "PC",
                "2013-3-4",
                "test"
        );
        String sql = "update GoodsTable set buildNumber=?, goodsName=?,goodsDate=?,goodsDetail=? where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,goodsBean.getBuildNumber());
            preparedStatement.setString(2,goodsBean.getGoodsName());
            preparedStatement.setString(3,goodsBean.getGoodsDate());
            preparedStatement.setString(4,goodsBean.getGoodsDetail());
            preparedStatement.setInt(5,goodsBean.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteById(){
        int dataId = 1;
        String sql = "delete from GoodsTable where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,dataId);
            if (preparedStatement.execute()){
                System.out.println("ok");
            }else {
                System.out.println("no");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("no");
        }
        System.out.println("no");
    }
}