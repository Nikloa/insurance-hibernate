package ru.vironit.app.servlets;

import ru.vironit.app.dao.filter.ServletUtils;
import ru.vironit.app.entities.Client;
import ru.vironit.app.entities.User;
import ru.vironit.app.services.ClientService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User client = ServletUtils.getLoggedUser(session);

        System.out.println(client.toString());

        request.setAttribute("nickname", client.getNickname());
        request.setAttribute("email", client.getEmail());
        request.setAttribute("password", client.getPassword());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/profile.jsp");
        requestDispatcher.forward(request, response);
        System.out.println("doPost missed");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }
}
