

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Arman
 */
import com.a2j.capp.config.SpringRootConfig;
import com.a2j.capp.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class checkAvailibilityTest {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserService userDAO = ctx.getBean(UserService.class);
        System.out.println(userDAO.isLoginNameExist("arman"));
        System.out.println(userDAO.isLoginNameExist("armanaa"));
        
    }
}
