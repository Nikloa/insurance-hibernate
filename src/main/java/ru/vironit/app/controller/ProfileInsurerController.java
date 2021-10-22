package ru.vironit.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.vironit.app.dao.filter.ServletUtils;
import ru.vironit.app.entities.Insurer;
import ru.vironit.app.entities.Licence;
import ru.vironit.app.entities.Offer;
import ru.vironit.app.services.InsurerService;
import ru.vironit.app.services.LicenceService;
import ru.vironit.app.services.OfferService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

@Controller
@RequestMapping("/profileInsurer")
public class ProfileInsurerController {

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Insurer insurer = (Insurer) ServletUtils.getLoggedUser(session);
        Licence licence = new LicenceService().checkLicence(insurer.getId());
        request.setAttribute("licence", licence);
        request.setAttribute("insurer", insurer);
        return "profileInsurer";

    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession session = request.getSession();
        Insurer insurer = (Insurer) ServletUtils.getLoggedUser(session);
        String offerButton = request.getParameter("offerButton");
        String licenceButton = request.getParameter("licenceButton");
        String profileButton = request.getParameter("profileButton");

        if (offerButton != null) {
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

        if (licenceButton != null) {
            Licence licence = new Licence();
            licence.setInsurerId(insurer.getId());
            licence.setInsurerName(request.getParameter("insurerName"));
            licence.setAddress(request.getParameter("address"));
            licence.setTaxpayerIdentificationNumber(Integer.parseInt(request.getParameter("taxpayerNumber")));
            licence.setLicenceNumber(request.getParameter("licenceNumber"));
            licence.setIssueDecisionDate(Date.valueOf(request.getParameter("decisionDate")));
            licence.setIssueDecisionNumber(Integer.parseInt(request.getParameter("decisionNumber")));
            licence.setConfirmation(false);
            try {
                LicenceService licenceService = new LicenceService();
                Licence oldLicence = licenceService.checkLicence(insurer.getId());
                if (oldLicence == null) {
                    licenceService.addLicence(licence);
                } else {
                    licence.setId(oldLicence.getId());
                    licenceService.updateLicence(licence, oldLicence.getId());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (profileButton != null) {
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
        }
        doGet(request, response);

        return "profileInsurer";
    }

}
