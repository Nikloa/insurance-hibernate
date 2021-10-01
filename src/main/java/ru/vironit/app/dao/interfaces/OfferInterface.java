package ru.vironit.app.dao.interfaces;

import ru.vironit.app.entities.Offer;

import java.sql.SQLException;

public interface OfferInterface {

    void addOffer(Offer offer) throws SQLException;
    Offer extractOffer(int id) throws SQLException;
    void updateOffer(Offer offer, int id) throws SQLException;
    void deleteOffer(int id) throws SQLException;
}
