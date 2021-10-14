package ru.vironit.app.servlets;

import ru.vironit.app.dao.filter.ServletUtils;
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
        InsurerService insurerService = new InsurerService();
        String email = request.getParameter("email");


        try {
            if(insurerService.checkInsurer(email) == null) {
                Insurer insurer = new Insurer();
                insurer.setNickname(request.getParameter("nickname"));
                insurer.setEmail(email);
                insurer.setPassword(request.getParameter("password"));
                insurer.setPhone(insurerService.parsePhone(request.getParameter("phone")));
                insurer.setCompanyName(request.getParameter("companyName"));
                insurerService.addInsurer(insurer);
                System.out.println(insurer.toString());
                ServletUtils.storeUserCookie(response, request.getParameter("email"), "INSURER");
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
