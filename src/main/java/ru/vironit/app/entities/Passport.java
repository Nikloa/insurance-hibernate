package ru.vironit.app.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "passports", schema = "public", catalog = "insurance_service")
public class Passport {

    private int id;
    private int clientId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String passportNumber;
    private String identificationNumber;
    private Date issueDate;
    private String issuingAuthority;
    private byte[] passportPhoto;
    private boolean confirmation;

    public Passport() {
    }

    public Passport(int id, int clientId, String firstName, String lastName, Date birthDate, String passportNumber,
                        String identificationNumber, Date issueDate, String issuingAuthority, byte[] passportPhoto, boolean confirmation) {
        this.id = id;
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.passportNumber = passportNumber;
        this.identificationNumber = identificationNumber;
        this.issueDate = issueDate;
        this.issuingAuthority = issuingAuthority;
        this.passportPhoto = passportPhoto;
        this.confirmation = confirmation;
    }



    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "client_id")
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "passport_number")
    public String  getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Basic
    @Column(name = "identification_number")
    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    @Basic
    @Column(name = "issue_date")
    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    @Basic
    @Column(name = "issuing_authority")
    public String getIssuingAuthority() {
        return issuingAuthority;
    }

    public void setIssuingAuthority(String issuingAuthority) {
        this.issuingAuthority = issuingAuthority;
    }

    @Basic
    @Column(name = "passport_photo")
    public byte[] getPassportPhoto() {
        return passportPhoto;
    }

    public void setPassportPhoto(byte[] passportPhoto) {
        this.passportPhoto = passportPhoto;
    }

    @Basic
    @Column(name = "confirmation")
    public Boolean getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(Boolean confirmation) {
        this.confirmation = confirmation;
    }

    @Override
    public String toString() {
        return "Passport: " + "Id='" + id + '\''
                + "client Id='" + clientId + '\''
                + "first name='" + firstName + '\''
                + ", last name='" + lastName + '\''
                + ", birth date='" + birthDate.toString() + '\''
                + ", passport number='" + passportNumber + '\''
                + ", identification number='" + identificationNumber + '\''
                + ", issue date='" + issueDate.toString() + '\''
                + ", issuing authority='" + issuingAuthority + '\''
                + ", confirmation='" + String.valueOf(confirmation) + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return  true;
        if (o == null || getClass() != o.getClass()) return false;

        Passport passport = (Passport) o;
        if (!Objects.equals(id, passport.id)) return false;
        if (!Objects.equals(clientId, passport.clientId)) return false;
        if (!Objects.equals(firstName, passport.firstName)) return false;
        if (!Objects.equals(lastName, passport.lastName)) return false;
        if (!Objects.equals(birthDate, passport.birthDate)) return false;
        if (!Objects.equals(passportNumber, passport.passportNumber)) return false;
        if (!Objects.equals(identificationNumber, passport.identificationNumber)) return false;
        if (!Objects.equals(issueDate, passport.issueDate)) return false;
        if (!Objects.equals(issuingAuthority, passport.issuingAuthority)) return false;
        return Objects.equals(confirmation, passport.confirmation);
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + clientId;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (passportNumber != null ? passportNumber.hashCode() : 0);
        result = 31 * result + (identificationNumber != null ? identificationNumber.hashCode() : 0);
        result = 31 * result + (issueDate != null ? issueDate.hashCode() : 0);
        result = 31 * result + (issuingAuthority != null ? issuingAuthority.hashCode() : 0);
        result = 31 * result + (confirmation ? 1 : 0);
        return result;
    }
}
