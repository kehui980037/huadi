package Servlet;

import Dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        try {
            String studentID = request.getParameter("studentID");
            String studentName = request.getParameter("studentName");
            String sex = request.getParameter("sex");
            String majorName = request.getParameter("majorName");
            int grade = Integer.parseInt(request.getParameter("grade"));
            String classNum = request.getParameter("classNum");
            System.out.println(studentID + " " + studentName + " " + sex + " " + majorName + " " + grade + " " + classNum);
            if(StudentDao.addStudent(studentID,studentName,sex,majorName,grade,classNum,0,0)){
                System.out.println("insert success");
                response.getWriter().write("0");
                return;
            }else {
                System.out.println("insert failed");
                response.getWriter().write("1");
                return;
            }
        }catch (NullPointerException e){            response.getWriter().write("1");
            System.out.println("Wrong!");
            e.printStackTrace();
            return;
        }
    }
}
