package ru.vironit.app.services;

import ru.vironit.app.dao.implementation.AdminImplementation;
import ru.vironit.app.dao.interfaces.AdminInterface;
import ru.vironit.app.entities.Admin;

import java.sql.SQLException;

public class AdminService implements AdminInterface {

    private AdminImplementation implementation;

    public AdminService() {
        implementation = new AdminImplementation();
    }

    @Override
    public void addAdmin(Admin admin) throws SQLException {
        implementation.addAdmin(admin);
    }

    @Override
    public Admin extractAdmin(int id) throws SQLException {
        Admin admin = implementation.extractAdmin(id);
        return admin;
    }

    @Override
    public void updateAdmin(Admin admin, int id) throws SQLException {
        implementation.updateAdmin(admin, id);
    }

    @Override
    public void deleteAdmin(int id) throws  SQLException {
        implementation.deleteAdmin(id);
    }
}
