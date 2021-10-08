package ru.vironit.app.servlets;

import ru.vironit.app.entities.Insurer;
import ru.vironit.app.services.InsurerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddInsurerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/addInsurer.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Insurer insurer = new Insurer();
            insurer.setNickname(request.getParameter("nickname"));
            insurer.setEmail(request.getParameter("email"));
            insurer.setPassword(request.getParameter("password"));
            //insurer.setPhone(Integer.parseInt(request.getParameter("phone")));
            insurer.setCompanyName("companyName");
            System.out.println(insurer.toString());

            try {
                new InsurerService().addInsurer(insurer);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        doGet(request, response);
    }
}
