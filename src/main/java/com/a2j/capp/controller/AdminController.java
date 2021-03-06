/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a2j.capp.controller;

import com.a2j.capp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Arman
 */
@Controller
public class AdminController {

    @Autowired
    private UserService service;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/admin/users")
    public String userList(Model m) {
        logger.info("userList method invocked");
        m.addAttribute("user_list", service.getUserList());
        return "user_list";
    }

    @RequestMapping(value = "/admin/changeLoginStatus")
    @ResponseBody
    public String changeLoginStatus(@RequestParam Integer userId,@RequestParam Integer loginStatus) {
        try {
            service.changeLoginStatus(userId, loginStatus);
            return "SUCCESS: Status Changed";
        } catch (Exception e) {
            return "ERROR: Unable to Change Status";
        }
    }
}
