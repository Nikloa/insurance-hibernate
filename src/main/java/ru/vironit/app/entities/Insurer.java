package ru.vironit.app.entities;

import java.util.Objects;

public class Insurer extends User {

    private String companyName;
    private  int phone = 0;
    private Double rating = 0.0;

    public Insurer() {

    }

    public Insurer (int id, String nickname, String email, String password, String companyName, int phone, Double rating) {
        super(id, nickname, email, password);
        super.setRole(Role.INSURER);
        this.companyName = companyName;
        this.phone = phone;
        this.rating = rating;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getPhone() {
        return phone;
    }

    public  void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", company name='" + companyName + '\''
                + ", phone='" + phone + '\''
                + ", rating='" + rating + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return  true;
        if (o == null || getClass() != o.getClass()) return false;

        Insurer insurer = (Insurer) o;
        if (!super.equals(o)) return false;
        if (!Objects.equals(companyName, insurer.companyName)) return false;
        if (!Objects.equals(phone, insurer.phone)) return false;
        if (!Objects.equals(rating, insurer.rating)) return false;
        return Objects.equals(getPassword(), insurer.getPassword());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + phone;
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }
}
