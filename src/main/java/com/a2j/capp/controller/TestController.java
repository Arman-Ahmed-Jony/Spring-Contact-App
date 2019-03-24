/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a2j.capp.controller;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Arman
 */
@Controller
public class TestController {
    private final Logger logger=LoggerFactory.getLogger(this.getClass());
        
    @RequestMapping(value = "/time_server")
    @ResponseBody
    public String getServerTime(){
        logger.info("-------------server time is called--------------");
        return new Date().toString();
    }
}
