
import com.a2j.capp.config.SpringRootConfig;
import com.a2j.capp.dao.UserDAO;
import com.a2j.capp.domain.User;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arman
 */
public class UserFindByProplRecord {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO=ctx.getBean(UserDAO.class);
        //TODO: the user details will be taken from User-Reg-Form
        
        List<User> users=userDAO.findByProperty("address", "Dhaka");
        
        System.out.println(users.toString());
        
    }
}
