package ru.vironit.app.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "insurers", schema = "public", catalog = "insurance_service")
public class Insurer extends User {

    private byte[] logo;
    private Double rating = 0.0;
    private String shortCompanyName;
    private Integer informationPhone;

    public Insurer() {

    }

    public Insurer (int id, String nickname, String email, String password, String companyName, int phone, byte[] logo, Double rating) {
        super(id, nickname, email, password);
        super.setRole(Role.INSURER);
        this.shortCompanyName = companyName;
        this.informationPhone = phone;
        this.logo = logo;
        this.rating = rating;
    }

    @Id
    @Column(name = "id")
    public Integer getId() {
        return super.getId();
    }

    public void setId(int id) {
        super.setId(id);
    }

    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return super.getNickname();
    }

    @Override
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
    @Column(name = "short_company_name")
    public String getShortCompanyName() {
        return shortCompanyName;
    }

    public void setShortCompanyName(String shortCompanyName) {
        this.shortCompanyName = shortCompanyName;
    }

    @Basic
    @Column(name = "information_phone")
    public Integer getInformationPhone() {
        return informationPhone;
    }

    public void setInformationPhone(Integer informationPhone) {
        this.informationPhone = informationPhone;
    }

    @Basic
    @Column(name = "logo")
    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    @Basic
    @Column(name = "rating")
    public Double getRating() {
        return rating;
    }

    public  void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", company name='" + shortCompanyName + '\''
                + ", phone='" + informationPhone + '\''
                + ", rating='" + rating + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return  true;
        if (o == null || getClass() != o.getClass()) return false;

        Insurer insurer = (Insurer) o;
        if (!super.equals(o)) return false;
        if (!Objects.equals(shortCompanyName, insurer.shortCompanyName)) return false;
        if (!Objects.equals(informationPhone, insurer.informationPhone)) return false;
        if (!Objects.equals(rating, insurer.rating)) return false;
        return Objects.equals(getPassword(), insurer.getPassword());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (shortCompanyName != null ? shortCompanyName.hashCode() : 0);
        result = 31 * result + informationPhone;
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }


}
