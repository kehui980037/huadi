package Servlet;

import Dao.PropertyDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PropertyServlet")
public class PropertyServlet extends HttpServlet {
    public static final int PROPERTY_ADD = 0;
    public static final int PROPERTY_DELETE = 1;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int type = Integer.parseInt(request.getParameter("type"));
        switch (type){
            case PROPERTY_ADD:
                int buildNumber = Integer.parseInt(request.getParameter("buildNumber"));
                String propertyName = request.getParameter("goodName");
                float price = Float.parseFloat(request.getParameter("price"));
                //System.out.println(buildNumber + " " + propertyName + " " + price );
                if (PropertyDao.addPropertyInfo(buildNumber,propertyName,price)){
                    response.getWriter().write("0");
                }else{
                    response.getWriter().write("1");
                }
            break;
            case PROPERTY_DELETE:
                int propertyID = Integer.parseInt(request.getParameter("propertyID"));
                System.out.println("property id is " + propertyID) ;
                if (!PropertyDao.deletePropertyByID(propertyID)){
                    response.getWriter().write("0");
                }else {
                    response.getWriter().write("1");
                }
                break;
        }
    }
}
