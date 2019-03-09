package com.a2j.capp.controller;

import com.a2j.capp.command.LoginCommand;
import com.a2j.capp.domain.User;
import com.a2j.capp.exception.UserBlockedException;
import com.a2j.capp.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Arman
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/index", "/"})
    public String Index(Model m) {
        m.addAttribute("command", new LoginCommand());
        return "index";     //it's a JSP page. and is resolved by view resolver
        //JSP    /WEB-INF/view/index.jsp
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {
        try {
            User loggedInUser = userService.login(cmd.getLoginName(), cmd.getPassword());
            if (loggedInUser == null) {
                m.addAttribute("err", "Login failed! Enter valied credentials");
                return "index";
            } else {
                if (loggedInUser.getRole().equals(UserService.ROLE_ADMIN)) {
                    addUserInSession(loggedInUser, session);
                    return "redirect:admin/dashboard";
                } else if (loggedInUser.getRole().equals(UserService.ROLE_USER)) {
                    addUserInSession(loggedInUser, session);
                    return "redirect:user/dashboard";
                } else {
                    m.addAttribute("err", "No such user role");
                    return "index";
                }
            }
        } catch (UserBlockedException ex) {
            //add error message and go back to login-form
            m.addAttribute("err", ex.getMessage());
            return "index";
        }
    }

    @RequestMapping(value = "/logout")
    public String userDashBoard(HttpSession session) {
        session.invalidate();
        return "redirect:index?action=logout";     //it's a JSP page. and is resolved by view resolver
        //JSP    /WEB-INF/view/index.jsp
    }
    
    @RequestMapping(value = "/user/dashboard")
    public String userDashBoard() {
        return "user_dashboard";     //it's a JSP page. and is resolved by view resolver
        //JSP    /WEB-INF/view/index.jsp
    }

    @RequestMapping(value = "/admin/dashboard")
    public String adminDashBoard() {
        return "admin_dashboard";     //it's a JSP page. and is resolved by view resolver
        //JSP    /WEB-INF/view/index.jsp
    }

    private void addUserInSession(User user, HttpSession session) {
        session.setAttribute("user", user);
        session.setAttribute("userId", user.getUserId());
        session.setAttribute("role", user.getRole());

    }

}
