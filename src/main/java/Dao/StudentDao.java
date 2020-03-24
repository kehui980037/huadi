package Dao;

import Bean.StudentBean;
import JDBCUtils.JDBCUtils;
import org.w3c.dom.ls.LSException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    static Connection connection;
    static {
        if (null == connection){
            connection = JDBCUtils.getConnection();
        }
    }
    public StudentDao(){
        if (null == connection){
            connection = JDBCUtils.getConnection();
        }
    }

    /**
     * get all student info
     * @return list of all student
     */
    public static List<StudentBean> getAllStudent(){
        String sql = "select * from StudentTable;";
        List<StudentBean> list = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                StudentBean studentBean = new StudentBean();
                studentBean.setId(resultSet.getInt(1));
                studentBean.setStudentID(resultSet.getString(2));
                studentBean.setStudentName(resultSet.getString(3));
                studentBean.setSex(resultSet.getString(4));
                studentBean.setMajorName(resultSet.getString(5));
                studentBean.setGrade(resultSet.getInt(6));
                studentBean.setClassNum(resultSet.getString(7));
                studentBean.setBuildNumber(resultSet.getInt(8));
                studentBean.setDormNumber(resultSet.getInt(9));
                list.add(studentBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * insert one student
     * @param studentID sudentID
     * @param studentName studentName
     * @param sex sex
     * @param majorName majorName 软件工程
     * @param grade grade 16
     * @param classNum 软件 1632
     * @param buildNumber 1
     * @param dormNumber 501
     * @return boolean: insert success return true, else false
     */
    public static boolean addStudent(String studentID,String studentName,String sex,String majorName,int grade,String  classNum,int buildNumber,int dormNumber){
        String sql = "insert into StudentTable(studentID, studentName, sex, majorName, grade, classNum, buildNumber, dormNumber) " +
                "values(?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,studentID);
            statement.setString(2,studentName);
            statement.setString(3,sex);
            statement.setString(4,majorName);
            statement.setInt(5,grade);
            statement.setString(6,classNum);
            statement.setInt(7,buildNumber);
            statement.setInt(8,dormNumber);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    /**
     * get student list by majorName(软件工程)
     * @param majorName
     * @return list of this major 's student lsit
     */
    public static List<StudentBean> getStudentsList(String majorName){
        List<StudentBean> list = new ArrayList<>();
        String sql = "select * from StudentTable where majorName=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,majorName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                StudentBean studentBean = new StudentBean();
                studentBean.setId(resultSet.getInt(1));
                studentBean.setStudentID(resultSet.getString(2));
                studentBean.setStudentName(resultSet.getString(3));
                studentBean.setSex(resultSet.getString(4));
                studentBean.setMajorName(resultSet.getString(5));
                studentBean.setGrade(resultSet.getInt(6));
                studentBean.setClassNum(resultSet.getString(7));
                studentBean.setBuildNumber(resultSet.getInt(8));
                studentBean.setDormNumber(resultSet.getInt(9));
                list.add(studentBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * get students list by dormNumebr
     * @param dormNumber
     * @return list of studentBean in this dormitory
     */
    public static List<StudentBean> getStudentListByDormNumberAndBuildNumber(int buildNumber,int dormNumber){
        List<StudentBean> list = new ArrayList<>();
        String sql = "select * from StudentTable where buildNumber=? and dormNumber=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,buildNumber);
            statement.setInt(2,dormNumber);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                StudentBean studentBean = new StudentBean();
                studentBean.setId(resultSet.getInt(1));
                studentBean.setStudentID(resultSet.getString(2));
                studentBean.setStudentName(resultSet.getString(3));
                studentBean.setSex(resultSet.getString(4));
                studentBean.setMajorName(resultSet.getString(5));
                studentBean.setGrade(resultSet.getInt(6));
                studentBean.setClassNum(resultSet.getString(7));
                studentBean.setBuildNumber(resultSet.getInt(8));
                studentBean.setDormNumber(resultSet.getInt(9));
                list.add(studentBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * get students list by grade(16) and classNum(软件1632)
     * @param classNum
     * @return list of this grade and this classNum's student
     */
    public static List<StudentBean> getStudentListByClassNum(String classNum){
        String sql = "select * from StudentTable where classNum=?";
        List<StudentBean> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setInt(1,grade);
            preparedStatement.setString(1,classNum);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                StudentBean studentBean = new StudentBean();
                studentBean.setId(resultSet.getInt(1));
                studentBean.setStudentID(resultSet.getString(2));
                studentBean.setStudentName(resultSet.getString(3));
                studentBean.setSex(resultSet.getString(4));
                studentBean.setMajorName(resultSet.getString(5));
                studentBean.setGrade(resultSet.getInt(6));
                studentBean.setClassNum(resultSet.getString(7));
                studentBean.setBuildNumber(resultSet.getInt(8));
                studentBean.setDormNumber(resultSet.getInt(9));
                list.add(studentBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * get Student List by Grade(16)
     * @param grade
     * @return this grade's students list
     */
    public static List<StudentBean> getStudentListByGrade(int grade){
        String sql = "select * from StudentTable where grade=?";
        List<StudentBean> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,grade);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                StudentBean studentBean = new StudentBean();
                studentBean.setId(resultSet.getInt(1));
                studentBean.setStudentID(resultSet.getString(2));
                studentBean.setStudentName(resultSet.getString(3));
                studentBean.setSex(resultSet.getString(4));
                studentBean.setMajorName(resultSet.getString(5));
                studentBean.setGrade(resultSet.getInt(6));
                studentBean.setClassNum(resultSet.getString(7));
                studentBean.setBuildNumber(resultSet.getInt(8));
                studentBean.setDormNumber(resultSet.getInt(9));
                list.add(studentBean);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * get this student's information
     * @param studentId
     * @return this student's information
     */
    public static StudentBean getThisStudent(String studentId){
        String sql="select * from StudentTable where studentID=?";
        StudentBean studentBean = new StudentBean();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,studentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                studentBean.setId(resultSet.getInt(1));
                studentBean.setStudentID(resultSet.getString(2));
                studentBean.setStudentName(resultSet.getString(3));
                studentBean.setSex(resultSet.getString(4));
                studentBean.setMajorName(resultSet.getString(5));
                studentBean.setGrade(resultSet.getInt(6));
                studentBean.setClassNum(resultSet.getString(7));
                studentBean.setBuildNumber(resultSet.getInt(8));
                studentBean.setDormNumber(resultSet.getInt(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  studentBean;
    }

    /**
     * get Student list by buildNumber
     * @param buildNumber
     * @return this build's student's list
     */
    public static List<StudentBean> getStudentListByBuildNumer(int buildNumber){
        String sql = "select * from StudentTable where buildNumber=?";
        List<StudentBean> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,buildNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                StudentBean studentBean = new StudentBean();
                studentBean.setId(resultSet.getInt(1));
                studentBean.setStudentID(resultSet.getString(2));
                studentBean.setStudentName(resultSet.getString(3));
                studentBean.setSex(resultSet.getString(4));
                studentBean.setMajorName(resultSet.getString(5));
                studentBean.setGrade(resultSet.getInt(6));
                studentBean.setClassNum(resultSet.getString(7));
                studentBean.setBuildNumber(resultSet.getInt(8));
                studentBean.setDormNumber(resultSet.getInt(9));
                list.add(studentBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * get student list by sex
     * @param sexId 0 girl, 1 boy
     * @return student list by sex
     */
    public static List<StudentBean> getStudentListBySex(int sexId){
        List<StudentBean> list = new ArrayList<>();
        String sex = "男";
        if (sexId == 0){
            sex = "女";
        }
        String sql = "select * from StudentTable where sex=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,sex);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                StudentBean studentBean = new StudentBean();
                studentBean.setId(resultSet.getInt(1));
                studentBean.setStudentID(resultSet.getString(2));
                studentBean.setStudentName(resultSet.getString(3));
                studentBean.setSex(resultSet.getString(4));
                studentBean.setMajorName(resultSet.getString(5));
                studentBean.setGrade(resultSet.getInt(6));
                studentBean.setClassNum(resultSet.getString(7));
                studentBean.setBuildNumber(resultSet.getInt(8));
                studentBean.setDormNumber(resultSet.getInt(9));
                list.add(studentBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     *
     * @return the class name list (unique)
     */
    public static List<String> getClassNameList(){
        List<String> list = new ArrayList<>();
        String sql ="select classNum from StudentTable group by classNum;";
        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(sql);
            while (set.next()){
                list.add(set.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int getThisClassAllPeopleCount(String className){
        String sql = "select studentID from StudentTable where classNum=?;";
        int rowCount = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,className);
            ResultSet set = preparedStatement.executeQuery();
            set.last();
            rowCount = set.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    public static int getThisClassBoyCount(String className){
        String sql = "select studentID from StudentTable where classNum=? and sex='男';";
        int rowCount = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,className);
            ResultSet set = preparedStatement.executeQuery();
            set.last();
            rowCount = set.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    public static int getThisClassGirlCount(String className){
        String sql = "select studentID from StudentTable where classNum=? and sex='女';";
        int rowCount = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,className);
            ResultSet set = preparedStatement.executeQuery();
            set.last();
            rowCount = set.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    public static int getStudentCount(){
        String sql = "select studentID from StudentTable;";
        int number = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(sql);
            set.last();
            number = set.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return number;
    }

    public static List<StudentBean> getGirlListByClassName(String className){
        List<StudentBean> list = new ArrayList<>();
        String sql = "select * from StudentTable where classNum =? and sex='女';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,className);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                StudentBean studentBean = new StudentBean();
                studentBean.setId(resultSet.getInt(1));
                studentBean.setStudentID(resultSet.getString(2));
                studentBean.setStudentName(resultSet.getString(3));
                studentBean.setSex(resultSet.getString(4));
                studentBean.setMajorName(resultSet.getString(5));
                studentBean.setGrade(resultSet.getInt(6));
                studentBean.setClassNum(resultSet.getString(7));
                studentBean.setBuildNumber(resultSet.getInt(8));
                studentBean.setDormNumber(resultSet.getInt(9));
                list.add(studentBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    public static List<StudentBean> getBoyListByClassName(String className){
        List<StudentBean> list = new ArrayList<>();
        String sql = "select * from StudentTable where classNum =? and sex='男';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,className);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                StudentBean studentBean = new StudentBean();
                studentBean.setId(resultSet.getInt(1));
                studentBean.setStudentID(resultSet.getString(2));
                studentBean.setStudentName(resultSet.getString(3));
                studentBean.setSex(resultSet.getString(4));
                studentBean.setMajorName(resultSet.getString(5));
                studentBean.setGrade(resultSet.getInt(6));
                studentBean.setClassNum(resultSet.getString(7));
                studentBean.setBuildNumber(resultSet.getInt(8));
                studentBean.setDormNumber(resultSet.getInt(9));
                list.add(studentBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    public static boolean setBuildNumberDormNumber(int studentiD,int buildNumber,int dormNumber){
        String sql = "update StudentTable set buildNumber = ?, dormNumber = ? where id=?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,buildNumber);
            preparedStatement.setInt(2,dormNumber);
            preparedStatement.setInt(3,studentiD);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean changeStudentInfo(int id,String studentID,String studentName,String sex,String majorName,int grade,String  classNum,int buildNumber,int dormNumber){
        String sql = "update StudentTable set studentName=?,sex=?,majorName=?,classNum=?,buildNumber=?,dormNumber=? where id =?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,studentName);
            preparedStatement.setString(2,sex);
            preparedStatement.setString(3,majorName);
            preparedStatement.setString(4,classNum);
            preparedStatement.setInt(5,buildNumber);
            preparedStatement.setInt(6,dormNumber);
            preparedStatement.setInt(7,id);
            if (!preparedStatement.execute()){
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
