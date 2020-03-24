package Servlet.PageServlet;

import Bean.PropertyBean;
import Dao.PropertyDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Page_PropertyServlet")
public class Page_PropertyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        List<PropertyBean> list = PropertyDao.getAllPropertyList();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/property.jsp").forward(request,response);
    }
}
