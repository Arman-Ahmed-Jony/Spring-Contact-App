
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
public class saveOperation {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		// TODO: the user details will be taken from User-Reg-Form
		User u = new User();
		u.setName("Amit");
		u.setPhone("9303580884");
		u.setEmail("amit@ezeon.net");
		u.setAddress("Mumbai");
		u.setLoginName("amithjkhjkhj");
		u.setPassword("amit123");
		u.setRole(1);// Admin Role
		u.setLoginStatus(1); // Active
		userDAO.save(u);
		System.out.println("--------Data Saved------");
	}
}
