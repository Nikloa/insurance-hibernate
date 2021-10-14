package ru.vironit.app.servlets;

import ru.vironit.app.dao.filter.ServletUtils;
import ru.vironit.app.entities.Client;
import ru.vironit.app.entities.Insurer;
import ru.vironit.app.entities.Role;
import ru.vironit.app.services.ClientService;
import ru.vironit.app.services.InsurerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

public class AddClientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/add.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClientService clientService = new ClientService();
        String email = request.getParameter("email");

        try {
            if(clientService.checkClient(email) == null) {
                Client client = new Client();
                client.setNickname(request.getParameter("nickname"));
                client.setRole(Role.CLIENT);
                client.setEmail(email);
                client.setPassword(request.getParameter("password"));
                String phone = request.getParameter("phone");
                int phoneNumber = clientService.parsePhone(phone);
                client.setPhone(phoneNumber);
                clientService.addClient(client);
                ServletUtils.storeUserCookie(response, request.getParameter("email"), "CLIENT");
                response.sendRedirect("history.back()");
            } else {
                request.setAttribute("error", email);
                doGet(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
