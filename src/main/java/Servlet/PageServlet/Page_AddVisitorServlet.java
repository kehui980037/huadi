package Servlet.PageServlet;

import Bean.VisitorBean;
import Dao.VisitorDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Page_AddVisitorServlet")
public class Page_AddVisitorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        List<VisitorBean> list = VisitorDao.getAllVisitor();
        if (null != list){
            request.setAttribute("list",list);
        }
        request.getRequestDispatcher("/addvisitor.jsp").forward(request,response);
    }
}
