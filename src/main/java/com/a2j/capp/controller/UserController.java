package com.a2j.capp.controller;

import com.a2j.capp.command.LoginCommand;
import com.a2j.capp.command.UserCommand;
import com.a2j.capp.domain.User;
import com.a2j.capp.exception.UserBlockedException;
import com.a2j.capp.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Arman
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/index", "/"}) // browser URL /index or root
    public String Index(Model m) {
        m.addAttribute("command", new LoginCommand());
        return "index"; // it's a JSP page. and is resolved by view resolver
        // JSP /WEB-INF/view/index.jsp
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
            // add error message and go back to login-form
            m.addAttribute("err", ex.getMessage());
            return "index";
        }
    }

    @RequestMapping(value = "/logout")
    public String userDashBoard(HttpSession session) {
        session.invalidate();
        return "redirect:index?action=logout"; // it's a JSP page. and is resolved by view resolver
        // JSP /WEB-INF/view/index.jsp
    }

    @RequestMapping(value = "/user/dashboard")
    public String userDashBoard() {
        return "user_dashboard"; // it's a JSP page. and is resolved by view resolver
        // JSP /WEB-INF/view/index.jsp
    }

    @RequestMapping(value = "/admin/dashboard")
    public String adminDashBoard() {
        return "admin_dashboard"; // it's a JSP page. and is resolved by view resolver
        // JSP /WEB-INF/view/index.jsp
    }

    @RequestMapping(value = "/registration_form")
    public String registrationForm(Model m) {
        m.addAttribute("command", new UserCommand());
        return "reg_form";
    }

    @RequestMapping(value = "/register")
    public String registerUser(@ModelAttribute("command") UserCommand command, Model m) {
        try {
            User user = command.getUser();
            user.setRole(UserService.ROLE_USER);
            user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);

            userService.register(user);

            return "redirect:index?action=reg";
        } catch (DuplicateKeyException dke) {
            m.addAttribute("err", "User name is already taken. Select another name");
            return "reg_form"; // jsp page
        }
    }

    private void addUserInSession(User user, HttpSession session) {
        session.setAttribute("user", user);
        session.setAttribute("userId", user.getUserId());
        session.setAttribute("role", user.getRole());

    }

    //check_avail
    @RequestMapping(value = "/check_avail")
    @ResponseBody
    public String checkAvailibility(@RequestParam String loginName) {
        if (userService.isLoginNameExist(loginName)) {
            return "this user name is already Taken";
        } else {
            return "yes you can take this user name";
        }
    }
}
