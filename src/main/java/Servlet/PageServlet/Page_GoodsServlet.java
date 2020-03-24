package Servlet.PageServlet;

import Bean.GoodsBean;
import Bean.PropertyBean;
import Dao.GoodsDao;
import Dao.PropertyDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Page_GoodsServlet")
public class Page_GoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        List<GoodsBean> list = GoodsDao.getAllGoodsList();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/goods.jsp").forward(request,response);
    }
}
