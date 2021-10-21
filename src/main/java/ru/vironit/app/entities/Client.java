package ru.vironit.app.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "clients", schema = "public", catalog = "insurance_service")
public class Client extends User{
    private Integer phone;
    private byte[] photo;
    private BigDecimal balance = new BigDecimal(0);
    private Double rating = 0.0;

    public Client() {

    }

    public Client(int id, String nickname, String email, String password, Integer phone, byte[] photo, BigDecimal balance, Double rating) {
        super(id, nickname, email, password);
        super.setRole(Role.CLIENT);
        this.phone = phone;
        this.balance = balance;
        this.rating = rating;
        this.photo = photo;
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

    @Basic
    @Column(name = "phone")
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "photo")
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "balance")
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "rating")
    public double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", phone='" + phone + '\''
                + ", balance='" + balance + '\''
                + ", rating='" + rating + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return  true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;
        if (!super.equals(o)) return false;
        if (!Objects.equals(phone, client.phone)) return false;
        if (!Objects.equals(balance, client.balance)) return false;
        return Objects.equals(rating, client.rating);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + phone;
        result = 31 * result + (balance != null ? this.balance.hashCode() : 0);
        result = 31 * result + (rating != null ? this.rating.hashCode() : 0);
        return result;
    }
}
