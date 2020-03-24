package Servlet;

import Bean.StudentBean;
import Dao.StudentDao;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoadStudentInfoServlet")
public class LoadStudentInfoServlet extends HttpServlet {

    public static final int GET_STUDENT_BY_STUDENTNUMBER = 0;
    public int type = -1;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //int m_type = (int) request.getAttribute("type");
        response.setCharacterEncoding("utf-8");
        String studentID = (String) request.getParameter("studentID");
        StudentBean studentBean = null;
        if ( null != studentID ){
            studentBean = StudentDao.getThisStudent(studentID.trim());
        }
        if ( null != studentBean ){
            List<StudentBean> list = new ArrayList<>();
            list.add(studentBean);
            String str = JSON.toJSONString(list);
            //System.out.println(str);
            response.getWriter().write(str);
        }

        /*switch (m_type){
            case GET_STUDENT_BY_STUDENTNUMBER:
                String studentID = request.getParameter("studentID");
                studentBean = StudentDao.getThisStudent(studentID);
                break;
        }*/
        //response.getWriter().write(studentBean);

    }
}
