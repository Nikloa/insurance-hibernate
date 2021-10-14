package ru.vironit.app.entities;

public class Admin extends User{

    public Admin() {
        super();
    }

    public Admin(int id, String nickname, String email, String password) {
        super(id, nickname, email, password);
        super.setRole(Role.ADMIN);

    }
}
