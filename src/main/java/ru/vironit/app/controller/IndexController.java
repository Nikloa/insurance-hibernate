package ru.vironit.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.vironit.app.dao.filter.ServletUtils;
import ru.vironit.app.entities.Client;
import ru.vironit.app.entities.InsuranceType;
import ru.vironit.app.entities.User;
import ru.vironit.app.services.InsuranceTypeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(HttpServletRequest request, HttpServletResponse response) throws SQLException{

        HttpSession session = request.getSession();
        User user = ServletUtils.getLoggedUser(session);

        ArrayList<InsuranceType> typeList = new InsuranceTypeService().allInsuranceType();
        request.setAttribute("typeList", typeList);

        request.setAttribute("user", user);

        return "index";

    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession session = request.getSession();
        if(request.getParameter("logout") != null) {
            ServletUtils.deleteLoggedUser(session);
            ServletUtils.deleteUserCookie(response, session);
            System.out.println("Logout");
        }

        doGet(request, response);
        return "index";
    }
}
