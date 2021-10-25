package ru.vironit.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.vironit.app.dao.filter.ServletUtils;
import ru.vironit.app.services.InsurerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
@RequestMapping("/loginInsurer")
public class LoginInsurerController {

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap model) {

        return "loginInsurer";

    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession session = request.getSession();
        InsurerService insurerService = new InsurerService();
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (insurerService.loginInsurer(email, password) != null) {
            ServletUtils.deleteLoggedUser(session);
            ServletUtils.deleteUserCookie(response, session);
            ServletUtils.storeUserCookie(response, email, password, "INSURER");
            return "redirect:" + session.getAttribute("referer");
        }

        return "loginInsurer";
    }
}
