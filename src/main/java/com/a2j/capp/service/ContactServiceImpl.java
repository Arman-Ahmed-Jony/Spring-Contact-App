/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a2j.capp.service;

import com.a2j.capp.dao.BaseDAO;
import com.a2j.capp.dao.ContactDAO;
import com.a2j.capp.domain.Contact;
import com.a2j.capp.rm.ContactRowMapper;
import com.a2j.capp.util.StringUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Arman
 */
@Service
public class ContactServiceImpl extends BaseDAO implements ContactService {

	/**
	 * ContactDAO Injected here to reuse same codes
	 *
	 */
	@Autowired
	private ContactDAO contactDAO;

	@Override
	public void save(Contact contact) {
		contactDAO.save(contact);
	}

	@Override
	public void update(Contact contact) {
		contactDAO.update(contact);
	}

	@Override
	public void delete(Integer contactId) {
		contactDAO.delete(contactId);
	}

	@Override
	public void delete(Integer[] contactId) {
		String ids = StringUtil.toCommaSeparatedString(contactId);
		String sql = "DELETE FROM contact WHERE contactId IN(" + ids + ")";
		getJdbcTemplate().update(sql);
	}

	@Override
	public List<Contact> findUserContact(Integer userId) {
		return contactDAO.findByProperty("userId", userId);
	}

	@Override
	public List<Contact> findUserContact(Integer userId, String text) {
		String sql = "SELECT contactId, userId, name, phone, email, address, remark FROM contact WHERE userId=? "
				+ "AND (name LIKE '%" + text + "%' OR phone LIKE '%" + text + "%' OR email LIKE '%" + text
				+ "%' OR address LIKE '%" + text + "%' OR remark LIKE '%" + text + "%' )";
		return getJdbcTemplate().query(sql, new ContactRowMapper(), userId);
	}

    @Override
    public Contact findById(Integer contactId) {
        return contactDAO.findById(contactId);
    }

}
