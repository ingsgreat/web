package cn.edu.guet.servlet;

import cn.edu.guet.bean.User;
import cn.edu.guet.dao.IUserDao;
import cn.edu.guet.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri=request.getRequestURI();
        if(uri.endsWith("viewUser.do")){
            IUserDao userDao=new UserDaoImpl();
            List<User> userList=userDao.viewUser();
            request.setAttribute("userList",userList);
            request.getRequestDispatcher("/user/viewUser.jsp").forward(request,response);

        }
        else if(uri.endsWith("deleteUser.do")) {
            String id=request.getParameter("id");
            IUserDao userDao=new UserDaoImpl();
            userDao.deleteUser(Integer.parseInt(id));
            request.getRequestDispatcher("/user/viewUser.do").forward(request,response);
        }
        else if(uri.endsWith("updateUser.do")){
            request.setCharacterEncoding("UTF-8");
            String id=request.getParameter("id");
            String name=request.getParameter("name");
            String address=request.getParameter("address");
            User user=new User(Integer.parseInt(id),name,address);
            IUserDao userDao=new UserDaoImpl();
            userDao.updateUser(user);
            request.getRequestDispatcher("/user/viewUser.do").forward(request,response);
        }
        else if(uri.endsWith("addUser.do")){
            System.out.println("kkkkkkkkkk");
            request.setCharacterEncoding("UTF-8");
            String id=request.getParameter("id");
            String name=request.getParameter("name");
            String address=request.getParameter("address");
            User user=new User(Integer.parseInt(id),name,address);
            IUserDao userDao=new UserDaoImpl();
            userDao.addUser(user);
            request.getRequestDispatcher("/user/viewUser.do").forward(request,response);
        }
        else if(uri.endsWith("login")){
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            if("lisi".equals(username) && "ls1234".equals(password)){
                HttpSession session=request.getSession();
                session.setAttribute("username",username);
                request.getRequestDispatcher("/user/viewUser.do").forward(request,response);
            }
        }
    }
}
