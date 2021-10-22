package ru.vironit.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.vironit.app.dao.filter.ServletUtils;
import ru.vironit.app.entities.Client;
import ru.vironit.app.services.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "login";

    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(@ModelAttribute Client user, HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Client client = new ClientService().loginClient(user.getEmail(), user.getPassword());
        HttpSession session = request.getSession();
        String referer = (String) session.getAttribute("referer");
        if(client != null) {
            ServletUtils.deleteLoggedUser(session);
            ServletUtils.deleteUserCookie(response, session);
            ServletUtils.storeUserCookie(response, user.getEmail(), user.getPassword(), "CLIENT");
            return "redirect:" + referer;
        } else {
            return "login";
        }
    }
}
