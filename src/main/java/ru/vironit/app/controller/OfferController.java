package ru.vironit.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.vironit.app.dao.filter.ServletUtils;
import ru.vironit.app.entities.Contract;
import ru.vironit.app.entities.Offer;
import ru.vironit.app.entities.User;
import ru.vironit.app.services.ContractService;
import ru.vironit.app.services.OfferService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import static ru.vironit.app.entities.Role.CLIENT;

@Controller
@RequestMapping("/offer")
public class OfferController {

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap model) throws SQLException {

        return "offer";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPost(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        HttpSession session = request.getSession();
        String offer_id = request.getParameter("buy");
        if(request.getParameter("buy") != null) {
            User user = ServletUtils.getLoggedUser(session);
            if(user != null && user.getRole() == CLIENT) {
                try {
                    Offer offer = new OfferService().extractOffer((int) session.getAttribute("view"));
                    Contract contract = new Contract();
                    LocalDate term = LocalDate.now();
                    term.plusDays(offer.getTerm());
                    Date date = Date.valueOf(term);
                    contract.setContractDate(date);
                    contract.setInsurerConfirmContractStatus(false);
                    contract.setClientConfirmPaymentStatus(false);
                    contract.setClientIncidentStatus(false);
                    contract.setInsurerConfirmIncidentStatus(false);
                    contract.setClientConfirmPaymentStatus(false);
                    contract.setClientId(user.getId());
                    contract.setOfferId(offer.getId());
                    new ContractService().addContract(contract);
                    return "redirect:http://localhost:8080/profile";
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(request.getHeader("referer"));
                return "redirect:http://localhost:8080/login";
            }
        }

        return "offer";
    }
}
