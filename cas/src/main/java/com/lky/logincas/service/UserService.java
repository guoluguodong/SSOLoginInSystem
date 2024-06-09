package com.lky.logincas.service;



import com.lky.logincas.dao.UserDao;
import com.lky.logincas.domain.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public final class UserService {
    private UserDao userDao = UserDao.getInstance();
    private static UserService userService = new UserService();

    public UserService() {
    }

    public static UserService getInstance(){
        return UserService.userService;
    }


    public User valToken(String token) throws SQLException {
        return UserDao.getInstance().valToken(token);
    }

    public User login(String username, String password) throws SQLException{
        return UserDao.getInstance().login(username, password);
    }
    public void logout(String token) throws SQLException{
        UserDao.getInstance().logout(token);
    }
    public ArrayList<User> showAllUser() throws SQLException {
        return UserDao.getInstance().showAllUser();
    }
//    public boolean changePassword(User user) throws SQLException{
//        return UserDao.getInstance().changePassword(user);
//    }
}