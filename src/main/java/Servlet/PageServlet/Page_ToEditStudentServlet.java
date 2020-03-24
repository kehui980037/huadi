package Servlet.PageServlet;

import Bean.StudentBean;
import Dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Page_ToEditStudentServlet")
public class Page_ToEditStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String URL = request.getRequestURI();
        System.out.println(URL);
        String id = request.getParameter("id");
        StudentBean studentBean = StudentDao.getThisStudent(id);
        request.setAttribute("bean",studentBean);
        request.getRequestDispatcher("/editstudent.jsp").forward(request,response);
    }
}
