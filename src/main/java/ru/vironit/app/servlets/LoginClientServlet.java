package ru.vironit.app.servlets;

import ru.vironit.app.dao.filter.ServletUtils;
import ru.vironit.app.entities.Client;
import ru.vironit.app.entities.User;
import ru.vironit.app.services.ClientService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginClientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/login.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if(new ClientService().loginClient(request.getParameter("email"), request.getParameter("password"))) {
                ServletUtils.storeUserCookie(response, request.getParameter("email"), "CLIENT");
                System.out.println("LoginClientServlet parameter button " + request.getParameter("button"));
                //response.sendRedirect(request.getHeader("referer"));
                response.sendRedirect(request.getParameter("button"));
                //response.sendRedirect((String) request.getAttribute("javax.servlet.forward.request_uri"));
            } else {
                doGet(request, response);
            }
            System.out.println("Login Servlet ----- ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
