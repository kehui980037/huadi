package Servlet.PageServlet;

import Bean.DormBean;
import Dao.DormDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Page_ShowDormServlet")
public class Page_ShowDormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        //List<DormBean> list = DormDao.getDormList();
        //request.setAttribute("list",list);
        request.getRequestDispatcher("/showdorm.jsp").forward(request,response);
    }
}
