package ru.vironit.app.dao.interfaces;

import ru.vironit.app.entities.Insurer;

import java.sql.SQLException;

public interface InsurerInterface {

    void addInsurer(Insurer insurer) throws SQLException;
    Insurer extractInsurer(int id) throws SQLException;
    void updateInsurer(Insurer newInsurer, int id) throws SQLException;
    void deleteInsurer(int id) throws SQLException;
}
