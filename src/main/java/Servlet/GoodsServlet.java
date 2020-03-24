package Servlet;

import Dao.GoodsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GoodsServlet")
public class GoodsServlet extends HttpServlet {
    public static final int GOODS_ADD = 0;
    public static final int GOODS_DELETE = 1;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int type = Integer.parseInt(request.getParameter("type"));
        switch (type){
            case GOODS_ADD:
                int buildNumber = Integer.parseInt(request.getParameter("buildNumber"));
                String goodsName = request.getParameter("goodsName");
                String date = request.getParameter("goodsDate");
                String detial = request.getParameter("goodsDetail");
                if (!GoodsDao.insertGood(buildNumber,goodsName,date,detial)){
                    response.getWriter().write("0");
                }else {
                    response.getWriter().write("1");
                }
                break;
            case GOODS_DELETE:
                int dataID = Integer.parseInt(request.getParameter("dataId"));
                if (!GoodsDao.deleteDataById(dataID)){
                    response.getWriter().write("0");
                }else {
                    response.getWriter().write("1");
                }

        }
    }
}
