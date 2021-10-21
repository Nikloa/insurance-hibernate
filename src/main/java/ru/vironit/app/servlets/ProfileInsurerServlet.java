package ru.vironit.app.servlets;

import ru.vironit.app.dao.filter.ServletUtils;
import ru.vironit.app.entities.Insurer;
import ru.vironit.app.entities.Licence;
import ru.vironit.app.entities.Offer;
import ru.vironit.app.entities.User;
import ru.vironit.app.services.InsurerService;
import ru.vironit.app.services.LicenceService;
import ru.vironit.app.services.OfferService;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ProfileInsurerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Insurer insurer = (Insurer) ServletUtils.getLoggedUser(session);
        Licence licence = new LicenceService().checkLicence(insurer.getId());
        request.setAttribute("licence", licence);
        request.setAttribute("insurer", insurer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/profileInsurer.jsp");
        requestDispatcher.forward(request, response);
        System.out.println("doPost missed");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Insurer insurer = (Insurer) ServletUtils.getLoggedUser(session);
        String offerButton = request.getParameter("offerButton");
        String licenceButton = request.getParameter("licenceButton");
        String profileButton = request.getParameter("profileButton");

        if(offerButton != null || licenceButton != null || profileButton != null) {
            if(offerButton != null) {
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
                response.sendRedirect("profileInsurer");
            }

            if(licenceButton != null) {
                Licence licence = new Licence();
                licence.setInsurerId(insurer.getId());
                licence.setInsurerName(request.getParameter("insurerName"));
                licence.setAddress(request.getParameter("address"));
                licence.setTaxpayerIdentificationNumber(Integer.parseInt(request.getParameter("taxpayerNumber")));
                licence.setLicenceNumber(request.getParameter("licenceNumber"));
                licence.setIssueDecisionDate(Date.valueOf(request.getParameter("decisionDate")));
                licence.setIssueDecisionNumber(Integer.parseInt(request.getParameter("decisionNumber")));
                licence.setConfirmation(false);
                System.out.println(licence.toString());
                try {
                    LicenceService licenceService = new LicenceService();
                    Licence oldLicence = licenceService.checkLicence(insurer.getId());
                    if(oldLicence == null) {
                        licenceService.addLicence(licence);
                    } else {
                        licence.setId(oldLicence.getId());
                        licenceService.updateLicence(licence, oldLicence.getId());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                response.sendRedirect("profileInsurer");
            }

            if(profileButton != null) {
                InsurerService insurerService = new InsurerService();
                insurer.setNickname(request.getParameter("nickname"));
                insurer.setEmail(request.getParameter("email"));
                insurer.setPassword(request.getParameter("password"));
                insurer.setShortCompanyName(request.getParameter("companyName"));
                insurer.setInformationPhone(insurerService.parsePhone(request.getParameter("informationPhone")));
                try {
                    insurerService.updateInsurer(insurer);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                response.sendRedirect("profileInsurer");
            }
        } else {
            doGet(request, response);
        }

    }
}
