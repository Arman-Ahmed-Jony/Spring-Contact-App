/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a2j.capp.command;

import com.a2j.capp.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Arman
 */
public class ContactCommand {
	@Autowired
	private Contact contact;

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
        

}
