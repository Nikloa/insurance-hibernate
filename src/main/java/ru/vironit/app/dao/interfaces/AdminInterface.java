package ru.vironit.app.dao.interfaces;

import ru.vironit.app.entities.Admin;

import java.sql.SQLException;

public interface AdminInterface {

    void addAdmin(Admin admin) throws SQLException;
    Admin extractAdmin(int id) throws SQLException;
    void updateAdmin(Admin admin, int id) throws SQLException;
    void deleteAdmin(int id) throws SQLException;
    boolean checkAdmin(String email) throws SQLException;
    Admin loginAdmin(String email, String password) throws SQLException;
}
