package ru.vironit.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.vironit.app.dao.filter.ServletUtils;
import ru.vironit.app.entities.Client;
import ru.vironit.app.entities.InsuranceType;
import ru.vironit.app.entities.Role;
import ru.vironit.app.entities.User;
import ru.vironit.app.services.ClientService;
import ru.vironit.app.services.InsuranceTypeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
@RequestMapping("/add")
public class AddController {

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        return "add";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        ClientService clientService = new ClientService();
        String email = request.getParameter("email");
        HttpSession session = request.getSession();

        if (clientService.checkClient(email)) {
            Client client = new Client();
            client.setNickname(request.getParameter("nickname"));
            client.setRole(Role.CLIENT);
            client.setEmail(email);
            client.setPassword(request.getParameter("password"));
            String phone = request.getParameter("phone");
            int phoneNumber = clientService.parsePhone(phone);
            client.setPhone(phoneNumber);
            clientService.addClient(client);
            ServletUtils.deleteLoggedUser(session);
            ServletUtils.deleteUserCookie(response, session);
            ServletUtils.storeUserCookie(response, request.getParameter("email"), request.getParameter("password"), "CLIENT");
            return "redirect:" + session.getAttribute("referer");
        } else {
            request.setAttribute("error", email);
        }
        return "add";
    }
}
