/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a2j.capp.controller;

import com.a2j.capp.command.ContactCommand;
import com.a2j.capp.service.ContactService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Arman
 */
@Controller
public class ContactController {

    @Autowired
    private ContactService service;

    @RequestMapping(value = "/user/contact_form")
    public String contactForm(Model m) {
        m.addAttribute("command", new ContactCommand());
        return "contact_form";

    }

    @RequestMapping(value = "/user/save_contact")
    public String saveContact(@ModelAttribute("command") ContactCommand cmd, Model m, HttpSession session) {
        //[NOTE: ModelAttribute is used to access or recieve command]

        try {
            cmd.getContact().setUserId((Integer) session.getAttribute("userId"));// as userId is a forign key. and userId is saved in HttpSession Scope.
            service.save(cmd.getContact());
            return "redirect:contact_list?action=save";

        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("err", "Failed to Save Contact!");
            return "contact_form";
        }

    }

    @RequestMapping(value = "/user/contact_list")
    public String contactList(Model m) {
        //TODO
        return "contact_list";

    }

}
