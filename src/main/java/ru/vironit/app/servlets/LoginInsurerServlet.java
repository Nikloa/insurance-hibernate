package ru.vironit.app.servlets;

import ru.vironit.app.dao.filter.ServletUtils;
import ru.vironit.app.services.ClientService;
import ru.vironit.app.services.InsurerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginInsurerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/loginInsurer.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InsurerService insurerService = new InsurerService();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            if(insurerService.loginInsurer(email, password) != null) {
                ServletUtils.storeUserCookie(response, email, password, "INSURER");
                response.sendRedirect(request.getParameter("button"));
            } else {
                doGet(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
