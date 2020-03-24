package Filter;

import Bean.ManagerBean;
import JDBCUtils.AttrConsts;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "isLoginFilter")
public class isLoginFilter implements Filter {
    String path = "";
    public void destroy() {
        //System.out.println("Filter destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //System.out.println("Do filter");
        ManagerBean managerBean = (ManagerBean) request.getSession().getAttribute(AttrConsts.SESSION_USER);

        if(null == managerBean){
            System.out.println("no login");
            //System.out.println("from filter "+request.getServletPath().toString());
            if(request.getServletPath().equals("/login") || request.getServletPath().equals("/login.jsp")){

            }else{
                response.sendRedirect("/login.jsp");
                return;
            }
        }else {
            //System.out.println("get login session");
            //System.out.println("is login");
            if(request.getServletPath().equals("login") || request.getServletPath().equals("login.jsp")){
                response.sendRedirect("/index.jsp");
                return;
            }
            /*if(request.getServletPath().equals("/index.jsp")||request.getServletPath().equals("/index")){

            }else {
                response.sendRedirect("/index.jsp");
                return;
            }*/
        }

        /*request.setCharacterEncoding("utf-8");
        //System.out.println("fliter is running!");
        System.out.println("servletPath : " + request.getServletPath());
        if (((HttpServletRequest) req).getServletPath().equals(path)){
            System.out.println(path);
            System.out.println("here");
        }else {
            ManagerBean managerBean = (ManagerBean) req.getAttribute(AttrConsts.SESSION_USER);
            //System.out.println(managerBean.getUsername() + " " + managerBean.getPassword());
            if (null == managerBean) {
                //req.getRequestDispatcher("/login").forward(req,resp);
                //request.getRequestDispatcher("login.jsp").forward(request,response);
                response.sendRedirect("/login.jsp");
                return;
            }else {
                response.sendRedirect("/index.jsp");
                return;
            }
        }*/
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        //System.out.println("filter init");
        path = config.getInitParameter("loginPage");
    }


}
