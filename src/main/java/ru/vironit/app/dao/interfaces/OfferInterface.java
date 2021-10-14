package ru.vironit.app.dao.interfaces;

import ru.vironit.app.entities.Offer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OfferInterface {

    void addOffer(Offer offer) throws SQLException;
    Offer extractOffer(int id) throws SQLException;
    void updateOffer(Offer offer, int id) throws SQLException;
    void deleteOffer(int id) throws SQLException;
    ArrayList<Offer> listOffer() throws SQLException;
    ArrayList<Offer> listInsurerOffer(int insurer_id) throws SQLException;
    ArrayList<Offer> listTypeOffer(int insurance_type_id) throws SQLException;

}
