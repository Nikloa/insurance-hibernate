package app.servlets;

import app.dao.DBIO;
import app.entities.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/add.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nickname = "";
        Client client = new Client();
        client.setNickname(request.getParameter("name"));
        client.setPassword(request.getParameter("password"));
        //Model model = Model.getInstance();
        DBIO test = new DBIO();
        try {
            test.addClient(client);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Class.forName("org.postgresql.jdbc.Driver");

            System.out.println("good");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("userName", nickname);
        doGet(request, response);
    }
}
