/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a2j.capp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Arman
 */
@Controller
public class UserController {
    @RequestMapping(value = {"/index","/"})
    public String Index(){
        return "hello";     //it's a JSP page. and is resolved by view resolver
                            //JSP    /WEB-INF/view/index.jsp
    }
    
}
