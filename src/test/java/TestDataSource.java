
import com.a2j.capp.config.SpringRootConfig;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Arman
 */
public class TestDataSource {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        DataSource ds = ac.getBean(DataSource.class);
        JdbcTemplate jt = new JdbcTemplate(ds);
        String sql = "INSERT INTO user(`name`, `phone`, `email`, `address`, `loginName`, `password`) VALUES(?,?,?,?,?,?)";
        Object[] param = new Object[]{"arman", "01906402798", "15103103@iubat.edu", "A2J", "123"};
        jt.update(sql, param);
        System.out.println("--------SQL EXECUTED-------");
    }
}
