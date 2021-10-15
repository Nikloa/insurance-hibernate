package ru.vironit.app.servlets;

import ru.vironit.app.dao.filter.ServletUtils;
import ru.vironit.app.entities.Client;
import ru.vironit.app.entities.InsuranceType;
import ru.vironit.app.entities.Role;
import ru.vironit.app.entities.User;
import ru.vironit.app.services.ClientService;
import ru.vironit.app.services.InsuranceTypeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = ServletUtils.getLoggedUser(session);

        try {
            ArrayList<InsuranceType> typeList = new InsuranceTypeService().allInsuranceType();
            request.setAttribute("typeList", typeList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("user", user);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println(request.getParameter("logout"));
        if(request.getParameter("logout") != null) {
            ServletUtils.deleteLoggedUser(session);
            ServletUtils.deleteUserCookie(response, session);
            System.out.println("Logout");
        }

        doGet(request, response);
    }
}
