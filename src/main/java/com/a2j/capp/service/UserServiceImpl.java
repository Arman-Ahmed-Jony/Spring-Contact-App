/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a2j.capp.service;

import com.a2j.capp.dao.BaseDAO;
import com.a2j.capp.dao.UserDAO;
import com.a2j.capp.domain.User;
import com.a2j.capp.exception.UserBlockedException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Arman
 */
@Service
public class UserServiceImpl extends BaseDAO implements UserService {
    
    @Autowired
    private UserDAO userDAO;
    
    @Override
    public void register(User user) {
        userDAO.save(user);
    }
    
    @Override
    public User login(String loginName, String password) throws UserBlockedException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<User> getUserList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void changeLoginStatus(Integer userId, Integer loginStatus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
