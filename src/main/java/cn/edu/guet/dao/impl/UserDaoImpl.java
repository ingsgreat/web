package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.User;
import cn.edu.guet.dao.IUserDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    @Override
    public List<User> viewUser() {
        /*
        具体的JDBC代码，连接数据库，获取数据
         */
        List<User> userList=new ArrayList<User>();
        String url="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=gbk&autoReconnect=true&failOverReadOnly=false&serverTimezone=UTC";
        String username="root";
        String password="123456";
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="SELECT * FROM users";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(url,username,password);
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()){
                User user=new User();
                user.setId(rs.getInt("ID"));
                user.setName(rs.getString("NAME"));
                user.setAddress(rs.getString("ADDRESS"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

    @Override
    public void deleteUser(int id) {
        //String id=request.getParameter("id");//获取前段传来的id
        String url="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=gbk&autoReconnect=true&failOverReadOnly=false&serverTimezone=UTC";
        String username="root";
        String password="123456";
        Connection conn=null;
        PreparedStatement pstmt=null;
        String sql="DELETE FROM users WHERE id=?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(url,username,password);
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateUser(User user) {
        String url="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=gbk&autoReconnect=true&failOverReadOnly=false&serverTimezone=UTC";
        String username="root";
        String password="123456";
        Connection conn=null;
        PreparedStatement pstmt=null;
        String sql="update users set name=?,address=? where id=?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(url,username,password);
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getAddress());
            pstmt.setInt(3,user.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addUser(User user) {
        String url="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=gbk&autoReconnect=true&failOverReadOnly=false&serverTimezone=UTC";
        String username="root";
        String password="123456";
        Connection conn=null;
        PreparedStatement pstmt=null;
        String sql="insert into users values (?,?,?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(url,username,password);
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,user.getId());
            pstmt.setString(2,user.getName());
            pstmt.setString(3,user.getAddress());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}