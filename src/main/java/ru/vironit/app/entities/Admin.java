package ru.vironit.app.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "admins", schema = "public", catalog = "insurance_service")
public class Admin extends User{

    public Admin() {
    }

    public Admin(int id, String nickname, String email, String password) {
        super(id, nickname, email, password);
        super.setRole(Role.ADMIN);
    }

    @Id
    @Column(name = "id")
    public Integer getId() {
        return super.getId();
    }

    public void setId(Integer id) {
        super.setId(id);
    }

    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return super.getNickname();
    }

    public void setNickname(String nickname) {
        super.setNickname(nickname);
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return super.getEmail();
    }

    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return super.getPassword();
    }

    public void setPassword(String password) {
        super.setPassword(password);
    }
}
