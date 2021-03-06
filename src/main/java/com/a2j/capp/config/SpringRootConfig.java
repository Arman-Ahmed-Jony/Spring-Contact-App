/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a2j.capp.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Vikram
 */
@Configuration
@ComponentScan(basePackages = { "com.a2j.capp.dao", "com.a2j.capp.service" })
public class SpringRootConfig {
	// TODO: Services, DAO, DataSource, Email Sender or some other business layer
	// beans
	@Bean
	public BasicDataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();         
		ds.setDriverClassName("com.mysql.jdbc.Driver");     //JDBC driver class name
                ds.setUrl("jdbc:mysql://sql12.freemysqlhosting.net/sql12285008"); //connection URL
		//ds.setUrl("jdbc:mysql://localhost:3306/conapp_db"); //connection URL
                ////demo.phpmyadmin.net/springTest
		ds.setUsername("sql12285008"); //database username
		ds.setPassword("4GFNHTfqW7"); //database password
		ds.setMaxTotal(-1); //no limit idle connection
		ds.setInitialSize(1);
		ds.setTestOnBorrow(true);
		ds.setValidationQuery("SELECT 1");
		ds.setDefaultAutoCommit(true);
		return ds;
	}
}
