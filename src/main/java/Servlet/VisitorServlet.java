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
                int buildNumber = Integer.parseInt(request.getParameter("buildNumber"));
                String visitorName = request.getParameter("visitorName");
                String visitorDate = request.getParameter("visitorDate");
                String phone = request.getParameter("phone");
                String reason = request.getParameter("reason");
                //System.out.println( buildNumber + " " + visitorName +" " + visitorDate + " " + phone + " " + reason) ;
                if (0 != buildNumber && null != visitorName && null != visitorDate && null != phone && null != reason) {
                    if (VisitorDao.addVistor(buildNumber, visitorName, visitorDate, phone, reason)){
                        response.getWriter().write("0");
                    }else {
                        response.getWriter().write("1");
                    }
                }else {
                    response.getWriter().write("1");
                }
                break;
            case  VISITOR_DELETE:
                int visitorId = Integer.parseInt(request.getParameter("visitorId"));
                if (VisitorDao.deleteVisitor(visitorId)){
                    response.getWriter().write("0");
                }else {
                    response.getWriter().write("1");
                }
                break;
        }
    }
}
