/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a2j.capp.rm;

import com.a2j.capp.domain.Contact;
import com.a2j.capp.domain.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Arman
 */
public class ContactRowMapper implements RowMapper<Contact>{

    @Override
    public Contact mapRow(ResultSet rs, int i) throws SQLException {
        
        Contact contact=new Contact();
        contact.setContactId(rs.getInt("contactId"));
        contact.setUserId(rs.getInt("userId"));
        contact.setName(rs.getString("name"));
        contact.setEmail(rs.getString("email"));
        contact.setAddress(rs.getString("address"));
        contact.setPhone(rs.getString("phone"));
        contact.setRemark(rs.getString("remark"));
        return contact;

        
        
    }
    
    
}
