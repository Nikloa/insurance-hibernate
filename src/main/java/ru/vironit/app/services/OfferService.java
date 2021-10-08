package ru.vironit.app.services;

import ru.vironit.app.dao.implementation.OfferImplementation;
import ru.vironit.app.dao.interfaces.OfferInterface;
import ru.vironit.app.entities.Offer;

import java.sql.SQLException;
import java.util.ArrayList;

public class OfferService implements OfferInterface {

    private OfferImplementation implementation;

    public OfferService() {
        implementation = new OfferImplementation();
    }

    @Override
    public void addOffer(Offer offer) throws SQLException {
        implementation.addOffer(offer);
    }

    @Override
    public Offer extractOffer(int id) throws SQLException {
        Offer offer = implementation.extractOffer(id);
        return offer;
    }

    @Override
    public void updateOffer(Offer offer, int id) throws SQLException {
        implementation.updateOffer(offer, id);
    }

    @Override
    public void deleteOffer(int id) throws  SQLException {
        implementation.deleteOffer(id);
    }

    @Override
    public ArrayList<Offer> listOffer() throws SQLException {
        return implementation.listOffer();
    }
}
