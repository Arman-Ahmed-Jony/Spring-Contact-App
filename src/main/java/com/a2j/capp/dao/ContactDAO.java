/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a2j.capp.dao;

import com.a2j.capp.domain.Contact;
import java.util.List;

/**
 *
 * @author Arman
 */
public interface ContactDAO {

    public void save(Contact contact);

    public void update(Contact contact);

    public void delete(Contact contact);

    public void delete(Integer contactId);

    public Contact findById(Integer contactId);

    public List<Contact> findAll();

    public List<Contact> findByProperty(String propName, Object propValue);

}
