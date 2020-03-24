package Dao;

import Bean.GoodsBean;
import JDBCUtils.JDBCUtils;

import javax.naming.ldap.PagedResultsControl;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsDao {

    static Connection connection = null;
    static {
        if (null == connection){
            connection = JDBCUtils.getConnection();
        }
    }
    public GoodsDao(){
        if (null == connection){
            connection = JDBCUtils.getConnection();
        }
    }

    /**
     * get all goods list
     * @return all good's list
     */
    public static List<GoodsBean> getAllGoodsList(){
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
        return list;
    }

    /**
     * insert a goods information to GoodsTable
     * @param buildNumber buildNumber
     * @param goodsName good's name
     * @param goodsDate goods date (String)
     * @param goodsDetail good's detail
     * @return insert success return true, else false
     */
    public static boolean insertGood(int buildNumber,String goodsName,String goodsDate,String goodsDetail){
        String sql = "insert into GoodsTable(buildNumber, goodsName, goodsDate, goodsDetail) " +
                "values(?,?,?,?)";
        boolean flag = true;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,buildNumber);
            statement.setString(2,goodsName);
            statement.setString(3,goodsDate);
            statement.setString(4,goodsDetail);
            flag = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return flag;
    }

    /**
     * update one good's info by its id
     * @param goodsBean goodsbean
     * @return if success return true,else false
     */
    public static boolean updateGoodsInfo(GoodsBean goodsBean){
        //String sql = "select * from GoodsTable where id=?";
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
            return false;
        }
        return true;
    }

    public static boolean deleteDataById(int dataId){
        String sql = "delete from GoodsTable where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,dataId);
            if (preparedStatement.execute()){
                return  true;
            }else {
                return  false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
