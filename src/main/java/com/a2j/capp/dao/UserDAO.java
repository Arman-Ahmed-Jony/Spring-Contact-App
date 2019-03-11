/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a2j.capp.dao;

import com.a2j.capp.domain.User;
import java.util.List;

/**
 *
 * @author Arman
 */
public interface UserDAO {

	public void save(User user);

	public void update(User user);

	public void delete(User user);

	public void delete(Integer userId);

	public User findById(Integer userId);

	public List<User> findAll();

	public List<User> findByProperty(String propName, Object propValue);

}
