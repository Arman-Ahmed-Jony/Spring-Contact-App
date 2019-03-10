/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a2j.capp.dao;

import com.a2j.capp.domain.Contact;
import com.a2j.capp.rm.ContactRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Arman
 */
@Repository
public class ContactDAOImpl extends BaseDAO implements ContactDAO{

    @Override
    public void save(Contact contact) {
        String sql="INSERT INTO contact(userId,name,phone,email,address,remark)"
                + "VALUES (:userId,:name,:phone,:email,:address,:remark)";
        Map n=new HashMap();
        n.put("userId", contact.getUserId());
        n.put("name", contact.getName());
        n.put("phone", contact.getPhone());
        n.put("email", contact.getEmail());
        n.put("address", contact.getAddress());
        n.put("remark", contact.getRemark());
        
        SqlParameterSource parameterSource=new MapSqlParameterSource(n);
        KeyHolder keyHolder=new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(sql, parameterSource,keyHolder);
        contact.setContactId(keyHolder.getKey().intValue());
    }

    @Override
    public void update(Contact contact) {
        
        String sql="UPDATE contactSET name=:name,phone=:phone,email=:email,address=:address,remark=:remark"
                + " WHERE contactId=:contactId";
                
        Map n=new HashMap();
        n.put("userId", contact.getUserId());
        n.put("name", contact.getName());
        n.put("phone", contact.getPhone());
        n.put("email", contact.getEmail());
        n.put("address", contact.getAddress());
        n.put("remark", contact.getRemark());
        
        getNamedParameterJdbcTemplate().update(sql, n);
    }

    @Override
    public void delete(Contact contact) {
        this.delete(contact.getContactId());
    }

    @Override
    public void delete(Integer contactId) {
        String sql="DELETE FROM contact WHERE contactId=?";
        getJdbcTemplate().update(sql,contactId);
    }

    @Override
    public Contact findById(Integer contactId) {
        String sql="SELECT contactId,userId,name,phone,email,address,remark FROM contact "
                + "WHERE contactId=?";
        return getJdbcTemplate().queryForObject(sql, new ContactRowMapper(), contactId);
    }

    @Override
    public List<Contact> findAll() {
        String sql="SELECT contactId,userId,name,phone,email,address,remark FROM contact";
        return getJdbcTemplate().query(sql, new ContactRowMapper());
    }

    @Override
    public List<Contact> findByProperty(String propName, Object propValue) {
        String sql="SELECT contactId,userId,name,phone,email,address,remark FROM contact WHERE "+propName+"=?";
        return getJdbcTemplate().query(sql, new ContactRowMapper(), propValue);
    }
}
