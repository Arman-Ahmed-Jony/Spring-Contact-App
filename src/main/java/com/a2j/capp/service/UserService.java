/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a2j.capp.service;

import com.a2j.capp.domain.User;
import com.a2j.capp.exception.UserBlockedException;
import java.util.List;

/**
 *
 * @author Arman
 */
public interface UserService {

    public static final Integer LOGIN_STATUS_ACTIVE = 1;
    public static final Integer LOGIN_STATUS_BLOCKED = 2;

    public static final Integer ROLE_ADMIN = 1;
    public static final Integer ROLE_USER = 2;

    /**
     * the method handle the user task
     *
     * @param user the new user detail as user Object
     */
    public void register(User user);

    /*
    the method handles loging operation(authentication) using given cridentials
    it returns User object and null when fail
    when user account is blocked an exception will be thrown by this method
     */
    public User login(String loginName, String password) throws UserBlockedException;

    /**
     * call this method to get list of registered users
     *
     */
    public List<User> getUserList();

    /**
     * this method change the user login status for details passed as argument
     *
     * @param userId
     * @param loginStatus
     */
    public void changeLoginStatus(Integer userId, Integer loginStatus);
}
