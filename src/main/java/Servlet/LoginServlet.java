package Servlet;

import Bean.ManagerBean;
import Dao.ManagerDao;
import JDBCUtils.AttrConsts;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("session : "+request.getSession().getAttribute(AttrConsts.SESSION_USER));
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //System.out.println(username + " : " + password);
        if(null != username){
            if (!username.trim().equals("") && !password.trim().equals("")){
                if (ManagerDao.isExistThisManager(username,password)){
                    ManagerBean managerBean1 = new ManagerBean(username,password);
                    System.out.println("login success!");

                    HttpSession session = request.getSession();
                    session.setAttribute(AttrConsts.SESSION_USER,managerBean1);

                    String sessionID = session.getId();
                    Cookie cookie = new Cookie("JSESSIONID",sessionID);
                    cookie.setMaxAge( 30 * 60 );
                    response.addCookie(cookie);
                    //request.getRequestDispatcher("/index").forward(request,response);
                    //return;
                    //response.sendRedirect("/index.jsp");
                    response.getWriter().write("123");
                    return;
                }else {
                    //System.out.println("username and password is wrong!");
                    //request.getRequestDispatcher("/login.jsp").forward(request,response);
                    System.out.println(username + " : " + password);
                    //response.getWriter().print("1");
                    response.getWriter().write("1");
                    return;
                    //System.out.println("response is writing!");
                    //response.sendRedirect("/login");
                    //return;
                }
            }
        }

        //request.setAttribute("answer",false);
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
}
