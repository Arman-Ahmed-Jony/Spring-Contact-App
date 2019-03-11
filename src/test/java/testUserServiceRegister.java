
import com.a2j.capp.config.SpringRootConfig;
import com.a2j.capp.dao.UserDAO;
import com.a2j.capp.domain.User;
import com.a2j.capp.service.UserService;
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
public class testUserServiceRegister {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserService userService = ctx.getBean(UserService.class);

		User u = new User();
		u.setName("akash");
		u.setPhone("turba");
		u.setEmail("amit@ezeon.net");
		u.setAddress("Mumbai");
		u.setLoginName("akash786");
		u.setPassword("amit123");
		u.setRole(UserService.ROLE_ADMIN);// Admin Role
		u.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE); // Active
		userService.register(u);
		System.out.println("--------user registration succesfully------");
	}
}
