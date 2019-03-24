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
import com.a2j.capp.rm.UserRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
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
		String sql = "SELECT userId, name, phone, email, address, role, loginStatus, loginName "
				+ "FROM user WHERE loginName=:loginName AND password=:password";

		Map m = new HashMap();
		m.put("loginName", loginName);
		m.put("password", password);

		try {
			User u = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
			if (u.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)) {
				throw new UserBlockedException("Your account has been blocked");
			} else {
				return u;
			}
		} catch (EmptyResultDataAccessException emptyResultDataAccessException) {
			return null;
		}
	}

	@Override
	public List<User> getUserList() {
            return userDAO.findByProperty("role", UserService.ROLE_USER);														// Tools | Templates.
	}

	@Override
	public void changeLoginStatus(Integer userId, Integer loginStatus) {
		String sql="UPDATE user SET loginStatus=:loginStatus "
                        + "WHERE userId=:userId";
                Map m=new HashMap();
                m.put("userId", userId);
                m.put("loginStatus", loginStatus);
                getNamedParameterJdbcTemplate().update(sql, m);
                
																		// Tools | Templates.
	}

}
