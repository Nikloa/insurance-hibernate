package ru.vironit.app.dao.interfaces;

import ru.vironit.app.entities.Insurer;

import java.sql.SQLException;

public interface InsurerInterface {

    void addInsurer(Insurer insurer) throws SQLException;
    Insurer extractInsurer(String email) throws SQLException;
    void updateInsurer(Insurer newInsurer, int id) throws SQLException;
    void deleteInsurer(int id) throws SQLException;
    boolean checkInsurer(String email) throws SQLException;
    boolean loginInsurer(String email, String password) throws SQLException;
    int parsePhone(String phone);
}
