package ru.vironit.app.servlets;

import ru.vironit.app.dao.filter.ServletUtils;
import ru.vironit.app.entities.Insurer;
import ru.vironit.app.entities.Offer;
import ru.vironit.app.entities.User;
import ru.vironit.app.services.OfferService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

public class ProfileInsurerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/profileInsurer.jsp");
        requestDispatcher.forward(request, response);
        System.out.println("doPost missed");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Insurer insurer = (Insurer) ServletUtils.getLoggedUser(session);
        System.out.println("Servlet button ---" + request.getParameter("offerButton") + "---");
        if(request.getParameter("offerButton") != null) {
            System.out.println("---TRUE---");
            Offer offer = new Offer();
            offer.setInsuranceTypeId(Integer.parseInt(request.getParameter("insuranceType")));
            offer.setDescription(request.getParameter("description"));
            offer.setCost(new BigDecimal(request.getParameter("cost")));
            offer.setInsurerId(insurer.getId());
            offer.setVisible(true);
            offer.setTerm(Integer.parseInt(request.getParameter("term")) * Integer.parseInt(request.getParameter("termType")));
            try {
                new OfferService().addOffer(offer);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        doGet(request, response);
    }
}
