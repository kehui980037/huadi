package Servlet;

import Dao.VisitorDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "VisitorServlet")
public class VisitorServlet extends HttpServlet {
    public static final int VISITOR_ADD = 0;
    public static final int VISITOR_DELETE = 1;
    int type = -1;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        type = Integer.parseInt(request.getParameter("type"));
        switch (type){
            case VISITOR_ADD:
                int buildNumber = Integer.parseInt(request.getParameter("buildNumber"));//获取楼号
                String visitorName = request.getParameter("visitorName");//获取访客名字
                String visitorDate = request.getParameter("visitorDate");//获取访问日期
                String phone = request.getParameter("phone");//获取手机号
                String reason = request.getParameter("reason");//获取访问原因
                //System.out.println( buildNumber + " " + visitorName +" " + visitorDate + " " + phone + " " + reason) ;
                if (0 != buildNumber && null != visitorName && null != visitorDate && null != phone && null != reason) {
                    if (VisitorDao.addVistor(buildNumber, visitorName, visitorDate, phone, reason)){
                        response.getWriter().write("0");//添加成功向页面返回响应数据0
                    }else {
                        response.getWriter().write("1");//添加失败向页面返回响应数据1
                    }
                }else {
                    response.getWriter().write("1");//添加失败向页面返回响应数据1
                }
                break;
            case  VISITOR_DELETE:
                int visitorId = Integer.parseInt(request.getParameter("visitorId"));//获取访客id
                if (VisitorDao.deleteVisitor(visitorId)){
                    response.getWriter().write("0");//删除成功向页面返回响应数据0
                }else {
                    response.getWriter().write("1");//删除失败向页面返回响应数据1
                }
                break;
        }
    }
}
