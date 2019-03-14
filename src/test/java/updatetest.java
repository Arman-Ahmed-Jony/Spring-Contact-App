
import com.a2j.capp.config.SpringRootConfig;
import com.a2j.capp.dao.ContactDAO;
import com.a2j.capp.dao.ContactDAOImpl;
import com.a2j.capp.dao.UserDAO;
import com.a2j.capp.domain.Contact;
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
public class updatetest {

    public static void main(String[] args) {
        
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		      ContactDAO contactDAO = ctx.getBean(ContactDAO.class);
       
        Contact c = new Contact();
        c.setUserId(3);
        c.setRemark("good person");
        c.setPhone("01906402798");
        c.setName("asad2");
        c.setEmail("test@gmail.com");
        c.setContactId(18);
        c.setAddress("1888 test");
        System.out.println(contactDAO.findById(18));
        contactDAO.update(c);
        System.out.println(contactDAO.findById(18));

    }
}
