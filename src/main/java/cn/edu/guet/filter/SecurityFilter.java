package cn.edu.guet.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SecurityFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;  //转成HttpServlet
        HttpSession session=request.getSession();
        String username=(String) session.getAttribute("username");
        if(username!=null || "".equals(username)){  //后面"".equals(username)可以避免空指针异常
            chain.doFilter(req,resp);//获取目标资源，例如：deleteUser.do、updateUser.do、viewUser.do
        }
        else{
            HttpServletResponse response=(HttpServletResponse)resp;
            response.sendRedirect("../login.html");//跳转到login.html
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
