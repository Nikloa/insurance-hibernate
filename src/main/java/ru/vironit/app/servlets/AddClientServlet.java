package ru.vironit.app.servlets;

import ru.vironit.app.entities.Client;
import ru.vironit.app.services.ClientService;

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

        Client client = new Client();
        client.setNickname(request.getParameter("nickname"));
        client.setEmail(request.getParameter("email"));
        client.setPassword(request.getParameter("password"));
        //client.setPhone(Integer.parseInt(request.getParameter("phone")));
        client.setBalance(BigDecimal.valueOf(0));
        client.setRating(0);
        System.out.println(client.toString());

        Client newClient = new Client();
        newClient.setNickname("pidor");

        try {
            new ClientService().addClient(client);
            new ClientService().addClient(newClient);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("userName", client.getNickname());
        doGet(request, response);
    }
}
