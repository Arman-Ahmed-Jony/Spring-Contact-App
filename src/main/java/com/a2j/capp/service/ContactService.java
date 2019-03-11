/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a2j.capp.service;

import com.a2j.capp.domain.Contact;
import java.util.List;

/**
 * this interface specify all business operation for Contact Entity
 *
 * @author Arman
 */
public interface ContactService {

	public void save(Contact contact);

	public void update(Contact contact);

	public void delete(Integer contactId);

	public void delete(Integer[] contactId);

	/**
	 * this method returns all User Contact (user who is logged in)
	 *
	 * @param userId
	 * @return
	 */
	public List<Contact> findUserContact(Integer userId);

	/**
	 * this method search contact for user(userId) based on given free text criteria
	 *
	 * @param userId
	 * @param text   criteria used to search free text criteria
	 * @return
	 */
	public List<Contact> findUserContact(Integer userId, String text);

}
