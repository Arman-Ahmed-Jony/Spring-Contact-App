
import com.a2j.capp.config.SpringRootConfig;
import com.a2j.capp.dao.UserDAO;
import com.a2j.capp.domain.User;
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
public class UserFindUserRecord {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		// TODO: the user details will be taken from User-Reg-Form
		User u = userDAO.findById(2);
		System.out.println(u.getName());
		System.out.println(u.getAddress());

	}
}
