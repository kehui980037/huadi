package Servlet;


import Dao.ManagerDao;


import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "RegistServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("session : "+request.getSession().getAttribute(AttrConsts.SESSION_USER));
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("id_username");//获取输入用户名
        String password = request.getParameter("id_password");//获取输入密码
        System.out.println(username + " : " + password);
        if (ManagerDao.isExistThisManager(username,password)){
//                    ManagerBean managerBean1 = new ManagerBean(username,password);
//                    System.out.println("login success!");
//
//                    HttpSession session = request.getSession();
//                    session.setAttribute(AttrConsts.SESSION_USER,managerBean1);
//
//                    String sessionID = session.getId();
//                    Cookie cookie = new Cookie("JSESSIONID",sessionID);
//                    cookie.setMaxAge( 30 * 60 );
//                    response.addCookie(cookie);
//                    //request.getRequestDispatcher("/index").forward(request,response);
//                    //return;
//                    //response.sendRedirect("/index.jsp");
//                    response.getWriter().write("123");
                    //不可用（用户名已存在）
                    //将错误信息和回显得表单信息保存到Request域中
            request.setAttribute("msg","用户名已存在！");
                    // 跳回注册页面
//            response.sendRedirect( request.getContextPath() + "/regist.jsp" );
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
            return;
            }else {
//                    //System.out.println("username and password is wrong!");
//                    //request.getRequestDispatcher("/login.jsp").forward(request,response);
//                    System.out.println(username + " : " + password);
//                    //response.getWriter().print("1");
//                    response.getWriter().write("1");

            ManagerDao.saveThisManager(username,password);//保存用户名、密码
            response.sendRedirect( request.getContextPath() + "/login.jsp" );//重定向回登录页面
//            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
                    //System.out.println("response is writing!");
                    //response.sendRedirect("/login");
                    //return;
        }

    }
}
