package ru.vironit.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.vironit.app.dao.filter.ServletUtils;
import ru.vironit.app.entities.InsuranceType;
import ru.vironit.app.services.InsuranceTypeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
@RequestMapping("/offers")
public class OffersController {

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(HttpServletRequest request, HttpServletResponse response) {

        return "offers";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession session = request.getSession();
        if(request.getParameter("view") != null) {
            session.setAttribute("view", Integer.parseInt(request.getParameter("view")));
            return "redirect:http://localhost:8080/offer";
        }

        return "offers";
    }
}
