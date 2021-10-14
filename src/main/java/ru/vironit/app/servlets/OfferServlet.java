package ru.vironit.app.servlets;

import ru.vironit.app.dao.filter.ServletUtils;
import ru.vironit.app.entities.*;
import ru.vironit.app.services.ContractService;
import ru.vironit.app.services.OfferService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;

import static ru.vironit.app.entities.Role.CLIENT;

public class OfferServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/offer.jsp");
        System.out.println(request.getParameter("id"));
        requestDispatcher.forward(request, response);
        System.out.println("Post missed");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String offer_id = request.getParameter("buy");
        System.out.println(request.getParameter("id"));
        System.out.println("buy ---" + request.getParameter("buy") + "---" + offer_id);
        if(request.getParameter("buy") != null) {
            User user = ServletUtils.getLoggedUser(session);
            if(user != null && user.getRole() == CLIENT) {
                try {
                    Offer offer = new OfferService().extractOffer((int) session.getAttribute("view"));
                    Contract contract = new Contract();
                    LocalDate term = LocalDate.now();
                    term.plusDays(offer.getTerm());
                    Date date = Date.valueOf(term);
                    contract.setDate(date);
                    contract.setInsurerConfirmContractStatus(false);
                    contract.setClientConfirmPaymentStatus(false);
                    contract.setClientIncidentStatus(false);
                    contract.setInsurerConfirmIncidentStatus(false);
                    contract.setClientConfirmPaymentStatus(false);
                    contract.setClientId(user.getId());
                    contract.setOfferId(offer.getId());
                    new ContractService().addContract(contract);
                    response.sendRedirect("profile");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                //session.setAttribute("previous_uri", "offer");
                //System.out.println(session.getAttribute("previous_uri"));
                System.out.println(request.getHeader("referer"));
                response.sendRedirect("login");
            }
        } else {
            doGet(request, response);
        }
    }
}
