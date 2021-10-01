package app.entities;

import java.math.BigDecimal;
import java.util.Objects;

public class Client extends User{
    private int phone;
    private BigDecimal balance;
    private Double rating = 0.0;

    public Client() {
    }
/*
    public Client(int id, String nickname, String email, String password, int phone, BigDecimal balance, Double rating) {
        this.setId(id);
        this.setNickname(nickname);
        this.setEmail(email);
        this.setPassword(password);
        this.phone = phone;
        this.balance = balance;
        this.rating = rating;
    }
*/

    public Client(int id, String nickname, String email, String password, int phone, BigDecimal balance, Double rating) {
        super(id, nickname, email, password);
        this.phone = phone;
        this.balance = balance;
        this.rating = rating;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getPhone() {
        return phone;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        return rating;
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
