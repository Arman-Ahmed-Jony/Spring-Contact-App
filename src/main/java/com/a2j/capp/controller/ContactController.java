/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a2j.capp.controller;

import com.a2j.capp.command.ContactCommand;
import com.a2j.capp.domain.Contact;
import com.a2j.capp.service.ContactService;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Arman
 */
@Controller
public class ContactController {

    @Autowired
    private ContactService service;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/user/contact_form")
    public String contactForm(Model m, HttpSession session) {
        m.addAttribute("command", new ContactCommand());
        logger.info("contact form invecked");
        return "contact_form";
    }

    @RequestMapping(value = "/user/edit_contact")
    public String prepareContactForm(@RequestParam("contactId") Integer contactId, Model m, HttpSession session) {
        logger.info("prepareContactForm method invecked");
        session.setAttribute("attribute_contact", contactId);
        logger.info("contact id "+contactId.toString());
        Contact contact = service.findById(contactId);
        logger.info("contact object "+contact.toString());
        ContactCommand contactCommand = new ContactCommand();
        contactCommand.setContact(contact);
        logger.info("contactCommand object "+contactCommand.toString());
        m.addAttribute("command", contactCommand);
        logger.info("invoking form");
        return "contact_form";

    }

    @RequestMapping(value = "/user/save_contact")
    public String saveOrUpdateContact(@ModelAttribute("command") ContactCommand cmd, Model m, HttpSession session) {
        // [NOTE: ModelAttribute is used to access or recieve command]

        //if contactId of session is null than it is a save operation.
        if ((Integer)session.getAttribute("attribute_contact") == null) {
            try {
                cmd.getContact().setUserId((Integer) session.getAttribute("userId"));// as userId is a forign key. and
                // userId is saved in HttpSession
                // Scope.
                service.save(cmd.getContact());
                return "redirect:contact_list?action=save";

            } catch (Exception e) {
                e.printStackTrace();
                m.addAttribute("err", "Failed to Save Contact!");
                return "contact_form";
            }
            //but is there is contactId in session. then it's a edit operaion
        } else {
            try {
                cmd.getContact().setContactId((Integer) session.getAttribute("attribute_contact"));
                Contact c = cmd.getContact();

                service.update(c);
                return "redirect:contact_list?action=edit";

            } catch (Exception e) {
                e.printStackTrace();
                m.addAttribute("err", "Failed to edit Contact!");
                return "contact_form";
            }
        }

    }

    @RequestMapping(value = "/user/contact_list")
    public String contactList(Model m, HttpSession session) {
        m.addAttribute("contactList", service.findUserContact((Integer) session.getAttribute("userId")));
        return "contact_list";

    }
    @RequestMapping(value = "/user/contact_search")
    public String contactSearch(Model m, HttpSession session, @RequestParam("free_text") String freeText){
        m.addAttribute("contactList", service.findUserContact((Integer)session.getAttribute("userId"), freeText));
        return "contact_list";
    }

    @RequestMapping(value = "/user/delete_contact")
    public String contactDelete(@RequestParam("contactId") Integer contactId) {
        service.delete(contactId);
        return "redirect:contact_list?action=delete";

    }
    @RequestMapping(value = "/user/bulk_delete_contact")
    public String bulkContactDelete(@RequestParam("contactId") Integer[] contactIds) {
        service.delete(contactIds);
        return "redirect:contact_list?action=delete";

    }
    

}
