package Dao;

import Bean.StudentBean;
import JDBCUtils.JDBCUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoTest {

    private Connection connection;

    @Test
    @Before
    public void getConnection(){
        connection = JDBCUtils.getConnection();
    }

    @Test
    public void getAllStudent(){
        String sql = "select * from StudentTable;";
        List<StudentBean> list = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
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
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        list.forEach(studentBean -> {
            System.out.println(
                    studentBean.getId() + " "
                    + studentBean.getStudentID() + " "
                    + studentBean.getStudentName() + " "
                    + studentBean.getSex() + " "
                    + studentBean.getMajorName() + " "
                    + studentBean.getGrade() + " "
                    + studentBean.getClassNum() + " "
                    + studentBean.getBuildNumber() + " "
                    + studentBean.getDormNumber()
            );
        });
    }

    @Test
    public void testAddStudent(){
        String studentID = "2016006542";
        String studentName = "连接电视";
        String sex = "女";
        String majorName = "计算机工程";
        int grade = 17;
        String classNum = "经济1732";
        int  buildNumber = 2;
        int dormNumber = 502;
        String sql = "insert into StudentTable(studentID, studentName, sex, majorName, grade, classNum, buildNumber, dormNumber) " +
                "values(?,?,?,?,?,?,?,?)";
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
        }
    }

    @Test
    public void testGetStudentListByMajorName(){
        String majorName = "计算机工程";
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
        list.forEach(studentBean -> {
            System.out.println(
                    studentBean.getId() + " "
                            + studentBean.getStudentID() + " "
                            + studentBean.getStudentName() + " "
                            + studentBean.getSex() + " "
                            + studentBean.getMajorName() + " "
                            + studentBean.getGrade() + " "
                            + studentBean.getClassNum() + " "
                            + studentBean.getBuildNumber() + " "
                            + studentBean.getDormNumber()
            );
        });
    }

    @Test
    public void testGetStudentListByDormNumber(){
        List<StudentBean> list = new ArrayList<>();
        int dormNumber = 502;
        String sql = "select * from StudentTable where dormNumber=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,dormNumber);
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
        soutStudents(list);
    }

    @Test
    public void testGetStudentListByGradeAndClassNum(){
        int grade = 17;
        String classNum = "软件1732";
        String sql = "select * from StudentTable where grade=? and classNum=?";
        List<StudentBean> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,grade);
            preparedStatement.setString(2,classNum);
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
        soutStudents(list);
    }

    @Test
    public void testGetThisStudent(){
        String studentId = "2016006533";
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
        System.out.println(studentBean.getId());
        System.out.println(studentBean.getStudentName());
        System.out.println(studentBean.getClassNum());
    }

    @Test
    public void getStudentListByBuildNumber(){
        int buildNumber = 2;
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
        soutStudents(list);
    }

    @Test
    public void getStudentListBySex(){
        List<StudentBean> list = new ArrayList<>();
        String sex = "男";
        //String sex = "女";
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
        soutStudents(list);
    }

    @Test
    public void getStudentListByGrade(){
        int grade = 17;
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
        soutStudents(list);
    }

    @Test
    public void testUpdateStudentInfo(){
        String studentName = "违法2的";
        String sex = "女";
        String majorName = "sdf";
        String classNum = "class name";
        int buildNumber = 44;
        int dormNumber = 3;
        int id = 1;
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
            if (preparedStatement.execute()){
                System.out.println("true");
            }else {
                System.out.println("false");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("false");
    }

    @Test
    public void addRJ(){
        String filePath = "/Users/binguner/Desktop/test.xlsx";
        try {
            FileInputStream stream = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(stream);
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            int rowNumber = sheet.getLastRowNum();
            int colNumber = sheet.getRow(3).getLastCellNum();
            System.out.println(sheet.getRow(1).getCell(1).toString()); //软件1601
            System.out.println("row :" + rowNumber);
            System.out.println("col :" + colNumber);
            String sql = "insert into StudentTable(studentID, studentName, sex, majorName, grade, classNum, buildNumber, dormNumber) " +
                    "values(?,?,?,?,?,?,?,?)";
            for(int row = 1;row <= rowNumber; row++){
                String className = sheet.getRow(row).getCell(1).toString();
                String studentNumber = sheet.getRow(row).getCell(0).toString();
                String studentName = sheet.getRow(row).getCell(2).toString();
                String sex = sheet.getRow(row).getCell(3).toString();

                try {
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1,studentNumber);
                    preparedStatement.setString(2,studentName);
                    preparedStatement.setString(3,sex);
                    preparedStatement.setString(4,"软件工程");
                    preparedStatement.setInt(5,16);
                    preparedStatement.setString(6,className);
                    preparedStatement.setInt(7,0);
                    preparedStatement.setInt(8,0);
                    preparedStatement.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getClassNameList(){
        String sql ="select classNum from StudentTable group by classNum;";
        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(sql);
            while (set.next()){
                System.out.println(set.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getThisClassAllPeopleCount(){
        String className = "软件1632";
        //String sql = "select studentID from StudentTable where classNum=?;";
        //String sql = "select studentID from StudentTable where classNum=? and sex='男';";
        String sql = "select studentID from StudentTable where classNum=? and sex='女';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,className);
            ResultSet set = preparedStatement.executeQuery();
            set.last();
            int rowCount = set.getRow();
            System.out.println(rowCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void soutStudents(List<StudentBean> list){
        list.forEach(studentBean -> {
            System.out.println(
                    studentBean.getId() + " "
                            + studentBean.getStudentID() + " "
                            + studentBean.getStudentName() + " "
                            + studentBean.getSex() + " "
                            + studentBean.getMajorName() + " "
                            + studentBean.getGrade() + " "
                            + studentBean.getClassNum() + " "
                            + studentBean.getBuildNumber() + " "
                            + studentBean.getDormNumber()
            );
        });
    }



}