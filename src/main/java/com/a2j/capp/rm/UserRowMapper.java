/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a2j.capp.rm;

import com.a2j.capp.domain.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Arman
 */
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {

        User user = new User();
        user.setUserId(rs.getInt("userId"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setAddress(rs.getString("address"));
        user.setLoginName(rs.getString("loginName"));
        user.setRole(rs.getInt("role"));
        user.setLoginStatus(rs.getInt("loginStatus"));
        user.setPhone(rs.getString("phone"));
        return user;
    }

}
