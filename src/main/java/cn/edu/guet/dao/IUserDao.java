package cn.edu.guet.dao;

import cn.edu.guet.bean.User;

import java.util.List;

public interface IUserDao {
    List<User> viewUser();
    void deleteUser(int id);
    void updateUser(User user);
}
